<%@include file="headers/headers.jsp" %>

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
	</head>
	<body>
		<div id="wrapper">
			<%@include file="navibars/navibar.html" %>
			
			<div id="page-wrapper">
				<div class="container-fluid">
					<!-- Page Heading -->
					<div class="row">
						<div class="col-lg-3">
							<h1 class="headline">
								Mis viajes <!-- <small>Statistics Overview</small> -->
							</h1>
						</div>
						<div class="col-lg-3 col-lg-offset-6 text-right top-padding-1">
							<button id="nuevoViaje" name="nuevoViaje" onclick="location.href = './viaje/viajeNuevo.html'" class="btn btn-lg btn-color-naraja">Nuevo viaje</button>
						</div>
					</div>
					<!-- /.row -->
					<div class="row">
						<div class="col-lg-3 col-md-6">
							<div class="panel">
								<a class="letra-blanca link-hoover-negro" href="viaje/refreshPendiente.html">
									<div class="panel-pendientes">
										<div class="row">
											<div class="col-xs-3">
												<i class="fa fa-clock-o fa-4x icono-negro" aria-hidden="true"></i>
											</div>
											<div class="col-xs-9 text-center">
												<div class="huge">${viajesPendientes}</div>
												<div>Viajes pendientes hoy!</div>
											</div>
										</div>
									</div>
								</a>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="panel">
								<a class="letra-blanca link-hoover-negro" href="viaje/refreshPublicado.html">
									<div class="panel-publicados">
										<div class="row">
											<div class="col-xs-3">
												<i class="fa fa-check-circle-o fa-4x icono-negro" aria-hidden="true"></i>
											</div>
											<div class="col-xs-9 text-center">
												<div class="huge">${viajesPublicaods}</div>
												<div>Viajes publicados hoy!</div>
											</div>
										</div>
									</div>
								</a>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="panel">
								<a class="letra-blanca link-hoover-negro" href="viaje/refreshEnProceso.html">
									<div class="panel-enProceso">
										<div class="row">
											<div class="col-xs-3 center-block">
												<i class="fa fa-car fa-4x icono-negro" aria-hidden="true"></i>
											</div>
											<div class="col-xs-9 text-center">
												<div class="huge">${viajesEnProceso}</div>
												<div>Viajes en proceso!</div>
											</div>
										</div>
									</div>
								</a>								
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="panel">
								<a class="letra-blanca link-hoover-negro" href="viaje/refreshTerminado.html">
									<div class="panel-finalizado">
										<div class="row">
											<div class="col-xs-3">
												<i class="fa fa-bars fa-4x icono-negro" aria-hidden="true"></i>
											</div>
											<div class="col-xs-9 text-center">
												<div class="huge">${viajesTerminados}</div>
												<div>Viajes terminados hoy!</div>
											</div>
										</div>
									</div>
								</a>								
							</div>
						</div>
					</div>
					<!-- /.row -->
					<div class="row">
						<div class="col-lg-6">
							<div class="panel panel-default panel-height">
								<div class="panel-heading">
									<h3 class="panel-title"><i class="fa fa-fw fa-cutlery" aria-hidden="true"></i> Pedidos</h3>
								</div>
								<!-- /.row -->
								<div class="panel-body">
									${alertaFiltro}
									<div class="input-group bottom-padding-1">
										<input type="text" class="form-control" placeholder="Estas buscando algún pedido en particular? Ingresalo acá!">
										<div class="input-group-btn">
											<button id="advancedSearch" name="advancedSearch" class="btn btn-primary btn-md" data-toggle="tooltip" title="Busqueda avanzada"><span class="glyphicon glyphicon-search"></span></button>
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
							<div class="panel panel-default panel-height">
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

		<!-- jQuery -->
		<script src="res/js/jquery-3.1.1.min.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="res/js/bootstrap.min.js"></script>

		<!-- Default page javascripts -->
		<script src="res/js/viaje.js"></script>	

		<!-- Google Maps -->
		<script src="res/js/viajeMapa.js"></script>
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA2NCnQBRCbuXHbNeUY7mW-lvP-v4V3x8A&callback=initMap"></script>

		<!-- User javascripts -->
		<script>activarTooltip("tooltip");</script>
	</body>
</html>