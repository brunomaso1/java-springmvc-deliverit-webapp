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
					<%@include file="viajeExtras/botones.html" %>
					<div class="row">
						<div class="col-lg-6">
							<%@include file="panels/viajePanel.html" %>
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
		<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA2NCnQBRCbuXHbNeUY7mW-lvP-v4V3x8A&callback=initMap"></script>

		<!-- User javascripts -->
	</body>
</html>