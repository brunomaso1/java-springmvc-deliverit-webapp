<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clases.Util" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="keywords" content="">

		<title>DeliverIT</title>		

		<meta property="og:title" content="">
		<meta property="og:type" content="website">
		<meta property="og:url" content="">
		<meta property="og:site_name" content="">
		<meta property="og:description" content="">

		<!-- Styles -->
		<link rel="stylesheet" href="res/css/bootstrap.min.css">
		<link rel="stylesheet" href="res/css/viajes.css">
		<link rel="shortcut icon" type="image/png" href="res/img/favicon.png">
	</head>
	<body>
		<!-- Menu desplegable -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Activar navegacion</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">DeliverIT</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Opciones</a></li>
					<li><a href="#">Perfil</a></li>
					<li><a href="#">Ayuda</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Busqueda...">
				</form>
			</div>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<!-- Side menu -->
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
			<!--	<li><a href="#">Sucursales</a></li>
					<li><a href="#">Calificaciones</a></li>	-->
					<li class="active"><a href="viajes.html">Viajes <span class="sr-only">(current)</span></a></li>
					
				</ul>
			<!--	<ul class="nav nav-sidebar">
					<li><a href="">Nav item</a></li>
					<li><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
					<li><a href="">More navigation</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
				</ul>	-->
			</div>
			<!-- Contenido -->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">Mis viajes</h1>
				<!-- Estados -->
				<div class="row">
					<div class="col-xs-6 col-sm-3">
						<div class="image-button-img">
							<img src="res/img/pendiente.jpg">	
						</div>
						<div class="image-button-btn bottom-padding-3">				
							<button type="button" class="btn btn-primary btn-lg">Pendientes</button>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="image-button-img">
							<img src="res/img/publicados.jpg">	
						</div>
						<div class="image-button-btn bottom-padding-3">				
							<button type="button" class="btn btn-primary btn-lg">Publicados</button>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="image-button-img">
							<img src="res/img/en-proceso.jpg">	
						</div>
						<div class="image-button-btn bottom-padding-3">				
							<button type="button" class="btn btn-primary btn-lg">En Proceso</button>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="image-button-img">
							<img src="res/img/terminados.jpg">	
						</div>
						<div class="image-button-btn bottom-padding-3">				
							<button type="button" class="btn btn-primary btn-lg">Terminados</button>
						</div>
					</div>
				</div>

				<!-- Grilla y mapa -->
				<div class="row top-padding-1">
					<!-- Grilla -->
					<div class="col-md-6">
						<div class="row">
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="Busqueda...">
							</div>
							<div class="col-md-4 ">
								<button type="button" data-toggle="modal" data-target="#popupNuevoViaje" class="btn btn-primary btn-md pull-right">Nuevo Viaje</button>
							</div>
						</div>
						<div class="row">
							<div class="table-responsive">
								<table class="table table-striped table-hover">
									<thead>
										<tr>
											<th>#</th>
											<th>Header</th>
											<th>Header</th>
											<th>Header</th>
											<th>Header</th>
										</tr>
									</thead>
									<tbody>
										<%
											Util u = new Util();
											out.print(u.popularTabla());
										%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="map-responsive">
							<div id="map" style="width: 500px; height: 500px">
							</div>
						</div>	
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Popup Nuevo viaje -->
    <div id="popupNuevoViaje" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Contenido Popup content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Nuevo viaje</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="table-responsive bottom-padding-5">
							<table id="pedidos" class="table table-striped table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>Header</th>
										<th>Header</th>
										<th>Header</th>
										<th>Header</th>
									</tr>
								</thead>
								<tbody>
									
								</tbody>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<div class="bottom-padding-5">
								<button type="button" data-toggle="modal" data-target="#popupNuevoPedido" class="btn btn-secondary btn-md ">Agregar Pedido</button>
							</div>
							<div class="bottom-padding-5">
								<input type="text" class="form-control" placeholder="Precio">
							</div>
						</div>					
					</div>
					<div class="row">
						<div class="col-md-2 bottom-padding-1">
							<button type="button" class="btn btn-primary btn-md">Publicar</button>
						</div>
						<div class="col-md-2 bottom-padding-1 pull-left">
							<button type="button" class="btn btn-primary btn-md">Guardar</button>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
    </div>
	
	<!-- Popup Nuevo Pedido -->
    <div id="popupNuevoPedido" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Contenido Popup content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Nuevo viaje</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="email">Nombre de usuario o correo: </label>
						<input type="#" class="form-control" id="#">
					</div>
					<div class="form-group">
						<label for="email">Contraseña: </label>
						<input type="#" class="form-control" id="#">
						<button type="button" class="btn btn-primary btn-md" onclick="nuevoPedido('pedidos')" data-dismiss="modal">Agregar</button>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
    </div>
	
	<!-- Bootstrap core JavaScript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="res/js/bootstrap.min.js"></script>
	<script src="res/js/mapa.js"></script>
	<script src="res/js/viajes.js"></script>	
	</script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA2NCnQBRCbuXHbNeUY7mW-lvP-v4V3x8A&callback=myMap"></script>
</body>
</html>