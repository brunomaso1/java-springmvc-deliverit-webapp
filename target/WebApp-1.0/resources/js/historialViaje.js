/**
 * Inicia la tabla.
 * @returns {undefined}
 */
function initDataTable() {
	$(document).ready(function () {
		$('#viajes').DataTable({
			dom: 'Bfrtip',
			buttons: [
				'csv', 'excel', 'pdf', 'print'
			],
			language: {
				processing: "Procesando...",
				search: "Busqueda&nbsp;:",
				lengthMenu: "Mostrar _MENU_ viajes",
				//info: "_START_ de _END_. Total: _TOTAL_ ",
				info: "",
				infoEmpty: "Ningun viaje",
				//infoFiltered: "(fitradas de _MAX_ entradas en total)",
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

function initCharts(rawData1/*, rawData2, rowData3*/) {
	var dona = rawData1;
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
	});
}