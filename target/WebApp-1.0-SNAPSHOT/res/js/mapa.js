function myMap() {
	var mapCanvas = document.getElementById("map");
	var mapOptions = {
		center: new google.maps.LatLng(-34.9, -56.1),
		zoom: 12,
		mapTypeId: google.maps.MapTypeId.ROADMAP
		};
	var map = new google.maps.Map(mapCanvas, mapOptions);
}