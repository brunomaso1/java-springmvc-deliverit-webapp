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
		<!-- DataTables Buttons -->
		<link rel="stylesheet" type="text/css" 
			  href="https://cdn.datatables.net/buttons/1.3.1/css/buttons.dataTables.min.css"/>
		<!-- Favicon -->
		<link rel="shortcut icon" type="image/png" href="resources/img/favicon.png">
		<!-- User stylesheets -->
		<link href="resources/css/deliverys.css" rel="stylesheet">
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
								Deliverys
							</h1>
						</div>
					</div>
					<!-- /.row -->
					<div class="row">
						<%@include file="plugins/panels/deliverysPanel.jsp" %>
					</div>
				</div>
			</div>
		</div>
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
		<!-- DataTables -->
		<script src="https://cdn.datatables.net/v/bs/dt-1.10.13/r-2.1.1/datatables.min.js"></script>
		<!-- DataTables Buttons -->
		<script src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>
		<script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.flash.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
		<script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/pdfmake.min.js"></script>
		<script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/vfs_fonts.js"></script>
		<script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
		<script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.print.min.js"></script>
		<!-- User javascripts -->
		<script src="resources/js/deliverys.js"></script>
		<script>initData(${opciones});</script>
		<script>initDataTable();</script>
	</body>
</html>