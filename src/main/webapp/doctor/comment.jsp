<%@page import="com.entity.*"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.*"%>
<%@page import="com.user.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comment: Patient</title>
<%@include file="../components/allCssJs.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3)),
		url("../img/banner.jpg");
	height: 40vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<c:if test="${empty doctObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>
	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
		  <div class="col-md-6 offset-md-2">
				<div class="card paint-card">
					<div class="card-body">
					<p class="text-center fs-3">Patient Comment</p>
					  
					 <%
					      int id = Integer.parseInt(request.getParameter("id"));
					      AppointmentDao dao = new AppointmentDao(DBConnect.getConnection());
					      Appointment ap =  dao.getAppointmentById(id);
					  
					  %> 
					  
					  
					  <form class="row g-3" action="../updateStatus" method="post">
						  
						  
						  <div class="col-md-6">
						   <label for="inputEmail4" class="form-label"> Patient Name</label>
						   <input required type="text" class="form-control" name="name" readonly value="<%=ap.getFullName()%>">
						  </div>
						  
						  <div class="col-md-6">
						   <label for="inputEmail4" class="form-label">Age</label>
						   <input required type="text" class="form-control" name="age" readonly value="<%=ap.getAge()%>">
						  </div>
						 
						  
						  
						
						  
						  
						  <div class="col-md-6">
						    <label for="inputEmail4" class="form-label">Phone no</label>
						    <input required type="text" class="form-control" name="phno" readonly value="<%=ap.getPhNo()%>">
						  </div>
						  
						  <div class="col-md-6">
						    <label for="inputEmail4" class="form-label">Diseases</label>
						    <input required type="text" class="form-control" name="diseases" readonly value="<%=ap.getDiseases()%>">
						  </div>
						  
						  
						  
						  
						  <div class="col-md-12">
						    <label>Comment</label>
						    <textarea required name="comment" class="form-control" 
						      rows="3" cols=""></textarea>
						  </div>
						  <input type="hidden" name="id" value="<%=ap.getId()%>">
						  <input type="hidden" name="did" value="<%=ap.getDoctorId()%>">
						  
						  
						  <button class="mt-3 btn btn-primary col-md-6 offset-md-3">Submit</button>
						  
						 
						</form>
					  
					  
					  
					  
					  
					</div>
				</div>
			</div>		
		</div>
	</div>	
</body>
</html>