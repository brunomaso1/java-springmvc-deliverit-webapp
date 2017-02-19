/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deliverit.webapp.viajes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author bruno
 */
@Controller
public class Viajes_Controller {

	@RequestMapping(value = "/viajes", method = RequestMethod.GET)
	public String showPage(ModelMap model) {
		return "viajes";
	}
	
	@RequestMapping(value = "/nuevoViaje", method = RequestMethod.POST)
	public String publicarPopup(@RequestParam String tipo) {
		//Crear viaje.
		//Insertar viaje.
		if (tipo.equals("publicar")) {
			//Obtener deliverys macheo.
			//Notificar deiverys.
		}	
		return "redirect:/viajes.html";
	}	
}