<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>         
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Profile - My Admin Template</title>

	<!-- Main Styles -->
	<link rel="stylesheet" href="assets/styles/style.min.css">
	
	<!-- Material Design Icon -->
	<link rel="stylesheet" href="assets/fonts/material-design/css/materialdesignicons.css">

	<!-- mCustomScrollbar -->
	<link rel="stylesheet" href="assets/plugin/mCustomScrollbar/jquery.mCustomScrollbar.min.css">

	<!-- Waves Effect -->
	<link rel="stylesheet" href="assets/plugin/waves/waves.min.css">

	<!-- Sweet Alert -->
	<link rel="stylesheet" href="assets/plugin/sweet-alert/sweetalert.css">
	
	<!-- Dark Themes -->
	<link rel="stylesheet" href="assets/styles/style-black.min.css">
</head>

<body>



<c:import url="include/navbar.jsp"></c:import>

<div class="row small-spacing">
			<div class="col-lg-3 col-12">
				<div class="box-content bordered primary margin-bottom-20">
					<div class="profile-avatar">
						<img src="assets/images/profile.jpg" alt="">
						
						
						
						
						
					</div>
					<!-- .profile-avatar -->
					
				</div>
				<!-- /.box-content bordered -->

				
				<!-- /.box-content -->
			</div>
			<!-- /.col-lg-3 col-12 -->
			<div class="col-lg-9 col-12">
				<div class="row">
					<div class="col-12">
						<div class="box-content card">
							<h4 class="box-title"><i class="fa fa-user ico"></i>About</h4>
							<!-- /.box-title -->
							
							<!-- /.dropdown js__dropdown -->
							<div class="card-content">
								<div class="row">
									<div class="col-lg-6">
										<div class="row">
											<div class="col-12"><label>First Name: ${contact.name}</label></div>
											<!-- /.col-5 -->
											<!-- /.col-7 -->
										</div>
										<!-- /.row -->
									</div>
									<!-- /.col-lg-6 -->
									<div class="col-lg-6">
										<div class="row">
											<div class="col-12"><label>Department:   ${contact.contactDepartment.name }</label></div>
											<!-- /.col-5 -->
											<!-- /.col-7 -->
										</div>
										<!-- /.row -->
									</div>
									<!-- /.col-lg-6 -->
									<div class="col-lg-6">
										<div class="row">
											<div class="col-12"><label>Birthday:  ${contact.birthday }</label></div>
											<!-- /.col-5 -->
											<!-- /.col-7 -->
										</div>
										<!-- /.row -->
									</div>
									<!-- /.col-lg-6 -->
									<div class="col-lg-6">
										<div class="row">
											<div class="col-12"><label>Creation Date: ${contact.creationDate } </label></div>
											<!-- /.col-5 -->
											<!-- /.col-7 -->
										</div>
										<!-- /.row -->
									</div>
									<!-- /.col-lg-6 -->
									
									<!-- /.col-lg-6 -->
									
									<!-- /.col-lg-6 -->
							
									<!-- /.col-lg-6 -->
									
									<!-- /.col-lg-6 -->
									
									<!-- /.col-lg-6 -->
								
									<!-- /.col-lg-6 -->
								</div>
								<!-- /.row -->
							</div>
							<!-- /.card-content -->
						</div>
						<!-- /.box-content card -->
					</div>
					<!-- /.col-lg-12 -->
					<div class="col-lg-6 col-12">
						<div class="box-content card">
						
							<h4 class="box-title"><i class="fa fa-file-text ico"></i> Phone</h4>
							<!-- /.box-title -->
							
							<!-- /.dropdown js__dropdown -->
							<div class="card-content">
								<ul class="dot-list">
								<c:forEach var="f" items="${contact.fields }">
								<c:if test="${f.field_type.parent.id == 1}">
									<li> ${f.content} <span class="date">${f.field_type.type_name } </span></li>
								</c:if>
								</c:forEach>
								</ul>
							</div>
							<!-- /.card-content -->
						</div>
						<!-- /.box-content card -->
					</div>
					<!-- /.col-lg-6 -->
					<div class="col-lg-6 col-12">
						<div class="box-content card">
							<h4 class="box-title"><i class="fa fa-trophy ico"></i> Email</h4>
							<!-- /.box-title -->
							
							<!-- /.dropdown js__dropdown -->
								<div class="card-content">
								<ul class="dot-list">
								<c:forEach var="f" items="${contact.fields }">
								<c:if test="${f.field_type.parent.id == 8}">
									<li> ${f.content} <span class="date">${f.field_type.type_name } </span></li>
								</c:if>
								</c:forEach>
								</ul>
							</div>
							<!-- /.card-content -->
						</div>
						<!-- /.box-content card -->
					</div>
					<!-- /.col-lg-6 -->
				</div>
				
				<!-- /.row -->
			</div>
			<!-- /.col-lg-9 col-12 -->
		</div>
<c:import url="include/fouter.jsp"></c:import>

	<script src="assets/scripts/jquery.min.js"></script>
	<script src="assets/scripts/modernizr.min.js"></script>
	<script src="assets/plugin/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/plugin/mCustomScrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="assets/plugin/nprogress/nprogress.js"></script>
	<script src="assets/plugin/sweet-alert/sweetalert.min.js"></script>
	<script src="assets/plugin/waves/waves.min.js"></script>

	<script src="assets/scripts/main.min.js"></script>
</body>
</html>