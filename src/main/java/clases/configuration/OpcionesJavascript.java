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
	private int zoomMap;
	private Map<Object, Object> dataTableOptions;

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

	public int getZoomMap() {
		return zoomMap;
	}

	public void setZoomMap(int zoomMap) {
		this.zoomMap = zoomMap;
	}

	public Map<Object, Object> getDataTableOptions() {
		return dataTableOptions;
	}

	public void setDataTableOptions(Map<Object, Object> dataTableOptions) {
		this.dataTableOptions = dataTableOptions;
	}
}
