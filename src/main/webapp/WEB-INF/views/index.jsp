<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header"> 
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> 
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="logo" href="index.html"><img src="res/img/140x32_logo_navibar.png" alt="Logo"></a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" data-toggle="modal" data-target="#popupRegistrarse">Registarse</a></li>
						<li><a href="#" data-toggle="modal" data-target="#popupIniciarSesion">Ingresar</a></li>
						<!-- <li><a href="#">Ayuda</a></li> -->
					</ul>
				</div>
			</div> <!--/.navbar-collapse --> 
		</div>
	<header>
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
					<a href="index.html"> <img src="res/img/fondo-trasparente.png" alt="Logo"> </a>
				</div>
				<div class="col-xs-6 signin text-right navbar-nav"> 
					<a href="#" data-toggle="modal" data-target="#popupRegistrarse">Registrarse</a> &nbsp; &nbsp;
					<a href="#" data-toggle="modal" data-target="#popupIniciarSesion">Ingresar</a>&nbsp; &nbsp;
					<!-- <a href="#" class="scroll">Conócenos</a>&nbsp; &nbsp;
					<a href="#">Ayuda</a> -->
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
						<!--	Cuando se quieran descomentar las lineas comentadas hay que cambiar la ubicacion de los
								botones en la grilla de bootstrap, esto es, agregarle el valor "col-md-4" al boton del medio.-->
								<!-- <div class="col-md-4 text-left wow fadeInUp" data-wow-delay="1s">
						  <a href="#be-the-first" class="btn btn-secondary btn-lg scroll">Quiero ser Delivery!</a> 
						</div> -->
								<div class="col-md-12 text-center wow fadeInUp" data-wow-delay="1.8s">
									<button data-toggle="modal" data-target="#popupRegistrarse" class="btn btn-primary btn-lg scroll">Regístrate</button>
								</div>
								<!-- <div class="col-md-4 text-right wow fadeInUp" data-wow-delay="1.4s">
						<a href="#be-the-first" class="btn btn-secondary btn-lg scroll">Necesito Deliverys!</a>
					  </div> -->
							</div>
						</div> <!--End Button Row--> 
					</div>
				</div>
			</div>
		</div>
	</header>

    <!-- Popup Registrarse -->
    <div id="popupRegistrarse" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Contenido Popup content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Registrarse</h4>
				</div>
				<div class="modal-body">
					<form action="registrarse.html" method="POST">
						<div class="form-group">
							<label for="email">Nombre de usuario: </label>
							<input type="email" class="form-control" id="email">
						</div>
						<div class="form-group">
							<label for="email">Contraseña: </label>
							<input type="email" class="form-control" id="email">
						</div>
				<!--	<div class="form-group">
							<label for="email">Repetir contraseña:</label>
							<input type="email" class="form-control" id="email">
						</div>
						<div class="form-group">
							<label for="email">Email address:</label>
							<input type="email" class="form-control" id="email">
						</div>
						<div class="form-group">
							<label for="email">Direccion:</label>
							<input type="email" class="form-control" id="email">
						</div>
						<div class="form-group">
							<label for="email">Telefono:</label>
							<input type="email" class="form-control" id="email">
						</div>
						<div class="form-group">
							<label for="email">RUT:</label>
							<input type="email" class="form-control" id="email">
						</div>
						<div class="form-group">
							<label for="email">Cuenta red pagos:</label>
							<input type="email" class="form-control" id="email">
						</div>
						<div class="form-group">
							<label for="email">Foto:</label>
							<input type="email" class="form-control" id="email">
						</div> -->
						<button type="submit" class="btn btn-default">Registrarse</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
    </div>

    <!-- Popup Iniciar Sesion -->
    <div id="popupIniciarSesion" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Contenido Popup content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Iniciar</h4>
				</div>
				<div class="modal-body">
					<form action="loguearse.html" method="POST">
						<div class="form-group">
							<label for="email">Nombre de usuario o correo: </label>
							<input type="#" class="form-control" id="#">
						</div>
						<div class="form-group">
							<label for="email">Contraseña: </label>
							<input type="#" class="form-control" id="#">
							<button type="submit" class="btn btn-default">Iniciar</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
    </div>

	<!-------------------------------------------------------------------------------------------------------
	---------------------------------------------------------------------------------------------------------
	-------------------------------------------------------------------------------------------------------->

	<!-- FALTA IMPLEMENTAR LO DE ABAJO -->

	<!--
	<div class="mouse-icon hidden-xs"> </div>
	 <section id="pricing" class="pad-lg">
	  <div class="container">
		<div class="row margin-40">
		  <div class="col-sm-8 col-sm-offset-2 text-center">
			<h2 class="white">Pricing</h2>
			<p class="white">Lorem ipsum dolor sit amet, consectetur adipiscing
			  elit. Aliquam viverra orci ut.</p>
		  </div>
		</div>
		<div class="row margin-50">
		  <div class="col-sm-4 pricing-container wow fadeInUp" data-wow-delay="1s">
			<br>
			<ul class="list-unstyled pricing-table text-center">
			  <li class="headline">
				<h5 class="white">Personal</h5>
			  </li>
			  <li class="price">
				<div class="amount">$5<small>/m</small></div>
			  </li>
			  <li class="info">2 row section for you package information. You
				can include all details or icons</li>
			  <li class="features first">Up To 25 Projects</li>
			  <li class="features">10GB Storage</li>
			  <li class="features">Other info</li>
			  <li class="features last btn btn-secondary btn-wide"><a href="#">Get
				  Started</a></li>
			</ul>
		  </div>
		  <div class="col-sm-4 pricing-container wow fadeInUp" data-wow-delay="0.4s">
			<ul class="list-unstyled pricing-table active text-center">
			  <li class="headline">
				<h5 class="white">Professional</h5>
			  </li>
			  <li class="price">
				<div class="amount">$12<small>/m</small></div>
			  </li>
			  <li class="info">2 row section for you package information. You
				can include all details or icons</li>
			  <li class="features first">Up To 25 Projects</li>
			  <li class="features">10GB Storage</li>
			  <li class="features">Other info</li>
			  <li class="features">Other info</li>
			  <li class="features last btn btn-secondary btn-wide"><a href="#">Get
				  Started</a></li>
			</ul>
		  </div>
		  <div class="col-sm-4 pricing-container wow fadeInUp" data-wow-delay="1.3s">
			<br>
			<ul class="list-unstyled pricing-table text-center">
			  <li class="headline">
				<h5 class="white">Business</h5>
			  </li>
			  <li class="price">
				<div class="amount">$24<small>/m</small></div>
			  </li>
			  <li class="info">2 row section for you package information. You
				can include all details or icons</li>
			  <li class="features first">Up To 25 Projects</li>
			  <li class="features">10GB Storage</li>
			  <li class="features">Other info</li>
			  <li class="features last btn btn-secondary btn-wide"><a href="#">Get
				  Started</a></li>
			</ul>
		  </div>
		</div>
	  </div>
	</section>
	<section id="be-the-first" class="pad-xl">
	  <div class="container">
		<div class="row">
		  <div class="col-sm-8 col-sm-offset-2 text-center margin-30 wow fadeIn"

			data-wow-delay="0.6s">
			<h2>Be the first</h2>
			<p class="lead">Lorem ipsum dolor sit amet, consectetur adipis.</p>
		  </div>
		</div>
		<div class="iphone wow fadeInUp" data-wow-delay="1s"> <img src="res/img/iphone.png">
		</div>
	  </div>
	</section>
	<section id="main-info" class="pad-xl">
	  <div class="container">
		<div class="row">
		  <div class="col-sm-4 wow fadeIn" data-wow-delay="0.4s">
			<hr class="line purple">
			<h3>App Feature One Here</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam
			  viverra orci ut est facilisis, eu elementum mi volutpat.
			  Pellentesque ac tristique nisi.</p>
		  </div>
		  <div class="col-sm-4 wow fadeIn" data-wow-delay="0.8s">
			<hr class="line blue">
			<h3>App Feature One Here</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam
			  viverra orci ut est facilisis, eu elementum mi volutpat.
			  Pellentesque ac tristique nisi.</p>
		  </div>
		  <div class="col-sm-4 wow fadeIn" data-wow-delay="1.2s">
			<hr class="line yellow">
			<h3>App Feature One Here</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam
			  viverra orci ut est facilisis, eu elementum mi volutpat.
			  Pellentesque ac tristique nisi.</p>
		  </div>
		</div>
	  </div>
	</section>   
	<section id="invite" class="pad-lg light-gray-bg">
	  <div class="container">
		<div class="row">
		  <div class="col-sm-8 col-sm-offset-2 text-center">
			<h2 class="black">Get the invite</h2>
			<br>
			<p class="black">Lorem ipsum dolor sit amet, consectetur adipiscing
			  elit. Aliquam viverra orci ut.</p>
			<br>
			<div class="row">
			  <div class="col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
				<form role="form">
				  <div class="form-group"> <input class="form-control" id="exampleInputEmail1"

					  placeholder="Enter Email" type="email"> </div>
				  <button type="submit" class="btn btn-primary btn-lg">Request
					Invite</button> </form>
			  </div>
			</div>
			</div>
		</div>
	  </div>
	</section>
	<section id="press" class="pad-sm">
	  <div class="container">
		<div class="row margin-30 news-container">
		  <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 wow fadeInLeft"

			data-wow-delay="0.8s"> <a href="#" target="_blank"> <img class="news-img pull-left"

				src="res/img/press-01.jpg" alt="Tech Crunch">
			  <p class="black">Lorem ipsum dolor sit amet, consectetur
				adipiscing elit. Aliquam viverra orci ut.<br>
				<small><em>Tech Crunch - January 15, 2015</em></small></p>
			</a> </div>
		</div>
		<div class="row margin-30 news-container">
		  <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 wow fadeInLeft"

			data-wow-delay="1.2s"> <a href="#" target="_blank"> <img class="news-img pull-left"

				src="res/img/press-02.jpg" alt="Forbes">
			  <p class="black">Lorem ipsum dolor sit amet, consectetur
				adipiscing elit. Aliquam viverra orci ut. <br>
				<small><em>Forbes - Feb 25, 2015</em></small></p>
			</a> </div>
		</div>
	  </div>
	</section>
	
	
	<footer>
	  <div class="container">
		<div class="row">
		  <div class="col-sm-8 margin-20">
			<ul class="list-inline social">
			  <li>Contáctanos!</li>
			  <li>Telefono: 099000000<br>
			  </li>
			  <li>DeliverIT<br>
			  </li>
			</ul>
		  </div>
		</div>
	  </div>
	</footer>
	-->
	<!-- Javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="res/js/jquery-1.11.0.min.js"><\/script>')</script>
	<script src="res/js/wow.min.js"></script>
	<script src="res/js/bootstrap.min.js"></script>
	<script src="res/js/index.js"></script>
</body>
</html>