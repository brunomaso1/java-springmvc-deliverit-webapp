/**
 * Inicia la tabla.
 * @returns {undefined}
 */
function initDataTable() {
	$(document).ready(function () {
		$('#deliverys').DataTable( {
			dom: 'Bfrtip',
        	buttons: [
            	'csv', 'excel', 'pdf', 'print'
        	]
    	} );
	} );
	$('#deliverys').DataTable({
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