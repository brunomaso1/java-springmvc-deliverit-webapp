package clases.historialPedidos;

import clases.accesControl.ACSessionServices;
import clases.configuration.OpcionesJavascriptHistPedidos;
import clases.dominio.Pedido;
import java.util.Calendar;
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
		
		Calendar fechaFinChartLineHistPedidos = Calendar.getInstance();
		Calendar fechaInicioChartLineHistPedidos = Calendar.getInstance(); fechaInicioChartLineHistPedidos.add(Calendar.MONTH, -6);
		Calendar fechaFinChartBarHistPedidos = Calendar.getInstance();
		Calendar fechaInicioChartBarHistPedidos = Calendar.getInstance(); fechaInicioChartBarHistPedidos.add(Calendar.MONTH, -6);
		
		OpcionesJavascriptHistPedidos opciones = new OpcionesJavascriptHistPedidos(vch.chartHistorialPedidosDona(pedidos),
		        vch.chartHistorialPedidosLinea(pedidos, fechaInicioChartLineHistPedidos, fechaFinChartLineHistPedidos),
		        vch.chartHistorialPedidosBarras(pedidos, fechaInicioChartBarHistPedidos, fechaFinChartBarHistPedidos));

		model.addAttribute("usuarioActual", acss.getUserName());

		model.addAttribute("datosTablaHistPedido", vch.getDatosTablaHistPedidosHTML(pedidos));
		model.addAttribute("nombreTablaHistPedido", opciones.getNombreTablaHistPedido());
		model.addAttribute("nombreChartDonut", opciones.getNombreChartDonut());
		model.addAttribute("nombreChartLine", opciones.getNombreChartLine());
		model.addAttribute("nombreChartBar", opciones.getNombreChartBar());
		
		// Para Javascript
		model.addAttribute("opciones", opciones.toJSON());

		return "historialPedidos";
	}
}