package clases.historialViaje;

import clases.accesControl.ACSessionServices;
import clases.configuration.OpcionesJavascriptHistViaje;
import clases.dominio.Viaje;
import java.util.Calendar;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de las acciones respecto a los viajes.
 */
@Controller
@RequestMapping(path = "/historialViaje")
public class HistorialViajeController {

	//Logger
	private final static Logger LOGGER = Logger.getLogger(HistorialViajeController.class.getName());

	private HistorialViajeLogica hvl;
	private HistorialViajeControllerHelper vch;
	private ACSessionServices acss;

	public HistorialViajeController() {
		this.hvl = new HistorialViajeLogica();
		this.vch = new HistorialViajeControllerHelper();
		this.acss = new ACSessionServices();
	}

	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	public String showPage(HttpSession request, Model model) {
		String sucursalId = acss.getUserId();
		Viaje[] viajes = hvl.obtenerViajes(sucursalId);

		Calendar fechaFinChartLineHistViaje = Calendar.getInstance();
		Calendar fechaInicioChartLineHistViaje = Calendar.getInstance(); fechaInicioChartLineHistViaje.add(Calendar.MONTH, -6);
		Calendar fechaFinChartBarHistViaje = Calendar.getInstance();
		Calendar fechaInicioChartBarHistViaje = Calendar.getInstance(); fechaInicioChartBarHistViaje.add(Calendar.MONTH, -6);

		OpcionesJavascriptHistViaje opciones = new OpcionesJavascriptHistViaje(vch.chartHistorialViajeDona(viajes),
		        vch.chartHistorialViajeLinea(viajes, fechaInicioChartLineHistViaje, fechaFinChartLineHistViaje),
		        vch.chartHistorialViajeBarras(viajes, fechaInicioChartBarHistViaje, fechaFinChartBarHistViaje));

		model.addAttribute("usuarioActual", acss.getUserName());

		model.addAttribute("datosTablaHistViaje", vch.getDatosTablaHistViajeHTML(viajes));
		model.addAttribute("nombreTablaHistViaje", opciones.getNombreTablaHistViaje());
		model.addAttribute("nombreChartDonut", opciones.getNombreChartDonut());
		model.addAttribute("nombreChartLine", opciones.getNombreChartLine());
		model.addAttribute("nombreChartBar", opciones.getNombreChartBar());


		// Para Javascript
		model.addAttribute("opciones", opciones.toJSON());

		return "historialViaje";
	}
}