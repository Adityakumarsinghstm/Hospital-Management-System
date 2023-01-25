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
 * Servlet implementation class UpdateDoctor
 */
@WebServlet("/update_doctor")
public class UpdateDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDoctor() {
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
			int id = Integer.parseInt(request.getParameter("id"));
			
			Doctor d = new Doctor(id,fullName,dob,qualification,spect,email,mobNo,password);
			
			DoctorDao dao = new DoctorDao(DBConnect.getConnection());
			HttpSession session = request.getSession();
			if(dao.updateDoctor(d))
			{
				session.setAttribute("succMsg", "Doctor updated Successfully...");
				response.sendRedirect("admin/view_doctor.jsp");
			}
			else {
				session.setAttribute("errorMsg", "Something Went Wrong on server...");
				response.sendRedirect("admin/view_doctor.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
