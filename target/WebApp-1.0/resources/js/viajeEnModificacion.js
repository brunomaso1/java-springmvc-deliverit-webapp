"use strict";
var op = {};

function initData(opciones) {
	op = opciones;
}
/**
 * Inicia la tabla dinamica.
 */
function initDataTable() {
	$(document).ready(function () {
		$('#pedidos').DataTable(op.dataTableOptions);
	});
}

function initMap() {
	$(document).ready(function () {
		map = new google.maps.Map(document.getElementById('map'), {
			center: {
				lat: op.defLat,
				lng: op.defLon
			},
			zoom: op.defZoomMap,
			mapTypeId: google.maps.MapTypeId.ROADMAP
		});
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function (position) {
				pos = {
					lat: position.coords.latitude,
					lng: position.coords.longitude
				};
				map.setCenter(pos);
			});
		} else {
			// El navegador no soporta geolocalizacion
			window.alert("No se soporta geolocalizacion, no se carga la ubicacion de la sucursal.");
		}
	});
}

function initColors() {
	$(document).ready(function () {
		if (op.estadoIdActual == "2" || op.estadoIdActual == "3") {
			activateRowsColors();
			window.setInterval(activateRowsColors, 5000);
		}
	});
}

function initFiltro() {
	switch (op.estadoIdActual) {
		case "1":
			document.getElementById("botonPendiente").style.backgroundColor = "#FFFFFF";
			break;
		case "2":
			document.getElementById("botonPublicado").style.backgroundColor = "#FFFFFF";
			break;
		case "3":
			document.getElementById("botonPendiente").style.backgroundColor = "#FFFFFF";
			break;
		case "4":
			document.getElementById("botonTerminado").style.backgroundColor = "#FFFFFF";
			break;
	}
}

function activateRowsColors() {
	var table = document.getElementById("pedidos");
	var rows = table.getElementsByTagName("tr");
	if (rows.length > 1) {
		var i = 1;
		var l = rows.length;
		for (; i < l; i++) {
			var currentRow = table.rows[i];
			var d = new Date();
			var timeViaje = currentRow.cells[6].innerHTML;
			var timeActual = d.getHours() * 60 + d.getMinutes() * 60 + d.getSeconds()
			var dif = parseInt(timeActual) - parseInt(timeViaje);
			switch (true) {
				case (dif < 120):
					break;
				case (dif < 300):
					currentRow.style.backgroundColor = "#ffe6e6";
					break;
				case (dif < 600):
					currentRow.style.backgroundColor = "#ff9999";
					break;
				case (dif < 900):
					currentRow.style.backgroundColor = "#ff6666";
					break;
				default:
					currentRow.style.backgroundColor = "#ff1a1a";
					break;
			}
		}
	}
}