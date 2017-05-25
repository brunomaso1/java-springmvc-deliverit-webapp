package clases.deliverys;

import clases.dominio.*;
import clases.configuration.*;
import org.springframework.web.client.RestTemplate;
import java.util.logging.Logger;

public class DeliverysLogica {

	private final static Logger LOGGER = Logger.getLogger(DeliverysLogica.class.getName());
	
	public Delivery[] obtenerDeliverys(String sucursalId) {
		RestTemplate restTemplate = new RestTemplate();

		//Obtiene la respuesta.
		// Falta implementar.
		Delivery[] deliverys = restTemplate.getForObject(Configuration.restFindDeliverysGet(sucursalId), Delivery[].class);
		return deliverys;
	}
}