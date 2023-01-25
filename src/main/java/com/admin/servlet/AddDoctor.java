package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.DoctorDao;
import com.DB.DBConnect;
import com.entity.Doctor;

/**
 * Servlet implementation class AddDoctor
 */
@WebServlet("/add_doctor")
public class AddDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String fullName = request.getParameter("fullname");
			String dob = request.getParameter("dob");
			String qualification = request.getParameter("qualification");
			String spect = request.getParameter("spect");
			String email = request.getParameter("email");
			String mobNo = request.getParameter("mobno");
			String password = request.getParameter("password");
			
			Doctor d = new Doctor(fullName,dob,qualification,spect,email,mobNo,password);
			
			DoctorDao dao = new DoctorDao(DBConnect.getConnection());
			HttpSession session = request.getSession();
			if(dao.registerDoctor(d))
			{
				session.setAttribute("succMsg", "Doctor Added Successfully...");
				response.sendRedirect("admin/doctor.jsp");
			}
			else {
				session.setAttribute("errorMsg", "Something Went Wrong on server...");
				response.sendRedirect("admin/doctor.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
