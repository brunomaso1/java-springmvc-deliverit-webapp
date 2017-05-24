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
			String[][] parser = new String[viajes.length][5];
			for (int i = 0; i < viajes.length; i++) {
//				parser[i][0] = viajes[i].getId().toString();
//				parser[i][1] = viajes[i].get;
//				parser[i][0] = viaje[i].getViaje() == null ? "Viaje no encontrado" : pedidos[i].getViaje().getId().toString();
//				parser[i][1] = pedidos[i].getCliente() == null ? "Cliente no encontrado" : pedidos[i].getCliente().getNombre();
//				parser[i][2] = pedidos[i].getCliente() == null ? "Cliente no encontrado"
//						: pedidos[i].getCliente().getDireccion() == null ? "Direcccion no encontrada"
//						: pedidos[i].getCliente().getDireccion().getCalle() + " "
//						+ pedidos[i].getCliente().getDireccion().getNroPuerta();
//				parser[i][3] = pedidos[i].getViaje().getDelivery() == null
//						? "No asignado" : pedidos[i].getViaje().getDelivery().getUsuario().getNombre();
//				parser[i][4] = pedidos[i].getCliente() == null ? "Cliente no encontrado"
//						: pedidos[i].getCliente().getTelefono() == null ? "Telefono no encontrado" : pedidos[i].getCliente().getTelefono();
			}
			return parser;
		}
		return null;
	}	
}
