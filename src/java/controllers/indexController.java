/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bruno
 */
@Controller
public class indexController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showPage(ModelMap model) {

		return "index";
	}
	
	@RequestMapping(value = "/registrarse", method = RequestMethod.POST)
	public String registrarse(ModelMap model) {
		// Llamar a la logica.
		return "registrarse";
	}
	
	@RequestMapping(value = "/loguearse", method = RequestMethod.POST)
	public String loguearse(ModelMap model) {
		// Llamar a la logica.
		return "loguearse";
	}
	
}
