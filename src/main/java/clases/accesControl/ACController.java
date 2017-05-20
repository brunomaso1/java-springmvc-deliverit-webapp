/**
 * Controlador del Control de Acceso (login, registro).
 */
package clases.accesControl;

import clases.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bruno
 */
@Controller
public class ACController {
	
	@Autowired
	private ACIUserService userService;
	
	@Autowired
	private ACISecurityService securityService;
	
	@Autowired
	private ACUserValidator userValidator;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Usuario());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Usuario userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getNombre(), userForm.getPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Usuario o contraseña incorrectos.");

        if (logout != null)
            model.addAttribute("message", "Has salido correctamente.");

        return "login";
    }
}