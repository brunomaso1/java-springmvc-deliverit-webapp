<%@include file="plugins/headers/headers.jsp" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>Ingresa con tu cuenta</title>

		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
			  rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
			  crossorigin="anonymous">
		<!--User css-->
		<link href="resources/css/login.css" rel="stylesheet">
		<!--Favicon-->
		<link rel="shortcut icon" type="image/png" href="resources/img/favicon.png">
	</head>
	<body>
		<div class="container">
			<div id="login-box">
				<div class="logo">
					<img src="resources/img/login-photo.jpg" class="img img-responsive img-circle center-block"/>
					<h1 class="logo-caption"><span class="tweak">L</span>ogin</h1>
				</div><!-- /.logo -->
				<form method="POST" action="${contextPath}/login" class="form-signin">
					<div class="form-group ${error != null ? 'has-error' : ''}">
						<span class="text-white">${message}</span>
						<input name="username" type="text" class="form-control" placeholder="Usuario"
							   autofocus="true"/>
						<input name="password" type="password" class="form-control" placeholder="Contraseña"/>
						<span class="text-white">${error}</span>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

						<button class="btn btn-warning btn-md btn3d btn-block" type="submit">Ingresar</button>
						<h4 class="text-center"><a>Crear cuenta nueva</a></h4>
					</div>
				</form>
			</div><!-- /#login-box -->
		</div><!-- /.container -->
		<div id="particles-js"></div>
		<!-- jQuery -->
		<script src="https://code.jquery.com/jquery-3.2.1.js" 
				integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" 
				crossorigin="anonymous">
		</script>
		<!-- Bootstrap Core JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
				integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
				crossorigin="anonymous">
		</script>
		<script src="resources/js/login.js"></script>
		<script src="resources/js/particulas.js"></script>
	</body>
</html>
