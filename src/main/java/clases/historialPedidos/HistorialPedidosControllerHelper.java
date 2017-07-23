/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.historialPedidos;

import clases.dominio.Pedido;
import clases.utils.HistorialUtils;
import clases.utils.JsonObjectDonut;
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
	
	private HistorialPedidosLogica hpl;

	public HistorialPedidosControllerHelper() {
		this.hpl = new HistorialPedidosLogica();
	}
	
	public String getDatosTablaHistPedidosHTML(Pedido[] pedidos) {
		String tabla = "";
		String[][] viajesParseados = parsearPedidos(pedidos);

		tabla += "<thead>";
		tabla += "<tr>";
		tabla += "<th>" + "Pedido" + "</th>";
		tabla += "<th>" + "Forma de Pago" + "</th>";
		tabla += "<th>" + "Cliente" + "</th>";
		tabla += "<th>" + "Direccion" + "</th>";
		tabla += "<th>" + "Telefono cliente" + "</th>";
		tabla += "<th>" + "Delivery" + "</th>";
		tabla += "<th>" + "Telefono Delivery" + "</th>";
		tabla += "<th>" + "Viaje" + "</th>";
		tabla += "<th>" + "Estado" + "</th>";
		tabla += "</tr>";
		tabla += "</thead>";

		tabla += "<tbody>";
		if (viajesParseados != null) {
			//Crea los items.
			for (String[] viajesParseado : viajesParseados) {
				tabla += "<tr>";
				tabla += "<td>" + viajesParseado[0] + "</td>";	// Id pedido.
				tabla += "<td>" + viajesParseado[1] + "</td>";	// Forma de Pago
				tabla += "<td>" + viajesParseado[2] + "</td>";	// Cliente.
				tabla += "<td>" + viajesParseado[3] + "</td>";	// Direccion.
				tabla += "<td>" + viajesParseado[4] + "</td>";	// Telefono cliente.
				tabla += "<td>" + viajesParseado[5] + "</td>";	// Delivery.
				tabla += "<td>" + viajesParseado[6] + "</td>";	// Telefono Delivery.
				tabla += "<td>" + viajesParseado[7] + "</td>";	// Viaje.
				tabla += "<td>" + viajesParseado[8] + "</td>";	// Estado.
				tabla += "</tr>";
			}
		}
		tabla += "</tbody>";
		return tabla;
	}

	private String[][] parsearPedidos(Pedido[] pedidos) {
		if ((pedidos != null) && (pedidos.length != 0)) {
			String[][] parser = new String[pedidos.length][9];
			for (int i = 0; i < pedidos.length; i++) {
				parser[i][0] = pedidos[i].getId().toString(); // Id pedido.
				parser[i][1] = pedidos[i].getFormaPago() == null ? "Ninguna." : pedidos[i].getFormaPago(); // Forma de pago.
				parser[i][2] = pedidos[i].getCliente() == null ? "Sin cliente" : pedidos[i].getCliente().getNombre(); // Cliente
				parser[i][3] = pedidos[i].getCliente() == null ? "Cliente no encontrado"
						: pedidos[i].getCliente().getDireccion() == null ? "Direcccion no encontrada"
						: pedidos[i].getCliente().getDireccion().getCalle() + " "
						+ pedidos[i].getCliente().getDireccion().getNroPuerta(); // Direccion.
				parser[i][4] = pedidos[i].getCliente() == null ? "Cliente no encontrado" : pedidos[i].getCliente().getTelefono(); // Telefono Cliente
				parser[i][5] = pedidos[i].getViaje().getDelivery() == null
						? "No asignado" : pedidos[i].getViaje().getDelivery().getNombre(); //Nombre delivery
				parser[i][6] = pedidos[i].getViaje().getDelivery() == null
						? "No asignado" : pedidos[i].getViaje().getDelivery().getUsuario().getTelefono(); // Telefono delivey
				parser[i][7] = pedidos[i].getViaje() == null ? "Viaje no encontrado" : pedidos[i].getViaje().getId().toString(); // Id viaje.
				parser[i][8] = pedidos[i].getViaje().getEstado().getDescripcion().toString(); // Estado
			}
			return parser;
		}
		return null;
	}

	public ArrayList chartHistorialPedidosDona(Pedido[] pedidos) {
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
		return jsonObjectDonutList;
	}

	/**
	* Logica: Inserto los string como "yyyymm" para agruparlos por año y mes.
	* Si la clave existe, sumo uno, sino agrego la clave con una ocurrencia.
	*/
	public ArrayList chartHistorialPedidosLinea(Pedido[] pedidos, Calendar fechaInicio, Calendar fechaFin) {
		HistorialUtils hu = new HistorialUtils();
		Map<String, Integer> orderedMap = new TreeMap<>(
		    (Comparator<String>) (o1, o2) -> o2.compareTo(o1)
		);

		for (Pedido pedido : pedidos) {
			// Parseo la fecha en el formato "yyyymm".
			Calendar fechaViaje = new GregorianCalendar();
			fechaViaje.setTime(pedido.getViaje().getFecha());
			if ((pedido.getViaje().getEstado().getId() == 4) && (hu.fechaDentroDeRango(fechaInicio, fechaFin, fechaViaje))) {
				String fechaParseada = hu.buildStringFecha(fechaViaje.get(Calendar.YEAR), fechaViaje.get(Calendar.MONTH));
				// Chequeo si el valor está en la lista, lo agrego, sino agrego un nuevo elemento en la lista.
				if (orderedMap.containsKey(fechaParseada))
					orderedMap.replace(fechaParseada, orderedMap.get(fechaParseada) + 1);
				else
					orderedMap.put(fechaParseada, 1);
			}
		}
		hu.agregarIntervalosFaltantes(fechaInicio, fechaFin, orderedMap);
		JsonObjectLineHistPedidos jolhv = new JsonObjectLineHistPedidos();
		return jolhv.mapToArrayList(orderedMap);
	}

	public ArrayList chartHistorialPedidosBarras(Pedido[] pedidos, Calendar fechaInicio, Calendar fechaFin) {
		HistorialUtils hu = new HistorialUtils();
		Map<String, Integer> orderedMap = new TreeMap<>(
		    (Comparator<String>) (o1, o2) -> o2.compareTo(o1)
		);

		for (Pedido pedido : pedidos) {
			// Parseo la fecha en el formato "yyyymm".
			Calendar fechaViaje = new GregorianCalendar();
			fechaViaje.setTime(pedido.getViaje().getFecha());
			if ((pedido.getViaje().getEstado().getId() == 4) && (hu.fechaDentroDeRango(fechaInicio, fechaFin, fechaViaje))) {
				String fechaParseada = hu.buildStringFecha(fechaViaje.get(Calendar.YEAR), fechaViaje.get(Calendar.MONTH));
				// Chequeo si el valor está en la lista, lo agrego, sino agrego un nuevo elemento en la lista.
				if (orderedMap.containsKey(fechaParseada))
					orderedMap.replace(fechaParseada, orderedMap.get(fechaParseada) + pedido.getViaje().getPrecio());
				else
					orderedMap.put(fechaParseada, (int)pedido.getViaje().getPrecio());
			}
		}

		hu.agregarIntervalosFaltantes(fechaInicio, fechaFin, orderedMap);
		JsonObjectBarsHistPedidos jobhv = new JsonObjectBarsHistPedidos();
		return jobhv.mapToJSON(orderedMap);
	}
}