package clases.deliverys;

import clases.viaje.*;
import clases.dominio.*;
import clases.configuration.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
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