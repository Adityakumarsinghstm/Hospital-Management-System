<%@page import="com.entity.Doctor"%>
<%@page import="com.DAO.DoctorDao"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.AppointmentDao"%>
<%@page import="com.entity.User"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
<%@include file="../components/allCssJs.jsp"%>
</head>
<body>
     <%@include file="navbar.jsp"%>
     
     
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
									
									<th scope="col">DoctorName</th>
									<th scope="col">Address</th>
									<th scope="col">Status</th>
									
								</tr>
							</thead>
							<tbody>
							      <%  
							         DoctorDao dao2 = new DoctorDao(DBConnect.getConnection());
							         AppointmentDao dao = new AppointmentDao(DBConnect.getConnection());
							         List<Appointment> list = dao.getAllAppointment();
							         for(Appointment ap :list){
							        	  Doctor doct = dao2.getDoctorById(ap.getDoctorId());
							         %>
							            <tr>
							          <th><%=ap.getFullName() %></th>
							          <td><%=ap.getGender() %></td>
							          <td><%=ap.getAge() %></td>
							          <td><%=ap.getAppointDate() %></td>
							          <td><%=ap.getEmail() %></td>
							          <td><%=ap.getPhNo() %></td>
							          <td><%=ap.getDiseases() %></td>
							          <td><%=doct.getFullName() %></td>
							          <td><%=ap.getAddress() %></td>
							          <td><%=ap.getStatus() %></td>
							         
							       </tr>
							         <%} %>
							        
							       
							       
							       
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