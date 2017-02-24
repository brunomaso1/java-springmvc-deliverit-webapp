package clases.viaje;

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
	
	@GetMapping
	public String showPage(HttpServletRequest request, Model model) {
		model.addAttribute("datosTablaPrincipal", ViajeLogica.popularTablaPrincipal());
		if (request.getParameter("datosTablaPedido") != null)
			model.addAttribute("datosTablaPedido", request.getParameter("datosTablaPedido"));
		model.addAttribute("pedidosPendientes", ViajeLogica.getPedidosPendientes());
		model.addAttribute("viajesPublicaods", ViajeLogica.getPedidosPublicados());
		model.addAttribute("viajesEnProceso", ViajeLogica.getPedidosEnProceso());
		model.addAttribute("viajesTerminados", ViajeLogica.getPedidosTerminados());
		return "viaje";
	}
	
	@RequestMapping(value = "/nuevoViaje", method = POST)
	public String publicarPopup(@RequestParam String tipo, @RequestParam String precio) {
		if (tipo.equals("publicar") == true) {
			System.out.println("Se inicio la insercion del viaje publicado.");
			ViajeLogica.crearViaje(precio,(short)2);
			System.out.println("Termino la insercion del viaje publicado.");
		} else {
			System.out.println("Se inicio la insercion del viaje publicado.");
			ViajeLogica.crearViaje(precio,(short)1);
			System.out.println("Termino la insercion del viaje publicado.");
		}
		return "redirect:/viaje.html";
	}
	
	@RequestMapping(value = "/nuevoPedido", method = POST)
	public String nuevoPedido(@ModelAttribute ViajeFormBean bean, Model model){
		ViajeLogica.nuevoPedido(bean);
		model.addAttribute("datosTablaPedido", ViajeLogica.popularTablaPedidos());
		return "redirect:/viaje.html";
	}
	
	@RequestMapping(value = "/refresh", method = GET)
	public String refresh(){
		System.out.println("Se hizo refresh.");
		//ViajeUtil.getPedidos().clear();
		return "redirect:/viaje.html";
	}
	
	@RequestMapping(value = "/refreshPendiente", method = GET)
	public String refreshPendiente() {
		ViajeLogica.setEstado(1);
		//ViajeUtil.getPedidos().clear();
		System.out.println("Se hizo refresh. Se filtro los viajes al estado 1.");
		return "redirect:/viaje.html";
	}
	
	@RequestMapping(value = "/refreshPublicado", method = GET)
	public String refreshPublicado() {
		ViajeLogica.setEstado(2);
		//ViajeUtil.getPedidos().clear();
		System.out.println("Se hizo refresh. Se filtro los viajes al estado 2.");
		return "redirect:/viaje.html";
	}
	
	@RequestMapping(value = "/refreshEnProceso", method = GET)
	public String refreshEnProceso() {
		ViajeLogica.setEstado(3);
		//ViajeUtil.getPedidos().clear();
		System.out.println("Se hizo refresh. Se filtro los viajes al estado 3.");
		return "redirect:/viaje.html";
	}
	
	@RequestMapping(value = "/refreshTerminado", method = GET)
	public String refreshTerminado() {
		ViajeLogica.setEstado(4);
		//ViajeUtil.getPedidos().clear();
		System.out.println("Se hizo refresh. Se filtro los viajes al estado 4.");
		return "redirect:/viaje.html";
	}
}