/**
 * Inicia la tabla.
 * @returns {undefined}
 */
function initDataTable() {
    $(document).ready(function() {
        $('#deliverys').DataTable({
            dom: 'Bfrtip',
            buttons: ['csv', 'excel', 'pdf', 'print'],
            language: {
                processing: "Procesando...",
                search: "Busqueda&nbsp;:",
                lengthMenu: "Mostrar _MENU_ deliverys",
                info: "",
                infoEmpty: "Ningun delivery",
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