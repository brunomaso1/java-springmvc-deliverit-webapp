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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class ObjAux {

	private boolean cambios;
	private ViajeControllerHelper vch = new ViajeControllerHelper();
	private String tablaPedidos;
	private Pedido[] pedidosJSON;

	public ObjAux() {
		this.cambios = false;
	}

	public ObjAux(Pedido[] pedidos, String estadoId) {
		this.cambios = true;
		this.tablaPedidos = vch.getDatosTablaViajeHTML(pedidos, estadoId);
		this.pedidosJSON = pedidos;
	}

	public Pedido[] getPedidosJSON() {
		return pedidosJSON;
	}

	public void setPedidosJSON(Pedido[] pedidosJSON) {
		this.pedidosJSON = pedidosJSON;
	}

	public String getTablaPedidos() {
		return tablaPedidos;
	}

	public void setTablaPedidos(String tablaPedidos) {
		this.tablaPedidos = tablaPedidos;
	}

	public boolean isCambios() {
		return cambios;
	}

	public void setCambios(boolean cambios) {
		this.cambios = cambios;
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
