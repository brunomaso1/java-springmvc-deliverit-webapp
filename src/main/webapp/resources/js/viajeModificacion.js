/**
 * Este programa se encarga de las siguientes funcionalidades:
 *	- Inicializar el mapa en el panel correspondiente.
 *	- Utilizar geolocaclizacion para ubicar a la sucursal y centrar el mapa en dicha ubicacion.
 *	- Colocar markadores por cada pedido de la lista de pedidos (aparecen todos los pedidos).
 * @type type
 */
"use strict";
var op = {};
var pedidos = [];
var map = {};
/**
 * Inicializa los datos a utilizar para las funciones.
 * @param {OpcionesJavascriptViaje} opciones
 * @param {List<Pedido>} listaPedidos
 * @returns {void}
 */
function initData(opciones, listaPedidos) {
    op = opciones;
    pedidos = listaPedidos;
    modificarEstructuraPedido();
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

function modificarEstructuraPedido() {
    if (pedidos.length > 0) {
        pedido[0].prototype.marker = {};
        pedido[0].prototype.getViajeId = function() {
            return
        };
        pedido[0].prototype.getViajeId = function() {
            return
        };
        pedido[0].prototype.cliente = function() {
            return
        };
        pedido[0].prototype.direccion = function() {
            return
        };
        pedido[0].prototype.getDeliveryNombre = function() {
            if () return
            else return null;
        };
    }
}
/**
 * Inicializa el mapa y ejecuta el siguiente pipe de funciones:
 *	- Coloca todos los markadores de la lista de pedidos en el mapa.
 *	- Agrega funciones a los pedidos.
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
        navigator.geolocation.getCurrentPosition(function(position) {
            pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };
            map.setCenter(pos);
        }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {
        // Browser doesn't support Geolocation
        window.window.alert(op.mensajes.geolocalizacion);
    }
    setMarkers();
}
/**
 * Coloca los markadores en todos los pedidos de la lista y los pone a todos invisibles.
 * @returns {undefined}
 */
function setMarkers() {
    for (var pedido in pedidos) {
        var idViaje = pedido.getViajeId();
        var cliente = pedido.getCliente();
        var direccion = pedido.getDireccion();
        var delivery = pedido.getDeliveryNombre();
        var contenido = "<p><strong>" + cliente + "</strong></p>" + "<p>" + direccion + "</p>";
        if (delivery != null) contenido += "<p>" + delivery + "</p>";
        var posMarker = {
            lat: ,
            lng:
        };
        var marker = new google.maps.Marker({
            position: posMarker,
            map: map,
            draggable: false,
            animation: google.maps.Animation.DROP,
            visible: false,
            icon: {
                url: op.coloresMarkadores[Number(idViaje) % op.coloresMarkadores.length],
                scaledSize: new google.maps.Size(25, 35),
                labelOrigin: new google.maps.Point(12, 12)
            },
            label: {
                text: String(viaje),
                color: "black"
            }
        });
        marker.addListener('click', function(contenido) {
            infowindow.setContent(contenido);
            infowindow.open(map, marker);
        });
        pedido.marker = marker;
    }
}

function setMarkersVisible() {
    // Oculto todos los markadores.
    for (var pedido in pedidos) {
        if !("undefined" === typeof pedido.marker) {
            pedido.marker.setVisible(false);
        }
    }
    var nombreTabla = op.identificadorJS + op.nombreTablaViaje;
    var rows = document.getElementById(nombreTabla).rows;
    if ((rows.length > 1) && !(rows[1].innerText == "No hay datos")) {
    	for(var i = 1, length = rows.length; i < length; i++){
    		var pedidoId = getPedidoIdRow(rows[i]);
    		getPedidoFromId(pedidoId).marker.setVisible(true);
    	}
    }
}
// Falta implementar.-¿
function getPedidoIdRow(row){
	switch (op.estadoIdActual) {
		case "1":
			return row.cells[5].textContent;
			break;
		case "2":
			return row.cells[5].textContent;
			break;
		case "3":
			return row.cells[7].textContent;
			break;
		case "4":
			return row.cells[5].textContent;
			break;
	}
	return row.cells[0].textContent;	
}

function getPedidoFromId(pedidoId){
	for (pedido in pedidos){
		if (pedido.getPedidoId() == pedidoId)
			return pedido;
	}
}