/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.viaje;

import dominio.Pedido;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String showPage(ModelMap model) {
		pedidos = new ArrayList<>();
		ViajeUtil.setEstado(1);
		ViajeUtil.setSucursal(1);
		ViajeUtil.setRestaurant(1);
		return "viaje";
	}
	
	@RequestMapping(value = "/nuevoViaje", method = POST)
	public String publicarPopup(@RequestParam String tipo) {
		//Crear viaje.
		//Insertar viaje.
		if (tipo.equals("publicar")) {
			//Obtener deliverys macheo.
			//Notificar deiverys.
		}
		pedidos.clear();
		return "redirect:/viaje.html";
	}
	
	@RequestMapping(value = "/nuevoPedido", method = POST)
	public String nuevoPedido(){
		return "redirect:/viaje.html";
	}
	
	/* @GetMapping(value = "/verViaje/{viajeID}")
	public String verViaje(@PathVariable String viajeID, Model model) {
		Viaje viaje = viajeService.findViaje(viajeID);
		model.addAttribute("viaje", viaje);
		return "mostrarViaje";
	} */
	
}