/**
 * Inicia la tabla.
 * @returns {undefined}
 */
function initDataTable() {
    $(document).ready(function() {
        $('#viajes').DataTable({
            dom: 'Bfrtip',
            buttons: ['csv', 'excel', 'pdf', 'print'],
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

function initCharts(donutData, lineData, barrsData) {
    $(document).ready(function() {
        new Morris.Donut({
            element: 'estadoViajesDona',
            data: donutData
        });
        new Morris.Line({
            element: 'cantidadViajeMes',
            data: lineData,
            xkey: 'anioMes',
            ykeys: ['viajes'],
            labels: ['Viajes']
        });
        new Morris.Bar({
            element: 'gananciaViajeMes',
            data: barrsData,
            xkey: 'anioMes',
            ykeys: ['ganancia'],
            labels: ['Ganancia']
        });
    });
}