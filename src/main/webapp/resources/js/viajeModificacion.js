"use strict";
var op = {};

function initData(opciones) {
    op = opciones;
}

/**
 * Inicia la tabla dinamica.
 */
function initDataTable() {
	var nombreTabla = op.identificadorJS + op.nombreTablaViaje;
    $(document).ready(function() {
        $(nombreTabla).DataTable(op.dataTableOptions);
    });
}

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
	if ((rows.length > 1) && !(rows[1].innerText == op.mensajes.sinDatos)) {
		var r = 1;
		var n = table.rows.length;
		for (; r < n; r++) {
			var direccion = table.rows[r].cells[3].innerHTML + ", Montevideo";
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
