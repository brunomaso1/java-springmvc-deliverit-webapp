<%@include file="plugins/headers/headers.jsp" %>

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
		<!-- Facebook, google, etc. tags -->
		<meta property="og:title" content="">
		<meta property="og:type" content="website">
		<meta property="og:url" content="">
		<meta property="og:site_name" content="">
		<meta property="og:description" content="">
		<!-- Bootstrap Core CSS -->
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
			  rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
			  crossorigin="anonymous">
		<!-- Fonts -->
		<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" 
			  rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" 
			  crossorigin="anonymous">
		<!-- Datatables -->
		<link rel="stylesheet" type="text/css" 
			  href="https://cdn.datatables.net/v/bs/dt-1.10.13/r-2.1.1/datatables.min.css"/>
		<!-- Favicon -->
		<link rel="shortcut icon" type="image/png" href="resources/img/favicon.png">
		<!-- User stylesheets -->
		<link href="resources/css/viaje.css" rel="stylesheet">
	</head>
	<body>
		<div id="wrapper">
			<%@include file="plugins/navibars/navibar.jsp" %>
			<div id="page-wrapper">
				<div class="container-fluid">
					<!-- Page Heading -->
					<div class="row">
						<div class="col-lg-3">
							<h1 class="headline">
								Mis viajes
							</h1>
						</div>
						<div class="col-lg-3 col-lg-offset-6 text-right top-padding-1">
							<button id="nuevoViaje" name="nuevoViaje" onclick="location.href = './viaje/viajeNuevo.html'" 
							class="btn btn-primary btn-lg btn3d">Nuevo viaje
							</button>
						</div>
					</div>
					<!-- /.row -->
					<%@include file="plugins/viajeExtras/viajeFiltros.jsp" %>
					<div class="row">
						<div class="col-lg-6">
							<%@include file="plugins/panels/viajePanel.jsp" %>
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
		<script src="https://code.jquery.com/jquery-3.2.1.js" 
				integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" 
				crossorigin="anonymous">
		</script>
		<!-- Bootstrap Core JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
				integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
				crossorigin="anonymous">
		</script>
		<!-- Google Maps -->
		<script async defer 
				src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA2NCnQBRCbuXHbNeUY7mW-lvP-v4V3x8A&callback=initMap">
		</script>
		<!-- DataTables -->
		<script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.13/r-2.1.1/datatables.min.js"></script>
		<!-- User javascripts -->
		<script src="resources/js/viaje.js"></script>	
		<script>initTableListener();</script>
		<script>initDataTable();</script>
		<script>initColors('${filtroActual}');</script>
	</body>
</html>