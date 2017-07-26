"use strict";
var op = {};

function initData(opciones) {
	op = opciones;
}

/**
 * Inicia la tabla dinamica.
 */
function initDataTable() {
	var nombreTabla = op.identificadorJS + op.nombreTablaHistViaje;
	$(document).ready(function () {
		$(nombreTabla).DataTable(op.dataTableOptions);
		applyClassButtons();
	});
}

function initCharts() {
	$(document).ready(function () {
		new Morris.Donut(op.chartDonutOptions);
		new Morris.Line(op.chartLineOptions);
		new Morris.Bar(op.chartBarOptions);
	});
}

function applyClassButtons(){
	document.getElementsByClassName("buttons-csv")[0].className = "btn btn-primary btn-sm btn3d";
	document.getElementsByClassName("buttons-excel")[0].className = "btn btn-primary btn-sm btn3d";
	document.getElementsByClassName("buttons-pdf")[0].className = "btn btn-primary btn-sm btn3d";
	document.getElementsByClassName("buttons-print")[0].className = "btn btn-primary btn-sm btn3d";
}