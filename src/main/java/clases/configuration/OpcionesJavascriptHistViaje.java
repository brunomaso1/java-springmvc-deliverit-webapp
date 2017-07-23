package clases.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OpcionesJavascriptHistViaje {

	private Map<Object, Object> dataTableOptions;
	private String nombreTablaHistViaje;
	private String nombreChartDonut;
	private String nombreChartLine;
	private String nombreChartBar;
	private String identificadorJS;
	private Map<Object, Object> chartDonutOptions;
	private Map<Object, Object> chartLineOptions;
	private Map<Object, Object> chartBarOptions;
	private Map<Object, Object> mensajes;

	public OpcionesJavascriptHistViaje(ArrayList dataChartDonutHistViaje,
	                                   ArrayList dataChartLineHistViaje,
	                                   ArrayList dataChartBarHistViaje) {
		// Agrego el identificador JavaScript
		this.identificadorJS = Parametros.IDENTIFICADOR_JS;

		// Agrego las opciones de la DataTable.
		this.dataTableOptions = Parametros.DATATABLE_OPCIONES_HISTVIAJE;

		// Agrego el nombre de la tabla principal para la pantalla de clientes.
		this.nombreTablaHistViaje = Parametros.NOMBRE_TABLA_HISTVIAJE;

		// Agrego el nombre de las gráficas.
		this.nombreChartDonut = Parametros.NOMBRE_CHART_DONUT;
		this.nombreChartLine = Parametros.NOMBRE_CHART_LINE;
		this.nombreChartBar = Parametros.NOMBRE_CHART_BAR;

		// Agrego las opciones de la dona.
		this.chartDonutOptions = Parametros.HISTVIAJECHART_OPCIONES_DONUT;
		this.chartDonutOptions.replace("data", dataChartDonutHistViaje);

		// Agrego las opciones de la linea.
		this.chartLineOptions = Parametros.HISTVIAJECHART_OPCIONES_LINE;
		this.chartLineOptions.replace("data", dataChartLineHistViaje);

		// Agrego las opciones de la barra.
		this.chartBarOptions = Parametros.HISTVIAJECHART_OPCIONES_BAR;
		this.chartBarOptions.replace("data", dataChartBarHistViaje);

		// Agrego los mensajes.
		this.mensajes = Parametros.MENSAJES;
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

	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(this);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(OpcionesJavascriptHistViaje.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}
}
