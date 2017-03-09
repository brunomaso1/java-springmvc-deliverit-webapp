function initMap() {
	var map = new google.maps.Map(document.getElementById('map'), {
		center: {lat: -34.397, lng: 150.644},
		zoom: 12,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	});

	// Try HTML5 geolocation.
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function (position) {
			var pos = {
				lat: position.coords.latitude,
				lng: position.coords.longitude
			};
			map.setCenter(pos);

			setMarkers(map);
		}, function () {
			handleLocationError(true, infoWindow, map.getCenter());
		});
	} else {
		// Browser doesn't support Geolocation
		handleLocationError(false, infoWindow, map.getCenter());
	}
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	infoWindow.setPosition(pos);
	infoWindow.setContent(browserHasGeolocation ?
			'Error: The Geolocation service failed.' :
			'Error: Your browser doesn\'t support geolocation.');
}

function setMarkers(map) {
	var table = document.getElementById("pedidos");
	if (table.rows.length > 1) {
		for (var r = 1, n = table.rows.length; r < n; r++) {
			direccion = table.rows[r].cells[2].innerHTML + ", Montevideo";
			var geocoder = new google.maps.Geocoder();
			geocoder.geocode({'address': direccion}, function (results, status) {
				if (status == google.maps.GeocoderStatus.OK) {
					var pos = {
						lat: results[0].geometry.location.lat(),
						lng: results[0].geometry.location.lng()
					};
					var marker = new google.maps.Marker({
						position: pos,
						map: map
					});
				}
			});
		}
	}
}