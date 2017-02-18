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
@RequestMapping("/app")
public class appController {

	@RequestMapping(method = RequestMethod.GET)
	public String showPage(ModelMap model) {
		return "app";
	}
	
	@RequestMapping(value = "/nuevoViaje", method = RequestMethod.POST)
	public String registrarse(ModelMap model) {
		return "nuevoViaje";
	}	
}
