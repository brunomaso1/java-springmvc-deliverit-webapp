/**
 * Inicia la tabla.
 * @returns {undefined}
 */
function initDataTable() {
	$(document).ready(function () {
		$('#pedidos').DataTable( {
			dom: 'Bfrtip',
        	buttons: [
            	'csv', 'excel', 'pdf', 'print'
        	]
    	} );
	} );
	$('#pedidos').DataTable({
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
		  element: 'estadoPedidosDona',
		  data: dona
		});

		// Falta implementar.
		// new Morris.Line({
		//   element: 'cantidadPedidosMes',
		//   data: lineas,
		//   xkey: 'anioMes',
		//   ykeys: ['pedidos'],
		//   labels: ['Pedidos']
		// });

		// Falta implementar
		// new Morris.Bar({
		//   element: 'gananciaPedidosMes',
		//   data: barras,
		//   xkey: 'anioMes',
		//   ykeys: ['ganancia'],
		//   labels: ['Ganancia']
		// });
	} );
}