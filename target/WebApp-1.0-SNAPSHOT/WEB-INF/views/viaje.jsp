<%-- Importaciones, declaracion de contenido, etc. --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clases.viaje.ViajeUtil" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<meta name="keywords" content="">

    <title>DeliverIT</title>
	
	<!-- Tags de Facebook, google, etc. -->
	<meta property="og:title" content="">
	<meta property="og:type" content="website">
	<meta property="og:url" content="">
	<meta property="og:site_name" content="">
	<meta property="og:description" content="">

    <!-- Bootstrap Core CSS -->
    <link href="res/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="res/css/viaje.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="res/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="res/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

	<!-- Favicon -->
	<link rel="shortcut icon" type="image/png" href="res/img/favicon.png">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    <div id="wrapper">

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
                <a class="navbar-brand" href="viaje.html"> DeliverIT </a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown">
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong> Venecia Pizzeria Rodo</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Ayer a las 4:32 PM</p>
                                        <p> Mañana voy a necesitar 30 cajas, vos tenes alguna caja que te sobre?</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong> Barack Obama</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Hoy a las 00:32 AM</p>
                                        <p> Se me quedó la moto, te llamé pero se ve que estas ocupado. Cuando veas llamame.</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong> DeliverIT</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Hoy a las 00:50 PM</p>
                                        <p> Michelle Obama ha terminado el viaje 5 correctamente y sin problemas reportados.</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-footer">
                            <a href="#"> Marcar todos como leidos</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        <!-- <li>
                            <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                        </li> -->
                        <li>
                            <a href="#"> Jose Villegas<span class="label label-primary">Pedido No Entregado</span></a>
                        </li>
                        <!-- <li>
                            <a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
                        </li> -->
                        <li class="divider"></li>
                        <li>
                            <a href="#"> Ver todas las alertas</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Pizzeria Venecia 18 <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Perfil</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Bandeja de entrada</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Configuracion</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Salir</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="viaje.html"><i class="fa fa-fw fa-dashboard"></i> Viajes</a> <span class="sr-only">(current)</span>
                    </li>
                    <li>
                        <a href="calificacion.html"><i class="fa fa-fw fa-bar-chart-o"></i> Calificaciones</a>
                    </li>
                    <!-- <li>
                        <a href="historial.html"><i class="fa fa-fw fa-table"></i> Historial</a>
                    </li> -->
                    <li>
                        <a href="estadoCuenta.html"><i class="fa fa-fw fa-edit"></i> Estado de cuenta</a>
                    </li>
                   <!--  <li>
                        <a href="bootstrap-elements.html"><i class="fa fa-fw fa-desktop"></i> Bootstrap Elements</a>
                    </li>
                    <li>
                        <a href="bootstrap-grid.html"><i class="fa fa-fw fa-wrench"></i> Bootstrap Grid</a>
                    </li> -->
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#droplist1"><i class="fa fa-fw fa-arrows-v"></i> Historial <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="droplist1" class="collapse">
                            <li>
                                <a href="#">Viajes</a>
                            </li>
                            <li>
                                <a href="#">Clientes</a>
                            </li>
							<li>
                                <a href="#">Deliverys</a>
                            </li>
                        </ul>
                    </li>
                    <!-- <li>
                        <a href="blank-page.html"><i class="fa fa-fw fa-file"></i> Blank Page</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Viajes <!-- <small>Statistics Overview</small> -->
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Filtros
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <!-- <div class="row">
                    <div class="col-lg-12">
                        <div class="alert alert-info alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <i class="fa fa-info-circle"></i>  <strong>Like SB Admin?</strong> Try out <a href="http://startbootstrap.com/template-overviews/sb-admin-2" class="alert-link">SB Admin 2</a> for additional features!
                        </div>
                    </div>
                </div> -->
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-comments fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">3</div>
                                        <div>Pedidos pendientes hoy!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="viaje/refreshPendiente.html">
                                <div class="panel-footer">
                                    <span class="pull-left">Aplicar filtro</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-tasks fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">3</div>
                                        <div>Pedidos publicados hoy!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="viaje/refreshPublicado.html">
                                <div class="panel-footer">
                                    <span class="pull-left">Aplicar filtro</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-shopping-cart fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">4</div>
                                        <div>Pedidos en proceso hoy!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="viaje/refreshEnProceso.html">
                                <div class="panel-footer">
                                    <span class="pull-left">Aplicar filtro</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-support fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">23</div>
                                        <div>Pedidos terminados hoy!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="viaje/refreshTerminado.html">
                                <div class="panel-footer">
                                    <span class="pull-left">Aplicar filtro</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-money fa-fw"></i> Pedidos</h3>
                            </div>
							
							<div class="row">
								<div class="col-md-8">
									<input type="text" class="form-control" placeholder="Busqueda...">
								</div>
								<div class="col-md-4 ">
									<button type="button" id="llamarModal" data-toggle="modal" data-target="#popupNuevoViaje" class="btn btn-primary btn-md pull-right">Nuevo Viaje</button>
								</div>
							</div>
							<!-- /.row -->
							
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover table-striped">
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
                                            <%
												out.print(ViajeUtil.popularTablaPrincipal());
											%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
					<div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-long-arrow-right fa-fw"></i> Deliverys</h3>
                            </div>
                            <div class="panel-body">
                                <div class="map-responsive">
									<div id="map" style="width: 500px; height: 500px"></div>
								</div>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
	
	<!-- Modals	 -->
	<!-- Popup Nuevo viaje -->
    <div id="popupNuevoViaje" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Contenido Popup content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Nuevo viaje</h4>
				</div>
				<div class="modal-body">
					<form action="viaje/nuevoViaje.html" method="POST">					
						<div class="row">
							<div class="table-responsive bottom-padding-5">
								<table id="pedidos" class="table table-striped table-hover">
									<thead>
										<tr>
											<th>#</th>
											<th>Cliente</th>
											<th>Direccion</th>
											<th>Telefono</th>
										</tr>
									</thead>
									<tbody>
										<%
											out.print(ViajeUtil.popularTablaPedidos());
										%>
									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-md-2">
								<div class="bottom-padding-5">
									<button type="button" data-toggle="modal" data-target="#popupNuevoPedido" class="btn btn-secondary btn-md ">Agregar Pedido</button>
								</div>
								<div class="bottom-padding-5">
									<input type="text" id="precio" name="precio" class="form-control" placeholder="Precio">
								</div>
							</div>					
						</div>
						<div class="row">
							<div class="col-md-2 bottom-padding-1">
								<button type="submit" name="tipo" value="publicar" class="btn btn-primary btn-md">Publicar</button>
							</div>
							<div class="col-md-2 bottom-padding-1 pull-left">
								<button type="submit" name="tipo" value="guardar" class="btn btn-primary btn-md">Guardar</button>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
    </div>
	
	<!-- Popup Nuevo Pedido -->
    <div id="popupNuevoPedido" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Contenido Popup content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Nuevo viaje</h4>
				</div>
				<div class="modal-body">
					<form action="viaje/nuevoPedido.html" method="POST">
						<div class="form-group">
							<input id="nombre" name="nombre" placeholder="Nombre cliente"/>
						</div>
						<div class="form-horizontal">
							<input id="calle" name="calle" placeholder="Calle"/>
							<input id="puerta" name="puerta" placeholder="Numero de puerta"/>
						</div>
						<div class="form-horizontal">
							<input id="esquina" name="esquina" placeholder="Esquina"/>
							<input id="apartamento" name="apartamento" placeholder="Apartamento"/>
							<input id="telefono" name="telefono" placeholder="Telefono"/>
						</div>
						<div class="form-group">
							<input class="input-lg" id="aclaraciones" name="aclaraciones" placeholder="Aclaraciones"/>
						</div>
						<button type="submit" class="btn btn-primary">Agregar</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
    </div>

    <!-- jQuery -->
    <script src="res/js/jquery-3.1.1.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="res/js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="res/js/plugins/morris/raphael.min.js"></script>
    <script src="res/js/plugins/morris/morris.min.js"></script>
    <script src="res/js/plugins/morris/morris-data.js"></script>
	
	<!-- Default page javascripts -->
	<script src="res/js/viaje.js"></script>	
	
	<!-- Google Maps -->
	<script src="res/js/mapa.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA2NCnQBRCbuXHbNeUY7mW-lvP-v4V3x8A&callback=myMap"></script>
	
	<!-- Modal javascripts -->
	<!-- <script>activarModal("llamarModal","pedidos");</script> -->
</body>

</html>