"use strict";
var op = {};

function initData(opciones) {
	op = opciones;
}

/**
 * Inicia la tabla dinamica.
 */
function initDataTable() {
	var nombreTabla = op.identificadorJS + op.nombreTablaHistPedido;
	$(document).ready(function () {
		$(nombreTabla).DataTable(op.dataTableOptions);
	});
}

function initCharts() {
	$(document).ready(function () {
		new Morris.Donut(op.chartDonutOptions);
		new Morris.Line(op.chartLineOptions);
		new Morris.Bar(op.chartBarOptions);
	});
}