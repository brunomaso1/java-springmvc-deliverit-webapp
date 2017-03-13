<%@include file="headers/headers.jsp"%>

<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="keywords" content="">

		<title>DeliverIT</title>

		<!-- Tags de Facebook, google, etc. -->
		<meta property="og:title" content="">
		<meta property="og:type" content="website">
		<meta property="og:url" content="">
		<meta property="og:site_name" content="">
		<meta property="og:description" content="">

		<!-- Bootstrap Core CSS -->
		<link href="res/css/bootstrap.min.css" rel="stylesheet">

		<!-- Custom CSS -->
		<link href="res/css/restaurant.css" rel="stylesheet">

		<!-- Morris Charts CSS -->
		<link href="res/css/plugins/morris.css" rel="stylesheet">

		<!-- Custom Fonts -->
		<link href="res/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

		<!-- Favicon -->
		<link rel="shortcut icon" type="image/png" href="res/img/favicon.png">
	</head>
	<body>
		<div id="wrapper">
			<!-- Navigation -->
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand bottom-padding-1" href="viaje.html"><img src="res/img/logo-navibar.png"> </a>
				</div>
				<!-- Top Menu Items -->
				<ul class="nav navbar-right top-nav">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
						<ul class="dropdown-menu message-dropdown">
							<li class="message-preview">
								<a href="#">
									<div class="media">
										<span class="pull-left">
											<img class="media-object" src="http://placehold.it/50x50" alt="">
										</span>
										<div class="media-body">
											<h5 class="media-heading"><strong> Venecia Pizzeria Rodo</strong>
											</h5>
											<p class="small text-muted"><i class="fa fa-clock-o"></i> Ayer a las 4:32 PM</p>
											<p> Mañana voy a necesitar 30 cajas, vos tenes alguna caja que te sobre?</p>
										</div>
									</div>
								</a>
							</li>
							<li class="message-preview">
								<a href="#">
									<div class="media">
										<span class="pull-left">
											<img class="media-object" src="http://placehold.it/50x50" alt="">
										</span>
										<div class="media-body">
											<h5 class="media-heading"><strong> Barack Obama</strong>
											</h5>
											<p class="small text-muted"><i class="fa fa-clock-o"></i> Hoy a las 00:32 AM</p>
											<p> Se me quedó la moto, te llamé pero se ve que estas ocupado. Cuando veas llamame.</p>
										</div>
									</div>
								</a>
							</li>
							<li class="message-preview">
								<a href="#">
									<div class="media">
										<span class="pull-left">
											<img class="media-object" src="http://placehold.it/50x50" alt="">
										</span>
										<div class="media-body">
											<h5 class="media-heading"><strong> DeliverIT</strong>
											</h5>
											<p class="small text-muted"><i class="fa fa-clock-o"></i> Hoy a las 00:50 PM</p>
											<p> Michelle Obama ha terminado el viaje 5 correctamente y sin problemas reportados.</p>
										</div>
									</div>
								</a>
							</li>
							<li class="message-footer">
								<a href="#"> Marcar todos como leidos</a>
							</li>
						</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
						<ul class="dropdown-menu alert-dropdown">
							<li>
								<a href="#">Jose Villegas <span class="label label-primary">No entregado</span></a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#"> Ver todas las alertas</a>
							</li>
						</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Pizzeria Venecia 18 <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li>
								<a href="#"><i class="fa fa-fw fa-user"></i> Perfil</a>
							</li>
							<li>
								<a href="#"><i class="fa fa-fw fa-envelope"></i> Mensajes</a>
							</li>
							<li>
								<a href="#"><i class="fa fa-fw fa-gear"></i> Configuración</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#"><i class="fa fa-fw fa-power-off"></i> Salir</a>
							</li>
						</ul>
					</li>
				</ul>
				<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul class="nav navbar-nav side-nav">
						<li class="active">
							<a href="restaurant.html"><i class="fa fa-fw fa-motorcycle " aria-hidden="true"></i> Sucursales</a> <span class="sr-only">(current)</span>
						</li>
						<li>
							<a href="calificacion.html"><i class="fa fa-fw fa-star" aria-hidden="true"></i> Calificaciones</a>
						</li>
						<li>
							<a href="estadoCuenta.html"><i class="fa fa-fw fa-credit-card-alt" aria-hidden="true"></i> Estado de cuenta</a>
						</li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</nav>
			<div id="page-wrapper">
				<div class="container-fluid">
					<!-- Page Heading -->
					<div class="row">
						<div class="col-lg-3">
							<h1 class="headline">
								Mis sucursales <!-- <small>Statistics Overview</small> -->
							</h1>
						</div>
						<div class="col-lg-3 col-lg-offset-6 text-right top-padding-1">
<!--							<button id="nuevoViaje" name="nuevoViaje" onclick="location.href = './viaje/viajeNuevo.html'" class="btn btn-lg btn-color-naraja">Nueva Sucursal</button>-->
						<!--Data model!-->
						</div>
					</div>
					<!-- /.row -->
					<div class="row">
						<div class="col-lg-6">
							<div class="panel panel-default panel-height">
								<div class="panel-heading">
									<h3 class="panel-title"><i class="fa fa-fw fa-cutlery" aria-hidden="true"></i> Sucursales</h3>
								</div>
								<!-- /.row -->
								<div class="panel-body">
									<div class="input-group bottom-padding-1">
										<input type="text" class="form-control" placeholder="Estas buscando algúna sucursal en particular? Ingresala acá!">
										<div class="input-group-btn">
											<button id="advancedSearch" name="advancedSearch" class="btn btn-primary btn-md" data-toggle="tooltip" title="Busqueda avanzada"><span class="glyphicon glyphicon-search"></span></button>
										</div>												
									</div>
									<div class="table-responsive">
										<table class="table table-bordered table-hover table-striped">
											<thead>
												<tr>
													<th>#</th>
													<th>Nombre</th>
													<th>Direccion</th>
												</tr>
											</thead>
											<tbody>
												${datosTablaPrincipal}
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="panel panel-default panel-height">
								<div class="panel-heading">
									<h3 class="panel-title"><i class="fa fa-long-arrow-right fa-fw"></i> Ubicaciones</h3>
								</div>
								<div class="panel-body">
									<div class="map-responsive" id="map"></div>
								</div>
							</div>
						</div>
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /#page-wrapper -->
		</div>
		<!-- /#wrapper -->		

		<!-- jQuery -->
		<script src="res/js/jquery-3.1.1.min.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="res/js/bootstrap.min.js"></script>

		<!-- Default page javascripts -->
		<script src="res/js/restaurant.js"></script>	

		<!-- Google Maps -->
		<script src="res/js/restaurantMapa.js"></script>
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA2NCnQBRCbuXHbNeUY7mW-lvP-v4V3x8A&callback=initMap"></script>

		<!-- User javascripts -->
		<script>activarTooltip("tooltip");</script>
	</body>
</html>