/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.historialPedidos;

import clases.dominio.Pedido;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class HistorialPedidosControllerHelper {

	private class JsonObjectDonut {

		private String estado;
		private String pedidos;

		private JsonObjectDonut(String estado, String pedidos) {
			this.estado = pedidos;
			this.estado = pedidos;
		}
	}

	private class JsonObjectLine {

		private String anioMes;
		private String pedidos;

		private JsonObjectLine(String anioMes, String pedidos) {
			this.anioMes = anioMes;
			this.pedidos = pedidos;
		}
	}

	private class JsonObjectBars {

		private String anioMes;
		private String ganancia;

		private JsonObjectBars(String anioMes, String ganancia) {
			this.anioMes = anioMes;
			this.ganancia = ganancia;
		}
	}

	public String tablaHistorialPedidosHtml(Pedido[] pedidos) {
		String tabla = "";

		String[][] pedidosParseados = parsearPedidos(pedidos);

		if (pedidosParseados != null) {
			//Crea los items.
			for (String[] pedidoParseado : pedidosParseados) {
				tabla += "<tr>";
				for (String string : pedidoParseado) {
					tabla += "<td>" + string + "</td>";
				}
				tabla += "</tr>";
			}
		}
		return tabla;
	}

	private String[][] parsearPedidos(Pedido[] pedidos) {
		if ((pedidos != null) && (pedidos.length != 0)) {
			String[][] parser = new String[pedidos.length][9];
			for (int i = 0; i < pedidos.length; i++) {
				parser[i][0] = pedidos[i].getId().toString();
				parser[i][1] = pedidos[i].getFormaPago() == null ? "No se especifica" : pedidos[i].getFormaPago();
				parser[i][2] = pedidos[i].getCliente() == null ? "No se especifica" : pedidos[i].getCliente().getNombre();
				parser[i][3] = pedidos[i].getCliente() == null ? "No se especifica"
						: pedidos[i].getCliente().getDireccion() == null ? "No se especifica" : pedidos[i].getCliente().getDireccion().getCalle() + " "
						+ pedidos[i].getCliente().getDireccion().getNroPuerta() + pedidos[i].getCliente().getDireccion().getApartamento() == null ? "" : "/"
						+ pedidos[i].getCliente().getDireccion().getApartamento();
				parser[i][4] = pedidos[i].getCliente().getTelefono() == null ? "Sin telefono" : pedidos[i].getCliente().getTelefono();
				parser[i][5] = pedidos[i].getViaje() == null ? "No se especifica" : pedidos[i].getViaje().getDelivery() == null ? "No se especifica"
						: pedidos[i].getViaje().getDelivery().getUsuario().getNombre();
				parser[i][6] = pedidos[i].getViaje().getDelivery().getUsuario().getTelefono();
				parser[i][7] = pedidos[i].getViaje().getEstado().getDescripcion();
				parser[i][8] = pedidos[i].getViaje().getId().toString();
			}
			return parser;
		}
		return null;
	}

	public String chartHistorialPedidosDona(Pedido[] pedidos) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<JsonObjectDonut> jsonObjectDonutList = new ArrayList<>();
		int cantEstadoPendiente = 0;
		int cantEstadoPublicado = 0;
		int cantEstadoEnProceso = 0;
		int cantEstadoTerminado = 0;

		for (Pedido pedido : pedidos) {
			switch (pedido.getViaje().getEstado().getId()) {
				case 1:
					cantEstadoPendiente++;
					break;
				case 2:
					cantEstadoPublicado++;
					break;
				case 3:
					cantEstadoEnProceso++;
					break;
				case 4:
					cantEstadoTerminado++;
					break;
			}
		}

		jsonObjectDonutList.add(new JsonObjectDonut("pendientes", Integer.toString(cantEstadoPendiente)));
		jsonObjectDonutList.add(new JsonObjectDonut("publicados", Integer.toString(cantEstadoPublicado)));
		jsonObjectDonutList.add(new JsonObjectDonut("enProceso", Integer.toString(cantEstadoEnProceso)));
		jsonObjectDonutList.add(new JsonObjectDonut("terminados", Integer.toString(cantEstadoTerminado)));
		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(jsonObjectDonutList);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(HistorialPedidosControllerHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}

	// Falta implementar
	public String chartHistorialPedidosLinea(Pedido[] pedidos) {
		/*Pedido[] pedidosOrdenados = ordenarPedidos(pedidos);

		JSONObject jsonObject = JSONObject.fromObject(jsonObjectLineList);
		return jsonObject.toString();*/
		return "";
	}

	// Falta implementar
	public String chartHistorialPedidosBarras(Pedido[] pedidos) {

		/*JSONObject jsonObject = JSONObject.fromObject(jsonObjectBarsList);
		return jsonObject.toString();*/
		return "";

	}

	private Pedido[] ordenarPedidos(Pedido[] pedidos) {
//		Collections.sort(pedidos, new Comparator<Pedido>() {
//		  	public int compare(Pedido o1, Pedido o2) {
//		      	if (o1.getViaje().getFecha() == null || o2.getViaje().getFecha() == null)
//		       		return 0;
//		     	return o1.getViaje().getFecha().compareTo(o2.getViaje().getFecha());
//		  	}
//		});
		return pedidos;
	}
}