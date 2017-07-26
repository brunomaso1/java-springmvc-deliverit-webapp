/**
 * Funcionalidades extra para el Módulo Clientes.
 */
package clases.clientes;

import clases.dominio.Cliente;

/**
 * Esta clase tiene funcionalidades extra para utilizarse en el controlador ClientesController.
 */
public class ClientesControllerHelper {

	/**
	 * Renderiza los clientes para mostrarse en una tabla HTML.
	 */
	public String getDatosTablaClientesHTML(Cliente[] clientes) {
		String tabla = "";
		String[][] clientesParseados = parsearClientes(clientes);
		
		tabla += "<thead>";
		tabla += "<tr>";
		tabla += "<th>" + "Id" + "</th>";	// Id cliente.
		tabla += "<th>" + "Nombre" + "</th>";	// Nombre cliente.
		tabla += "<th>" + "Direccion" + "</th>";	// Direccion Cliente.
		tabla += "<th>" + "Telefono" + "</th>";	// Telefono cliente.
		tabla += "</tr>";
		tabla += "</thead>";

		tabla += "<tbody>";
		if (clientesParseados != null) {
			//Crea los items.
			for (String[] pedidosParseado : clientesParseados) {
				tabla += "<tr>";
				tabla += "<td>" + pedidosParseado[0] + "</td>";	// Id cliente.
				tabla += "<td>" + pedidosParseado[1] + "</td>";	// Nombre cliente.
				tabla += "<td>" + pedidosParseado[2] + "</td>";	// Direccion Cliente.
				tabla += "<td>" + pedidosParseado[3] + "</td>";	// Telefono cliente.
				tabla += "</tr>";
			}
		}
		tabla += "</tbody>";
		return tabla;
	}

	/**
	 * Parsea los clientes para facilitar la generación de datos.
	 */
	private String[][] parsearClientes(Cliente[] clientes) {
		if ((clientes != null) && (clientes.length != 0)) {
			String[][] parser = new String[clientes.length][4];
			for (int i = 0; i < clientes.length; i++) {
				parser[i][0] = clientes[i].getId().toString(); // Id Cliente
				parser[i][1] = clientes[i].getNombre() == null ? "No se especifica" : clientes[i].getNombre(); //Nombre Cliente.
				parser[i][2] = clientes[i].getDireccion() == null ? "No se especifica" : clientes[i].getDireccion().getCalle() + " "
						+ clientes[i].getDireccion().getNroPuerta() + (clientes[i].getDireccion().getApartamento() == 0 ? "" : "/"
						+ clientes[i].getDireccion().getApartamento()); // Dirección Cliente.
				parser[i][3] = clientes[i].getTelefono() == null ? "No se especifica" : clientes[i].getTelefono(); // Telefono Cliente.
			}
			return parser;
		}
		return null;
	}
}
