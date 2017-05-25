package clases.historialPedidos;

import clases.accesControl.ACSessionServices;
import clases.dominio.Pedido;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de las acciones respecto a los Pedidos.
 */
@Controller
@RequestMapping(path = "/historialPedidos")
public class HistorialPedidosController {

	//Logger
	private final static Logger LOGGER = Logger.getLogger(HistorialPedidosController.class.getName());

	private HistorialPedidosLogica hvl;
	private HistorialPedidosControllerHelper vch;
	private ACSessionServices acss;

	public HistorialPedidosController() {
		this.hvl = new HistorialPedidosLogica();
		this.vch = new HistorialPedidosControllerHelper();
		this.acss = new ACSessionServices();
	}

	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	public String showPage(HttpSession request, Model model) {
		String sucursalId = acss.getUserId();

		Pedido[] pedidos = hvl.obtenerPedidos(sucursalId);

		model.addAttribute("datosTablaHistorialPedidos", vch.tablaHistorialPedidosHtml(pedidos));
		model.addAttribute("donutData", vch.chartHistorialPedidosDona(pedidos));
		model.addAttribute("lineData", vch.chartHistorialPedidosLinea(pedidos));
		model.addAttribute("barrsData", vch.chartHistorialPedidosBarras(pedidos));

		model.addAttribute("usuarioActual", acss.getUserName());

		return "historialPedidos";
	}
}