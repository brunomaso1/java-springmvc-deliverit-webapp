<%-- Importaciones, declaracion de contenido, etc. --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		<link href="res/css/viaje.css" rel="stylesheet">

		<!-- Morris Charts CSS -->
		<link href="res/css/plugins/morris.css" rel="stylesheet">

		<!-- Custom Fonts -->
		<link href="res/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

		<!-- Favicon -->
		<link rel="shortcut icon" type="image/png" href="res/img/favicon.png">
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
			<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
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
					<a class="navbar-brand" href="viaje.html"> DeliverIT </a>
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
							<!-- <li>
								<a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
							</li> -->
							<li>
								<a href="#">Jose Villegas <span class="label label-primary">No entregado</span></a>
							</li>
							<!-- <li>
								<a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
							</li>
							<li>
								<a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
							</li>
							<li>
								<a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
							</li>
							<li>
								<a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
							</li> -->
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
							<a href="viaje.html"><i class="fa fa-fw fa-motorcycle " aria-hidden="true"></i> Viajes</a> <span class="sr-only">(current)</span>
						</li>
						<li>
							<a href="calificacion.html"><i class="fa fa-fw fa-star" aria-hidden="true"></i> Calificaciones</a>
						</li>
						<!-- <li>
							<a href="historial.html"><i class="fa fa-fw fa-table"></i> Historial</a>
						</li> -->
						<li>
							<a href="estadoCuenta.html"><i class="fa fa-fw fa-credit-card-alt" aria-hidden="true"></i> Estado de cuenta</a>
						</li>
						<!--  <li>
							 <a href="bootstrap-elements.html"><i class="fa fa-fw fa-desktop"></i> Bootstrap Elements</a>
						 </li>
						 <li>
							 <a href="bootstrap-grid.html"><i class="fa fa-fw fa-wrench"></i> Bootstrap Grid</a>
						 </li> -->
						<li>
							<a href="javascript:;" data-toggle="collapse" data-target="#droplist1"><i class="fa fa-fw fa-history" aria-hidden="true"></i> Historial <i class="fa fa-fw fa-caret-down"></i></a>
							<ul id="droplist1" class="collapse">
								<li>
									<a href="#">Viajes</a>
								</li>
								<li>
									<a href="#">Clientes</a>
								</li>
								<li>
									<a href="#">Deliverys</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</nav>

			<div id="page-wrapper">

				<div class="container-fluid">

					<!-- Page Heading -->
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">
								Mis viajes <!-- <small>Statistics Overview</small> -->
							</h1>
							<ol class="breadcrumb">
								<li class="active">
									<i class="fa fa-filter" aria-hidden="true"></i> Filtros
								</li>
							</ol>
						</div>
					</div>
					<!-- /.row -->

					<!-- <div class="row">
						<div class="col-lg-12">
							<div class="alert alert-info alert-dismissable">
								<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
								<i class="fa fa-info-circle"></i>  <strong>Like SB Admin?</strong> Try out <a href="http://startbootstrap.com/template-overviews/sb-admin-2" class="alert-link">SB Admin 2</a> for additional features!
							</div>
						</div>
					</div> -->
					<!-- /.row -->

					<div class="row">
						<div class="col-lg-3 col-md-6">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<div class="row">
										<div class="col-xs-3">
											<i class="fa fa-clock-o fa-5x" aria-hidden="true"></i>
										</div>
										<div class="col-xs-9 text-right">
											<div class="huge">${pedidosPendientes}</div>
											<div>Pedidos pendientes hoy!</div>
										</div>
									</div>
								</div>
								<a href="viaje/refreshPendiente.html">
									<div class="panel-footer">
										<span class="pull-left">Aplicar filtro</span>
										<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
										<div class="clearfix"></div>
									</div>
								</a>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="panel panel-green">
								<div class="panel-heading">
									<div class="row">
										<div class="col-xs-3">
											<i class="fa fa-check-circle-o fa-5x" aria-hidden="true"></i>
										</div>
										<div class="col-xs-9 text-right">
											<div class="huge">${viajesPublicaods}</div>
											<div>Viajes publicados hoy!</div>
										</div>
									</div>
								</div>
								<a href="viaje/refreshPublicado.html">
									<div class="panel-footer">
										<span class="pull-left">Aplicar filtro</span>
										<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
										<div class="clearfix"></div>
									</div>
								</a>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="panel panel-yellow">
								<div class="panel-heading">
									<div class="row">
										<div class="col-xs-3">
											<i class="fa fa-car fa-5x" aria-hidden="true"></i>
										</div>
										<div class="col-xs-9 text-right">
											<div class="huge">${viajesEnProceso}</div>
											<div>Viajes en proceso!</div>
										</div>
									</div>
								</div>
								<a href="viaje/refreshEnProceso.html">
									<div class="panel-footer">
										<span class="pull-left">Aplicar filtro</span>
										<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
										<div class="clearfix"></div>
									</div>
								</a>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="panel panel-red">
								<div class="panel-heading">
									<div class="row">
										<div class="col-xs-3">
											<i class="fa fa-bars fa-5x" aria-hidden="true"></i>
										</div>
										<div class="col-xs-9 text-right">
											<div class="huge">${viajesTerminados}</div>
											<div>Viajes terminados hoy!</div>
										</div>
									</div>
								</div>
								<a href="viaje/refreshTerminado.html">
									<div class="panel-footer">
										<span class="pull-left">Aplicar filtro</span>
										<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
										<div class="clearfix"></div>
									</div>
								</a>
							</div>
						</div>
					</div>
					<!-- /.row -->

					<div class="row">
						<div class="col-lg-6">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title"><i class="fa fa-fw fa-cutlery" aria-hidden="true"></i> Pedidos</h3>
								</div>
								<!-- /.row -->

								<div class="panel-body">
									<div class="input-group bottom-padding-1">
										<input type="text" class="form-control" placeholder="Estas buscando algún pedido en particular? Ingresalo acá!">
										<div class="input-group-btn">
											<button id="refreshTablaButton" name="refreshTablaButton" class="btn btn-primary btn-md"><span class="glyphicon glyphicon-refresh"></span></button>
											<button type="button" id="llamarModal" data-toggle="modal" data-target="#popupNuevoViaje" class="btn btn-danger btn-md">Nuevo Viaje</button>
										</div>												
									</div>
									<div class="table-responsive">
										<table class="table table-bordered table-hover table-striped">
											<thead>
												<tr>
													<th>Viaje</th>
													<th>Cliente</th>
													<th>Direccion</th>
													<th>Delivery</th>
													<th>Telefono</th>
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
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title"><i class="fa fa-long-arrow-right fa-fw"></i> Deliverys</h3>
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

		<%-- Se incluyen los modals --%>
		<%@include file="viajeModal.html" %>

		<!-- jQuery -->
		<script src="res/js/jquery-3.1.1.min.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="res/js/bootstrap.min.js"></script>

		<!-- Default page javascripts -->
		<script src="res/js/viaje.js"></script>	

		<!-- Google Maps -->
		<script src="res/js/mapa.js"></script>
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA2NCnQBRCbuXHbNeUY7mW-lvP-v4V3x8A&callback=initMap"></script>

		<!-- Modal javascripts -->
		<script>activarModal("llamarModal","pedidos");</script>
	</body>

</html>