<%@include file="headers/headers.jsp" %>

<!DOCTYPE html>
<html lang="es">
	<head>
		<meta content="text/html; charset=utf-8" http-equiv="content-type">
		<title>DeliverIT</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta property="og:title" content="">
		<meta property="og:type" content="website">
		<meta property="og:url" content="">
		<meta property="og:site_name" content="">
		<meta property="og:description" content="">
		<!-- Styles -->
		<link rel="stylesheet" href="res/css/font-awesome.min.css">
		<link rel="stylesheet" href="res/css/animate.css">
		<link href="http://fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900%7CMontserrat:400,700" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="res/css/bootstrap.min.css">
		<link rel="stylesheet" href="res/css/index.css">
		<link rel="shortcut icon" type="image/png" href="res/img/favicon.png">
		<script src="res/js/modernizr-2.7.1.js"></script>
	</head>
	<body>
		<%-- Navibar --%>
		<%@include file="navibars/indexNavibar.html" %>
	<header>
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
					<a href="index.html"> <img src="res/img/fondo-trasparente.png" alt="Logo"> </a>
				</div>
				<div class="col-xs-6 signin text-right navbar-nav"> 
					<a href="#" data-toggle="modal" data-target="#popupRegistrarse">Registrarse</a> &nbsp; &nbsp;
					<a href="#" data-toggle="modal" data-target="#popupIniciarSesion">Ingresar</a>&nbsp; &nbsp;
				</div>
			</div>
			<div class="row header-info">
				<div class="col-sm-10 col-sm-offset-1 text-center">
					<h1 class="wow fadeIn">Llegó una nueva forma de hacer Delivery!</h1>
					<br>
					<p class="lead wow fadeIn" data-wow-delay="0.5s">Eres Delivery y quieres trabajar cuando quieras y como quieras? O necesitas Deliverys para que entregen tus pedidos de comida? <br> Únete a DeliverIT y soluciona tus problemas! <br>
					</p>
					<div class="row">
						<div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1">
							<div class="row">
								<div class="col-md-12 text-center wow fadeInUp" data-wow-delay="1.8s">
									<button data-toggle="modal" data-target="#popupRegistrarse" class="btn btn-primary btn-lg scroll">Regístrate</button>
								</div>
							</div>
						</div> 
					</div>
					<!-- /.row -->
				</div>
			</div>
		</div>
	</header>

    <!-- Popup Registrarse -->
	<%@include file="popups/indexPopupRegistrarse.html" %>

    <!-- Popup Iniciar Sesion -->
	<%@include file="popups/indexPopupLogin.html" %>

	<!-- Javascript -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="res/js/jquery-1.11.0.min.js"><\/script>')</script>
	<script src="res/js/wow.min.js"></script>
	<script src="res/js/bootstrap.min.js"></script>
	<script src="res/js/index.js"></script>
</body>
</html>