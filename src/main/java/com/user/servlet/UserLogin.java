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
import com.entity.User;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			HttpSession session = request.getSession();
			UserDao dao = new UserDao(DBConnect.getConnection());
             User user = dao.login(email, password);
			if (user!=null) {
				session.setAttribute("userObj", user);
				response.sendRedirect("index.jsp");
			} else {
				session.setAttribute("errorMsg", "Invalid email & password");
				response.sendRedirect("user_login.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
