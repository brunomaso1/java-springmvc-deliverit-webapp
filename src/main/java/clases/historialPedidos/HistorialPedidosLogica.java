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

public class HistorialPedidosLogica {

	private final static Logger LOGGER = Logger.getLogger(HistorialPedidosLogica.class.getName());
	
	public Pedido[] obtenerPedidos(String sucursalId) {
		RestTemplate restTemplate = new RestTemplate();

		//Obtiene la respuesta.
		Pedido[] pedidos = restTemplate.getForObject(Configuration.restFindPedidosGet(sucursalId), Pedido[].class);
		return pedidos;
	}
}