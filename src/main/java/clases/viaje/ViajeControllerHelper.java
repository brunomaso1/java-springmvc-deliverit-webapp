/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.viaje;

import clases.dominio.Pedido;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author bruno
 */
public class ViajeControllerHelper {

	/**
	 * Devuelve un String conteniendo los items de la tabla ubicada en la pagina
	 * del viaje. Estos items ya estan filtrados segun lo que esté en el
	 * parametro estado.
	 *
	 * @param pedidos Arreglo conteniendo los pedidos a colocar en la tabla
	 * principal.
	 * @return String Una cadena conteniendo los items.
	 */
	public String tablaPrincipalHtml(Pedido[] pedidos) {
		String tabla = "";

		String[][] pedidosParseados = parsearPedidos(pedidos);

		if (pedidosParseados != null) {
			//Crea los items.
			for (String[] pedidosParseado : pedidosParseados) {
				tabla += "<tr>";
				int i = 0; // Obtener fecha.
				for (String string : pedidosParseado) {
					// tabla += "<td>" + string + "</td>"; Obtener fecha
					if (i != 6) // Obtener fecha
						tabla += "<td>" + string + "</td>"; // Obtener fecha
					else // Obtener fecha
						tabla += "<td style=\"display:none;\">" + string + "</td>"; // Obtener fecha
					i++; // Obtener fecha
				}
				tabla += "</tr>";
			}
		}
		return tabla;
	}

	/**
	 * Realiza lo mismo que el método "tablaPrincipalHtml", solo que esta vez
	 * polula la tabla pedidos.
	 *
	 * @return String Cadena conteniendo los items de la tabla.
	 */
	public String tablaPedidosHtml(ArrayList<Pedido> pedidos) {
		String tabla = "";

		if (pedidos != null) {
			int i = 1;
			for (Pedido pedido : pedidos) {
				tabla += "<tr>";
				tabla += "<td>" + i + "</td>";
				tabla += "<td>" + pedido.getCliente().getNombre() + "</td>";
				tabla += "<td>" + pedido.getCliente().getDireccion().getCalle()
				         + " " + pedido.getCliente().getDireccion().getNroPuerta() + "</td>";
				tabla += "<td>" + pedido.getCliente().getTelefono() + "</td>";
				tabla += "</tr>";
				i++;
			}
		}
		return tabla;
	}

	/**
	 * Parsea un arreglo de entidades Pedidos acorde a los valores de la tabla
	 * principal.
	 *
	 * @param pedidos Es un arreglo de pedidos.
	 * @return String[][] Un arreglo multidimensional, en donde: La primera
	 * diemnsion contienen los pedidos y la segunda los datos de la tabla.
	 */
	private String[][] parsearPedidos(Pedido[] pedidos) {
		if ((pedidos != null) && (pedidos.length != 0)) {
			// String[][] parser = new String[pedidos.length][6]; // Obtener fecha.
			String[][] parser = new String[pedidos.length][7]; // Obtener fecha.
			for (int i = 0; i < pedidos.length; i++) {
				parser[i][0] = pedidos[i].getViaje() == null ? "Viaje no encontrado" : pedidos[i].getViaje().getId().toString();
				parser[i][1] = pedidos[i].getCliente() == null ? "Cliente no encontrado" : pedidos[i].getCliente().getNombre();
				parser[i][2] = pedidos[i].getCliente() == null ? "Cliente no encontrado" : pedidos[i].getCliente().getTelefono();
				parser[i][3] = pedidos[i].getCliente() == null ? "Cliente no encontrado"
				               : pedidos[i].getCliente().getDireccion() == null ? "Direcccion no encontrada"
				               : pedidos[i].getCliente().getDireccion().getCalle() + " "
				               + pedidos[i].getCliente().getDireccion().getNroPuerta();
				parser[i][4] = pedidos[i].getViaje().getDelivery() == null
				               ? "No asignado" : pedidos[i].getViaje().getDelivery().getUsuario().getNombre();
				parser[i][5] = pedidos[i].getViaje().getDelivery() == null
				               ? "No asignado" : pedidos[i].getViaje().getDelivery().getUsuario().getTelefono();
				parser[i][6] = pedidos[i].getViaje().getFecha() == null ? "Sin fecha" // Obtener fecha.
				               : obtenerHora(pedidos[i].getViaje().getFecha()); // Obtener fecha.
			}
			return parser;
		}
		return null;
	}

	public String getFiltroActual(String estadoId) {
		String retorno = "";
		switch (estadoId) {
		case "1":
			retorno = "pendientes";
			break;
		case "2":
			retorno = "publicados";
			break;
		case "3":
			retorno = "en proceso";
			break;
		case "4":
			retorno = "terminados";
			break;
		default:
			retorno = "sin filtrar";
		}
		return retorno;
	}

	public String obtenerHora(Timestamp timestamp){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(timestamp);
		return calendar.toString();
	}
}
