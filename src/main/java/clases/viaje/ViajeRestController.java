/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.viaje;

import clases.dominio.Ubicacion;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bruno
 */
public class ViajeRestController {

	@RestController
	public class DeliveryController {

		//Logger
		private final Logger LOGGER = Logger.getLogger(ViajeRestController.class.getName());
		
		private ViajeLogica vl;

		public DeliveryController() {
			this.vl = new ViajeLogica();
		}		
		
		@RequestMapping(value="/student/{id}/", method=RequestMethod.GET)
		public Ubicacion doRequest(@PathVariable String id) {
			Ubicacion u = vl.obtenerUbicacionDelivery(id);
			return u;
		}
	}
}
