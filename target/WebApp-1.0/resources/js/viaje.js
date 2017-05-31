"use strict";
var op = {};

function initData(opciones){
	op = opciones;
}
/**
 * Inicia la tabla dinamica.
 */
function initDataTable(){
	$(document).ready(function () {
		$('#pedidos').DataTable(op.dataTableOptions);
	});
}