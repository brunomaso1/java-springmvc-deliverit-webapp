/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.historialViaje;

import clases.dominio.Viaje;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
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
public class HistorialViajeControllerHelper {

	private HistorialViajeLogica hvl;

	public HistorialViajeControllerHelper() {
		this.hvl = new HistorialViajeLogica();
	}

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

	public String tablaHistorialViajeHtml(Viaje[] viajes) {
		String tabla = "";

		String[][] viajesParseados = parsearViajes(viajes);

		if (viajesParseados != null) {
			//Crea los items.
			for (String[] viajeParseado : viajesParseados) {
				tabla += "<tr>";
				for (String string : viajeParseado) {
					tabla += "<td>" + string + "</td>";
				}
				tabla += "</tr>";
			}
		}
		return tabla;
	}

	private String[][] parsearViajes(Viaje[] viajes) {
		if ((viajes != null) && (viajes.length != 0)) {
			String[][] parser = new String[viajes.length][9];
			for (int i = 0; i < viajes.length; i++) {
				parser[i][0] = viajes[i].getId().toString();
				parser[i][1] = viajes[i].getDelivery() == null ? "No asignado" : viajes[i].getDelivery().getUsuario().getNombre();
				parser[i][2] = viajes[i].getDelivery() == null ? "No asignado" : viajes[i].getDelivery().getUsuario().getTelefono();
				parser[i][3] = viajes[i].getDelivery() == null ? "No asignado" : viajes[i].getDelivery().getCalificacion().toString();
				parser[i][4] = viajes[i].getCalificacion() == null ? "Sin calificacion" : viajes[i].getCalificacion().toString();
				parser[i][5] = viajes[i].getEstado().getDescripcion();
				parser[i][6] = viajes[i].getFecha().toString();
				parser[i][7] = Short.toString(viajes[i].getPrecio());
				parser[i][8] = obtenerCantidadPedidos(viajes[i].getId().toString());
			}
			return parser;
		}
		return null;
	}

	private String obtenerCantidadPedidos(String viajeId) {
		return hvl.contarPedidosViaje(viajeId);
	}

	public String chartHistorialViajeDona(Viaje[] viajes) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<JsonObjectDonut> jsonObjectDonutList = new ArrayList<>();
		int cantEstadoPendiente = 0;
		int cantEstadoPublicado = 0;
		int cantEstadoEnProceso = 0;
		int cantEstadoTerminado = 0;

		for (Viaje viaje : viajes) {
			switch (viaje.getEstado().getId()) {
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
			Logger.getLogger(HistorialViajeControllerHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}

	/**
	* Logica: Inserto los string como "yyyymm" para agruparlos por año y mes.
	* Si la clave existe, sumo uno, sino agrego la clave con una ocurrencia.
	*/
	public String chartHistorialViajeLinea(Viaje[] viajes) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Integer> orderedMap = new TreeMap<>(
		    (Comparator<String>) (o1, o2) -> o2.compareTo(o1)
		);
		
		// Test
		orderedMap.put("2017-01", 0);
		orderedMap.put("2017-02", 0);
		orderedMap.put("2017-03", 0);
		orderedMap.put("2017-04", 0);
		orderedMap.put("2017-05", 0);

		for (Viaje viaje : viajes) {
			if (viaje.getEstado().getId() == 4) {
				// Parseo la fecha en el formato "yyyymm".
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(viaje.getFecha());
				String fechaParseada = String.valueOf(calendar.get(Calendar.YEAR)) + "-" + String.valueOf(calendar.get(Calendar.MONTH) + 1);
				// Chequeo si el valor está en la lista, lo agrego, sino agrego un nuevo elemento en la lista.
				if (orderedMap.containsKey(fechaParseada))
					orderedMap.replace(fechaParseada, orderedMap.get(fechaParseada) + 1);
				else
					orderedMap.put(fechaParseada, 1);
			}
		}
		
		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(parsearLineMapToJson(orderedMap));
		} catch (JsonProcessingException ex) {
			Logger.getLogger(HistorialViajeControllerHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}

	public String chartHistorialViajeBarras(Viaje[] viajes) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Integer> orderedMap = new TreeMap<String, Integer>(
		    (Comparator<String>) (o1, o2) -> o2.compareTo(o1)
		);
		
		orderedMap.put("2017-01", 0);
		orderedMap.put("2017-02", 0);
		orderedMap.put("2017-03", 0);
		orderedMap.put("2017-04", 0);
		orderedMap.put("2017-05", 0);

		for (Viaje viaje : viajes) {
			if (viaje.getEstado().getId() == 4) {
				// Parseo la fecha en el formato "yyyymm".
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(viaje.getFecha());
				String fechaParseada = String.valueOf(calendar.get(Calendar.YEAR)) + "-" + String.valueOf(calendar.get(Calendar.MONTH) + 1);
				// Chequeo si el valor está en la lista, lo agrego, sino agrego un nuevo elemento en la lista.
				if (orderedMap.containsKey(fechaParseada))
					orderedMap.replace(fechaParseada, orderedMap.get(fechaParseada) + viaje.getPrecio());
				else
					orderedMap.put(fechaParseada, (int)viaje.getPrecio());
			}
		}
		
		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(parsearBaraMapToJson(orderedMap));
		} catch (JsonProcessingException ex) {
			Logger.getLogger(HistorialViajeControllerHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}

	private List<JsonObjectLine> parsearLineMapToJson (Map<String, Integer> map) {
		List<JsonObjectLine> jsonObjectLineList = new ArrayList<>();
		// Agrego a la lista objetos del tipo JsonObjcetLine con clave y valor.
		map.forEach((k, v) -> jsonObjectLineList.add(new JsonObjectLine(k, v)));
		return jsonObjectLineList;
	}

	private List<JsonObjectBars> parsearBaraMapToJson (Map<String, Integer> map) {
		List<JsonObjectBars> jsonObjectBarsList = new ArrayList<>();
		// Agrego a la lista objetos del tipo JsonObjcetLine con clave y valor.
		map.forEach((k, v) -> jsonObjectBarsList.add(new JsonObjectBars(k, v)));
		return jsonObjectBarsList;
	}
}