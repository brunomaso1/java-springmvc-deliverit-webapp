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
						<h4 class="modal-title">Nuevo Pedido</h4>
					</div>
					<div class="modal-body">
						<form action="./nuevoPedido.html" method="POST" onsubmit="return validarPedidoForm()">
							<div class="form-group">
								<label for="nombre">Nombre: </label>
								<div class="input-group bottom-padding-1">
									<input type="text" id="nombre" name="nombre" class="form-control" placeholder="Nombre">
									<div class="input-group-btn">
										<button type="button" id="searchName" name="searchName" class="btn btn-primary btn-md"><span class="glyphicon glyphicon-search"></span></button>
									</div>												
								</div>
							</div>
							<div class="form-group form-inline">
								<label for="calle">Calle: </label>
								<input type="text" id="calle" name="calle" class="form-control" placeholder="Calle">
								<label for="puerta">Puerta: </label>
								<input type="number" id="puerta" name="puerta" class="form-control" placeholder="Num puerta">
							</div>
							<div class="form-group form-inline">
								<label for="esquina">Esquina: </label>
								<input type="text" id="esquina" name="esquina" class="form-control" placeholder="Esquina">
								<label for="apartamento">Apartamento: </label>
								<input type="number" id="apartamento" name="apartamento" class="form-control" placeholder="Apartamento">
							</div>
							<div class="form-group form-inline">
								<label for="telefono">Telefono: </label>
								<input type="number" id="telefono" name="telefono" class="form-control" placeholder="Telefono">
								<label for="pago">Pago online? </label>
								<input type="checkbox" name="pago" checked data-toggle="toggle" data-onstyle="success" data-on="S" data-off="N" data-size="small" class="form-control">
							</div>
							<div class="form-group">
								<label for="aclaraciones">Aclaraciones: </label>
								<textarea class="form-control" rows="3" placeholder="Cuidado con el perro? " id="aclaraciones" name="aclaraciones"></textarea>
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<button type="submit" class="btn btn-warning">Ingresar</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>