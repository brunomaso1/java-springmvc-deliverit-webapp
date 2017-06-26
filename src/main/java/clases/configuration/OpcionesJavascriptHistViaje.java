package clases.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OpcionesJavascriptCliente {

	private Map<Object, Object> dataTableOptions;
	private String nombreTablaHistViaje;
	private String identificadorJS;

	public OpcionesJavascriptCliente() {
		// Agrego el identificador JavaScript
		this.identificadorJS = Parametros.IDENTIFICADOR_JS;

		// Agrego las opciones de la DataTable.
		this.dataTableOptions = Parametros.DATATABLE_OPCIONES_HISTVIAJE;

		// Agrego el nombre de la tabla principal para la pantalla de clientes.
		this.nombreTablaHistViaje = Parametros.NOMBRE_TABLA_CLIENTE;
	}

	public Map<Object, Object> getDataTableOptions() {
		return dataTableOptions;
	}

	public void setDataTableOptions(Map<Object, Object> dataTableOptions) {
		this.dataTableOptions = dataTableOptions;
	}

	public String getNombreTablaHistViaje() {
		return nombreTablaHistViaje;
	}

	public void setNombreTablaHistViaje(String nombreTablaHistViaje) {
		this.nombreTablaHistViaje = nombreTablaHistViaje;
	}

	public String getIdentificadorJS() {
		return identificadorJS;
	}

	public void setIdentificadorJS(String identificadorJS) {
		this.identificadorJS = identificadorJS;
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
