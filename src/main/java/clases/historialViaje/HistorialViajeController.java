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
		Calendar fechaFin = Calendar.getInstance();
		Calendar fechaInicio = Calendar.getInstance();
		fechaInicio.add(Calendar.MONTH, -6);
		
		Viaje[] viajes = hvl.obtenerViajes(sucursalId);
		OpcionesJavascriptHistViaje opciones = new OpcionesJavascriptHistViaje();

		model.addAttribute("datosTablaHistViaje", vch.getDatosTablaHistViajeHTML(viajes));
		model.addAttribute("nombreTablaHistViaje", opciones.getNombreTablaHistViaje());
		
		model.addAttribute("donutData", vch.chartHistorialViajeDona(viajes));
		model.addAttribute("lineData", vch.chartHistorialViajeLinea(viajes, fechaInicio, fechaFin));
		model.addAttribute("barrsData", vch.chartHistorialViajeBarras(viajes, fechaInicio, fechaFin));

		model.addAttribute("usuarioActual", acss.getUserName());

		return "historialViaje";
	}
}