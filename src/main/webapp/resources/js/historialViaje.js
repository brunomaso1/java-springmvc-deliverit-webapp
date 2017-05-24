/**
 * Inicia la tabla.
 * @returns {undefined}
 */
function initDataTable() {
	$(document).ready(function () {
		$('#viajes').DataTable( {
			dom: 'Bfrtip',
        	buttons: [
            	'csv', 'excel', 'pdf', 'print'
        	]
    	} );
	} );
	$('#viajes').DataTable({
		language: {
			processing: "Procesando...",
			search: "Busqueda&nbsp;:",
			lengthMenu: "Mostrar _MENU_ entradas",
			info: "_START_ de _END_. Total: _TOTAL_ ",
			infoEmpty: "Ninguna entrada",
			infoFiltered: "(fitradas de _MAX_ entradas en total)",
			infoPostFix: "",
			loadingRecords: "Cargando registros...",
			zeroRecords: "No se han encontrado registros",
			emptyTable: "No hay datos",
			paginate: {
				first: "Primero",
				previous: "Anterior",
				next: "Siguiente",
				last: "Ultimo"
			}
		}
	});
}

function initCharts(rawData1, rawData2, rowData3)) {
	var dona = JSON.parse(rawData1);
	// Falta implementar.
	// var lineas = JSON.parse(rawData2);
	// Falta implementar
	// var barras = JSON.parse(rowData3);
	$(document).ready(function () {
		new Morris.Donut({
		  element: 'estadoViajesDona',
		  data: dona
		});

		// Falta implementar.
		// new Morris.Line({
		//   element: 'cantidadViajeMes',
		//   data: lineas,
		//   xkey: 'anioMes',
		//   ykeys: ['viajes'],
		//   labels: ['Viajes']
		// });

		// Falta implementar
		// new Morris.Bar({
		//   element: 'gananciaViajeMes',
		//   data: barras,
		//   xkey: 'anioMes',
		//   ykeys: ['ganancia'],
		//   labels: ['Ganancia']
		// });
	} );
}