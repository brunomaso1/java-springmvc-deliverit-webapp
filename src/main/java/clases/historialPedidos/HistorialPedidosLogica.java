package clases.historialPedidos;

import clases.dominio.*;
import clases.configuration.*;
import org.springframework.web.client.RestTemplate;
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