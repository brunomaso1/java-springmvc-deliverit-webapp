/**
 * Inicia la tabla.
 * @returns {undefined}
 */
function initDataTable() {
	$(document).ready(function () {
		$('#pedidos').DataTable({
			dom: 'Bfrtip',
			buttons: [
				'csv', 'excel', 'pdf', 'print'
			],
			language: {
				processing: "Procesando...",
				search: "Busqueda&nbsp;:",
				lengthMenu: "Mostrar _MENU_ pedidos",
				info: "",
				infoEmpty: "Ningun pedido",
				infoFiltered: "",
				infoPostFix: "",
				loadingRecords: "Cargando registros...",
				zeroRecords: "No se han encontrado registros",
				emptyTable: "No hay datos",
				paginate: {
					first: "<<",
					previous: "<",
					next: ">",
					last: ">>"
				}
			}
		});
	});
}

function initCharts(rawData1, rawData2, rowData3) {
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
	});
}