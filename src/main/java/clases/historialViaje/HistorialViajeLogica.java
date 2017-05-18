package clases.historialViaje;

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

public class HistorialViajeLogica {

	private final static Logger LOGGER = Logger.getLogger(HistorialViajeLogica.class.getName());

	public List<Viaje> obtenerViajes(Date fechaDesde, Date fechaHasta) {
		RestTemplate restTemplate = new RestTemplate();

		//Obtiene la respuesta.
		//Viaje[] viajes = restTemplate.getForObject(Configuration.restViajeGet(fechaDesde, fechaHasta), Viaje[].class);
		Viaje[] viajesArry = restTemplate.getForObject(Configuration.restViajeGet(), Viaje[].class);
		ArrayList<Viaje> viajes = new ArrayList<Viaje>(Arrays.asList(viajesArry));
		return viajes;
	}
}