<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<div class="panel panel-default panel-height">
			<div class="panel-heading">
				<h3 class="panel-title"><i class="fa fa-fw fa-cutlery" aria-hidden="true"></i> Clientes </h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-striped compact" id="clientes">
						<thead>
							<tr>
								<th>Id</th>
								<th>Nombre</th>
								<th>Direccion</th>
								<th>Telefono</th>
							</tr>
						</thead>
						<tbody>
							${datosTablaClientes}
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>