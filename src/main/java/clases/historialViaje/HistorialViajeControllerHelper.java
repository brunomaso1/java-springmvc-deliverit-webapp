/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.historialViaje;

import clases.dominio.Viaje;

/**
 *
 * @author bruno
 */
public class HistorialViajeControllerHelper {

	private class JsonObjectDonut {
		private String estado;
		private String viajes;

		private JsonObjectDonut(String estado, String viajes) {
			this.estado = viajes;
			this.estado = viajes;
		}
	}

	private class JsonObjectLine {
		private String anioMes;
		private String viajes;

		private JsonObjectLine(String anioMes, String viajes) {
			this.anioMes = anioMes;
			this.viajes = viajes;
		}
	}

	private class JsonObjectBars {
		private String anioMes;
		private String ganancia;

		private JsonObjectBars(String anioMes, String ganancia) {
			this.anioMes = anioMes;
			this.gannacia = ganancia;
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
		if (viajes != null) {
			String[][] parser = new String[viajes.length][9];
			for (int i = 0; i < viajes.length; i++) {
				parser[i][0] = viajes[i].getId().toString();
				parser[i][1] = viajes[i].getDelivery() == null ? "No asignado" : viajes[i].getDelivery().getUsuario().getNombre();
				parser[i][2] = viajes[i].getDelivery() == null ? "No asignado" : viajes[i].getDelivery().getUsuario().getTelefono();
				parser[i][3] = viajes[i].getDelivery() == null ? "No asignado" : viajes[i].getDelivery().getCalificacion();
				parser[i][4] = viajes[i].getCalificacion() == null ? "Sin calificacion" : viajes[i].getCalificacion();
				parser[i][5] = viajes[i].getEstado().getDescripcion();
				parser[i][6] = viajes[i].getFecha();
				parser[i][7] = viajes[i].getPrecio();
				parser[i][8] = obtenerCantidadPedidos(viajes[i]);
			}
			return parser;
		}
		return null;
	}

	// Puede haber un tema aca.
	private String obtenerCantidadPedidos(Viaje viaje){
		return viaje.pedidos.size();
	}

	public String chartHistorialViajeDona(Viaje[] viajes){
		ArrayList<JsonObjectDonut> jsonObjectDonutList = new ArrayList<>();
		int cantEstadoPendiente = 0;
		int cantEstadoPublicado = 0;
		int cantEstadoEnProceso = 0;
		int cantEstadoTerminado = 0;

		for (viaje : viajes) {
			switch (viaje.getEstado().getId()) {
				case 1: 
					cantEstadoPendiente ++;
					break;
				case 2:
					cantEstadoPublicado ++;
					break;
				case 3:
					cantEstadoEnProceso ++;
					break;
				case 4:
					cantEstadoTerminado ++;
					break;					
			}	
		}

		jsonObjectDonutList.add(new jsonObjectDonut("pendientes", cantEstadoPendiente));
		jsonObjectDonutList.add(new jsonObjectDonut("publicados", cantEstadoPublicado));
		jsonObjectDonutList.add(new jsonObjectDonut("enProceso", cantEstadoEnProceso));
		jsonObjectDonutList.add(new jsonObjectDonut("terminados", cantEstadoTerminado));
		JSONObject jsonObject = JSONObject.fromObject(jsonObjectDonutList);
		return jsonObject.toString();
	}

	// Falta implementar
	public String chartHistorialViajeLinea(Viaje[] viajes){
		/*Viaje[] viajesOrdenados = ordenarViajes(viajes);

		JSONObject jsonObject = JSONObject.fromObject(jsonObjectLineList);
		return jsonObject.toString();*/
		return "";		
	}

	// Falta implementar
	public String chartHistorialViajeBarras(Viaje[] viajes){
		
		/*JSONObject jsonObject = JSONObject.fromObject(jsonObjectBarsList);
		return jsonObject.toString();*/
		return "";
		
	}

	private Viaje[] ordenarViajes(Viaje[] viajes){
		Collections.sort(viajes, new Comparator<Viaje>() {
		  	public int compare(Viaje o1, Viaje o2) {
		      	if (o1.getFecha() == null || o2.getFecha() == null)
		       		return 0;
		     	return o1.getFecha().compareTo(o2.getFecha());
		  	}
		});
	}
}
