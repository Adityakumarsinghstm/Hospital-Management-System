package com.doctor.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.DoctorDao;
import com.DAO.UserDao;
import com.DB.DBConnect;
import com.entity.Doctor;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet("/edit_profile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String fullName = request.getParameter("fullname");
			String dob = request.getParameter("dob");
			String qualification = request.getParameter("qualification");
			String spect = request.getParameter("spect");
			String email = request.getParameter("email");
			String mobNo = request.getParameter("mobno");
			
			
			
			int id = Integer.parseInt(request.getParameter("doctid"));
			
			Doctor d = new Doctor(id,fullName,dob,qualification,spect,email,mobNo,"");
			
			
			
			DoctorDao dao = new DoctorDao(DBConnect.getConnection());
			HttpSession session = request.getSession();
			if(dao.editDoctoProfile(d))
			{
				session.setAttribute("succMsg", "Doctor updated Successfully...");
				response.sendRedirect("doctor/edit_profile.jsp");
			}
			else {
				session.setAttribute("errorMsg", "Something Went Wrong on server...");
				response.sendRedirect("doctor/edit_profile.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}

