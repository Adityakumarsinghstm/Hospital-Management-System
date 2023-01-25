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

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		DoctorDao dao = new DoctorDao(DBConnect.getConnection());
		HttpSession session = request.getSession();
		if(dao.deleteDoctor(id))
		{
			session.setAttribute("succMsg", "Doctor Deleted Successfully...");
			response.sendRedirect("admin/view_doctor.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Something Went Wrong on server...");
			response.sendRedirect("admin/view_doctor.jsp");
		}
	}

	

}
