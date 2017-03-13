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