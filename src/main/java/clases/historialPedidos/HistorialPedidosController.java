package clases.historialPedidos;

import clases.accesControl.ACSessionServices;
import clases.configuration.Parametros;
import clases.dominio.Viaje;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		model.addAttribute("rawData1", vch.chartHistorialPedidosDona(pedidos));
		model.addAttribute("rawData2", vch.chartHistorialPedidosLinea(pedidos));
		model.addAttribute("rawData3", vch.chartHistorialPedidosBarras(pedidos));

		model.addAttribute("usuarioActual", acss.getUserName());

		return "historialPedidos";
	}
}