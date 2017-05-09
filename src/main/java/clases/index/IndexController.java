package clases.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class IndexController {
	
	@RequestMapping(path = {"/index","/"}, method = RequestMethod.GET)
	public String showPage(Model model) {
		return "index";
	}
}