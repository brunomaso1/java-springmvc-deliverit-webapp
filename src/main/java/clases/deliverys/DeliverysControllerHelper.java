/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.deliverys;

import clases.dominio.Viaje;

/**
 *
 * @author bruno
 */
public class DeliverysControllerHelper {

	public String tablaDeliverysHtml(Delivery[] deliverys) {
		String tabla = "";

		String[][] deliverysParseados = parsearDeliverys(deliverys);

		if (deliverysParseados != null) {
			//Crea los items.
			for (String[] deliveryParseado : deliverysParseados) {
				tabla += "<tr>";
				for (String string : deliveryParseado) {
					tabla += "<td>" + string + "</td>";
				}
				tabla += "</tr>";
			}
		}
		return tabla;
	}

	private String[][] parsearDeliverys(Delivery[] deliverys) {
		if (deliverys != null) {
			String[][] parser = new String[deliverys.length][5];
			for (int i = 0; i < deliverys.length; i++) {
				parser[i][0] = deliverys[i].getId().toString();
				parser[i][1] = deliverys[i].getNombre() == null ? "No especifica" : deliverys[i].getNombre().toString();
				parser[i][2] = deliverys[i].getTelefono()  == null ? "No especifica" : deliverys[i].getTelefono().toString();
				parser[i][3] = deliverys[i].getVehiculo()  == null ? "No especifica" : deliverys[i].getVehiculo().toString();
				parser[i][4] = deliverys[i].getCalificacion()  == null ? "No especifica" : deliverys[i].getCalificacion().toString();
			}
			return parser;
		}
		return null;
	}
}
