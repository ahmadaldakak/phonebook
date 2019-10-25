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

	<title>Contact - My Admin Template</title>

	<!-- Main Styles -->
	<link rel="stylesheet" href="assets/styles/style.min.css">
	
	<!-- Material Design Icon -->
	<link rel="stylesheet" href="assets/fonts/material-design/css/materialdesignicons.css">

	<!-- mCustomScrollbar -->
	<link rel="stylesheet" href="assets/plugin/mCustomScrollbar/jquery.mCustomScrollbar.min.css">

	<!-- Waves Effect -->
	<link rel="stylesheet" href="assets/plugin/waves/waves.min.css">
	<link rel="stylesheet" href="assets/plugin/bootstrap/bootstrap-theme.min.css">

	<!-- Sweet Alert -->
	<link rel="stylesheet" href="assets/plugin/sweet-alert/sweetalert.css">
	
	<!-- Dark Themes -->
	<link rel="stylesheet" href="assets/styles/style-black.min.css">
</head>
<body>


<c:import url="include/navbar.jsp"></c:import>


<c:forEach var="con" items="${cotacts}">
			<div class="col-lg-4 col-md-6">
				<div class="box-contact">
					<h3 class="name margin-top-10">${con.name }</h3>
					<!-- /.name -->
					<h4 class="job"></h4>
					<!-- /.job -->
					<div class="text-muted">
						<p class="margin-bottom-20"></p>
						<ul class="contact-social list-inline">
							<li><a href="viewcontact?id=${con.id }" data-toggle="tooltip" data-placement="top" title="Open" class="fa fa-folder-open" style="background: #00aeff;"></a></li>
							<li><a href="#" data-toggle="tooltip" data-placement="top" title="Edite" class="fa  fa-edit" style="background: #00bf4f;"></a></li>
						</ul>
					</div>
				</div>
				<!-- /.box-contact -->
			</div>

</c:forEach>







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