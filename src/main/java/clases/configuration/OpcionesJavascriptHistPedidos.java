/**
 * Objeto auxiliar para comunicarse con JavaScript del lado del cliente.
 */
package clases.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contiene todas las opciones que se le pasa desde el controlador del HistorialPedidosController
 * a la vista del historialPedidos.jsp.
 */
public class OpcionesJavascriptHistPedidos {

	private Map<Object, Object> dataTableOptions;
	private String nombreTablaHistPedido;
	private String nombreChartDonut;
	private String nombreChartLine;
	private String nombreChartBar;
	private String identificadorJS;
	private Map<Object, Object> chartDonutOptions;
	private Map<Object, Object> chartLineOptions;
	private Map<Object, Object> chartBarOptions;
	private Map<Object, Object> mensajes;

	public OpcionesJavascriptHistPedidos(ArrayList dataChartDonutHistPedido,
	                                   ArrayList dataChartLineHistPedido,
	                                   ArrayList dataChartBarHistPedido) {
		// Agrego el identificador JavaScript
		this.identificadorJS = Parametros.IDENTIFICADOR_JS;

		// Agrego las opciones de la DataTable.
		this.dataTableOptions = Parametros.DATATABLE_OPCIONES_HISTPEDIDO;

		// Agrego el nombre de la tabla principal para la pantalla de clientes.
		this.nombreTablaHistPedido = Parametros.NOMBRE_TABLA_HISTPEDIDO;

		// Agrego el nombre de las gráficas.
		this.nombreChartDonut = Parametros.NOMBRE_CHART_DONUT;
		this.nombreChartLine = Parametros.NOMBRE_CHART_LINE;
		this.nombreChartBar = Parametros.NOMBRE_CHART_BAR;

		// Agrego las opciones de la dona.
		this.chartDonutOptions = Parametros.HISTPEDIDOCHART_OPCIONES_DONUT;
		this.chartDonutOptions.replace("data", dataChartDonutHistPedido);

		// Agrego las opciones de la linea.
		this.chartLineOptions = Parametros.HISTPEDIDOCHART_OPCIONES_LINE;
		this.chartLineOptions.replace("data", dataChartLineHistPedido);

		// Agrego las opciones de la barra.
		this.chartBarOptions = Parametros.HISTPEDIDOCHART_OPCIONES_BAR;
		this.chartBarOptions.replace("data", dataChartBarHistPedido);

		// Agrego los mensajes.
		this.mensajes = Parametros.MENSAJES;
	}

	public Map<Object, Object> getDataTableOptions() {
		return dataTableOptions;
	}

	public void setDataTableOptions(Map<Object, Object> dataTableOptions) {
		this.dataTableOptions = dataTableOptions;
	}

	public String getNombreTablaHistPedido() {
		return nombreTablaHistPedido;
	}

	public void setNombreTablaHistPedido(String nombreTablaHistPedido) {
		this.nombreTablaHistPedido = nombreTablaHistPedido;
	}

	public String getIdentificadorJS() {
		return identificadorJS;
	}

	public void setIdentificadorJS(String identificadorJS) {
		this.identificadorJS = identificadorJS;
	}

	public String getNombreChartDonut() {
		return nombreChartDonut;
	}

	public void setNombreChartDonut(String nombreChartDonut) {
		this.nombreChartDonut = nombreChartDonut;
	}

	public String getNombreChartLine() {
		return nombreChartLine;
	}

	public void setNombreChartLine(String nombreChartLine) {
		this.nombreChartLine = nombreChartLine;
	}

	public String getNombreChartBar() {
		return nombreChartBar;
	}

	public void setNombreChartBar(String nombreChartBar) {
		this.nombreChartBar = nombreChartBar;
	}

	public Map<Object, Object> getChartDonutOptions() {
		return chartDonutOptions;
	}

	public void setChartDonutOptions(Map<Object, Object> chartDonutOptions) {
		this.chartDonutOptions = chartDonutOptions;
	}

	public Map<Object, Object> getChartLineOptions() {
		return chartLineOptions;
	}

	public void setChartLineOptions(Map<Object, Object> chartLineOptions) {
		this.chartLineOptions = chartLineOptions;
	}

	public Map<Object, Object> getChartBarOptions() {
		return chartBarOptions;
	}

	public void setChartBarOptions(Map<Object, Object> chartBarOptions) {
		this.chartBarOptions = chartBarOptions;
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
			Logger.getLogger(OpcionesJavascriptCliente.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}
}
