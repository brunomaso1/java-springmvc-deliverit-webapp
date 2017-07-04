/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class OpcionesJavascriptViaje {

	private String urlGetAllDelivery;
	private String urlCalificar;
	private String urlObtenerPedidosTabla;
	private String urlObtenerViajesArray;
	private List<String> coloresMarkadores;
	private int tiempoActivacionCambioColores;
	private int serverHourPadding;
	private Map<Object, Object> tiempoColores;
	private String urlMoto;
	private int defZoomMap;
	private Map<Object, Object> dataTableOptions;
	private double defLat;
	private double defLon;
	private String estadoIdActual;
	private String nombreTablaViaje;
	private String nombreMapaViaje;
	private String identificadorJS;
	private Map<Object, Object> mensajes;
	private Map<Object, Object> iconSize;
	private Map<Object, Object> labelOrigin;
	private Map<Object, Object> nombreFiltros;
	private int markerBounceTimeOut;
	private int zoomResaltarMarkador;
	private int timeOutResaltarMarkador;
	private int actualizarDeliverysTime;
	private int tiempoActivacionUpdates;

	public OpcionesJavascriptViaje(String contextPath, String estadoId) {

		// Agrego la url del para la llamada ajax para obtener la ubicacion del dleivery.
		this.urlGetAllDelivery = contextPath + Parametros.URL_DELIVERY;

		// Agrego la url para la llamada ajax para obtener calificar al viaje.
		this.urlCalificar = contextPath + Parametros.URL_CALIFICAR;

		// Agreg la url para la llamada ajax para obtener los pedidos para modificar la tabla.
		this.urlObtenerPedidosTabla = contextPath + Parametros.URL_OBTENERPEDIDOSTABLA;

		// Agrego la url para la llamada ajax de los viajes.
		this.urlObtenerViajesArray = contextPath + Parametros.URL_OBTENERVIAJESARRAY;

		// Agrego los colores de los markadores.
		this.coloresMarkadores = new ArrayList<>();

		Arrays.asList(Parametros.COLORES_MARKADORES).forEach((k) -> {
			String color = Parametros.UBICACION_MARKADORES + k + Parametros.EXTENSION_MARKADORES;
			this.coloresMarkadores.add(color);
		});

		// Agrego la ubicacion de la moto.
		this.urlMoto = Parametros.UBICACION_MOTO;

		// Agrego el zoom del mapa.
		this.defZoomMap = Parametros.ZOOM_MAPA;

		// Agrego las opciones de la DataTable.
		this.dataTableOptions = Parametros.DATATABLE_OPCIONES_VIAJE;

		// Agrego la latitud y longitud por defecto.
		this.defLat = Parametros.DEFAULT_LATITUDE;
		this.defLon = Parametros.DEFAULT_LONGITUDE;

		// Agrego el estado actual.
		this.estadoIdActual = estadoId;

		// Agrego el nombre de la tabla principal.
		this.nombreTablaViaje = Parametros.NOMBRE_TABLA_VIAJE;

		// Agrego el nombre del mapa.
		this.nombreMapaViaje = Parametros.NOMBRE_MAPA_VIAJE;

		// Agrego los mensajes.
		this.mensajes = Parametros.MENSAJES;

		// Agrego el identificador JavaScript
		this.identificadorJS = Parametros.IDENTIFICADOR_JS;

		// Tamaño de los iconos.
		this.iconSize = Parametros.ICONSIZE;

		// Agrego la ubicacion de origen de las etiquetas de los iconos.
		this.labelOrigin = Parametros.LABELORIGIN;

		// Agrego el tiempo en que se activa la funcion para cambiar los colores.
		this.tiempoActivacionCambioColores = Parametros.TIEMPOACTIVACIONCAMBIOCOLORES;

		// Agrego el padding para la hora del server.
		this.serverHourPadding = Parametros.SERVERHOURPADDING;

		// Agrego los tiempos para los colores.
		this.tiempoColores = Parametros.TIEMPOCOLORES;

		// Agrego el nombre de los filtros.
		this.nombreFiltros = Parametros.NOMBREFILTROS;

		// Agrego el tiempo de para terminar la animacion del markador.
		this.markerBounceTimeOut = Parametros.MARKERBOUNCETIMEOUT;

		// Agrego el zoom que se realiza al resaltar el markador.
		this.zoomResaltarMarkador = Parametros.ZOOMRESALTARMARKADOR;

		// Agrego el time out de resaltar markadores.
		this.timeOutResaltarMarkador = Parametros.TIMEOUTRESALTARMARKADOR;

		// Agrego el tiempo que se ejecuta el actualizarDeliverys;
		this.actualizarDeliverysTime = Parametros.ACTUALIZARDELIVERYSTIME;

		// Agrego el tiempo de actualziacion de los updates.
		this.tiempoActivacionUpdates = Parametros.TIEMPOACTIVACIONUPDATES;
	}
	public List<String> getColoresMarkadores() {
		return coloresMarkadores;
	}

	public void setColoresMarkadores(List<String> coloresMarkadores) {
		this.coloresMarkadores = coloresMarkadores;
	}

	public int getDefZoomMap() {
		return defZoomMap;
	}

	public void setDefZoomMap(int defZoomMap) {
		this.defZoomMap = defZoomMap;
	}

	public Map<Object, Object> getDataTableOptions() {
		return dataTableOptions;
	}

	public void setDataTableOptions(Map<Object, Object> dataTableOptions) {
		this.dataTableOptions = dataTableOptions;
	}

	public double getDefLat() {
		return defLat;
	}

	public void setDefLat(double defLat) {
		this.defLat = defLat;
	}

	public double getDefLon() {
		return defLon;
	}

	public void setDefLon(double defLon) {
		this.defLon = defLon;
	}

	public String getEstadoIdActual() {
		return estadoIdActual;
	}

	public void setEstadoIdActual(String estadoIdActual) {
		this.estadoIdActual = estadoIdActual;
	}

	public String getNombreTablaViaje() {
		return nombreTablaViaje;
	}

	public void setNombreTablaViaje(String nombreTablaViaje) {
		this.nombreTablaViaje = nombreTablaViaje;
	}

	public String getUrlCalificar() {
		return urlCalificar;
	}

	public void setUrlCalificar(String urlCalificar) {
		this.urlCalificar = urlCalificar;
	}

	public String getNombreMapaViaje() {
		return nombreMapaViaje;
	}

	public void setNombreMapaViaje(String nombreMapaViaje) {
		this.nombreMapaViaje = nombreMapaViaje;
	}

	public Map<Object, Object> getMensajes() {
		return mensajes;
	}

	public void setMensajes(Map<Object, Object> mensajes) {
		this.mensajes = mensajes;
	}

	public String getIdentificadorJS() {
		return identificadorJS;
	}

	public void setIdentificadorJS(String identificadorJS) {
		this.identificadorJS = identificadorJS;
	}

	public String getUrlGetAllDelivery() {
		return urlGetAllDelivery;
	}

	public void setUrlGetAllDelivery(String urlGetAllDelivery) {
		this.urlGetAllDelivery = urlGetAllDelivery;
	}

	public String getUrlObtenerPedidosTabla() {
		return urlObtenerPedidosTabla;
	}

	public void setUrlObtenerPedidosTabla(String urlObtenerPedidosTabla) {
		this.urlObtenerPedidosTabla = urlObtenerPedidosTabla;
	}

	public String getUrlObtenerViajesArray() {
		return urlObtenerViajesArray;
	}

	public void setUrlObtenerViajesArray(String urlObtenerViajesArray) {
		this.urlObtenerViajesArray = urlObtenerViajesArray;
	}

	public int getTiempoActivacionCambioColores() {
		return tiempoActivacionCambioColores;
	}

	public void setTiempoActivacionCambioColores(int tiempoActivacionCambioColores) {
		this.tiempoActivacionCambioColores = tiempoActivacionCambioColores;
	}

	public int getServerHourPadding() {
		return serverHourPadding;
	}

	public void setServerHourPadding(int serverHourPadding) {
		this.serverHourPadding = serverHourPadding;
	}

	public Map<Object, Object> getTiempoColores() {
		return tiempoColores;
	}

	public void setTiempoColores(Map<Object, Object> tiempoColores) {
		this.tiempoColores = tiempoColores;
	}

	public String getUrlMoto() {
		return urlMoto;
	}

	public void setUrlMoto(String urlMoto) {
		this.urlMoto = urlMoto;
	}

	public Map<Object, Object> getIconSize() {
		return iconSize;
	}

	public void setIconSize(Map<Object, Object> iconSize) {
		this.iconSize = iconSize;
	}

	public Map<Object, Object> getLabelOrigin() {
		return labelOrigin;
	}

	public void setLabelOrigin(Map<Object, Object> labelOrigin) {
		this.labelOrigin = labelOrigin;
	}

	public Map<Object, Object> getNombreFiltros() {
		return nombreFiltros;
	}

	public void setNombreFiltros(Map<Object, Object> nombreFiltros) {
		this.nombreFiltros = nombreFiltros;
	}

	public int getMarkerBounceTimeOut() {
		return markerBounceTimeOut;
	}

	public void setMarkerBounceTimeOut(int markerBounceTimeOut) {
		this.markerBounceTimeOut = markerBounceTimeOut;
	}

	public int getZoomResaltarMarkador() {
		return zoomResaltarMarkador;
	}

	public void setZoomResaltarMarkador(int zoomResaltarMarkador) {
		this.zoomResaltarMarkador = zoomResaltarMarkador;
	}

	public int getTimeOutResaltarMarkador() {
		return timeOutResaltarMarkador;
	}

	public void setTimeOutResaltarMarkador(int timeOutResaltarMarkador) {
		this.timeOutResaltarMarkador = timeOutResaltarMarkador;
	}

	public int getActualizarDeliverysTime() {
		return actualizarDeliverysTime;
	}

	public void setActualizarDeliverysTime(int actualizarDeliverysTime) {
		this.actualizarDeliverysTime = actualizarDeliverysTime;
	}

	public int getTiempoActivacionUpdates() {
		return tiempoActivacionUpdates;
	}

	public void setTiempoActivacionUpdates(int tiempoActivacionUpdates) {
		this.tiempoActivacionUpdates = tiempoActivacionUpdates;
	}

	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(this);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(OpcionesJavascriptViaje.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}
}
