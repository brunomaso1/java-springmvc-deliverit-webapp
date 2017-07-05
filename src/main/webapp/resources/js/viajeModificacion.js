/**
 * Este programa se encarga de las siguientes funcionalidades:
 *  - Inicializar el mapa en el panel correspondiente.
 *  - Utilizar geolocaclizacion para ubicar a la sucursal y centrar el mapa en dicha ubicacion.
 *  - Colocar markadores por cada pedido de la lista de pedidos (aparecen todos los pedidos).
 * @type type
 */
"use strict";
var op = {};
var pedidos = [];
var map = {};
var deliverys = [];

function DeliveryBuilder(deliveryId, viajeId, markador, ubicacion) {
    this.deliveryId = deliveryId;
    this.viajeId = viajeId;
    this.markador = markador;
    this.listaUbicaciones = listaUbicaciones.push(ubicacion);
}
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
/**
 * Inicializa el mapa y ejecuta el siguiente pipe de funciones:
 *  - Coloca todos los markadores de la lista de pedidos en el mapa.
 *  - Agrega funciones a los pedidos.
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
    setMarkersVisible();
    addRowHandlers();
    actualizarDeliverys();
}

function initColors() {
    if (op.estadoIdActual == "2" || op.estadoIdActual == "3") {
        changeColors();
        window.setInterval(changeColors, op.tiempoActivacionCambioColores);
    }
}

function initFiltroColor() {
    switch (op.estadoIdActual) {
        case "1":
            document.getElementById(op.nombreFiltros.filtroPendiende).style.backgroundColor = op.nombreFiltros.backgroundColorFiltros;
            break;
        case "2":
            document.getElementById(op.nombreFiltros.filtroPublicado).style.backgroundColor = op.nombreFiltros.backgroundColorFiltros;
            break;
        case "3":
            document.getElementById(op.nombreFiltros.filtroProceso).style.backgroundColor = op.nombreFiltros.backgroundColorFiltros;
            break;
        case "4":
            document.getElementById(op.nombreFiltros.filtroTerminado).style.backgroundColor = op.nombreFiltros.backgroundColorFiltros;
            break;
    }
}

function initUpdates() {
    excecuteUpdate();
    window.setInterval(excecuteUpdate, op.tiempoActivacionUpdates);
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
        pedido[0].prototype.getFechaHoraViaje = function() {
            return
        };
    }
}

function changeColors() {
    var nombreTabla = op.identificadorJS + op.nombreTablaViaje;
    var rows = document.getElementById(nombreTabla).rows;
    if ((rows.length > 1) && !(rows[1].innerText == op.mensajes.sinDatos)) {
        for (var i = 1, length = rows.length; i < length; i++) {
            var fechaHoraActual = new Date();
            var horaActual = fechaHoraActual.getHours() * 3600 + fechaHoraActual.getMinutes() * 60 + d.getSeconds();
            var fechaHoraViaje = new Date(getPedidoFromRow(rows[i]).getFechaHoraViaje());
            var horaViaje = (fechaHoraViaje.getHours() + op.serverHourPadding) * 3600 + fecha.getMinutes() * 60 + fecha.getSeconds();
            var dif = parseInt(horaActual) - parseInt(horaViaje);
            switch (true) {
                case (dif < op.tiempoColores.tiempo1):
                    break;
                case (dif < op.tiempoColores.tiempo2):
                    rows[i].style.backgroundColor = op.tiempoColores.colorTiempo2;
                    break;
                case (dif < op.tiempoColores.tiempo3):
                    rows[i].style.backgroundColor = op.tiempoColores.colorTiempo3;
                    break;
                case (dif < op.tiempoColores.tiempo4):
                    rows[i].style.backgroundColor = op.tiempoColores.colorTiempo4;
                    break;
                default:
                    rows[i].style.backgroundColor = op.tiempoColores.colorTiempoDefault;
                    break;
            }
        }
    }
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
                scaledSize: new google.maps.Size(op.iconSize.altura, op.iconSize.ancho),
                labelOrigin: new google.maps.Point(op.labelOrigin.altura, op.labelOrigin.ancho)
            },
            label: {
                text: String(viaje),
                color: op.labelOrigin.color
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
    if ((rows.length > 1) && !(rows[1].innerText == op.mensajes.sinDatos)) {
        for (var i = 1, length = rows.length; i < length; i++) {
            getPedidoFromRow(rows[i]).marker.setVisible(true);
        }
    }
}

function getPedidoIdFromRow(row) {
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

function getPedidoFromPedidos(pedidoId) {
    for (pedido in pedidos) {
        if (pedido.getPedidoId() == pedidoId) return pedido;
    }
}

function getPedidoFromRow(row) {
    return getPedidoFromPedidos(getPedidoIdFromRow(row));
}

function addRowHandlers() {
    var nombreTabla = op.identificadorJS + op.nombreTablaViaje;
    var rows = document.getElementById(nombreTabla).rows;
    if ((rows.length > 1) && !(rows[1].innerText == op.mensajes.sinDatos)) {
        var currentRow = table.rows[i];
        var createClickHandler = function(pedido) {
            return function() {
                pedido.marker.setAnimation(google.maps.Animation.BOUNCE);
                stopAnimation(pedido.marker);
            }
        };
        var createDoubleClickHandler = function(pedido) {
            return function() {
                resaltarMarkador(pedido.marker)
            }
        };
        rows[i].onclick = createClickHandler(getPedidoFromRow(rows[i]));
        rows[i].ondblclick = createDoubleClickHandler(getPedidoFromRow(rows[i]));
    }
}

function stopAnimation(marker) {
    setTimeout(function() {
        marker.setAnimation(null);
    }, op.markerBounceTimeOut);
}

function resaltarMarkador(marker) {
    var posAnterior = map.getZoom();
    map.setZoom(op.zoomResaltarMarkador);
    map.setCenter(marker.getPosition());
    window.setTimeout(function() {
        map.setZoom(posAnterior);
    }, op.timeOutResaltarMarkador);
}

function cargarDeliverys() {
    getAllDelivery(op.urlGetAllDelivery);
}

function actualizarDeliverys() {
    if (op.estadoIdActual == "3") {
        cargarDeliverys();
        setInterval(cargarDeliverys, op.actualizarDeliverysTime);
    }
}

function getDeliveryViaje(viaje) {
    var i = 0;
    var l = deliverys.length;
    for (; i < l; i++) {
        if (deliverys[i].idViaje == viaje) {
            return deliverys[i];
        }
    }
}

function getAllDelivery(url) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            deliverysJSON = JSON.parse(this.responseText);
            abmDeliverysMap(deliverysJSON);
        }
    };
    xhttp.open("GET", url, true);
    xhttp.send();
}

function abmDeliverysMap(deliverysJSON) {
    for (var i = 0, length = deliverysJSON.length; i < length; i++) {
        if (findDeliverysJSONIdInDeliverys(deliverysJSON[i].id)) { // Modificar
            var delivery = getDelivery(deliverysJSON[i].id);
            if !(delivery.marker.position.lat == deliverysJSON.ubicacion.latitud && delivery.marker.position.lng == deliverysJSON[i].ubicacion.longitud) {
                var myLatLng = {
                    lat: deliverysJSON[i].ubicacion.latitud,
                    lng: deliverysJSON[i].ubicacion.longitud
                };
                delivery.marker.position = myLatLng;
                deivery.listaUbicaciones.push(myLatLng);
            }
        } else { // Alta
            var myLatLng = {
                lat: deliverysJSON[i].ubicacion.latitud,
                lng: deliverysJSON[i].ubicacion.longitud
            };
            var marker = new google.maps.Marker({
                position: myLatLng,
                map: map,
                draggable: false,
                icon: op.urlMoto
            });
            var delivery = new DeliveryBuilder(deliverysJSON[i].deliveryId, deliveryJSON[i].viajeId, markador, myLatLng);
            deliverys.push(delivery);
        }
    };
    for (var i = 0, length = deliverys.length; i < length; i++) { // Baja
        if !(findDeliverysIdInDeliverysJSON(deliverys[i].deliveryId, deliverysJSON)) {
            deliverys.splice(i, 1); // Elimina el elemento.
        }
    }
}

function findDeliverysJSONIdInDeliverys(deliveryJSONId) {
    for (var i = 0, length = deliverys.length; i < length; i++) {
        if (deliverys[i].deliveryId == deliveryJSONId) return true;
    };
    return false;
}

function findDeliverysIdInDeliverysJSON(deliveryId, deliverysJSON) {
    for (var i = 0, length = deliverysJSON.length; i < length; i++) {
        if (deliverysJSON[i].deliveryId == deliveryId) return true;
    };
    return false;
}

function excecuteUpdate() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            objAux = JSON.parse(this.responseText);
            if !(objAux.cambios == "true") {
                mostrarNotificaciones(objAux);
                var nombreTabla = op.identificadorJS + op.nombreTablaViaje;
                $(nombreTabla).DataTable({
                    data: objAux.dataSet;
                });
            }
        }
    };
    var params = 'estadoId=' + op.estadoIdActual;
    xhttp.open("GET", urlObtenerPedidosTabla, true);
    xhttp.send(params.toString());
}

function mostrarNotificaciones(objAux) { //aada
}
