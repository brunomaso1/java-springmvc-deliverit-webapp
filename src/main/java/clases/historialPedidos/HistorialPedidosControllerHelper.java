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

	public class JsonObjectDonut {
		private String label;
		private String value;

		public JsonObjectDonut(String label, String value) {
			this.label = label;
			this.value = value;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	public class JsonObjectLine {

		private String anioMes;
		private String viajes;

		public JsonObjectLine(String anioMes, String viajes) {
			this.anioMes = anioMes;
			this.viajes = viajes;
		}

		public String getAnioMes() {
			return anioMes;
		}

		public void setAnioMes(String anioMes) {
			this.anioMes = anioMes;
		}

		public String getViajes() {
			return viajes;
		}

		public void setViajes(String viajes) {
			this.viajes = viajes;
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

		jsonObjectDonutList.add(new JsonObjectDonut("Pendientes", Integer.toString(cantEstadoPendiente)));
		jsonObjectDonutList.add(new JsonObjectDonut("Publicados", Integer.toString(cantEstadoPublicado)));
		jsonObjectDonutList.add(new JsonObjectDonut("En Proceso", Integer.toString(cantEstadoEnProceso)));
		jsonObjectDonutList.add(new JsonObjectDonut("Terminados", Integer.toString(cantEstadoTerminado)));
		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(jsonObjectDonutList);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(HistorialPedidosControllerHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}

	public String chartHistorialViajeLinea(Pedido[] pedidos) {
		Map<String, Integer> orderedMap = new TreeMap<String, Integer>(
		    (Comparator<String>) (o1, o2) -> o2.compareTo(o1)
		);

		for (Pedido pedido : pedidos) {
			if (pedido.getViaje().getEstado().getId() == 4) {
				// Parseo la fecha en el formato "yyyymm".
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(pedido.getViaje().getFecha());
				String fechaParseada = String.valueOf(calendar.YEAR) + String.valueOf(calendar.MONTH);
				// Chequeo si el valor está en la lista, lo agrego, sino agrego un nuevo elemento en la lista.
				if (orderedMap.containsKey(fechaParseada))
					orderedMap.replace(fechaParseada, orderedMap.get(fechaParseada)++);
				else
					orderedMap.put(fechaParseada, 1);
			}
		}

		JSONObject jsonObject = JSONObject.fromObject(parsearLineMapToJson(orderedMap));
		return jsonObject.toString();
	}

	public String chartHistorialViajeBarras(Pedido[] pedidos) {
		Map<String, Integer> orderedMap = new TreeMap<String, Integer>(
		    (Comparator<String>) (o1, o2) -> o2.compareTo(o1)
		);

		for (Pedido pedido : pedidos) {
			if (pedido.getViaje().getEstado().getId() == 4) {
				// Parseo la fecha en el formato "yyyymm".
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(pedido.getViaje().getFecha());
				String fechaParseada = String.valueOf(calendar.YEAR) + String.valueOf(calendar.MONTH);
				// Chequeo si el valor está en la lista, lo agrego, sino agrego un nuevo elemento en la lista.
				if (orderedMap.containsKey(fechaParseada))
					orderedMap.replace(fechaParseada, orderedMap.get(fechaParseada) + pedido.getViaje().getPrecio());
				else
					orderedMap.put(fechaParseada, pedido.getViaje().getPrecio());
			}
		}

		JSONObject jsonObject = JSONObject.fromObject(parsearBaraMapToJson(orderedMap));
		return jsonObject.toString();
	}

	private List<JsonObjectLine> parsearLineMapToJson (Map<String, Integer> map) {
		List<JsonObjectLine> jsonObjectLineList = new ArrayList<>();
		// Agrego a la lista objetos del tipo JsonObjcetLine con clave y valor.
		map.foreach((k, v) -> jsonObjectLineList.add(new JsonObjectLine(k, v)));
		return jsonObjectLineList;
	}

	private List<JsonObjectLine> parsearBaraMapToJson (Map<String, Integer> map) {
		List<JsonObjectBars> jsonObjectBarsList = new ArrayList<>();
		// Agrego a la lista objetos del tipo JsonObjcetLine con clave y valor.
		map.foreach((k, v) -> jsonObjectBarsList.add(new JsonObjectLine(k, v)));
		return jsonObjectBarsList;
	}
}