/**
 * Este programa se encarga de las siguientes funcionalidades:
 *	- Inicializar el mapa en el panel correspondiente.
 *	- Utilizar geolocaclizacion para ubicar a la sucursal y centrar el mapa en dicha ubicacion.
 *	- Colocar markadores por cada pedido de la lista de pedidos (aparecen todos los pedidos).
 * @type type
 */

"use strict";
var op = {};
var pedidos = {};

/**
 * Inicializa los datos a utilizar para las funciones.
 * @param {OpcionesJavascriptViaje} opciones
 * @param {List<Pedido>} listaPedidos
 * @returns {void}
 */
function initData(opciones, listaPedidos) {
    op = opciones;
	pedidos = listaPedidos;
}

/**
 * Inicia la DataTable. Los valores de inicializacion los obtiene de las opciones.
 */
function initDataTable() {
	var nombreTabla = op.identificadorJS + op.nombreTablaViaje;
    $(document).ready(function() {
        $(nombreTabla).DataTable(op.dataTableOptions);
    });
}

/**
 * Inicializa el mapa y ejecuta el siguiente pipe de funciones:
 *	- Coloca todos los markadores de la lista de pedidos en el mapa.
 *	- Agrega funciones a los pedidos 
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
		window.window.alert(op.mensajes.geolocalizacion);
	}
	setMarkers();
}

function setMarkers() {
	var geocoder = new google.maps.Geocoder();
	var rows = document.getElementById(op.nombreTablaViaje).rows;
	if ((rows.length > 1) && !(rows[1].textContent == op.mensajes.sinDatos)) {
		var r = 1;
		var n = rows.length;
		for (; r < n; r++) {
			var direccion = table.rows[r].cells[3].textContent + ", Montevideo";
			geocoder.geocode({
				'address': direccion
			}, function (results, status) { // Si le paso otro parametro a esta funcion, no se asigna, ej: r.
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