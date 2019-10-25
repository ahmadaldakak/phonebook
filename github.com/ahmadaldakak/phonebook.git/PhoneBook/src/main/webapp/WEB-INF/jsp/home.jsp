<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Home - My Admin Template</title>

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
	
	<!-- Morris Chart -->
	<link rel="stylesheet" href="assets/plugin/chart/morris/morris.css">

	<!-- FullCalendar -->
	<link rel="stylesheet" href="assets/plugin/fullcalendar/fullcalendar.min.css">
	<link rel="stylesheet" href="assets/plugin/fullcalendar/fullcalendar.print.css" media='print'>

	<!-- Dark Themes -->
	<link rel="stylesheet" href="assets/styles/style-black.min.css">
</head>

<body>
<c:import url="include/navbar.jsp"></c:import>



<c:import url="include/fouter.jsp"></c:import>
${User.user_id}
${User.name}
${User.userType.type_name}





	<script src="assets/scripts/jquery.min.js"></script>
	<script src="assets/scripts/modernizr.min.js"></script>
	<script src="assets/plugin/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/plugin/mCustomScrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="assets/plugin/nprogress/nprogress.js"></script>
	<script src="assets/plugin/sweet-alert/sweetalert.min.js"></script>
	<script src="assets/plugin/waves/waves.min.js"></script>

	<!-- Morris Chart -->
	<script src="assets/plugin/chart/morris/morris.min.js"></script>
	<script src="assets/plugin/chart/morris/raphael-min.js"></script>
	<script src="assets/scripts/chart.morris.black.init.min.js"></script>

	<!-- Flot Chart -->
	<script src="assets/plugin/chart/plot/jquery.flot.min.js"></script>
	<script src="assets/plugin/chart/plot/jquery.flot.tooltip.min.js"></script>
	<script src="assets/plugin/chart/plot/jquery.flot.categories.min.js"></script>
	<script src="assets/plugin/chart/plot/jquery.flot.pie.min.js"></script>
	<script src="assets/plugin/chart/plot/jquery.flot.stack.min.js"></script>
	<script src="assets/scripts/chart.flot.black.init.min.js"></script>

	<!-- Sparkline Chart -->
	<script src="assets/plugin/chart/sparkline/jquery.sparkline.min.js"></script>
	<script src="assets/scripts/chart.sparkline.init.min.js"></script>

	<!-- FullCalendar -->
	<script src="assets/plugin/moment/moment.js"></script>
	<script src="assets/plugin/fullcalendar/fullcalendar.min.js"></script>
	<script src="assets/scripts/fullcalendar.init.js"></script>

	<script src="assets/scripts/main.min.js"></script>
</body>
</html>