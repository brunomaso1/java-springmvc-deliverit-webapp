package clases.index;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import clases.dominio.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes({"sucursalId", "restaurantId", "estado"})
public class IndexController {

	//Logger
	private final static Logger LOGGER = Logger.getLogger(IndexController.class.getName());
	
	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public String showPage(Model model) {
		LOGGER.log(Level.FINEST, "Se realizo una solicitud request al index.html");	
		
		model.addAttribute("sucursalId", "1");
		model.addAttribute("restaurantId", "1");
		model.addAttribute("estado", "1");
		
		return "redirect:/viaje.html";
	}

	@RequestMapping(path = "/registrarse", method = RequestMethod.POST)
	public String registrarse(@ModelAttribute IndexFormBean bean, RedirectAttributes model) {
		IndexLogica il = new IndexLogica(bean);

		LOGGER.log(Level.FINEST, "Ha comenzado el proceso de registro.");
		Restaurant rt = il.registrarRestaurant();

		//Agrego a la sesion
		model.addFlashAttribute("restaurantId", rt);
		model.addFlashAttribute("estado", 2);

		LOGGER.log(Level.FINER, "Se ha registrado el cliente correctamente.", rt);
		LOGGER.log(Level.FINEST, "Ha finalizado el proceso de registro.");
		return "redirect:/restaurant.html";
	}

	@RequestMapping(path = "/loguearse", method = RequestMethod.POST)
	public String loguearse(@RequestParam("nombre") String nombreUsuario, @RequestParam("pass") String pass, RedirectAttributes model) {
		IndexLogica il = new IndexLogica(nombreUsuario, pass);
		
		//Agrego a la session el estado.		
		model.addFlashAttribute("estado", 2);

		//Valido el login.
		boolean valido = il.loginValido();
		LOGGER.log(Level.FINEST, "Logeo con datos correctos.");

		if (valido) {
			//Los datos son validos, tengo que saber si es una sucursal o un restaurant.
			switch (il.getTipo()) {
				case "Sucursal" : {
					//Agrego sus identificadores a la session.
					Restaurant rt = il.getRestaurant();
					model.addFlashAttribute("restaurantId", rt);
					
					Sucursal su = il.getSucursal();
					model.addFlashAttribute("sucursalId", su);
					
					LOGGER.log(Level.FINEST, "Se ha logueado correctamente la sucursal.");
					return "redirect:/viaje.html";
				}
				case "Restaurant" : {
					//Agrego su identificador a la session.
					Restaurant rt = il.getRestaurant();
					model.addFlashAttribute("restaurantId", rt);
					
					LOGGER.log(Level.FINER, "Se ha logeado correctamente el cliente Restaurant.", rt);
					return "redirect:/restaurant.html";
				}
				default : {
					LOGGER.log(Level.SEVERE, "No se ha encontrado el tipo de ingreso.");
					return "redirect:/error500.html";
				}
			}
		} else {
			//Agregar el error para mostrar en el modelo.
			model.addAttribute("error", "El usuario y la contraseña no coinciden.");
			return "index";
		}
	}
}