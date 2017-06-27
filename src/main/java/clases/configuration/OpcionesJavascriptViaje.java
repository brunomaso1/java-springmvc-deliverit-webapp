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

	private String url;
	private String urlCalificar;
	private List<String> coloresMarkadores;
	private String moto;
	private int defZoomMap;
	private Map<Object, Object> dataTableOptions;
	private double defLat;
	private double defLon;
	private String estadoIdActual;
	private String nombreTablaViaje;
	private String nombreMapaViaje;
	private Map<Object, Object> mensajes;

	public OpcionesJavascriptViaje(String contextPath, String estadoId) {

		// Agrego la url del para la llamada ajax para obtener la ubicacion del dleivery.
		this.url = contextPath + Parametros.URL_DELIVERY;

		// Agrego la url para la llamada ajax para obtener calificar al viaje.
		this.urlCalificar = contextPath + Parametros.URL_CALIFICAR;

		// Agrego los colores de los markadores.
		this.coloresMarkadores = new ArrayList<>();

		Arrays.asList(Parametros.COLORES_MARKADORES).forEach((k) -> {
			String color = Parametros.UBICACION_MARKADORES + k + Parametros.EXTENSION_MARKADORES;
			this.coloresMarkadores.add(color);
		});

		// Agrego la ubicacion de la moto.
		this.moto = Parametros.UBICACION_MOTO;

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
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getColoresMarkadores() {
		return coloresMarkadores;
	}

	public void setColoresMarkadores(List<String> coloresMarkadores) {
		this.coloresMarkadores = coloresMarkadores;
	}

	public String getMoto() {
		return moto;
	}

	public void setMoto(String moto) {
		this.moto = moto;
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
			Logger.getLogger(OpcionesJavascriptViaje.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}
}
