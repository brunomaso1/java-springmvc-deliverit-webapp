package clases.viaje;

import clases.dominio.Pedido;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * Controlador de las acciones respecto a los viajes.
 */
@Controller
@RequestMapping(value = "/viaje")
public class ViajeController {

	//Logger
	private final static Logger LOGGER = Logger.getLogger(ViajeController.class.getName());

	private ViajeLogica vl;
	private ViajeControllerHelper vch;

	public ViajeController() {
		this.vl = new ViajeLogica();
		this.vch = new ViajeControllerHelper();
	}

	@GetMapping
	public String showPage(HttpServletRequest request, Model model) {
		String sucursalId = (String) request.getSession(false).getAttribute("sucursalId");
		String restaurantId = (String) request.getSession(false).getAttribute("restaurantId");
		String estado = (String) request.getSession(false).getAttribute("estado");

		Pedido[] pedidos = vl.filtrarPedidos(vl.obtenerPedidos(sucursalId, restaurantId), Integer.parseInt(estado));

		model.addAttribute("datosTablaPrincipal", vch.tablaPrincipalHtml(pedidos));

		model.addAttribute("pedidosPendientes", vl.getPedidosPendientes());
		model.addAttribute("viajesPublicaods", vl.getPedidosPublicados());
		model.addAttribute("viajesEnProceso", vl.getPedidosEnProceso());
		model.addAttribute("viajesTerminados", vl.getPedidosTerminados());

		return "viaje";
	}
	
	@RequestMapping(path = "/viajeNuevo", method = POST)
	public String nuevoViaje(@RequestParam String tipo, @RequestParam String precio, HttpServletRequest request) {
		String sucursalIdStr = (String) request.getSession(false).getAttribute("sucursalId");
		String restaurantIdStr = (String) request.getSession(false).getAttribute("restaurantId");

		int sucursalId = Integer.valueOf(sucursalIdStr);
		int restaurantId = Integer.valueOf(restaurantIdStr);

		if (tipo.equals("publicar") == true) {
			LOGGER.log(Level.FINEST, "Se inicio la insercion del viaje publicado.");
			try {
				vl.crearViaje(precio, 2, sucursalId, restaurantId);
				LOGGER.log(Level.FINEST, "Termino la insercion del viaje publicado.");
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "No se pudo procesar el viaje publicado.", e.toString());
			}
		} else {
			LOGGER.log(Level.FINEST, "Se inicio la insercion del viaje pendiente.");
			try {
				vl.crearViaje(precio, 1, sucursalId, restaurantId);
				LOGGER.log(Level.FINEST, "Termino la insercion del viaje pendiente.");
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "No se pudo procesar el viaje publicado.", e.toString());
			}
		}
		return "redirect:/viaje.html";
	}

	@RequestMapping(path = "/viajeNuevo", method = GET)
	public String showViajeNuevo(Model model, HttpServletRequest request) {
		if (request.getParameter("datosTablaPedido") != null) {
			model.addAttribute("datosTablaPedido", request.getParameter("datosTablaPedido"));
		}
		return "viajeNuevo";
	}

	@RequestMapping(path = "/nuevoPedido", method = POST)
	public String nuevoPedido(@ModelAttribute ViajeFormBean bean, Model model) {
		vl.nuevoPedido(bean);
		model.addAttribute("datosTablaPedido", vch.tablaPedidosHtml(vl.getPedidos()));
		return "redirect:/viaje/viajeNuevo.html";
	}

	@RequestMapping(path = "/refreshPendiente", method = GET)
	public String refreshPendiente(HttpServletRequest request) {
		request.getSession(false).setAttribute("estado", "1");
		LOGGER.log(Level.FINEST, "Se hizo refresh. Se filtro los viajes al estado 1.");
		return "redirect:/viaje.html";
	}

	@RequestMapping(path = "/refreshPublicado", method = GET)
	public String refreshPublicado(HttpServletRequest request) {
		request.getSession(false).setAttribute("estado", "2");
		LOGGER.log(Level.FINEST, "Se hizo refresh. Se filtro los viajes al estado 2.");
		return "redirect:/viaje.html";
	}

	@RequestMapping(path = "/refreshEnProceso", method = GET)
	public String refreshEnProceso(HttpServletRequest request) {
		request.getSession(false).setAttribute("estado", "3");
		LOGGER.log(Level.FINEST, "Se hizo refresh. Se filtro los viajes al estado 3.");
		return "redirect:/viaje.html";
	}

	@RequestMapping(path = "/refreshTerminado", method = GET)
	public String refreshTerminado(HttpServletRequest request) {
		request.getSession(false).setAttribute("estado", "4");
		LOGGER.log(Level.FINEST, "Se hizo refresh. Se filtro los viajes al estado 4.");
		return "redirect:/viaje.html";
	}
	
	@RequestMapping(path = "/refresh/{parmSucursalId}/{parmRestaurantId}", method = RequestMethod.GET)
	@ResponseBody
	public String refresh(@PathVariable String parmSucursalId, @PathVariable String parmRestaurantId, @SessionAttribute String sucursalId, @SessionAttribute String restaurantId) {
		
		return "redirect:/viaje.html";
	}
}