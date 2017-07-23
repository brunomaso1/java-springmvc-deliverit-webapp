package clases.deliverys;

import clases.dominio.Delivery;

/**
 *
 * @author bruno
 */
public class DeliverysControllerHelper {

	public String getDatosTablaDeliveryHTML(Delivery[] deliverys) {
		String tabla = "";

		String[][] deliverysParseados = parsearDeliverys(deliverys);

		tabla += "<thead>";
		tabla += "<tr>";
		tabla += "<th>" + "Id" + "</th>";	// Id delivery.
		tabla += "<th>" + "Nombre" + "</th>";	// Nombre delivery.
		tabla += "<th>" + "Telefono" + "</th>";	// Telefono delivery.
		tabla += "<th>" + "Vehiculo" + "</th>";	// Vehiculo delivery.
		tabla += "<th>" + "Calificacion" + "</th>";	// Calificacion delivery.
		tabla += "</tr>";
		tabla += "</thead>";

		if (deliverysParseados != null) {
			//Crea los items.
			for (String[] deliveryParseado : deliverysParseados) {
				String calificacionDeliveryAux = "<div class=\"starrr stars-existing\" data-rating='" + deliveryParseado[4] + "'></div>";
				String calificacionDelivery = (deliveryParseado[4].equals("No especifica"))? deliveryParseado[4] : calificacionDeliveryAux;
				tabla += "<tr>";
				tabla += "<td>" + deliveryParseado[0] + "</td>";	// Id delivery.
				tabla += "<td>" + deliveryParseado[1] + "</td>";	// Nombre delivery.
				tabla += "<td>" + deliveryParseado[2] + "</td>";	// Telefono delivery.
				tabla += "<td>" + deliveryParseado[3] + "</td>";	// Vehiculo delivery.
				tabla += "<td>" + calificacionDelivery + "</td>";	// Calificacion delivery.
				tabla += "</tr>";
			}
		}
		return tabla;
	}

	private String[][] parsearDeliverys(Delivery[] deliverys) {
		if ((deliverys != null) && (deliverys.length != 0)) {
			String[][] parser = new String[deliverys.length][5];
			for (int i = 0; i < deliverys.length; i++) {
				parser[i][0] = deliverys[i].getId().toString();
				parser[i][1] = deliverys[i].getUsuario().getNombre() == null ? "No especifica" : deliverys[i].getNombre();
				parser[i][2] = deliverys[i].getUsuario().getTelefono()  == null ? "No especifica" : deliverys[i].getUsuario().getTelefono();
				parser[i][3] = deliverys[i].getVehiculo()  == null ? "No especifica" : deliverys[i].getVehiculo().getDescripcion();
				parser[i][4] = deliverys[i].getCalificacion()  == null ? "No especifica" : deliverys[i].getCalificacion().toString();
			}
			return parser;
		}
		return null;
	}
}
