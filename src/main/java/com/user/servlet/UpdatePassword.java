package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDao;
import com.DB.DBConnect;
@WebServlet("/updatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassword() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("uid"));
		String newpassword = request.getParameter("NewPassword");
		String oldpassword = request.getParameter("OldPassword");
		
		UserDao dao = new UserDao(DBConnect.getConnection());
		HttpSession session = request.getSession();
		if(dao.checkOldPassword(userId, oldpassword))
		{
			if(dao.updatePassword(userId, newpassword))
			{
				session.setAttribute("succMsg", "Password Updated Successfully...");
				response.sendRedirect("change_password.jsp");
			}
			else {
				session.setAttribute("errorMsg", "something went wrong on server.....");
				response.sendRedirect("change_password.jsp");
			}
		}
		else {
			session.setAttribute("errorMsg", "Old Password Incorrect");
			response.sendRedirect("change_password.jsp");
		}
	}

}
