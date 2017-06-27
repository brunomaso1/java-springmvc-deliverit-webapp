package clases.deliverys;

import clases.accesControl.ACSessionServices;
import clases.configuration.OpcionesJavascriptCliente;
import clases.configuration.OpcionesJavascriptDelivery;
import clases.dominio.Delivery;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		OpcionesJavascriptDelivery ojc = new OpcionesJavascriptDelivery();
		Delivery[] deliverys = hvl.obtenerDeliverys(sucursalId);

		model.addAttribute("usuarioActual", acss.getUserName());

		model.addAttribute("nombreTablaDelivery", ojc.getNombreTablaDelivery());
		model.addAttribute("datosTablaDelivery", vch.getDatosTablaDeliveryHTML(deliverys));	
		
		// Para Javascript
		model.addAttribute("opciones", ojc.toJSON());

		return "deliverys";
	}
}