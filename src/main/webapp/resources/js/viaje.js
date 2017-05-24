"use strict";
var map;
var pos;
var mapZoom = 15;
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
 * @returns {undefined}
 */
function initMap(url) {
	map = new google.maps.Map(document.getElementById('map'), {
		center: {lat: -34.9082249, lng: -56.1664964},
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
	//cargarDeliverys();
}

/**
 * Inicia la tabla.
 * @returns {undefined}
 */
function initDataTable() {
	$(document).ready(function () {
		$('#pedidos').DataTable();
	});
	$('#pedidos').DataTable({
		language: {
			processing: "Procesando...",
			search: "Busqueda&nbsp;:",
			lengthMenu: "Mostrar _MENU_ entradas",
			info: "_START_ de _END_. Total: _TOTAL_ ",
			infoEmpty: "Ninguna entrada",
			infoFiltered: "(fitradas de _MAX_ entradas en total)",
			infoPostFix: "",
			loadingRecords: "Cargando registros...",
			zeroRecords: "No se han encontrado registros",
			emptyTable: "No hay datos",
			paginate: {
				first: "Primero",
				previous: "Anterior",
				next: "Siguiente",
				last: "Ultimo"
			}
		}
	});
}

/**
 * Inicia los listeners para la tabla.
 * @returns {undefined}
 */
function initTableListener() {
	window.onload = addRowHandlers();
}

/**
 * Coloca los markadores.
 * @returns {undefined}
 */
function setMarkers() {
	var geocoder = new google.maps.Geocoder();

	if (table.rows.length > 1) {
		var r = 1;
		var n = table.rows.length;
		for (; r < n; r++) {
			var direccion = table.rows[r].cells[2].innerHTML + ", Montevideo";

			geocoder.geocode({'address': direccion}, function (results, status) { // Si le paso otro parametro a esta funcion, no se asigna, ej: r.
				if (status == google.maps.GeocoderStatus.OK) {
					var posMarker = {
						lat: results[0].geometry.location.lat(),
						lng: results[0].geometry.location.lng()
					};
					posiciones.push(posMarker);
					console.log("Push marker.");
				} else {
					posiciones.push(null);
					console.log("Push null.")
				}
				if (posiciones.length == table.rows.length - 1) {
					flag = true;
					console.log("Se cambio flag.");
				}
			});
		}
	}
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

/**
 * Carga los markadores.
 * @returns {undefined}
 */
function cargarMarkadores() {
	console.log("Se entro en los markadores.");
	if (flag) {
		var r = 1;
		var l = posiciones.length;
		var infowindow = new google.maps.InfoWindow();
		for (; r <= l; r++) {
			var i = r - 1;

			var viaje = table.rows[r].cells[0].innerHTML;
			var cliente = table.rows[r].cells[1].innerHTML;
			var direccion = table.rows[r].cells[2].innerHTML;
			var content = "<p><strong>" + cliente + "</strong></p>" + "<p>" + direccion + "</p>";
			contents.push(content);

			var marker = new google.maps.Marker({
				position: posiciones[i],
				map: map,
				draggable: false,
				animation: google.maps.Animation.DROP,
				icon: {
					url: urlIcon + colorSet[Number(viaje) % colorSetLen] + png,
					scaledSize: new google.maps.Size(20, 30),
					labelOrigin: new google.maps.Point(10, 10)
				},
				label: {
					text: String(viaje),
					color: "black"
				}
			});

			google.maps.event.addListener(marker, 'click', (function (marker, i) {
				return function () {
					infowindow.setContent(contents[i]);
					infowindow.open(map, marker);
				}
			})(marker, i));
			markadores.push(marker);
		}
		clearInterval(repeater);
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
		var createClickHandler =
				function (row)
				{
					return function () {
						var marker = markadores[row.rowIndex - 1];
						marker.setAnimation(google.maps.Animation.BOUNCE);
						stopAnimation(marker);
					}
				};
		var createDoubleClickHandler =
				function (row)
				{
					return function () {
						resaltarDelivery(table.rows[row.rowIndex - 1].cells[0].innerHTML)
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

function resaltarDelivery(viaje) {
	if (deliverys != null) {
		var delivery = getDeliveryViaje(viaje);
		var posAnterior = map.getZoom();
		map.setZoom(13);
		map.setCenter(delivery.markador.getPosition());
		window.setTimeout(function () {
			map.setZoom(posAnterior);
		}, 3000);
	}
}

function cargarDeliverys() {
	getAllDelivery('http://localhost:8080/webapp/delivery');
	var i = 0;
	var l = deliverys.length;
	for (; i < l; i++) {
		var posicion = {lat: deliverys[i].ubicacion.latitud, lng: deliverys[i].ubicacion.longitud};
		var marker = new google.maps.Marker({
			position: posicion,
			map: map,
			draggable: false,
			icon: urlMoto
		});

		var delivery = new Delivery(deliverys[i].id, deliverys[i].idViaje, marker);

		deliverys.push(delivery);
	}
}

function actualizarDeliverys() {
	setInterval(cargarDeliverys, 5000);
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

function activateColors() {
	if (true) {//algo
		setInterval(changeColors, 10000);
	}
}

function changeColors() {
	var rows = table.getElementsByTagName("tr");
	var i = 0;
	var l = rows.length;
	for (; i < l; i++) {
		var currentRow = table.rows[i];
		var time = currentRow.cells[5].innerHTML;
		switch (true) {
			case (time < 1000):
				currentRow.style.color = "";
		}
	}
}