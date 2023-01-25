<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<%@include file="components/allCssJs.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
      <%@include file="components/navbar.jsp"%>
      
      <c:if test="${empty userObj }">
       <c:redirect url="user_login.jsp"></c:redirect>
      </c:if>
      
      <div class="container p-5">
		<div class="row">
		

			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3 fw-bold">Change Password</p>
						<c:if test="${not empty succMsg }">
							<p class="text-center text-success fs-3">${succMsg }</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-5">${errorMsg }</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						
						<form class="row g-3" action="updatePassword" method="post">
						
						  
						  <div class="mb-2">
								<label class="form-label">Enter New Password</label> <input required
									name="NewPassword" type="text" class="form-control">
							</div>
						  
						  <div class="mb-2">
								<label class="form-label">Enter Old Password</label> <input required
									name="OldPassword" type="text" class="form-control">
							</div>
							<input type="hidden" name="uid" value="${userObj.id }">
						    <button class="col-md-10 offset-md-1 btn btn-success">Change Password</button>
						
						</form>
						
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>