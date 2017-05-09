<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<div class="panel panel-default panel-height">
			<div class="panel-heading">
				<h3 class="panel-title"><i class="fa fa-fw fa-cutlery" aria-hidden="true"></i> Pedidos</h3>
			</div>
			<!-- /.row -->
			<div class="panel-body">
				${alertaFiltro}
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
							${datosTablaPrincipal}
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>