package clases.historialViaje;

import clases.viaje.*;
import clases.configuration.Parametros;
import clases.dominio.Pedido;
import clases.dominio.Viaje;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	public HistorialViajeController() {
		this.hvl = new HistorialViajeLogica();
		this.vch = new HistorialViajeControllerHelper();
	}

	@GetMapping
	public String showPage(HttpSession request, Model model) {
		String sucursalId = (String) request.getAttribute("SUCURSAL_ID");
		String estadoId = (String) request.getAttribute("ESTADO_ID");

		return "historialViaje";
	}

	@PostMapping(path = "/exportar")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ModelAndView exportExcel(/*@RequestParam(name = "fechaDesdeExport", required = false) Date fechaDesde,
			@RequestParam(name = "fechaHastaExport", required = false) Date fechaHasta,
			@RequestParam(name = "tipoArchivo", required = false) String tipoArcihvo*/) {

		ModelAndView m = new ModelAndView("ExcelMarcasBean");
		
		//Test
		Date fechaDesde = new Date();
		Date fechaHasta = new Date();
		String tipoArcihvo = "XLS";
		
		List<Viaje> auditorias = hvl.obtenerViajes(fechaDesde, fechaHasta);

		m.addObject("tipo_archivo", tipoArcihvo);
		m.addObject("export_audit", auditorias);

		return m;
	}
}
