package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class UserServlet
 */
@WebServlet("/user_register")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User u = new User(name, email, password);

		UserDao dao = new UserDao(DBConnect.getConnection());
		HttpSession session = request.getSession();
		boolean f = dao.userRegister(u);

		if (f) {
			session.setAttribute("succMsg", "Register Succsesfully...");
			response.sendRedirect("signup.jsp");
		} else {
			session.setAttribute("errorMsg", "Something went wrong...");
			response.sendRedirect("signup.jsp");
		}

	}

}
