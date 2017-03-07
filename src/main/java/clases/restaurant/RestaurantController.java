package clases.restaurant;

import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de las acciones respecto a los restaurantes.
 */
@Controller
@RequestMapping(path = "/restaurant")
public class RestaurantController {

	//Logger
	private final static Logger LOGGER = Logger.getLogger(RestaurantController.class.getName());

	private RestaurantLogica vl;
	private RestaurantControllerHelper vch;

	public RestaurantController() {
		this.vl = new RestaurantLogica();
		this.vch = new RestaurantControllerHelper();
	}

	@GetMapping
	public String showPage(Model model) {
		model.addAttribute("datosTablaPrincipal", vch.tablaPrincipalHtml());
		return "restaurant";
	}
}