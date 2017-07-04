<!DOCTYPE html> 
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<div class="row">
			<div class="col-lg-3">
				<button class="flag btn3d" id=${nombreFiltroPendiende} onclick="href = location.href = '${contextPath}/viaje/refreshPendiente'">
					<strong>${viajesPendientes}</strong>
					<br> Viajes 
					<br> pendientes
				</button>
			</div>
			<div class="col-lg-3">
				<button class="flag btn3d" id=${nombreFiltroPublicado} onclick="href = location.href = '${contextPath}/viaje/refreshPublicado'">
					<strong>${viajesPublicaods}</strong>
					<br> Viajes 
					<br> publicados
				</button>
			</div>
			<div class="col-lg-3">
				<button class="flag btn3d" id=${nombreFiltroProceso} onclick="href = location.href = '${contextPath}/viaje/refreshEnProceso'">
					<strong>${viajesEnProceso}</strong>
					<br> Viajes 
					<br> en proceso
				</button>
			</div>
			<div class="col-lg-3">
				<button class="flag btn3d" id=${nombreFiltroTerminado} onclick="href = location.href = '${contextPath}/viaje/refreshTerminado'">
					<strong>${viajesTerminados}</strong>
					<br> Viajes 
					<br> terminados
				</button>
			</div>
		</div>
		<!-- /.row -->
	</body>
</html>