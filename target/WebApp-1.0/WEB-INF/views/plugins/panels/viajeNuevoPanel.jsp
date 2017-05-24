<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<div class="panel panel-default panel-height">
			<div class="panel-heading">
				<h3 class="panel-title"><i class="fa fa-fw fa-cutlery" aria-hidden="true"></i> Pedidos</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table id="pedidos" class="table table-striped table-hover">
						<thead>
							<tr>
								<th>#</th>
								<th>Cliente</th>
								<th id="direccionTabla">Direccion</th>
								<th>Telefono</th>
							</tr>
						</thead>
						<tbody>
							${datosTablaPedido}
						</tbody>
					</table>
				</div>
			</div>
			<div class="panel-footer">
				<button type="button" data-toggle="modal" data-target="#popupNuevoPedido" id="agregarPedido" class="btn btn-warning btn-md pull-right btn3d">Agregar Pedido</button>
			</div>
		</div>
	</body>
</html>