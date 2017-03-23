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
	initTableListener();
}

function initTableListener() {
	window.onload = addRowHandlers();
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
	repeater = window.setInterval(cargarMarkadores, 500);
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

        currentRow.onclick = createClickHandler(currentRow);
    }
}

function stopAnimation(marker) {
    setTimeout(function () {
        marker.setAnimation(null);
    }, 3000);
}