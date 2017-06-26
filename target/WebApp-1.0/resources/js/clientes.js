"use strict";
var op = {};

function initData(opciones) {
    op = opciones;
}

/**
 * Inicia la tabla dinamica.
 */
function initDataTable() {
	var nombreTabla = op.identificadorJS + op.nombreTablaCliente;
    $(document).ready(function() {
        $(nombreTabla).DataTable(op.dataTableOptions);
    });
}