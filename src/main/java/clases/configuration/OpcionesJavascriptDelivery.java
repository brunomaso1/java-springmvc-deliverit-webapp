/**
 * Objeto auxiliar para comunicarse con JavaScript del lado del cliente.
 */
package clases.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contiene todas las opciones que se le pasa desde el controlador del DeliveryController
 * a la vista del delivery.jsp.
 */
public class OpcionesJavascriptDelivery {

	private Map<Object, Object> dataTableOptions;
	private String nombreTablaDelivery;
	private String identificadorJS;
	private Map<Object, Object> mensajes;

	public OpcionesJavascriptDelivery() {
		// Agrego el identificador JavaScript
		this.identificadorJS = Parametros.IDENTIFICADOR_JS;

		// Agrego las opciones de la DataTable.
		this.dataTableOptions = Parametros.DATATABLE_OPCIONES_DELIVERY;

		// Agrego el nombre de la tabla principal para la pantalla de clientes.
		this.nombreTablaDelivery = Parametros.NOMBRE_TABLA_DELIVERY;

		// Agrego los mensajes.
		this.mensajes = Parametros.MENSAJES;
	}

	public Map<Object, Object> getDataTableOptions() {
		return dataTableOptions;
	}

	public void setDataTableOptions(Map<Object, Object> dataTableOptions) {
		this.dataTableOptions = dataTableOptions;
	}

	public String getNombreTablaDelivery() {
		return nombreTablaDelivery;
	}

	public void setNombreTablaDelivery(String nombreTablaDelivery) {
		this.nombreTablaDelivery = nombreTablaDelivery;
	}

	public String getIdentificadorJS() {
		return identificadorJS;
	}

	public void setIdentificadorJS(String identificadorJS) {
		this.identificadorJS = identificadorJS;
	}

	public Map<Object, Object> getMensajes() {
		return mensajes;
	}

	public void setMensajes(Map<Object, Object> mensajes) {
		this.mensajes = mensajes;
	}

	/**
	 * Parsea este objeto a JSON.
 	 */
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(this);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(OpcionesJavascriptDelivery.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}
}
