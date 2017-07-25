/**
 * Controlador de la clase Clientes.
 */
package clases.clientes;

import clases.accesControl.ACSessionServices;
import clases.configuration.OpcionesJavascriptCliente;
import clases.dominio.Cliente;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de las acciones respecto a los Clientes. Mapea solitudes relacionadas con los clientes.
 */
@Controller
@RequestMapping(path = "/clientes")
public class ClientesController {

	//Logger
	private final static Logger LOGGER = Logger.getLogger(ClientesController.class.getName());

	private ClientesLogica hvl;
	private ClientesControllerHelper vch;
	private ACSessionServices acss;

	public ClientesController() {
		this.hvl = new ClientesLogica();
		this.vch = new ClientesControllerHelper();
		this.acss = new ACSessionServices();
	}

	/**
	 * Muestra la página principal de los clientes.
	 */
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	public String showPage(HttpSession request, Model model) {
		String sucursalId = acss.getUserId();
		OpcionesJavascriptCliente ojc = new OpcionesJavascriptCliente();

		Cliente[] clientes = hvl.obtenerClientes(sucursalId);
		
		model.addAttribute("nombreTablaCliente", ojc.getNombreTablaCliente());
		model.addAttribute("datosTablaCliente", vch.getDatosTablaClientesHTML(clientes));
		model.addAttribute("usuarioActual", acss.getUserName());
		
		// Para Javascript
		model.addAttribute("opciones", ojc.toJSON());

		return "clientes";
	}
}