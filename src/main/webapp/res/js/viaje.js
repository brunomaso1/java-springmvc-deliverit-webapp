"use strict";
var map;
var pos;
var mapZoom = 14;
var urlIcon = 'res/img/iconosMaps/';
var png = '.png';
var colorSet = ['blue', 'brown', 'gray', 'green', 'orange', 'purple', 'red', 'yellow'];
var colorSetLen = colorSet.length;
var table = document.getElementById("pedidos");
var posiciones = [];
var markadores = [];
var flag = false;
var intervalo = 0;
var repeater = 0;
var contents = [];
var deliverys = [];
function Delivery(deliveryId, viajeId, markador){
	this.deliveryId = deliveryId;
	this.viajeId = viajeId;
	this.markador = markador;
}

function initMap() {
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
		handleLocationError(false, infoWindow, map.getCenter());
	}
	setMarkers();
	timeCargarMarkadores();
}

function initTableListener() {
	window.onload = addRowHandlers();
}

function initDataTable() {
	$(document).ready(function () {
				$('#pedidos').DataTable();
	});
	$('#pedidos').DataTable( {
		language: {
        processing:     "Procesando...",
        search:         "Busqueda&nbsp;:",
        lengthMenu:    "Mostrar _MENU_ entradas",
        info:           "Mostrando _START_ de _END_ de un total de _TOTAL_ entradas",
        infoEmpty:      "Mostrando 0 de 0 de un total de 0 entradas",
        infoFiltered:   "(fitradas de _MAX_ entradas en total)",
        infoPostFix:    "",
        loadingRecords: "Cargando registros...",
        zeroRecords:    "No se han encontrado registros",
        emptyTable:     "No hay datos",
        paginate: {
            first:      "Primero",
            previous:   "Anterior",
            next:       "Siguiente",
            last:       "Ultimo"
        },
    }
	} );
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	infoWindow.setPosition(pos);
	infoWindow.setContent(browserHasGeolocation ?
			'Error: The Geolocation service failed.' :
			'Error: Your browser doesn\'t support geolocation.');
}

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

function timeCargarMarkadores() {
	if (table.rows.length > 1) {
		repeater = window.setInterval(cargarMarkadores, 500);
	}
}

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

function ajustarZoom(){
	var bounds = new google.maps.LatLngBounds();
	var i = 0;
	var l = markadores.length;
	for (; i < l; i++) {
		bounds.extend(markadores[i].getPosition());
	}
	map.fitBounds(bounds);		
}

function addRowHandlers() {
    var table = document.getElementById("pedidos");
    var rows = table.getElementsByTagName("tr");
	var i = 0;
	var l = rows.length;
    for (; i < l; i++) {
        var currentRow = table.rows[i];
        var createClickHandler = 
            function(row) 
            {
                return function() { 
					var marker = markadores[row.rowIndex - 1];
					marker.setAnimation(google.maps.Animation.BOUNCE);
					stopAnimation(marker);
				}
            };
		var createDoubleClickHandler = 
            function(row) 
            {
                return function() { 
					resaltarDelivery(table.rows[row.rowIndex - 1].cells[0].innerHTML)
				}
            };
		
        currentRow.onclick = createClickHandler(currentRow);
		currentRow.ondblclick = createDoubleClickHandler(currentRow);
    }
}

function stopAnimation(marker) {
    setTimeout(function () {
        marker.setAnimation(null);
    }, 3000);
}

function resaltarDelivery(viaje){
	if (deliverys != null){
		var delivery = getDeliveryViaje(viaje);
		var posAnterior = map.getZoom();
		map.setZoom(9);
		map.setCenter(delivery.markador.getPosition());
		window.setTimeout(function() {map.setZoom(posAnterior);},3000);
	}	
}

function cargarDeliverys(){
	var del = $Ajax
	var i = 0;
	var l = del.length;
	for (; i < l; i++){
		var marker = new google.maps.Marker({
				position: del[i].posicion,
				map: map,
				draggable: false,
				icon: {
				  url: "moto"
				  scaledSize: new google.maps.Size(20, 30),
				  labelOrigin: new google.maps.Point(10, 10)
				}
			});
		
		var delivery = new Delivery(del[i].id, del[i].idViaje, marker);
		
		deliverys.push(delivery);
	}
}

function actualizarDeliverys(){
	repeater = window.setInterval(cargarDeliverys, 5000);
}

function getDeliveryViaje(viaje){
	var i = 0;
	var l = deliverys.length;
	for(; i < l; i++){
		if (deliverys[i].idViaje == viaje){
			return deliverys[i];
		}
	}
}