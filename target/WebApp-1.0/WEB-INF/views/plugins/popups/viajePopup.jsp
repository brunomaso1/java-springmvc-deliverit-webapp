<!DOCTYPE html> 
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<div id="popupNuevoPedido" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Contenido Popup content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Datos del pedido</h4>
					</div>
					<div class="modal-body">
						<div class="form-group form-inline">
							<label>Nombre: </label>
							<p id="showName"></p>
							<label>Telefono: </label>
							<p id="showTelefono"></p>							
						</div>
						<div class="form-group">
							<label for="calle">Direccion: </label>
							<p id="showDireccion"></p>
						</div>
						<div class="form-group form-inline">
							<label>Telefono: </label>
							<input type="number" id="telefono" name="telefono" class="form-control" placeholder="Telefono">
							<label for="pago">Pago online? </label>
							<input type="checkbox" name="pago" checked data-toggle="toggle" data-onstyle="success" data-on="S" data-off="N" data-size="small" class="form-control">
						</div>
						<div class="form-group">
							<label for="aclaraciones">Aclaraciones: </label>
							<textarea class="form-control" rows="3" placeholder="Cuidado con el perro? " id="aclaraciones" name="aclaraciones"></textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>