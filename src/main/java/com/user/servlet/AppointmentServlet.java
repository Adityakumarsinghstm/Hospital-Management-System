package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AppointmentDao;
import com.DB.DBConnect;
import com.entity.Appointment;

/**
 * Servlet implementation class AppointmentServlet
 */
@WebServlet("/addappointment")
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			int userId = Integer.parseInt(request.getParameter("Userid"));
			String name=request.getParameter("name");
			String gender = request.getParameter("gender");
			String age = request.getParameter("age");
			String appointmentDate = request.getParameter("appoint_date");
			String email = request.getParameter("email");
			String phNo = request.getParameter("phno");
			String diseases = request.getParameter("diseases");
			int doctId = Integer.parseInt(request.getParameter("doct"));
			String address = request.getParameter("address");
			
			
			Appointment ap = new Appointment(userId,name,gender,age,appointmentDate,email,phNo,diseases,doctId,address,"pending");
			
			AppointmentDao dao = new AppointmentDao(DBConnect.getConnection());
			HttpSession session = request.getSession();
			boolean f = dao.addAppointment(ap);
			if(f)
			{
				session.setAttribute("succMsg","appointment added Successfully...");
				response.sendRedirect("user_appointment.jsp");
			}
			else
			{
				session.setAttribute("errorMsg", "Something went wrong on server...");
				response.sendRedirect("user_appointment.jsp");
			}
		
		
		
		
	}

}
