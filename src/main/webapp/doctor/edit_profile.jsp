<%@page import="com.DAO.DoctorDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Specialist"%>
<%@page import="com.entity.Doctor"%>

<%@page import="com.DAO.SpecialistDao"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit profile</title>
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


	<div class="container p-5">
		<div class="row">
			<c:if test="${not empty succMsg }">
				<p class="text-center text-success fs-3">${succMsg }</p>
				<c:remove var="succMsg" scope="session" />
			</c:if>

			<c:if test="${not empty errorMsg }">
				<c:remove var="errorMsg" scope="session" />
			</c:if>

			<div class="col-md-4 ">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3 fw-bold">Change Password</p>

						<p class="text-center text-danger fs-5">${errorMsg }</p>


						<form class="row g-3" action="../changePassword" method="post">


							<div class="mb-2">
								<label class="form-label">Enter New Password</label> <input
									required name="NewPassword" type="text" class="form-control">
							</div>

							<div class="mb-2">
								<label class="form-label">Enter Old Password</label> <input
									required name="OldPassword" type="text" class="form-control">
							</div>
							<input type="hidden" name="did" value="${doctObj.id }">
							<button class="col-md-10 offset-md-1 btn btn-primary">Change
								Password</button>

						</form>

					</div>
				</div>
			</div>


			<div class="col-md-5 offset-md-2 ">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center fw-bold ">Update Doctor Profile</p>
						<c:if test="${not empty succMsg }">
							<p class="text-center text-success fs-3" role="alert">${succMsg }</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-3">${errorMsg }</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>

						<form action="../edit_profile" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullname" class="form-control"
									value="${doctObj.fullName }">

							</div>

							<div class="mb-3">
								<label class="form-label">DBO</label> <input type="date"
									required name="dob" class="form-control"
									value="${doctObj.dob }">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input
									type="text" required name="qualification" class="form-control"
									value="${doctObj.qualification }">
							</div>

							<div class="mb-3">
								<label class="form-label">Specialist</label> <select
									name="spect" required class="form-control"
									value="${doctObj.specialist }">


									<%
									SpecialistDao dao = new SpecialistDao(DBConnect.getConnection());
									List<Specialist> list = dao.getAllSpecialist();
									for (Specialist s : list) {
									%>
									<option><%=s.getSpecialistName()%></option>
									<%
									}
									%>


								</select>
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									required name="email" class="form-control"
									value="${doctObj.email }">
							</div>

							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									required name="mobno" class="form-control"
									value="${doctObj.mobNo }">
							</div>

							<input type="hidden" name="doctid" value="${doctObj.id }">

							<button type="submit"
								class="btn btn-primary col-md-10 offset-md-1">Update</button>

						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>