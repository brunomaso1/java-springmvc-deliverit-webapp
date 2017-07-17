/**
 * Este programa se encarga de las siguientes funcionalidades:
 *  - Inicializar el mapa en el panel correspondiente.
 *  - Utilizar geolocaclizacion para ubicar a la sucursal y centrar el mapa en dicha ubicacion.
 *  - Colocar markadores por cada pedido de la lista de pedidos (aparecen todos los pedidos).
 * @type type
 */
"use strict";
var op = {};
var pedidos = [];
var map = {};
var deliverys = [];

function DeliveryBuilder(deliveryId, viajeId, markador, ubicacion) {
	this.deliveryId = deliveryId;
	this.viajeId = viajeId;
	this.markador = markador;
	this.listaUbicaciones = [];
	this.listaUbicaciones.push(ubicacion);
}
/**
 * Inicializa los datos a utilizar para las funciones.
 * @param {OpcionesJavascriptViaje} opciones
 * @param {List<Pedido>} listaPedidos
 * @returns {void}
 */
function initData(opciones, listaPedidos) {
	op = opciones;
	pedidos = listaPedidos;
	modificarEstructuraPedido();
}
/**
 * Inicia la DataTable. Los valores de inicializacion los obtiene de las opciones.
 */
function initDataTable() {
	var nombreTabla = op.identificadorJS + op.nombreTablaViaje;
	$(document).ready(function () {
		$(nombreTabla).DataTable(op.dataTableOptions);
	});
}
/**
 * Inicializa el mapa y ejecuta el siguiente pipe de funciones:
 *  - Coloca todos los markadores de la lista de pedidos en el mapa.
 *  - Agrega funciones a los pedidos.
 * @returns {undefined}
 */
function initMap() {
	map = new google.maps.Map(document.getElementById(op.nombreMapaViaje), {
		center: {
			lat: op.defLat,
			lng: op.defLon
		},
		zoom: op.defZoomMap,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	});
	// Try HTML5 geolocation.
	if (navigator.geolocation) { // La variable global "navigator" contiene toda la info del navegador.
		navigator.geolocation.getCurrentPosition(function (position) {
			var pos = {
				lat: position.coords.latitude,
				lng: position.coords.longitude
			};
			map.setCenter(pos);
		}, function () {
			handleLocationError(true, infoWindow, map.getCenter());
		});
	} else {
		// Browser doesn't support Geolocation
		window.window.alert(op.mensajes.geolocalizacion);
	}
	setMarkers();
	setMarkersVisible();
	addRowHandlers();
	//actualizarDeliverys();
}

function initColors() {
	if (op.estadoIdActual == "2" || op.estadoIdActual == "3") {
		changeColors();
		window.setInterval(changeColors, op.tiempoActivacionCambioColores);
	}
}

function initFiltroColor() {
	switch (op.estadoIdActual) {
		case "1":
			document.getElementById(op.nombreFiltros.filtroPendiende).style.backgroundColor = op.nombreFiltros.backgroundColorFiltros;
			break;
		case "2":
			document.getElementById(op.nombreFiltros.filtroPublicado).style.backgroundColor = op.nombreFiltros.backgroundColorFiltros;
			break;
		case "3":
			document.getElementById(op.nombreFiltros.filtroProceso).style.backgroundColor = op.nombreFiltros.backgroundColorFiltros;
			break;
		case "4":
			document.getElementById(op.nombreFiltros.filtroTerminado).style.backgroundColor = op.nombreFiltros.backgroundColorFiltros;
			break;
	}
}

function initUpdates() {
	excecuteUpdate();
	window.setInterval(excecuteUpdate, op.tiempoActivacionUpdates);
}

function modificarEstructuraPedido() {
	if (pedidos != null && pedidos.length > 0) {
		for (var i = 0, length = pedidos.length; i < length; i++) {
			pedidos[i].marker = {};
			pedidos[i].getViajeId = pedidos[i].viaje.id;
			pedidos[i].getClienteNombre = pedidos[i].cliente.nombre;

			var direccion = "";
			direccion = pedidos[i].cliente.direccion.calle + " " + pedidos[i].cliente.direccion.nroPuerta;
			direccion += (pedidos[i].cliente.direccion.apartamento != null
					&& pedidos[i].cliente.direccion.apartamento != ""
					&& pedidos[i].cliente.direccion.apartamento != "0")
					? "/" + pedidos[i].cliente.direccion.apartamento : "";

			pedidos[i].getDireccionCompleta = direccion;

			var delivery = "";
			delivery += (pedidos[i].viaje.delivery != null) ? pedidos[i].viaje.delivery.usuario.nombre : "";

			pedidos[i].getDeliveryNombre = delivery;
			pedidos[i].getDeliveryId = (pedidos[i].viaje.delivery != null) ? pedidos[i].viaje.delivery.id : null;
			pedidos[i].getFechaHoraViaje = pedidos[i].viaje.fecha;

			var myLatLng = {
				lat: pedidos[i].cliente.direccion.latitud,
				lng: pedidos[i].cliente.direccion.longitud
			};

			pedidos[i].getPedidoId = pedidos[i].id;

			pedidos[i].getLatLng = myLatLng;
		}
		;
	}
	;
}

function changeColors() {
	if (pedidos != null && pedidos.length > 0) {
		var rows = document.getElementById(op.nombreTablaViaje).rows;
		if ((rows.length > 1) && !(rows[1].innerText == op.mensajes.sinDatos) && !(rows[1].innerText == op.mensajes.sinDatosBusqueda)) {
			for (var i = 1, length = rows.length; i < length; i++) {
				var fechaHoraActual = new Date();
				var horaActual = fechaHoraActual.getHours() * 3600 + fechaHoraActual.getMinutes() * 60 + fechaHoraActual.getSeconds();
				var fechaHoraViaje = new Date(getPedidoFromRow(rows[i]).getFechaHoraViaje);
				var horaViaje = (fechaHoraViaje.getHours() + op.serverHourPadding) * 3600 + fechaHoraViaje.getMinutes() * 60 + fechaHoraViaje.getSeconds();
				var dif = parseInt(horaActual) - parseInt(horaViaje);
				switch (true) {
					case (dif < op.tiempoColores.tiempo1):
						break;
					case (dif < op.tiempoColores.tiempo2):
						rows[i].style.backgroundColor = op.tiempoColores.colorTiempo2;
						break;
					case (dif < op.tiempoColores.tiempo3):
						rows[i].style.backgroundColor = op.tiempoColores.colorTiempo3;
						break;
					case (dif < op.tiempoColores.tiempo4):
						rows[i].style.backgroundColor = op.tiempoColores.colorTiempo4;
						break;
					default:
						rows[i].style.backgroundColor = op.tiempoColores.colorTiempoDefault;
						break;
				}
			}
		}
	}
}
/**
 * Coloca los markadores en todos los pedidos de la lista y los pone a todos invisibles.
 * @returns {undefined}
 */
function setMarkers() {
	if (pedidos != null && pedidos.length > 0) {
		var infowindow = new google.maps.InfoWindow();
		for (var i = 0, length = pedidos.length; i < length; i++) {
			var idViaje = pedidos[i].getViajeId;
			var cliente = pedidos[i].getClienteNombre;
			var direccion = pedidos[i].getDireccionCompleta;
			var delivery = pedidos[i].getDeliveryNombre;
			var contenido = "<p><strong>" + cliente + "</strong></p>" + "<p>" + direccion + "</p>";
			if (delivery != "")
				contenido += "Delivery: " + "<strong>" + delivery + "</strong>";
			var posMarker = pedidos[i].getLatLng;
			var marker = new google.maps.Marker({
				position: posMarker,
				map: map,
				draggable: false,
				animation: google.maps.Animation.DROP,
				visible: false,
				icon: {
					url: op.coloresMarkadores[Number(idViaje) % op.coloresMarkadores.length],
					scaledSize: new google.maps.Size(op.iconSize.altura, op.iconSize.ancho),
					labelOrigin: new google.maps.Point(op.labelOrigin.altura, op.labelOrigin.ancho)
				},
				label: {
					text: String(idViaje),
					color: op.labelOrigin.color
				}
			});
			google.maps.event.addListener(marker, 'click', (function (marker, contenido) {
				return function () {
					infowindow.setContent(contenido);
					infowindow.open(map, marker);
				};
			})(marker, contenido));
			pedidos[i].marker = marker;
		}
	}
}

function setMarkersVisible() {
	if (pedidos != null && pedidos.length > 0) {
		// Oculto todos los markadores.
		for (var i = 0, length = pedidos.length; i < length; i++) {
			if (!("undefined" === typeof pedidos[i].marker)) {
				pedidos[i].marker.setVisible(false);
			}
		}
		var rows = document.getElementById(op.nombreTablaViaje).rows;
		if ((rows.length > 1) && !(rows[1].innerText == op.mensajes.sinDatos)) {
			for (var i = 1, length = rows.length; i < length; i++) {
				getPedidoFromRow(rows[i]).marker.setVisible(true);
			}
		}
	}
}

function getPedidoIdFromRow(row) {
	switch (op.estadoIdActual) {
		case "1":
			return row.cells[5].textContent;
			break;
		case "2":
			return row.cells[5].textContent;
			break;
		case "3":
			return row.cells[7].textContent;
			break;
		case "4":
			return row.cells[5].textContent;
			break;
	}
	return row.cells[0].textContent;
}

function getPedidoFromPedidos(pedidoId) {
	for (var i = 0, length = pedidos.length; i < length; i++) {
		if (pedidos[i].getPedidoId == pedidoId)
			return pedidos[i];
	}
}

function getPedidoFromRow(row) {
	return getPedidoFromPedidos(getPedidoIdFromRow(row));
}

function addRowHandlers() {
	if (pedidos != null && pedidos.length > 0) {
		var rows = document.getElementById(op.nombreTablaViaje).rows; // Cuando databables no esta inicializado esto da null.
		if ((rows.length > 1) && !(rows[1].innerText == op.mensajes.sinDatos) && !(rows[1].innerText == op.mensajes.sinDatosBusqueda)) {
			for (var i = 1, length = rows.length; i < length; i++) {
				var createClickHandler = function (pedido) {
					return function () {
						pedido.marker.setAnimation(google.maps.Animation.BOUNCE);
						var markerDelivery = obtenerMarkadorDelivery(pedido.getDeliveryId);
						if (markerDelivery != null)
							markerDelivery.setAnimation(google.maps.Animation.BOUNCE);
						stopAnimation(pedido.marker, markerDelivery);
					};
				};
				var createDoubleClickHandler = function (pedido) {
					return function () {
						resaltarMarkador(pedido.marker);
					};
				};
				rows[i].onclick = createClickHandler(getPedidoFromRow(rows[i]));
				rows[i].ondblclick = createDoubleClickHandler(getPedidoFromRow(rows[i]));
			}
		}
	}
}

function obtenerMarkadorDelivery(deliveryId) {
	if (deliverys != null && deliverys.length > 0) {
		for (var i = 0, length = deliverys.length; i < length; i++) {
			if (deliverys[i].deliveryId == deliveryId)
				return deliverys[i].markador;
		}
	}
	return null;
}

function stopAnimation(marker, markerDellivery) {
	setTimeout(function () {
		marker.setAnimation(null);
		if (markerDellivery != null)
			markerDellivery.setAnimation(null);
	}, op.markerBounceTimeOut);
}

function resaltarMarkador(marker) {
	var posAnterior = map.getZoom();
	map.setZoom(op.zoomResaltarMarkador);
	map.setCenter(marker.getPosition());
	window.setTimeout(function () {
		map.setZoom(posAnterior);
	}, op.timeOutResaltarMarkador);
}

function cargarDeliverys() {
	if (op.estadoIdActual == "3") {
		getAllDelivery(op.urlGetAllDelivery);
	}
}

function actualizarDeliverys() {
	if (op.estadoIdActual == "3") {
		cargarDeliverys();
		setInterval(cargarDeliverys, op.actualizarDeliverysTime);
	}
}

function getDeliveryViaje(viaje) {
	var i = 0;
	var l = deliverys.length;
	for (; i < l; i++) {
		if (deliverys[i].idViaje == viaje) {
			return deliverys[i];
		}
	}
}

function getAllDelivery(url) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			var deliverysJSON = JSON.parse(this.responseText);
			abmDeliverysMap(deliverysJSON);
			addRowHandlers();
		}
	};
	xhttp.open("GET", url, true);
	xhttp.send();
}

function abmDeliverysMap(deliverysJSON) {
	for (var i = 0, length = deliverys.length; i < length; i++) { // Baja
		if (!(findDeliverysIdInDeliverysJSON(deliverys[i].deliveryId, deliverysJSON))) {
			deliverys.splice(i, 1); // Elimina el elemento.
		}
	}
	;
	for (var i = 0, length = deliverysJSON.length; i < length; i++) {
		if (findDeliverysJSONIdInDeliverys(deliverysJSON[i].id)) { // Modificar
			var delivery = getDeliveryFromDeliverys(deliverysJSON[i].id);
			var num = deliverysJSON[i].ubicacion.longitud; // Arreglo porque la api de google redondea a 6 decimales
			num = Math.round(num * 1000000) / 1000000 // Hay que tener cuidado, en algunos casos no redonda bien. Bug de chorme.
			if (!((delivery.markador.position.lat() == deliverysJSON[i].ubicacion.latitud) && (delivery.markador.position.lng() == num))) {
				var myLatLng = {
					lat: deliverysJSON[i].ubicacion.latitud,
					lng: deliverysJSON[i].ubicacion.longitud
				};
				delivery.markador.position = myLatLng;
				delivery.listaUbicaciones.push(myLatLng);
			}
		} else { // Alta
			var infowindow = new google.maps.InfoWindow();
			var myLatLng = {
				lat: deliverysJSON[i].ubicacion.latitud,
				lng: deliverysJSON[i].ubicacion.longitud
			};
			var marker = new google.maps.Marker({
				position: myLatLng,
				map: map,
				draggable: false,
				icon: op.urlMoto
			});
			var deliveryViajeId = getViajeIdFromDeliverysJSON(deliverysJSON[i].id);
			var nombre = deliverysJSON[i].usuario.nombre;
			var contenido = "<strong>" + nombre + "</strong>";
			contenido += "<p>" + "Viaje: " + "<strong>" + deliveryViajeId + "</strong>" + "</p>";
			google.maps.event.addListener(marker, 'click', (function (marker, contenido) {
				return function () {
					infowindow.setContent(contenido);
					infowindow.open(map, marker);
				};
			})(marker, contenido));
			var delivery = new DeliveryBuilder(deliverysJSON[i].id, deliveryViajeId, marker, myLatLng);
			deliverys.push(delivery);
		}
		;
	}
	;
}

function getDeliveryFromDeliverys(deliveryId){
	for (var i = 0, length = deliverys.length; i < length; i++) {
		if (deliverys[i].deliveryId == deliveryId)
			return deliverys[i];
	}
	throw "Error";
}

function getViajeIdFromDeliverysJSON(deliverId) {
	if (pedidos != null && pedidos.length > 0) {
		for (var i = 0, length = pedidos.length; i < length; i++) {
			if (pedidos[i].getDeliveryId == deliverId)
				return pedidos[i].getViajeId;
		}
	}
	;
	throw "Error";
}

function findDeliverysJSONIdInDeliverys(deliveryJSONId) {
	for (var i = 0, length = deliverys.length; i < length; i++) {
		if (deliverys[i].deliveryId == deliveryJSONId)
			return true;
	}
	;
	return false;
}

function findDeliverysIdInDeliverysJSON(deliveryId, deliverysJSON) {
	for (var i = 0, length = deliverysJSON.length; i < length; i++) {
		if (deliverysJSON[i].id == deliveryId)
			return true;
	}
	;
	return false;
}

function excecuteUpdate() {
	var xhttp = new XMLHttpRequest();
	var csrfToken = $("meta[name='_csrf']").attr("content");
	var csrfHeader = $("meta[name='_csrf_header']").attr("content");
	xhttp.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			var objAux = JSON.parse(this.responseText);
			if (objAux.cambios == true) {
				mostrarNotificaciones(objAux);
				var nombreTabla = op.identificadorJS + op.nombreTablaViaje;
				$(nombreTabla).DataTable().destroy();
				document.getElementById(op.nombreTablaViaje).innerHTML = objAux.tablaPedidos;
				initDataTable();
				setMarkers();
				setMarkersVisible();
				addRowHandlers();
				cargarDeliverys();
			}
		}
	};
	var params = 'estadoId=' + op.estadoIdActual;
	xhttp.open("POST", op.urlObtenerPedidosTabla, true);
	xhttp.setRequestHeader(csrfHeader, csrfToken);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(params.toString());
}

function mostrarNotificaciones(objAux) {
	if (op.estadoIdActual == "2") {
		$.notify("Un delivery ha tomado un viaje.", "info");
		// Aumento los pedidos en proceso.
		var cantPed = parseInt(document.getElementById(op.nombreFiltros.filtroProceso).firstElementChild.textContent);
		document.getElementById(op.nombreFiltros.filtroProceso).firstElementChild.textContent = (cantPed + 1).toString();
		// Disminuyo los pedidos publicados.
		var cantPed = parseInt(document.getElementById(op.nombreFiltros.filtroPublicado).firstElementChild.textContent);
		document.getElementById(op.nombreFiltros.filtroPublicado).firstElementChild.textContent = (cantPed - 1).toString();
	} else if (op.estadoIdActual == "3") {
		$.notify("Se ha terminado un viaje.", "success");
		// Aumento los pedidos terminados.
		var cantPed = parseInt(document.getElementById(op.nombreFiltros.filtroTerminado).firstElementChild.textContent);
		document.getElementById(op.nombreFiltros.filtroTerminado).firstElementChild.textContent = (cantPed + 1).toString();
		//Disminuyo los pedidos en proceso.
		var cantPed = parseInt(document.getElementById(op.nombreFiltros.filtroProceso).firstElementChild.textContent);
		document.getElementById(op.nombreFiltros.filtroProceso).firstElementChild.textContent = (cantPed - 1).toString();
	}
}
