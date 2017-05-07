<%@include file="plugins/headers/headers.jsp" %>

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
		<!-- Fonts -->
		<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" 
			  rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" 
			  crossorigin="anonymous">
		<!--Animate-->
		<link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css"
			  rel="stylesheet">
		<!--Goggle api fonts-->
		<link href="http://fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900%7CMontserrat:400,700" 
			  rel="stylesheet" type="text/css">
		<!-- Bootstrap Core CSS -->
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
			  rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
			  crossorigin="anonymous">
		<!--User css-->
		<link rel="stylesheet" href="res/css/index.css">
		<!--Favicon-->
		<link rel="shortcut icon" type="image/png" href="res/img/favicon.png">
		<!--Modernizer-->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.js"></script>
	</head>
	<body>
		<%-- Navibar --%>
		<%@include file="plugins/navibars/indexNavibar.html" %>
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
		<%@include file="plugins/popups/indexPopupRegistrarse.html" %>

		<!-- Popup Iniciar Sesion -->
		<%@include file="plugins/popups/indexPopupLogin.html" %>

		<!-- Javascript -->
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
		<!--Wow-->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.min.js"></script>
		<!--User javascript-->
		<script src="resources/js/index.js"></script>
	</body>
</html>