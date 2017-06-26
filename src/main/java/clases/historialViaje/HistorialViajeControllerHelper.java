/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.historialViaje;

import clases.dominio.Viaje;
import clases.utils.HistorialUtils;
import clases.utils.JsonObjectDonut;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
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

	public String getDatosTablaHistViajeHTML(Viaje[] viajes) {
		String tabla = "";
		String[][] viajesParseados = parsearViajes(viajes);

		tabla += "<thead>";
		tabla += "<tr>";
		tabla += "<th>" + "Viaje" + "</th>";
		tabla += "<th>" + "Delivery" + "</th>";
		tabla += "<th>" + "Telefono Delivery" + "</th>";
		tabla += "<th>" + "Calificacion Delivery" + "</th>";
		tabla += "<th>" + "Calificacion Viaje" + "</th>";
		tabla += "<th>" + "Estado" + "</th>";
		tabla += "<th>" + "Fecha" + "</th>";
		tabla += "<th>" + "Precio" + "</th>";
		tabla += "<th>" + "Cantidad Pedidos" + "</th>";
		tabla += "</tr>";
		tabla += "</thead>";

		tabla += "<tbody>";
		if (viajesParseados != null) {
			//Crea los items.
			for (String[] viajesParseado : viajesParseados) {
				tabla += "<tr>";
				tabla += "<td>" + viajesParseado[0] + "</td>";	// Id viaje.
				tabla += "<td>" + viajesParseado[1] + "</td>";	// Nombre del delivery.
				tabla += "<td>" + viajesParseado[2] + "</td>";	// Telefono del delivery.
				tabla += "<td>" + viajesParseado[3] + "</td>";	// Calificacion del delivery.
				tabla += "<td>" + viajesParseado[4] + "</td>";	// Calificacion del viaje.
				tabla += "<td>" + viajesParseado[5] + "</td>";	// Estado del viaje.
				tabla += "<td>" + viajesParseado[6] + "</td>";	// Fecha del viaje.
				tabla += "<td>" + viajesParseado[7] + "</td>";	// Precio del viaje.
				tabla += "<td>" + viajesParseado[8] + "</td>";	// Cantidad de pedidos.
				tabla += "</tr>";
			}
		}
		tabla += "</tbody>";
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
	public String chartHistorialViajeLinea(Viaje[] viajes, Calendar fechaInicio, Calendar fechaFin) {
		ObjectMapper mapper = new ObjectMapper();
		HistorialUtils hu = new HistorialUtils();
		Map<String, Integer> orderedMap = new TreeMap<>(
		    (Comparator<String>) (o1, o2) -> o2.compareTo(o1)
		);

		for (Viaje viaje : viajes) {
			// Parseo la fecha en el formato "yyyymm".
			Calendar fechaViaje = new GregorianCalendar();
			fechaViaje.setTime(viaje.getFecha());
			if ((viaje.getEstado().getId() == 4) && (hu.fechaDentroDeRango(fechaInicio, fechaFin, fechaViaje))) {
				String fechaParseada = hu.buildStringFecha(fechaViaje.get(Calendar.YEAR), fechaViaje.get(Calendar.MONTH));
				// Chequeo si el valor está en la lista, lo agrego, sino agrego un nuevo elemento en la lista.
				if (orderedMap.containsKey(fechaParseada))
					orderedMap.replace(fechaParseada, orderedMap.get(fechaParseada) + 1);
				else
					orderedMap.put(fechaParseada, 1);
			}
		}

		hu.agregarIntervalosFaltantes(fechaInicio, fechaFin, orderedMap);

		String jsonObject = "";
		JsonObjectLineHistViaje jolhv = new JsonObjectLineHistViaje();
		try {
			jsonObject = mapper.writeValueAsString(jolhv.mapToJSON(orderedMap));
		} catch (JsonProcessingException ex) {
			Logger.getLogger(HistorialViajeControllerHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}

	public String chartHistorialViajeBarras(Viaje[] viajes, Calendar fechaInicio, Calendar fechaFin) {
		ObjectMapper mapper = new ObjectMapper();
		HistorialUtils hu = new HistorialUtils();
		Map<String, Integer> orderedMap = new TreeMap<>(
		    (Comparator<String>) (o1, o2) -> o2.compareTo(o1)
		);

		for (Viaje viaje : viajes) {
			// Parseo la fecha en el formato "yyyymm".
			Calendar fechaViaje = new GregorianCalendar();
			fechaViaje.setTime(viaje.getFecha());
			if ((viaje.getEstado().getId() == 4) && (hu.fechaDentroDeRango(fechaInicio, fechaFin, fechaViaje))) {
				String fechaParseada = hu.buildStringFecha(fechaViaje.get(Calendar.YEAR), fechaViaje.get(Calendar.MONTH));
				// Chequeo si el valor está en la lista, lo agrego, sino agrego un nuevo elemento en la lista.
				if (orderedMap.containsKey(fechaParseada))
					orderedMap.replace(fechaParseada, orderedMap.get(fechaParseada) + viaje.getPrecio());
				else
					orderedMap.put(fechaParseada, (int)viaje.getPrecio());
			}
		}

		hu.agregarIntervalosFaltantes(fechaInicio, fechaFin, orderedMap);

		String jsonObject = "";
		JsonObjectBarsHistViaje jobhv = new JsonObjectBarsHistViaje();
		try {
			jsonObject = mapper.writeValueAsString(jobhv.mapToJSON(orderedMap));
		} catch (JsonProcessingException ex) {
			Logger.getLogger(HistorialViajeControllerHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}

	private String obtenerCantidadPedidos(String viajeId) {
		return hvl.contarPedidosViaje(viajeId);
	}
}