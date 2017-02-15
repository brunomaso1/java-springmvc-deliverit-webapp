<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/indexApp.css">
		<link rel="shortcut icon" type="image/png" href="img/favicon.png">
	</head>
	<body>
		<!-- Menu desplegable -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
		  <div class="container-fluid">
			<div class="navbar-header">
			  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			  </button>
			  <a class="navbar-brand" href="#">Project name</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
			  <ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
			  </ul>
			  <form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			  </form>
			</div>
		  </div>
		</nav>
		<div class="container-fluid">
			<div class="row">
		  		<!-- Side menu -->
				<div class="col-sm-3 col-md-2 sidebar">
				  <ul class="nav nav-sidebar">
					<li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
					<li><a href="#">Reports</a></li>
					<li><a href="#">Analytics</a></li>
					<li><a href="#">Export</a></li>
				  </ul>
				  <ul class="nav nav-sidebar">
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
				  </ul>
				</div>
				<!-- Contenido -->
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			  		<h1 class="page-header">Dashboard</h1>
		  			<!-- Estados -->
					<div class="row placeholders">
						<div class="col-xs-6 col-sm-3 placeholder">
							<img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
					  		<h4>Label</h4>
					  		<span class="text-muted">Something else</span>
						</div>
						<div class="col-xs-6 col-sm-3 placeholder">
							<img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
						  	<h4>Label</h4>
							<span class="text-muted">Something else</span>
						</div>
						<div class="col-xs-6 col-sm-3 placeholder">
							<img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
						  	<h4>Label</h4>
						 	<span class="text-muted">Something else</span>
						</div>
						<div class="col-xs-6 col-sm-3 placeholder">
							<img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
						  	<h4>Label</h4>
						  	<span class="text-muted">Something else</span>
						</div>
					</div>

					<!-- Grilla y mapa -->
					<div class="row">
						<!-- Grilla -->
						<div class="col-md-6">
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
									<tr>
									  <td>1,001</td>
									  <td>Lorem</td>
									  <td>ipsum</td>
									  <td>dolor</td>
									  <td>sit</td>
								  </tbody>
								</table>
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
		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/mapa.js"></script>
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA2NCnQBRCbuXHbNeUY7mW-lvP-v4V3x8A&callback=myMap"></script>
	</body>
</html>