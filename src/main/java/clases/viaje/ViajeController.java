package clases.viaje;

import clases.accesControl.ACSessionServices;
import clases.configuration.ObjAux;
import clases.configuration.OpcionesJavascriptViaje;
import clases.configuration.Parametros;
import clases.dominio.Pedido;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	private ACSessionServices acss;
	private Pedido[] pedidos;

	public ViajeController() {
		this.vl = new ViajeLogica();
		this.vch = new ViajeControllerHelper();
		this.acss = new ACSessionServices();
	}

	@GetMapping
	public String showPage(HttpSession session, HttpServletRequest request, Model model) {
		String sucursalId = acss.getUserId();
		String url = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());

		String estadoId = (String) session.getAttribute("ESTADO_ID");
		OpcionesJavascriptViaje opciones = new OpcionesJavascriptViaje(url, estadoId);

		pedidos = vl.filtrarPedidos(vl.obtenerPedidosHoy(sucursalId), estadoId);

		model.addAttribute("datosTablaViaje", vch.getDatosTablaViajeHTML(pedidos, estadoId));

		model.addAttribute("usuarioActual", acss.getUserName());
		model.addAttribute("viajesPendientes", vl.getViajesPendientes());
		model.addAttribute("viajesPublicaods", vl.getViajesPublicados());
		model.addAttribute("viajesEnProceso", vl.getViajesEnProceso());
		model.addAttribute("viajesTerminados", vl.getViajesTerminados());
		model.addAttribute("filtroActual", vch.getFiltroActual(estadoId));
		model.addAttribute("nombreTablaViaje", Parametros.NOMBRE_TABLA_VIAJE);
		model.addAttribute("nombreFiltroPendiende", Parametros.NOMBREFILTROS.get("filtroPendiende"));
		model.addAttribute("nombreFiltroPublicado", Parametros.NOMBREFILTROS.get("filtroPublicado"));
		model.addAttribute("nombreFiltroProceso", Parametros.NOMBREFILTROS.get("filtroProceso"));
		model.addAttribute("nombreFiltroTerminado", Parametros.NOMBREFILTROS.get("filtroTerminado"));

		// Para Javascript
		model.addAttribute("listaPedidos", vch.toJSON(pedidos));
		model.addAttribute("opciones", opciones.toJSON());

		return "viaje";
	}

	@RequestMapping(path = "/viajeNuevo", method = POST)
	public String nuevoViaje(@RequestParam String tipo, @RequestParam String precio, HttpServletRequest request) {
		String sucursalId = acss.getUserId();

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
		model.addAttribute("usuarioActual", acss.getUserName());
		return "viajeNuevo";
	}

	@RequestMapping(path = "/nuevoPedido", method = POST)
	public String nuevoPedido(@ModelAttribute ViajeFormBean bean, RedirectAttributes model, HttpServletRequest request) {
		vl.nuevoPedido(bean);
		String url1 = request.getContextPath();
		String url2 = request.getRequestURI();
		StringBuffer url3 = request.getRequestURL();
		String url4 = request.getServletPath();
		model.addFlashAttribute("datosTablaPedido", vch.getDatosTablaViajeNuevoHTML(vl.getPedidos()));
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

	@RequestMapping(value = "/obtenerViajesTabla", method = POST)
	@ResponseBody
	public String obtenerViajesTabla(@RequestParam String estadoId) {
		String sucursalId = acss.getUserId();
		Pedido[] pedidosAux = vl.obtenerViajesTabla(sucursalId, estadoId);
		if (Arrays.equals(pedidos, pedidosAux)){
			ObjAux objAux = new ObjAux();
			return objAux.toJSON();
		}
		else {
			pedidos = pedidosAux;
			ObjAux objAux = new ObjAux(pedidos, vch.toJSON(pedidos), estadoId);
			return objAux.toJSON();
		}
	}
}