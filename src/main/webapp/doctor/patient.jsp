<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.AppointmentDao"%>
<%@page import="com.DAO.DoctorDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="com.entity.User"%>
<%@page import="com.entity.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient List: Doctor Dashboard</title>
<%@include file="../components/allCssJs.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<c:if test="${empty doctObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>
	
	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">Patient Details</p>
						
						<c:if test="${not empty succMsg }"> 
							<p class="text-center text-success fs-3">${succMsg }</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-5">${errorMsg }</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Email</th>
									<th scope="col">Mob No</th>
									<th scope="col">Diseases</th>
									
									<th scope="col">Status</th>
									<th scope="col">Action</th>
									
								</tr>
							</thead>
							<tbody>
							      
							       <%
							       Doctor doctor = (Doctor) session.getAttribute("doctObj"); 
							        AppointmentDao dao = new AppointmentDao(DBConnect.getConnection());
							       
							        List<Appointment> list = dao.getAppointmentByDoctorLogin(doctor.getId());
							        for(Appointment a:list){
							       %>
							        <tr>
							          <td><%=a.getFullName() %></td>
							          <td><%=a.getGender() %></td>
							          <td><%=a.getAge() %></td>
							          <td><%=a.getAppointDate() %></td>
							          <td><%=a.getEmail() %></td>
							          <td><%=a.getPhNo() %></td>
							          <td><%=a.getDiseases() %></td>
							          <td><%=a.getStatus() %></td>
							          <td>
							          
							          <%
							            if("pending".equals(a.getStatus()))
							            {%>
							            	<a href="comment.jsp?id=<%=a.getId()%>" class="btn btn-sm btn-success"><i class="fa-regular fa-comment"></i> Comment</a>
							           <% }else{%>
							            	<a href="comment.jsp?id=<%=a.getId()%>" class="btn btn-sm btn-success disabled"><i class="fa-regular fa-comment"></i> Comment</a>
							            <%}%>
							            
							            
							          </td>
							       </tr>
							       
							       <%}%>
							       
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<img alt="" src="img/doc1.png" class="w-100">
			</div>
		</div>
	</div>
</body>
</html>