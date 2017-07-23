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
public class OpcionesJavascriptViajeNuevo {

	private List<String> coloresMarkadores;
	private Map<Object, Object> mensajes;
	private Map<Object, Object> iconSize;
	private Map<Object, Object> labelOrigin;

	public OpcionesJavascriptViajeNuevo() {

		// Agrego los colores de los markadores.
		this.coloresMarkadores = new ArrayList<>();

		Arrays.asList(Parametros.COLORES_MARKADORES).forEach((k) -> {
			String color = Parametros.UBICACION_MARKADORES + k + Parametros.EXTENSION_MARKADORES;
			this.coloresMarkadores.add(color);
		});

		// Agrego los mensajes.
		this.mensajes = Parametros.MENSAJES;

		// Tamaño de los iconos.
		this.iconSize = Parametros.ICONSIZE;

		// Agrego la ubicacion de origen de las etiquetas de los iconos.
		this.labelOrigin = Parametros.LABELORIGIN;
	}
	
	public List<String> getColoresMarkadores() {
		return coloresMarkadores;
	}

	public void setColoresMarkadores(List<String> coloresMarkadores) {
		this.coloresMarkadores = coloresMarkadores;
	}

	public Map<Object, Object> getMensajes() {
		return mensajes;
	}

	public void setMensajes(Map<Object, Object> mensajes) {
		this.mensajes = mensajes;
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

	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(this);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(OpcionesJavascriptViajeNuevo.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}
}
