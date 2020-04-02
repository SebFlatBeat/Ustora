<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login Ustora</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="icon" type="image/png" href="../../../resources/META-INF.resources/iconsLogin/favicon.ico"/>

	<link rel="stylesheet" type="text/css" href="../../../resources/META-INF.resources/vendorLogin/bootstrap/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="../../../resources/META-INF.resources/fontsLogin/font-awesome-4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="../../../resources/META-INF.resources/fontsLogin/Linearicons-Free-v1.0.0/icon-font.min.css">

	<link rel="stylesheet" type="text/css" href="../../../resources/META-INF.resources/vendorLogin/animate/animate.css">

	<link rel="stylesheet" type="text/css" href="../../../resources/META-INF.resources/vendorLogin/css-hamburgers/hamburgers.min.css">

	<link rel="stylesheet" type="text/css" href="../../../resources/META-INF.resources/vendorLogin/animsition/css/animsition.min.css">

	<link rel="stylesheet" type="text/css" href="../../../resources/META-INF.resources/vendorLogin/select2/select2.min.css">

	<link rel="stylesheet" type="text/css" href="../../../resources/META-INF.resources/vendorLogin/daterangepicker/daterangepicker.css">

	<link rel="stylesheet" type="text/css" href="../../../resources/META-INF.resources/cssLogin/util.css">
	<link rel="stylesheet" type="text/css" href="../../../resources/META-INF.resources/cssLogin/main.css">

</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
				<form class="login100-form validate-form flex-sb flex-w" action="/login" method="post">
					<span class="login100-form-title p-b-32">
						Account Login
					</span>

					<span class="txt1 p-b-11">
						<label for="userName">Username</label>
					</span>
					<div class="wrap-input100 validate-input m-b-36" data-validate = "Username is required">
						<input class="input100" type="text" name="username" id="username"/>
						<span class="focus-input100"></span>
					</div>
					
					<span class="txt1 p-b-11">
						<label for="password">Password</label>
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<input class="input100" type="password" name="password" id="password"/>
						<span class="focus-input100"></span>
					</div>


					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Login
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>

	<script src="../../../resources/META-INF.resources/vendorLogin/jquery/jquery-3.2.1.min.js"></script>

	<script src="../../../resources/META-INF.resources/vendorLogin/animsition/js/animsition.min.js"></script>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.sticky/1.0.4/jquery.sticky.js"></script>

	<script src="../../../resources/META-INF.resources/vendorLogin/bootstrap/js/popper.js"></script>
	<script src="../../../resources/META-INF.resources/vendorLogin/bootstrap/js/bootstrap.min.js"></script>

	<script src="../../../resources/META-INF.resources/vendorLogin/select2/select2.min.js"></script>

	<script src="../../../resources/META-INF.resources/vendorLogin/daterangepicker/moment.min.js"></script>
	<script src="../../../resources/META-INF.resources/vendorLogin/daterangepicker/daterangepicker.js"></script>

	<script src="../../../resources/META-INF.resources/vendorLogin/countdowntime/countdowntime.js"></script>

	<script src="../../../resources/META-INF.resources/js/main.js"></script>

</body>
</html>
