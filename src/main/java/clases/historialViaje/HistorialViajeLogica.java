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
	
	public Viaje[] obtenerViajes(String sucursalId) {
		RestTemplate restTemplate = new RestTemplate();

		//Obtiene la respuesta.
		Viaje[] viajes = restTemplate.getForObject(Configuration.restFindViajesGet(sucursalId), Viaje[].class);
		return viajes;
	}
	
	public String contarPedidosViaje(String viajeId){
		RestTemplate restTemplate = new RestTemplate();

		//Obtiene la respuesta.
		String viajes = restTemplate.getForObject(Configuration.restCountPedidosViaje(viajeId), String.class);
		return viajes;
	}
}