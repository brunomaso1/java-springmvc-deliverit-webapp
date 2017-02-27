/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.viaje;

import clases.dominio.Pedido;
import java.util.ArrayList;

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
	 * @param pedidos Arreglo conteniendo los pedidos a colocar en la tabla principal.
	 * @return String Una cadena conteniendo los items.
	 */
	public String tablaPrincipalHtml(Pedido[] pedidos) {
		String tabla = "";

		String[][] pedidosParseados = parsearPedidos(pedidos);

		if (pedidosParseados != null) {
			//Crea los items.
			for (String[] pedidosParseado : pedidosParseados) {
				tabla += "<tr>";
				for (String string : pedidosParseado) {
					tabla += "<td>" + string + "</td>";
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
						+ pedido.getCliente().getDireccion().getNroPuerta() + "</td>";
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
		if (pedidos != null) {
			String[][] parser = new String[pedidos.length][5];
			for (int i = 0; i < pedidos.length; i++) {
				parser[i][0] = pedidos[i].getViaje() == null ? "Viaje no encontrado" : pedidos[i].getViaje().getId().toString();
				parser[i][1] = pedidos[i].getCliente() == null ? "Cliente no encontrado" : pedidos[i].getCliente().getNombre();
				parser[i][2] = pedidos[i].getCliente() == null ? "Cliente no encontrado"
						: pedidos[i].getCliente().getDireccion() == null ? "Direcccion no encontrada"
						: pedidos[i].getCliente().getDireccion().getCalle() + " "
						+ pedidos[i].getCliente().getDireccion().getNroPuerta();
				parser[i][3] = pedidos[i].getViaje().getDelivery() == null
						? "No asignado" : pedidos[i].getViaje().getDelivery().getUsuario().getNombre();
				parser[i][4] = pedidos[i].getCliente() == null ? "Cliente no encontrado"
						: pedidos[i].getCliente().getTelefono() == null ? "Telefono no encontrado" : pedidos[i].getCliente().getTelefono();
			}
			return parser;
		}
		return null;
	}
}
