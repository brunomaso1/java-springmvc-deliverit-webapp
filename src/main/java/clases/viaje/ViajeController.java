/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.viaje;

import dominio.Cliente;
import dominio.ClienteTelefono;
import dominio.ClienteTelefonoPK;
import dominio.Direccion;
import dominio.Pedido;
import dominio.Sucursal;
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
 *
 * @author bruno
 */
@Controller
@RequestMapping(value = "/viaje")
public class ViajeController {
	
	public ArrayList<Pedido> pedidos;

	@GetMapping
	public String showPage(HttpServletRequest request) {
		return "viaje";
	}
	
	@RequestMapping(value = "/nuevoViaje", method = POST)
	public String publicarPopup(@RequestParam String tipo, @RequestParam String precio) {
//		Viaje viaje = new Viaje(1, null, Short.parseShort(precio), null, null, null, new Sucursal(new SucursalPK((short)1, 1)), new EstadoViaje((short)1));
//		System.out.println("Se creo el viaje.");
//		ViajeUtil.crearViaje(viaje);
//		System.out.println("Termino la insercion.");
		ViajeUtil.test();
		if (tipo.equals("publicar")) {
			//Obtener deliverys macheo.
			//Notificar deiverys.
		}
		return "redirect:/viaje.html";
	}
	
	@RequestMapping(value = "/nuevoPedido", method = POST)
	public String nuevoPedido(@ModelAttribute FormBean bean, Model model){
		Direccion dir = new Direccion(1, bean.getCalle(), Short.parseShort(bean.getPuerta()), bean.getEsquina(), 0d, 0d, new ArrayList<Cliente>(), new ArrayList<Sucursal>());
		Cliente cli = new Cliente(1, bean.getNombre(), dir, null, new ArrayList<ClienteTelefono>());
		ClienteTelefono ct = new ClienteTelefono(new ClienteTelefonoPK(cli.getId(), bean.getTelefono()), cli);
		cli.getClienteTelefonoCollection().add(ct);
		Pedido ped = new Pedido(null, bean.getAclaraciones(), "Contado", null, cli);
		ViajeUtil.getPedidos().add(ped);
		return "redirect:/viaje.html";
	}
	
	/* @GetMapping(value = "/verViaje/{viajeID}")
	public String verViaje(@PathVariable String viajeID, Model model) {
		Viaje viaje = viajeService.findViaje(viajeID);
		model.addAttribute("viaje", viaje);
		return "mostrarViaje";
	} */
	
	@RequestMapping(value = "/refresh", method = GET)
	public String refresh(){
		System.out.println("Se hizo refresh.");
		return "redirect:/viaje.html";
	}
	
}