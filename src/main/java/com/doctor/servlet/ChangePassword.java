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

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
		int userId = Integer.parseInt(request.getParameter("did"));
		String newpassword = request.getParameter("NewPassword");
		String oldpassword = request.getParameter("OldPassword");
		
		DoctorDao dao = new DoctorDao(DBConnect.getConnection());
		HttpSession session = request.getSession();
		if(dao.checkOldPassword(userId, oldpassword))
		{
			if(dao.updatePassword(userId, newpassword))
			{
				session.setAttribute("succMsg", "Password Updated Successfully...");
				response.sendRedirect("doctor/edit_profile.jsp");
			}
			else {
				session.setAttribute("errorMsg", "something went wrong on server.....");
				response.sendRedirect("doctor/edit_profile.jsp");
			}
		}
		else {
			session.setAttribute("errorMsg", "Old Password Incorrect");
			response.sendRedirect("doctor/edit_profile.jsp");
		}
	}
	

}
