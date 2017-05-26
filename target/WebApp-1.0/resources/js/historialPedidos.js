/**
 * Inicia la tabla.
 * @returns {undefined}
 */
function initDataTable() {
    $(document).ready(function() {
        $('#pedidos').DataTable({
            dom: 'Bfrtip',
            buttons: ['csv', 'excel', 'pdf', 'print'],
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

function initCharts(donutData, lineData, barrsData) {
    $(document).ready(function() {
        new Morris.Donut({
            element: 'estadoPedidosDona',
            data: donutData
        });
        new Morris.Line({
            element: 'cantidadPedidosMes',
            data: lineData,
            xkey: 'anioMes',
            ykeys: ['pedidos'],
            labels: ['Pedidos']
        });
        new Morris.Bar({
            element: 'costoPedidosMes',
            data: barrsData,
            xkey: 'anioMes',
            ykeys: ['costo'],
            labels: ['Costo']
        });
    });
}