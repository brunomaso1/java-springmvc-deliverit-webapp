package clases.viaje;

import dominio.Cliente;
import dominio.ClienteTelefono;
import dominio.ClienteTelefonoPK;
import dominio.Direccion;
import dominio.EstadoViaje;
import dominio.Pedido;
import dominio.Sucursal;
import dominio.SucursalPK;
import dominio.Transaccion;
import dominio.Viaje;
import java.util.ArrayList;
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
	public String showPage(HttpServletRequest request) {
		return "viaje";
	}
	
	@RequestMapping(value = "/nuevoViaje", method = POST)
	public String publicarPopup(@RequestParam String tipo, @RequestParam String precio) {
//		Viaje viaje = new Viaje(1, null, Short.parseShort(precio), null, null, null, new Sucursal(new SucursalPK((short)1, 1)), new EstadoViaje((short)1));
//		System.out.println("Se creo el viaje.");
//		ViajeUtil.crearViaje(viaje);
		System.out.println("Termino la insercion.");
		if (tipo.equals("publicar")) {
			//Obtener deliverys macheo.
			//Notificar deiverys.
		} else ViajeUtil.test();
		return "redirect:/viaje.html";
	}
	
	@RequestMapping(value = "/nuevoPedido", method = POST)
	public String nuevoPedido(@ModelAttribute FormBean bean, Model model){
		ViajeUtil.nuevoPedido(bean);
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
		ViajeUtil.setEstado(1);
		//ViajeUtil.getPedidos().clear();
		System.out.println("Se hizo refresh. Se filtro los viajes al estado 1.");
		return "redirect:/viaje.html";
	}
	
	@RequestMapping(value = "/refreshPublicado", method = GET)
	public String refreshPublicado() {
		ViajeUtil.setEstado(2);
		//ViajeUtil.getPedidos().clear();
		System.out.println("Se hizo refresh. Se filtro los viajes al estado 2.");
		return "redirect:/viaje.html";
	}
	
	@RequestMapping(value = "/refreshEnProceso", method = GET)
	public String refreshEnProceso() {
		ViajeUtil.setEstado(3);
		//ViajeUtil.getPedidos().clear();
		System.out.println("Se hizo refresh. Se filtro los viajes al estado 3.");
		return "redirect:/viaje.html";
	}
	
	@RequestMapping(value = "/refreshTerminado", method = GET)
	public String refreshTerminado() {
		ViajeUtil.setEstado(4);
		//ViajeUtil.getPedidos().clear();
		System.out.println("Se hizo refresh. Se filtro los viajes al estado 4.");
		return "redirect:/viaje.html";
	}
}