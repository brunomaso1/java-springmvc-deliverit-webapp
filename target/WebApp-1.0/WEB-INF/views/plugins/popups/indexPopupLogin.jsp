<%-- No se usa --%>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<div id="popupIniciarSesion" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Contenido Popup content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Iniciar</h4>
					</div>
					<div class="modal-body">
						<form method="POST" action="${contextPath}/login" class="form-signin">
							<h2 class="form-heading">Log in</h2>

							<div class="form-group ${error != null ? 'has-error' : ''}">
								<span>${message}</span>
								<input name="username" type="text" class="form-control" placeholder="Username"
									   autofocus="true"/>
								<input name="password" type="password" class="form-control" placeholder="Password"/>
								<span>${error}</span>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

								<button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
								<h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>