package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.SpecialistDao;
import com.DB.DBConnect;

/**
 * Servlet implementation class AddSpecialist
 */
@WebServlet("/addSpecialist")
public class AddSpecialist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddSpecialist() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String spectName = request.getParameter("spectName");
		//out.println(spectName);
		SpecialistDao dao = new SpecialistDao(DBConnect.getConnection());
		boolean f= dao.addSpecialist(spectName);
		
		HttpSession session = request.getSession();
		
		if (f) {
			session.setAttribute("succMsg", "Specialist Added...");
			response.sendRedirect("admin/index.jsp");
		} else {
			session.setAttribute("errorMsg", "Something went wrong");
			response.sendRedirect("admin/index.jsp");
		}
		
	}

}
