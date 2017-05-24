<!DOCTYPE html> 
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<div class="row">
			<div class="col-lg-3">
				<button class="flag btn3d" onclick="href = location.href = '${contextPath}/viaje/refreshPendiente'">
					<strong>${viajesPendientes}</strong>
					<br> Viajes 
					<br> pendientes hoy
				</button>
			</div>
			<div class="col-lg-3">
				<button class="flag btn3d" onclick="href = location.href = '${contextPath}/viaje/refreshPublicado'">
					<strong>${viajesPublicaods}</strong>
					<br> Viajes 
					<br> publicados hoy
				</button>
			</div>
			<div class="col-lg-3">
				<button class="flag btn3d" onclick="href = location.href = '${contextPath}/viaje/refreshEnProceso'">
					<strong>${viajesEnProceso}</strong>
					<br> Viajes 
					<br> en proceso hoy
				</button>
			</div>
			<div class="col-lg-3">
				<button class="flag btn3d" onclick="href = location.href = '${contextPath}/viaje/refreshTerminado'">
					<strong>${viajesTerminados}</strong>
					<br> Viajes 
					<br> terminados hoy
				</button>
			</div>
		</div>
		<!-- /.row -->
	</body>
</html>