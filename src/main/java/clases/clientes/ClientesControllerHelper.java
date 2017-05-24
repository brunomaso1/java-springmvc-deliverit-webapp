/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.clientes;

import clases.dominio.Viaje;

/**
 *
 * @author bruno
 */
public class ClientesControllerHelper {

	public String tablaClientesHtml(Cliente[] clientes) {
		String tabla = "";

		String[][] clientesParseados = parsearClientes(clientes);

		if (clientesParseados != null) {
			//Crea los items.
			for (String[] clienteParseado : clientesParseados) {
				tabla += "<tr>";
				for (String string : clienteParseado) {
					tabla += "<td>" + string + "</td>";
				}
				tabla += "</tr>";
			}
		}
		return tabla;
	}

	private String[][] parsearClientes(Cliente[] clientes) {
		if (clientes != null) {
			String[][] parser = new String[clientes.length][4];
			for (int i = 0; i < clientes.length; i++) {
				parser[i][0] = clientes[i].getId().toString();
				parser[i][1] = clientes[i].getNombre() = null ? "No se especifica" : clientes[i].getNombre().toString();
				parser[i][2] = clientes[i].getDireccion() == null ? "No se especifica" : clientes[i].getDireccion().getCalle().toString() + " " + 
					clientes[i].getDireccion().getNroPuerta().toString() + clientes[i].getDireccion().getApartamento() == null ? "" : "/" +
					clientes[i].getDireccion().getApartamento().toString();
				parser[i][3] = clientes[i].getTelefono() == null ? "No se especifica" : clientes[i].getTelefono().toString();
			}
			return parser;
		}
		return null;
	}
}
