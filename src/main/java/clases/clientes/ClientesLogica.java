/**
 * Ejecuta la lógica del controlador ClientesController.
 */
package clases.clientes;

import clases.dominio.*;
import clases.configuration.*;
import org.springframework.web.client.RestTemplate;
import java.util.logging.Logger;

public class ClientesLogica {

	private final static Logger LOGGER = Logger.getLogger(ClientesLogica.class.getName());
	
	/**
	 * Consulta a la API para obtener los clientes pertenecientes a una sucursal.
	 */
	public Cliente[] obtenerClientes(String sucursalId) {
		RestTemplate restTemplate = new RestTemplate();

		//Obtiene la respuesta.
		Cliente[] clientes = restTemplate.getForObject(Configuration.restFindClientesGet(sucursalId), Cliente[].class);
		return clientes;
	}
}