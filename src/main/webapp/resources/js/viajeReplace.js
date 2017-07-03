"use strict";
var map;
var pos;
var mapZoom = 14;
var urlIcon = 'resources/img/iconosMaps/';
var urlMoto = 'resources/img/moto.png';
var png = '.png';
var colorSet = ['blue', 'brown', 'gray', 'green', 'orange', 'purple', 'red', 'yellow'];
var colors = [];
var colorSetLen = colorSet.length;
var table = document.getElementById("pedidos");
var posiciones = [];
var markadores = [];
var flag = false;
var intervalo = 0;
var repeater = 0;
var contents = [];
var deliverys = [];

function Delivery(deliveryId, viajeId, markador) {
	this.deliveryId = deliveryId;
	this.viajeId = viajeId;
	this.markador = markador;
}
/**
 * Inicia el mapa.
 */

function initMap() {
	map = new google.maps.Map(document.getElementById(op.nombreMapaViaje), {
		center: {
			lat: -34.9082249,
			lng: -56.1664964
		},
		zoom: mapZoom,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	});
	// Try HTML5 geolocation.
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function (position) {
			pos = {
				lat: position.coords.latitude,
				lng: position.coords.longitude
			};
			map.setCenter(pos);
		}, function () {
			handleLocationError(true, infoWindow, map.getCenter());
		});
	} else {
		// Browser doesn't support Geolocation
		window.window.alert("No se soporta geolocalizacion, no se carga la ubicacion de la sucursal.");
	}
	setMarkers();
	timeCargarMarkadores();
	actualizarDeliverys();
}

function initFiltro() {
	switch (op.estadoIdActual) {
		case "1":
			document.getElementById("botonPendiente").style.backgroundColor = "#000000";
			break;
		case "2":
			document.getElementById("botonPublicado").style.backgroundColor = "#000000";
			break;
		case "3":
			document.getElementById("botonEnProceso").style.backgroundColor = "#000000";
			break;
		case "4":
			document.getElementById("botonTerminado").style.backgroundColor = "#000000";
			break;
	}
}

/**
 * Inicia los listeners para la tabla.
 * @returns {undefined}
 */
function initTableListener() {
	window.onload = addRowHandlers();
}

/**
 * Carga la funcion markadores cada medio segundo hasta que se ejecute (espera a que este el mapa).
 * @returns {undefined}
 */
function timeCargarMarkadores() {
	if (table.rows.length > 1) {
		repeater = window.setInterval(cargarMarkadores, 500);
	}
}
//No se usa.
function ajustarZoom() {
	var bounds = new google.maps.LatLngBounds();
	var i = 0;
	var l = markadores.length;
	for (; i < l; i++) {
		bounds.extend(markadores[i].getPosition());
	}
	map.fitBounds(bounds);
}
/**
 * Agrega los eventos a las filas.
 * @returns {undefined}
 */
function addRowHandlers() {
	var rows = table.getElementsByTagName("tr");
	var i = 0;
	var l = rows.length;
	for (; i < l; i++) {
		var currentRow = table.rows[i];
		var createClickHandler = function (row) {
			return function () {
				var marker = markadores[row.rowIndex - 1];
				marker.setAnimation(google.maps.Animation.BOUNCE);
				stopAnimation(marker);
			}
		};
		var createDoubleClickHandler = function (row) {
			return function () {
				resaltarMarkador(row.rowIndex - 1)
			}
		};
		currentRow.onclick = createClickHandler(currentRow);
		currentRow.ondblclick = createDoubleClickHandler(currentRow);
	}
}
/**
 * Para la animacion de un markador.
 * @param {type} marker
 * @returns {undefined}
 */
function stopAnimation(marker) {
	setTimeout(function () {
		marker.setAnimation(null);
	}, 3000);
}
//function resaltarDelivery(viaje) {
//  if (deliverys != null) {
//      var delivery = getDeliveryViaje(viaje);
//      var posAnterior = map.getZoom();
//      map.setZoom(13);
//      map.setCenter(delivery.markador.getPosition());
//      window.setTimeout(function () {
//          map.setZoom(posAnterior);
//      }, 3000);
//  }
//}
function resaltarMarkador(idrow) {
	var posAnterior = map.getZoom();
	map.setZoom(17);
	map.setCenter(markadores[idrow].getPosition());
	window.setTimeout(function () {
		map.setZoom(posAnterior);
	}, 5000);
}

function cargarDeliverys() {
	deliverys = [];
	getAllDelivery(op.url);
	var i = 0;
	var l = deliverys.length;
	for (; i < l; i++) {
		var posicion = {
			lat: deliverys[i].ubicacion.latitud,
			lng: deliverys[i].ubicacion.longitud
		};
		var marker = new google.maps.Marker({
			position: posicion,
			map: map,
			draggable: false,
			icon: op.moto
		});
		var delivery = new Delivery(deliverys[i].id, deliverys[i].idViaje, marker);
		deliverys.push(delivery);
	}
}

function actualizarDeliverys() {
	if (op.estadoIdActual == "3") {
		cargarDeliverys();
		setInterval(cargarDeliverys, 5000);
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
	xhttp.open("GET", url, false);
	xhttp.send();
	var text = xhttp.responseText;
	deliverys = JSON.parse(text);
}

