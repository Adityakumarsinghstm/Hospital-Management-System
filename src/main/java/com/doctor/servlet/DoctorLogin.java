package com.doctor.servlet;

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

@WebServlet("/doctorLogin")
public class DoctorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			HttpSession session = request.getSession();
			DoctorDao dao = new DoctorDao(DBConnect.getConnection());
             Doctor doctor = dao.login(email, password);
			if (doctor!=null) {
				session.setAttribute("doctObj", doctor);
				response.sendRedirect("doctor/index.jsp");
			} else {
				session.setAttribute("errorMsg", "Invalid email & password");
				response.sendRedirect("doctor_login.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
