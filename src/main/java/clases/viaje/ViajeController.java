package clases.viaje;

import clases.configuration.Configuration;
import clases.configuration.Parametros;
import clases.dominio.Pedido;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador de las acciones respecto a los viajes.
 */
@Controller
@RequestMapping(path = "/viaje")
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
	public String showPage(HttpSession request, Model model) {
		String sucursalId = (String) request.getAttribute("SUCURSAL_ID");
		String estadoId = (String) request.getAttribute("ESTADO_ID");

		Pedido[] pedidos = vl.filtrarPedidos(vl.obtenerPedidos(sucursalId), estadoId);

		model.addAttribute("datosTablaPrincipal", vch.tablaPrincipalHtml(pedidos));

		model.addAttribute("viajesPendientes", vl.getViajesPendientes());
		model.addAttribute("viajesPublicaods", vl.getViajesPublicados());
		model.addAttribute("viajesEnProceso", vl.getViajesEnProceso());
		model.addAttribute("viajesTerminados", vl.getViajesTerminados());
		
		model.addAttribute("alertaFiltro", vch.generateAlerta(estadoId));
		
		model.addAttribute("url", "http://localhost:8080/webapp/delivery");

		return "viaje";
	}
	
	@RequestMapping(path = "/viajeNuevo", method = POST)
	public String nuevoViaje(@RequestParam String tipo, @RequestParam String precio, HttpServletRequest request) {
		String sucursalId = (String) request.getSession(false).getAttribute("SUCURSAL_ID");
		
		if (tipo.equals("publicar") == true) {
			LOGGER.log(Level.FINEST, "Se inicio la insercion del viaje publicado.");
			try {
				vl.crearViaje(precio, Parametros.ESTADO_PUBLICADO, sucursalId);
				LOGGER.log(Level.FINEST, "Termino la insercion del viaje publicado.");
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "No se pudo procesar el viaje publicado.", e.toString());
			}
		} else {
			LOGGER.log(Level.FINEST, "Se inicio la insercion del viaje pendiente.");
			try {
				vl.crearViaje(precio, Parametros.ESTADO_PENDIENTE, sucursalId);
				LOGGER.log(Level.FINEST, "Termino la insercion del viaje pendiente.");
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "No se pudo procesar el viaje pendiente.", e.toString());
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
	public String nuevoPedido(@ModelAttribute ViajeFormBean bean, RedirectAttributes model) {
		vl.nuevoPedido(bean);
		model.addFlashAttribute("datosTablaPedido", vch.tablaPedidosHtml(vl.getPedidos()));
		return "redirect:/viaje/viajeNuevo.html";
	}

	@RequestMapping(path = "/refreshPendiente", method = GET)
	public String refreshPendiente(HttpServletRequest request) {
		request.getSession(false).setAttribute("ESTADO_ID", Parametros.ESTADO_PENDIENTE);
		LOGGER.log(Level.FINEST, "Se hizo refresh. Se filtro los viajes al estado 1.");
		return "redirect:/viaje.html";
	}

	@RequestMapping(path = "/refreshPublicado", method = GET)
	public String refreshPublicado(HttpServletRequest request) {
		request.getSession(false).setAttribute("ESTADO_ID", Parametros.ESTADO_PUBLICADO);
		LOGGER.log(Level.FINEST, "Se hizo refresh. Se filtro los viajes al estado 2.");
		return "redirect:/viaje.html";
	}

	@RequestMapping(path = "/refreshEnProceso", method = GET)
	public String refreshEnProceso(HttpServletRequest request) {
		request.getSession(false).setAttribute("ESTADO_ID", Parametros.ESTADO_ENPROCESO);
		LOGGER.log(Level.FINEST, "Se hizo refresh. Se filtro los viajes al estado 3.");
		return "redirect:/viaje.html";
	}

	@RequestMapping(path = "/refreshTerminado", method = GET)
	public String refreshTerminado(HttpServletRequest request) {
		request.getSession(false).setAttribute("ESTADO_ID", Parametros.ESTADO_TERMINADO);
		LOGGER.log(Level.FINEST, "Se hizo refresh. Se filtro los viajes al estado 4.");
		return "redirect:/viaje.html";
	}
}