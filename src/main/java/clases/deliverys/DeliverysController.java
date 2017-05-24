package clases.deliverys;

import clases.accesControl.ACSessionServices;
import clases.configuration.Parametros;
import clases.dominio.Viaje;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador de las acciones respecto a los Pedidos.
 */
@Controller
@RequestMapping(path = "/deliverys")
public class DeliverysController {

	//Logger
	private final static Logger LOGGER = Logger.getLogger(DeliverysController.class.getName());

	private DeliverysLogica hvl;
	private DeliverysControllerHelper vch;
	private ACSessionServices acss;

	public DeliverysController() {
		this.hvl = new DeliverysLogica();
		this.vch = new DeliverysControllerHelper();
		this.acss = new ACSessionServices();
	}

	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	public String showPage(HttpSession request, Model model) {
		String sucursalId = acss.getUserId();

		Delivery[] deliverys = hvl.obtenerDeliverys(sucursalId);

		model.addAttribute("datosTablaDeliverys", vch.tablaDeliverysHtml(deliverys));
		model.addAttribute("usuarioActual", acss.getUserName());

		return "deliverys";
	}
}