/**
 * Inicia la tabla.
 * @returns {undefined}
 */
function initDataTable() {
	$(document).ready(function () {
		$('#clientes').DataTable({
			dom: 'Bfrtip',
			buttons: [
				'csv', 'excel', 'pdf', 'print'
			],
			language: {
				processing: "Procesando...",
				search: "Busqueda&nbsp;:",
				lengthMenu: "Mostrar _MENU_ clientes",
				info: "",
				infoEmpty: "Ningun cliente",
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