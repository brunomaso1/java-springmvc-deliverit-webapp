function activarTooltip(nombreTooltip) {
	$(document).ready(function () {
		$('[data-toggle=nombreTooltip]').tooltip();
	});
}

function createAutoClosingAlert(selector, delay) {
	var alert = $(selector).alert();
	window.setTimeout(function () {
		alert.alert('close')
	}, delay);
}
