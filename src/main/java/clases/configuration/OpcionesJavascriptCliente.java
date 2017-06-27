package clases.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OpcionesJavascriptCliente {

	private Map<Object, Object> dataTableOptions;
	private String nombreTablaCliente;
	private String identificadorJS;
	private Map<Object, Object> mensajes;

	public OpcionesJavascriptCliente() {
		// Agrego el identificador JavaScript
		this.identificadorJS = Parametros.IDENTIFICADOR_JS;

		// Agrego las opciones de la DataTable.
		this.dataTableOptions = Parametros.DATATABLE_OPCIONES_CLIENTE;

		// Agrego el nombre de la tabla principal para la pantalla de clientes.
		this.nombreTablaCliente = Parametros.NOMBRE_TABLA_CLIENTE;

		// Agrego los mensajes.
		this.mensajes = Parametros.MENSAJES;
	}

	public Map<Object, Object> getDataTableOptions() {
		return dataTableOptions;
	}

	public void setDataTableOptions(Map<Object, Object> dataTableOptions) {
		this.dataTableOptions = dataTableOptions;
	}

	public String getNombreTablaCliente() {
		return nombreTablaCliente;
	}

	public void setNombreTablaCliente(String nombreTablaCliente) {
		this.nombreTablaCliente = nombreTablaCliente;
	}

	public String getIdentificadorJS() {
		return identificadorJS;
	}

	public void setIdentificadorJS(String identificadorJS) {
		this.identificadorJS = identificadorJS;
	}

	public String getMensajes() {
		return mensajes;
	}

	public void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}

	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(this);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(OpcionesJavascriptCliente.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}
}
