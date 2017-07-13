/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.configuration;

import clases.dominio.Pedido;
import clases.viaje.ViajeControllerHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class ObjAux {

	private boolean cambios;
	private Map<Object, Object> pedidos;
	private String pedidosJSON;
	private ViajeControllerHelper vch = new ViajeControllerHelper();

	public ObjAux() {
		this.cambios = false;
		this.pedidos = null;
		this.pedidosJSON = null;
	}

	public ObjAux(Pedido[] pedidos, String pedidosJSON, String estadoId) {
		this.cambios = true;
		this.pedidosJSON = pedidosJSON;
		this.pedidos = new HashMap<>();
		this.pedidos.put("dataSet", generarLista(pedidos, estadoId));
	}

	public boolean isCambios() {
		return cambios;
	}

	public void setCambios(boolean cambios) {
		this.cambios = cambios;
	}

	public Map<Object, Object> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Map<Object, Object> pedidos) {
		this.pedidos = pedidos;
	}

	public String getPedidosJSON() {
		return pedidosJSON;
	}

	public void setPedidosJSON(String pedidosJSON) {
		this.pedidosJSON = pedidosJSON;
	}

	private List<String> generarLista(Pedido[] pedidos, String estadoId) {
		ArrayList<String> listaPedidos = new ArrayList<>();
		String[][] pedidosParseados = vch.parsearPedidos(pedidos);
		switch (estadoId) {
			case "1":
				listaPedidos = vch.generateDatosTablaViajeAjaxEstPend(pedidosParseados);
				break;
			case "2":
				listaPedidos = vch.generateTablaViajeAjaxEstPub(pedidosParseados);
				break;
			case "3":
				listaPedidos = vch.generateDataTablaViajeAjaxEstPro(pedidosParseados);
				break;
			case "4":
				listaPedidos = vch.generateDataTablaViajeAjaxEstTer(pedidosParseados);
				break;
			default:
				throw new AssertionError();
		}
		return listaPedidos;
	}

	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(this);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(ObjAux.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}
}
