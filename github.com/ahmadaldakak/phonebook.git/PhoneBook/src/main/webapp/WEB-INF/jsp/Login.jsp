<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype html>
<head>
<c:import url="include/header.jsp"></c:import>
</head>
<body>
<div id="single-wrapper">
	<form action="/login" method="post" class="frm-single">
		<div class="inside">
			<div class="title"><strong>DTH</strong>PhoneBook</div>
			<!-- /.title -->
			<div class="frm-title">Login</div>
			<!-- /.frm-title -->
			<div class="frm-input"><input type="text" placeholder="Email" class="frm-inp" name ="email"><i class="fa fa-user frm-ico"></i></div>
			<!-- /.frm-input -->
			<div class="frm-input"><input type="password" placeholder="Password" name="password" class="frm-inp"><i class="fa fa-lock frm-ico"></i></div>
			<!-- /.frm-input -->

			<!-- /.clearfix -->
			<button type="submit" class="frm-submit">Login<i class="fa fa-arrow-circle-right"></i></button>
			<div class="row small-spacing">

			
			</div>
			<!-- /.row -->
			<a href="page-register.html" class="a-link"><i class="fa fa-key"></i>New to DTH PhoneBook? Register.</a>
			<div class="frm-footer">NinjaAdmin © 2016.</div>
			<!-- /.footer -->
		</div>
		<!-- .inside -->
	</form>
	<!-- /.frm-single -->
</div>
</body>
<c:import url="include/fouter.jsp"></c:import>