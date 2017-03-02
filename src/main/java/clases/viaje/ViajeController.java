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
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;

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

		if (request.getParameter("datosTablaPedido") != null) {
			model.addAttribute("datosTablaPedido", request.getParameter("datosTablaPedido"));
		}

		model.addAttribute("pedidosPendientes", vl.getPedidosPendientes());
		model.addAttribute("viajesPublicaods", vl.getPedidosPublicados());
		model.addAttribute("viajesEnProceso", vl.getPedidosEnProceso());
		model.addAttribute("viajesTerminados", vl.getPedidosTerminados());

		return "viaje";
	}

	@RequestMapping(value = "/nuevoViaje", method = POST)
	public String publicarPopup(@RequestParam String tipo, @RequestParam String precio, HttpServletRequest request) {
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

	@RequestMapping(value = "/nuevoPedido", method = POST)
	public String nuevoPedido(@ModelAttribute ViajeFormBean bean, Model model) {
		vl.nuevoPedido(bean);
		model.addAttribute("datosTablaPedido", vch.tablaPedidosHtml(vl.getPedidos()));
		return "redirect:/viaje.html";
	}

	@RequestMapping(value = "/refresh", method = GET)
	public String refresh() {
		LOGGER.log(Level.FINEST, "Se hizo refresh.");
		return "redirect:/viaje.html";
	}

	@RequestMapping(value = "/refreshPendiente", method = GET)
	public String refreshPendiente(HttpServletRequest request) {
		request.getSession(false).setAttribute("estado", "1");
		LOGGER.log(Level.FINEST, "Se hizo refresh. Se filtro los viajes al estado 1.");
		return "redirect:/viaje.html";
	}

	@RequestMapping(value = "/refreshPublicado", method = GET)
	public String refreshPublicado(HttpServletRequest request) {
		request.getSession(false).setAttribute("estado", "2");
		LOGGER.log(Level.FINEST, "Se hizo refresh. Se filtro los viajes al estado 2.");
		return "redirect:/viaje.html";
	}

	@RequestMapping(value = "/refreshEnProceso", method = GET)
	public String refreshEnProceso(HttpServletRequest request) {
		request.getSession(false).setAttribute("estado", "3");
		LOGGER.log(Level.FINEST, "Se hizo refresh. Se filtro los viajes al estado 3.");
		return "redirect:/viaje.html";
	}

	@RequestMapping(value = "/refreshTerminado", method = GET)
	public String refreshTerminado(HttpServletRequest request) {
		request.getSession(false).setAttribute("estado", "4");
		LOGGER.log(Level.FINEST, "Se hizo refresh. Se filtro los viajes al estado 4.");
		return "redirect:/viaje.html";
	}
}
