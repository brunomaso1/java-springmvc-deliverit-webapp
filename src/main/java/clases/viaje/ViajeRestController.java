package clases.viaje;

import clases.accesControl.ACSessionServices;
import clases.dominio.Delivery;
import clases.dominio.Ubicacion;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bruno
 */
@RestController
public class ViajeRestController {

	//Logger
	private final Logger LOGGER = Logger.getLogger(ViajeRestController.class.getName());

	private ViajeLogica vl;
	private ACSessionServices acss;

	public ViajeRestController() {
		this.vl = new ViajeLogica();
		this.acss = new ACSessionServices();
	}

	@RequestMapping(value = "delivery/{id}/", method = RequestMethod.GET)
	public Ubicacion doRequest(@PathVariable String id) {
		Ubicacion u = vl.obtenerUbicacionDelivery(id);
		return u;
	}

	// TEST
	@RequestMapping(value = "delivery/", method = RequestMethod.GET)
	public Delivery[] doRequest() {
		String sucursalId = acss.getUserId();
		Delivery[] d = vl.obtenerDeliverys(sucursalId);
		return d;
	}
	
	@RequestMapping(value = "calificar/", method = RequestMethod.POST)
	public void doPut(@RequestParam String idViaje, @RequestParam String calificacion) {
		vl.calificar(idViaje, calificacion);		
	}
}
