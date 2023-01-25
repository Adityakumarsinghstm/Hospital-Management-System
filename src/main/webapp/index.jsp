<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page: Hospital System</title>
<%@include file="components/allCssJs.jsp"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%-- 	<%
	Connection conn = DBConnect.getConnection();
	out.println(conn);
	%> --%>
	<!-- Adding NavBar -->
	<%@include file="components/navbar.jsp"%>

	<!-- Adding Crousel -->

	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/img1.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/img2.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/img3.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<!-- Features Section with card -->

	<div class="container p-3">
		<p class="text-center fs-2">Key Features of our Hospital</p>
		<!-- Cards -->
		<div class="row">
			<div class="col-md-8 p-5">
				<div class="row">
					<div class="col-md-6 ">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5 fw-bold ">100% Safety</p>
								<p>Hospital safety is always known to serve the positive
									correlation between the value of good things and the services
									that are provided in the overall state of economy.Health and
									safety in health care and hospitals. Our tools and guides can
									be used to assess and control the specific risks in your
									workplace.</p>
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5 fw-bold">Clean Environment</p>
								<p>A clean hospital is vitally important to the health of
									patients. This is because hospital environments are full of
									potential pathogens that can cause infections. When a hospital
									is clean, it reduces the chances that patients will come into
									contact with these harmful microorganisms.</p>
							</div>
						</div>
					</div>


					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5 fw-bold">Friendly Doctors</p>
								<p>There are many doctors who are LGBT friendly. This means
									that they are open and accepting of patients who identify as
									lesbian, gay, bisexual, or transgender. These doctors provide
									quality care without judgment or discrimination. They may also
									be knowledgeable about LGBT-specific health issues and can
									provide referrals to specialists if needed.</p>
							</div>
						</div>
					</div>

					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5 fw-bold">Medical Research</p>
								<p>Medical Research Medical schools and teaching hospitals
									pioneer discoveries and innovations that save lives and
									transform health care. Scientists and physicians at medical
									schools and teaching hospitals discover new treatments and
									bring them from the laboratory bench to the patient bedside.</p>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-4 mt-4">
				<img alt="" src="img/doc1.png" style="width: 100%">
			</div>
		</div>

	</div>


	<hr>

	<!-- Team Section -->

	<div class="container p-2">
		<p class="text-center fs-2">Our Team</p>


		<div class="row">
			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/doc2.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Samuani Simi</p>
						<p class=" fs-7">(CEO & Chairman)</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/doc3.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr. Siva Kumar</p>
						<p class=" fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/doc4.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr. Niuise Paule</p>
						<p class=" fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>


			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/doc5.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr. Mathue Samuel</p>
						<p class=" fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="components/footer.jsp"%>
</body>
</html>