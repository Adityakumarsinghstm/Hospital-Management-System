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
<title>View appointment</title>
<%@include file="components/allCssJs.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3)),
		url("img/banner.jpg");
	height: 40vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<c:if test="${empty userObj }">
		<c:redirect url="user_login.jsp"></c:redirect>
	</c:if>
	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>

	<div class="container p-3">
		<div class="row">
			<div class="col-md-9">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">Appointment
							List</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Diseases</th>
									<th scope="col">Doctor</th>
									<th scope="col">Status</th>

								</tr>
							</thead>
							<tbody>

								<%
								User user = (User) session.getAttribute("userObj");
								AppointmentDao dao = new AppointmentDao(DBConnect.getConnection());
								DoctorDao dao2 = new DoctorDao(DBConnect.getConnection());
								List<Appointment> list = dao.getAppointmentByUserId(user.getId());
								for (Appointment a : list) {
									Doctor doct = dao2.getDoctorById(a.getDoctorId());
								%>
								<tr>
									<td><%=a.getFullName()%></td>
									<td><%=a.getGender()%></td>
									<td><%=a.getAge()%></td>
									<td><%=a.getAppointDate()%></td>
									<td><%=a.getDiseases()%></td>
									<td><%=doct.getFullName()%></td>
									<td>
										<%
										if ("pending".equals(a.getStatus())) {
										%> <a href="#" class="btn btn-sm btn-warning">Pending</a>
										<%
										} else {
										%> <%=a.getStatus()%> <%
 }
 %>
									</td>
								</tr>
								<%
								}
								%>



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