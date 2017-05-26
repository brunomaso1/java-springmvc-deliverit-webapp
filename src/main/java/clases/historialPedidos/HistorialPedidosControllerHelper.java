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
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
		private Integer viajes;

		public JsonObjectLine(String anioMes, Integer viajes) {
			this.anioMes = anioMes;
			this.viajes = viajes;
		}

		public String getAnioMes() {
			return anioMes;
		}

		public void setAnioMes(String anioMes) {
			this.anioMes = anioMes;
		}

		public Integer getViajes() {
			return viajes;
		}

		public void setViajes(Integer viajes) {
			this.viajes = viajes;
		}
	}
	
	public class JsonObjectBars {

		private String anioMes;
		private Integer costo;

		public JsonObjectBars(String anioMes, Integer ganancia) {
			this.anioMes = anioMes;
			this.costo = ganancia;
		}

		public String getAnioMes() {
			return anioMes;
		}

		public void setAnioMes(String anioMes) {
			this.anioMes = anioMes;
		}

		public Integer getCosto() {
			return costo;
		}

		public void setCosto(Integer costo) {
			this.costo = costo;
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
				parser[i][3] = pedidos[i].getCliente() == null ? "Cliente no encontrado"
				               : pedidos[i].getCliente().getDireccion() == null ? "Direcccion no encontrada"
				               : pedidos[i].getCliente().getDireccion().getCalle() + " "
				               + pedidos[i].getCliente().getDireccion().getNroPuerta();
				parser[i][4] = pedidos[i].getCliente().getTelefono() == null ? "Sin telefono" : pedidos[i].getCliente().getTelefono();
				parser[i][5] = pedidos[i].getViaje() == null ? "No se especifica" : pedidos[i].getViaje().getDelivery() == null ? "No se especifica"
						: pedidos[i].getViaje().getDelivery().getUsuario().getNombre();
				parser[i][6] = pedidos[i].getViaje().getDelivery() == null ? "No asignado" : pedidos[i].getViaje().getDelivery().getUsuario().getTelefono();
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

	public String chartHistorialPedidosLinea(Pedido[] pedidos){
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Integer> orderedMap = new TreeMap<String, Integer>(
				(Comparator<String>) (o1, o2) -> o2.compareTo(o1)
		);

		for (Pedido pedido : pedidos) {
			if (pedido.getViaje().getEstado().getId() == 4) {
				// Parseo la fecha en el formato "yyyymm".
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(pedido.getViaje().getFecha());
				String fechaParseada = String.valueOf(calendar.get(Calendar.YEAR)) + "-" + String.valueOf(calendar.get(Calendar.MONTH) + 1);
				// Chequeo si el valor está en la lista, lo agrego, sino agrego un nuevo elemento en la lista.
				if (orderedMap.containsKey(fechaParseada)) {
					orderedMap.replace(fechaParseada, orderedMap.get(fechaParseada) + 1);
				} else {
					orderedMap.put(fechaParseada, 1);
				}
			}
		}

		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(parsearLineMapToJson(orderedMap));
		} catch (JsonProcessingException ex) {
			Logger.getLogger(HistorialPedidosControllerHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}

	public String chartHistorialPedidosBarras(Pedido[] pedidos) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Integer> orderedMap = new TreeMap<String, Integer>(
				(Comparator<String>) (o1, o2) -> o2.compareTo(o1)
		);

		for (Pedido pedido : pedidos) {
			if (pedido.getViaje().getEstado().getId() == 4) {
				// Parseo la fecha en el formato "yyyymm".
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(pedido.getViaje().getFecha());
				String fechaParseada = String.valueOf(calendar.get(Calendar.YEAR)) + "-" + String.valueOf(calendar.get(Calendar.MONTH) + 1);
				// Chequeo si el valor está en la lista, lo agrego, sino agrego un nuevo elemento en la lista.
				if (orderedMap.containsKey(fechaParseada)) {
					orderedMap.replace(fechaParseada, orderedMap.get(fechaParseada) + pedido.getViaje().getPrecio());
				} else {
					orderedMap.put(fechaParseada, (int) pedido.getViaje().getPrecio());
				}
			}
		}
		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(parsearBaraMapToJson(orderedMap));
		} catch (JsonProcessingException ex) {
			Logger.getLogger(HistorialPedidosControllerHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}

	private List<JsonObjectLine> parsearLineMapToJson(Map<String, Integer> map) {
		List<JsonObjectLine> jsonObjectLineList = new ArrayList<>();
		// Agrego a la lista objetos del tipo JsonObjcetLine con clave y valor.
		map.forEach((k, v) -> jsonObjectLineList.add(new JsonObjectLine(k, v)));
		return jsonObjectLineList;
	}

	private List<JsonObjectBars> parsearBaraMapToJson(Map<String, Integer> map) {
		List<JsonObjectBars> jsonObjectBarsList = new ArrayList<>();
		// Agrego a la lista objetos del tipo JsonObjcetLine con clave y valor.
		map.forEach((k, v) -> jsonObjectBarsList.add(new JsonObjectBars(k, v)));
		return jsonObjectBarsList;
	}
}
