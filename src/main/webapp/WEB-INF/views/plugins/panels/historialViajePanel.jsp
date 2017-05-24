<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<div class="panel panel-default panel-height">
			<div class="panel-heading">
				<div class="col-lg-6">
					<h3 class="panel-title"><i class="fa fa-fw fa-cutlery" aria-hidden="true"></i> Pedidos </h3>
				</div>
				<div class="col-lg-6 text-right">
					<form action="${contextPath}/historialViaje/exportar" id="filterFormExport" class="form-horizontal" method="POST" >
						<div>
							<button class="btn btn-primary" type="submit">XLS</button>
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<!-- /.row -->
					</form>	
				</div>
			</div>
			<!-- /.row -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-striped compact" id="pedidos">
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
							${datosTablaHistorialViaje}
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>