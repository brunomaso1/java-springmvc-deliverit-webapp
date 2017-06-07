/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bruno
 */
public class OpcionesJavascript {

	private String url;
	private List<String> coloresMarkadores;
	private String moto;
	private int defZoomMap;
	private Map<Object, Object> dataTableOptions;
	private double defLat;
	private double defLon;
	private String estadoIdActual;
	private String nombreTablaPrincipal;

	public OpcionesJavascript(String contextPath, String estadoId) {

		// Agrego la url del para la llamada ajax para obtener la ubicacion del dleivery.
		this.url = contextPath + Parametros.URL_DELIVERY;

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
		this.dataTableOptions = Parametros.OPCIONES;

		// Agrego la latitud y longitud por defecto.
		this.defLat = Parametros.DEFAULT_LATITUDE;
		this.defLon = Parametros.DEFAULT_LONGITUDE;

		// Agrego el estado actual.
		this.estadoIdActual = estadoId;

		// Agrego el nombre de la tabla principal.
		this.nombreTablaPrincipal = Parametros.NOMBRE_TABLA_PRINCIPAL;
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

	public String getNombreTablaPrincipal() {
		return nombreTablaPrincipal;
	}

	public void setNombreTablaPrincipal(String nombreTablaPrincipal) {
		this.nombreTablaPrincipal = nombreTablaPrincipal;
	}

	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(this);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(ViajeControllerHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}
}