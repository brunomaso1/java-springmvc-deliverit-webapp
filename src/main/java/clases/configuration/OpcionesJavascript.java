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
	private String urlCalificar;
	private List<String> coloresMarkadores;
	private String moto;
	private int defZoomMap;
	private Map<Object, Object> dataTableOptions;
	private double defLat;
	private double defLon;
	private String estadoIdActual;

	public OpcionesJavascript() {
		this.coloresMarkadores = new ArrayList<>();
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

	public String getUrlCalificar() {
		return urlCalificar;
	}

	public void setUrlCalificar(String urlCalificar) {
		this.urlCalificar = urlCalificar;
	}
}
