var map;

function activarPopup() {
    var table = document.getElementById("pedidos");
    if (table.rows.length < 2) {
        document.getElementById("agregarPedido").click();
    }
}
/* Test */
function ingresarDatos() {
    document.getElementById("precio").value = "50";
    document.getElementById("nombre").value = "Bruno Masoller";
    document.getElementById("calle").value = "Juan Manuel Blanes";
    document.getElementById("puerta").value = "1136";
    document.getElementById("esquina").value = "Maldonado";
    document.getElementById("apartamento").value = "203";
    document.getElementById("telefono").value = "091414979";
    document.getElementById("aclaraciones").value = "El gato es violento. Cuidado.";
}

function validarPagina() {
    var table = document.getElementById("pedidos");
    if (table.rows.length < 2) {
        alert("No has ingresado ningun pedido!");
        return false;
    }
    var precio = document.getElementById("precio");
    if (precio.value === "") {
        alert("El precio no puede ser vacio!");
        return false;
    }
}

function validarPedidoForm() {
    var nombre = document.getElementById("nombre");
    if (nombre.value === "") {
        alert("El nombre no puede ser vacio!");
        return false;
    }
    var calle = document.getElementById("calle");
    if (calle.value === "") {
        alert("El nombre no puede ser vacio!");
        return false;
    }
    var puerta = document.getElementById("puerta");
    if (puerta.value === "") {
        alert("El numero de puerta no puede ser vacio!");
        return false;
    }
    var esquina = document.getElementById("esquina");
    if (esquina.value === "") {
        alert("La esquina no puede ser vacio!");
        return false;
    }
    var telefono = document.getElementById("telefono");
    if (telefono.value === "") {
        alert("El numero de telefono no puede ser vacio!");
        return false;
    }
}

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {
            lat: -34.397,
            lng: 150.644
        },
        zoom: 14,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });
    // Try HTML5 geolocation.
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };
            map.setCenter(pos);
            setMarkers(map);
        }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {
        // Browser doesn't support Geolocation
        handleLocationError(false, infoWindow, map.getCenter());
    }
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ? 'Error: The Geolocation service failed.' : 'Error: Your browser doesn\'t support geolocation.');
}

function setMarkers() {
    var table = document.getElementById("pedidos");
    if (table.rows.length > 1) {
        for (var r = 1, n = table.rows.length; r < n; r++) {
            direccion = table.rows[r].cells[2].textContent + ", Montevideo";
            var geocoder = new google.maps.Geocoder();
            geocoder.geocode({
                'address': direccion
            }, function(results, status) {
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