package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AppointmentDao;
import com.DB.DBConnect;

/**
 * Servlet implementation class UpdateStatus
 */
@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatus() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int id = Integer.parseInt(request.getParameter("id"));
		int did = Integer.parseInt(request.getParameter("did"));
		String comment = request.getParameter("comment");
		
		AppointmentDao dao = new AppointmentDao(DBConnect.getConnection());
		HttpSession session = request.getSession();
		
		if(dao.updateStatus(id, did, comment))
		{
			session.setAttribute("succMsg", "Status Updated Successfully");
			response.sendRedirect("doctor/patient.jsp");
		}
		else
		{
			session.setAttribute("errorMsg", "Something went wrong on server");
			response.sendRedirect("doctor/patient.jsp");
		}
		
	}

}
