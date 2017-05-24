<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand bottom-padding-1" href="viaje.html"><img src="resources/img/logo-navibar.png"> </a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${usuarioActual}<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li>
							<a href="#"><i class="fa fa-fw fa-user"></i> Perfil</a>
						</li>
						<li>
							<a href="#"><i class="fa fa-fw fa-gear"></i> Configuracion</a>
						</li>
						<li class="divider">

						</li>
						<li>
							<c:if test="${pageContext.request.userPrincipal.name != null}">
								<form id="logoutForm" method="POST" action="${contextPath}/logout">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								</form>
								<a onclick="document.forms['logoutForm'].submit()"><i class="fa fa-fw fa-power-off"></i> Salir</a>
							</c:if>
						</li>
					</ul>
				</li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li>
						<a href="viaje.html"><i class="fa fa-fw fa-bicycle" aria-hidden="true"></i> Viajes</a>
					</li>
					<li>
						<a href="clientes.html"><i class="fa fa-fw fa-address-book-o" aria-hidden="true"></i> Clientes</a>
					</li>
					<li>
						<a href="deliverys.html"><i class="fa fa-fw fa-motorcycle" aria-hidden="true"></i> Deliverys</a>
					</li>
					<li>
						<a href="calificacion.html"><i class="fa fa-fw fa-star" aria-hidden="true"></i> Calificaciones</a>
					</li>
					<li>
						<a href="estadoCuenta.html"><i class="fa fa-fw fa-credit-card-alt" aria-hidden="true"></i> Estado de cuenta</a>
					</li>
					<li>
						<a href="javascript:;" data-toggle="collapse" data-target="#droplist1"><i class="fa fa-fw fa-history" aria-hidden="true"></i> Historial 
						<i class="fa fa-fw fa-caret-down"></i></a>
						<ul id="droplist1" class="collapse">
							<li>
								<a href="historialViaje.html"><i class="fa fa-fw fa-book" aria-hidden="true"></i> Viajes</a>
							</li>
							<li>
								<a href="historialPedidos.html"><i class="fa fa-fw fa-hand-o-up" aria-hidden="true"></i> Pedidos</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>
	</body>
</html>