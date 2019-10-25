<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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


<form action="">
<div class="card-content" style="width: 50%;">
						<div class="input-group margin-bottom-20">
							<div class="input-group-btn"><label for="ig-1" class="btn btn-default"><i class="fa fa-user"></i></label></div>
							<!-- /.input-group-btn -->
							<input id="ig-1" type="text" class="form-control" placeholder="name" name="name">
						</div>
						<!-- /.input-group -->
						<div class="input-group margin-bottom-20">
							<div class="input-group-btn"><label for="ig-2" class="btn btn-default"><i class="fa fa-envelope"></i></label></div>
							<!-- /.input-group-btn -->
							<input id="ig-2" type="email" class="form-control" placeholder="Email address" name="email">
						</div>
					
						<!-- /.input-group -->
						<div class="input-group">
						<label for="inp-type-1" class="col-sm-3 control-label">Birthday</label>
							<div class="input-group-btn"><label for="ig-3" class="btn btn-default"><i class="fa fa-dollar-sign"></i></label></div>
							<!-- /.input-group-btn -->
							<input id="ig-3" type="date" class="form-control" placeholder="birthday" name="birthday">
						</div>
						<br><br>
						<div class="input-group">
							<!-- /.input-group-btn -->
								<input  type="button" class="btn btn-orange waves-effect waves-light addphone" id="addphone">	
						</div>
						<div class="phoneadd"></div>
						<!-- /.input-group -->
					</div>
					
					

</form>

<c:import url="include/fouter.jsp"></c:import>











	<script src="assets/scripts/jquery.min.js"></script>
	<script src="assets/scripts/modernizr.min.js"></script>
	<script src="assets/plugin/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/plugin/mCustomScrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="assets/plugin/nprogress/nprogress.js"></script>
	<script src="assets/plugin/sweet-alert/sweetalert.min.js"></script>
	<script src="assets/plugin/waves/waves.min.js"></script>

	<script src="assets/scripts/main.min.js"></script>
	

<script>
$(document).ready(function() {
	var max_fields      = 1000; //maximum input boxes allowed
	var wrapperemail   		= $(".phoneadd"); //Fields wrapper
	var add_buttonemail      = $("#addphone"); //Add button ID
	
    var wrapperphone  = $(".input_phone_wrap");
    var add_buttonphone  = $(".add_phone_button20");
	var x = 1; //initlal text box count
	$(add_buttonemail).click(function(e){ //on add input button click
		alert("Hello! I am an alert box!!");
		e.preventDefault();
		if(x < max_fields){ //max input box allowed
			x++; //text box increment
			v ='<div class="input-group"><label for="inp-type-1" class="col-sm-3 control-label">Birthday</label>
				<div class="input-group-btn"><label for="ig-3" class="btn btn-default"><i class="fa fa-dollar-sign"></i></label></div><!-- /.input-group-btn --><input id="ig-3" type="date" class="form-control" placeholder="birthday" name="birthday"></div>;'
			$(wrapperemail).append(v); //add input box
		}
	});
	
	$(wrapperemail).on("click",".remove_field", function(e){ //user click on remove text
		e.preventDefault(); $(this).parent('div').remove(); x--;
	});



$(add_buttonphone).click(function(e){ //on add input button click
		e.preventDefault();
		if(x < max_fields){ //max input box allowed
			x++; //text box increment
			$(wrapperphone).append('<div><input type="text" class="inputpart60 inputpart" name="myphone[]"/>&nbsp;<select name="phonetype"><option value="home">Home</option><option value="mobile">Mobile</option><option value="Work">Work</option></select>&nbsp;<button class="remove_field add_phone_button20"><i class="fa fa-minus"></i></button></div>'); //add input box
		}
	});
	
	$(wrapperphone).on("click",".remove_field", function(e){ //user click on remove text
		e.preventDefault(); $(this).parent('div').remove(); x--;
	});

});


</script>
</body>
</html>