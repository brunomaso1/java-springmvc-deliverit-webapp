"use strict";
var map;
var pos;
var mapZoom = 14;
var colorSet = ['blue'];
var colorLen = colorSet.length;
var table = document.getElementById("pedidos");
var markadores = [];
var flag = false;
var intervalo = 0;
var repeater = 0;

function activarTooltip(nombreTooltip) {
	$(document).ready(function () {
		$('[data-toggle=nombreTooltip]').tooltip();
	});
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
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	infoWindow.setPosition(pos);
	infoWindow.setContent(browserHasGeolocation ?
			'Error: The Geolocation service failed.' :
			'Error: Your browser doesn\'t support geolocation.');
}

function setMarkers() {
	var posiciones = [];
	var geocoder = new google.maps.Geocoder();
	
	if (table.rows.length > 1) {
		var r = 1;
		var n = table.rows.length;
		for (; r < n; r++) {
			var direccion = table.rows[r].cells[2].innerHTML + ", Montevideo";
			
			geocoder.geocode({'address': direccion}, function (results, status, r) {
				if (status == google.maps.GeocoderStatus.OK) {				
					var posMarker = {
						lat: results[0].geometry.location.lat(),
						lng: results[0].geometry.location.lng()
					};
					markadores.push(posMarker);
					console.log("Push marker.");
				} else {
					markadores.push(null);
					console.log("Push null.")
				}
				if (markadores.length == table.rows.length) {
					flag = true;
					console.log("Se cambio flag.");
				}
			});
		}
	}
}

function timeCargarMarkadores() {
	repeater = window.setInterval(cargarMarkadores, 500);
}

function cargarMarkadores() {
	console.log("Se entro en los markadores.");
	if (flag) {
		var r = 1;
		for (posMarker in markadores) {
			var viaje = table.rows[r].cells[0].innerHTML;
						
			var marker = new google.maps.Marker({
				position: posMarker,
				map: map,
				draggable: false,
				animation: google.maps.Animation.DROP,
				label: { 
					text: String(viaje), 
					color: "black"
				}
			});
			
			var contentString = "Soy un String";
			
			var infowindow = new google.maps.InfoWindow({
				content: contentString
			  });

			
			google.maps.event.addListener(marker,'click',function() {
				if (marker.getAnimation() !== null) {
					marker.setAnimation(null);
					map.setZoom(14);
					map.setCenter(pos);
					infoWindow.close(map, marker);
				  } else {
					marker.setAnimation(google.maps.Animation.BOUNCE);
					map.setZoom(9);
					map.setCenter(marker.getPosition());							
					infoWindow.open(map, marker);
				  }
			  });
			r++;
		}
	}
	if (intervalo == 10) {
		clearInterval(repeater);
	} else {
		intervalo++;
	}
}