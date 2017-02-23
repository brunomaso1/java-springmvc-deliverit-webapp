function nuevoPedido(nombreTabla) {
    var table = document.getElementById(nombreTabla);
	var row = table.insertRow(-1);
	var cell1 = row.insertCell(-1);
	var cell2 = row.insertCell(-1);
	var cell3 = row.insertCell(-1);
	var cell4 = row.insertCell(-1);
	var cell5 = row.insertCell(-1);
    cell1.innerHTML = "NEW CELL1";
    cell2.innerHTML = "NEW CELL2";
	cell3.innerHTML = "NEW CELL3";
    cell4.innerHTML = "NEW CELL4";
	cell5.innerHTML = "NEW CELL5";
}
/**
 * Este metodo se encarga de activar el Modal (popup) del elemento deseado. Se
 * ejecuta condicionado segun haya datos en la tabla o no, cada vez que se 
 * carga la pantalla.
 * @param {String} nombreBoton El nombre del boton a activar.
 * @param {String} nombreTabla El nombre de la tabla a buscar los datos.
 * @returns {undefined}
 */
function activarModal(nombreBoton, nombreTabla){
	var table = document.getElementById(nombreTabla);
	if (table.rows.length > 1) {
		document.getElementById(nombreBoton).click();
	}
}