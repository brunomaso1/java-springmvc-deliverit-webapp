package clases.viaje;

import clases.configuration.OpcionesJavascript;
import clases.dominio.Pedido;
import java.util.ArrayList;
import clases.configuration.Parametros;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	public String tablaPrincipalHtml(Pedido[] pedidos, String estadoId) {
		String[][] pedidosParseados = parsearPedidos(pedidos);
		String tabla = "";
		switch (estadoId) {
		case "1":
			tabla = tablaPrincipalPendiente(pedidosParseados);
			break;
		case "2":
			tabla = tablaPrincipalPublicado(pedidosParseados);
			break;
		case "3":
			tabla = tablaPrincipalProceso(pedidosParseados);
			break;
		case "4":
			tabla = tablaPrincipalTerminado(pedidosParseados);
			break;
		default:
			throw new AssertionError();
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
			String[][] parser = new String[pedidos.length][9];
			for (int i = 0; i < pedidos.length; i++) {
				parser[i][0] = pedidos[i].getViaje() == null ? "Viaje no encontrado" : pedidos[i].getViaje().getId().toString(); // Id viaje.
				parser[i][1] = pedidos[i].getCliente() == null ? "Cliente no encontrado" : pedidos[i].getCliente().getNombre(); // Nombre Cliente.
				parser[i][2] = pedidos[i].getCliente() == null ? "Cliente no encontrado" : pedidos[i].getCliente().getTelefono(); // Telefono Cliente
				parser[i][3] = pedidos[i].getCliente() == null ? "Cliente no encontrado"
				               : pedidos[i].getCliente().getDireccion() == null ? "Direcccion no encontrada"
				               : pedidos[i].getCliente().getDireccion().getCalle() + " "
				               + pedidos[i].getCliente().getDireccion().getNroPuerta(); // Direccion cliente.
				parser[i][4] = pedidos[i].getViaje().getDelivery() == null
				               ? "No asignado" : pedidos[i].getViaje().getDelivery().getUsuario().getNombre(); //Nombre delivery
				parser[i][5] = pedidos[i].getViaje().getDelivery() == null
				               ? "No asignado" : pedidos[i].getViaje().getDelivery().getUsuario().getTelefono(); // Telefono delivey
				parser[i][6] = pedidos[i].getViaje().getFecha() == null ? "Sin fecha"
				               : pedidos[i].getViaje().getFecha().toString(); // Fecha viaje.
				parser[i][7] = pedidos[i].getViaje().getCalificacion() == null ? "Sin calificacion"
				               : pedidos[i].getViaje().getCalificacion().toString(); // Calificacion viaje.
				parser[i][8] = pedidos[i].getId().toString(); // Id del pedido.
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

	private String tablaPrincipalPendiente(String[][] pedidosParseados) {
		String tabla = "";

		tabla += "<thead>";
		tabla += "<tr>";
		tabla += "<th>" + "Viaje" + "</th>";	// Id viaje.
		tabla += "<th>" + "Cliente" + "</th>";	// Nombre cliente.
		tabla += "<th>" + "Telefono" + "</th>";	// Telefono Cliente.
		tabla += "<th>" + "Dirección" + "</th>";	// Direccion cliente.
		tabla += "<th>" + "Fecha" + "</th>";	// Fecha del viaje.
		tabla += "<th style=\"display:none;\">" + "PedidoId" + "</th>";	// Id del pedido.
		tabla += "</tr>";
		tabla += "</thead>";

		tabla += "<tbody>";
		if (pedidosParseados != null) {
			//Crea los items.
			for (String[] pedidosParseado : pedidosParseados) {
				tabla += "<tr>";
				tabla += "<td>" + pedidosParseado[0] + "</td>";	// Id viaje.
				tabla += "<td>" + pedidosParseado[1] + "</td>";	// Nombre cliente.
				tabla += "<td>" + pedidosParseado[2] + "</td>";	// Telefono Cliente.
				tabla += "<td>" + pedidosParseado[3] + "</td>";	// Direccion cliente.
				tabla += "<td>" + pedidosParseado[6] + "</td>";	// Fecha del viaje.
				tabla += "<td style=\"display:none;\">" + pedidosParseado[8] + "</td>";	// Id del pedido.
				tabla += "</tr>";
			}
		}
		tabla += "</tbody>";
		return tabla;
	}

	private String tablaPrincipalPublicado(String[][] pedidosParseados) {
		String tabla = "";

		tabla += "<thead>";
		tabla += "<tr>";
		tabla += "<th>" + "Viaje" + "</th>";	// Id viaje.
		tabla += "<th>" + "Cliente" + "</th>";	// Nombre cliente.
		tabla += "<th>" + "Telefono" + "</th>";	// Telefono Cliente.
		tabla += "<th>" + "Dirección" + "</th>";	// Direccion cliente.
		tabla += "<th>" + "Fecha" + "</th>";	// Fecha del viaje.
		tabla += "<th style=\"display:none;\">" + "PedidoId" + "</th>";	// Id del pedido.
		tabla += "</tr>";
		tabla += "</thead>";

		tabla += "<tbody>";
		if (pedidosParseados != null) {
			//Crea los items.
			for (String[] pedidosParseado : pedidosParseados) {
				tabla += "<tr>";

				tabla += "<td>" + pedidosParseado[0] + "</td>";	// Id viaje.
				tabla += "<td>" + pedidosParseado[1] + "</td>";	// Nombre cliente.
				tabla += "<td>" + pedidosParseado[2] + "</td>";	// Telefono Cliente.
				tabla += "<td>" + pedidosParseado[3] + "</td>";	// Direccion cliente.
				tabla += "<td>" + pedidosParseado[6] + "</td>";	// Fecha del viaje.
				tabla += "<td style=\"display:none;\">" + pedidosParseado[8] + "</td>";	// Id del pedido.

				tabla += "</tr>";
			}
		}
		tabla += "</tbody>";
		return tabla;
	}

	private String tablaPrincipalProceso(String[][] pedidosParseados) {
		String tabla = "";

		tabla += "<thead>";
		tabla += "<tr>";
		tabla += "<th>" + "Viaje" + "</th>";	// Id viaje.
		tabla += "<th>" + "Cliente" + "</th>";	// Nombre cliente.
		tabla += "<th>" + "Telefono" + "</th>";	// Telefono Cliente.
		tabla += "<th>" + "Dirección" + "</th>";	// Direccion cliente.
		tabla += "<th>" + "Delivery" + "</th>";	// Nombre Delivery.
		tabla += "<th>" + "Telefono" + "</th>";	// Telefono Delivery.
		tabla += "<th>" + "Fecha" + "</th>";	// Fecha del viaje.
		tabla += "<th style=\"display:none;\">" + "PedidoId" + "</th>";	// Id del pedido.
		tabla += "</tr>";
		tabla += "</thead>";

		tabla += "<tbody>";
		if (pedidosParseados != null) {
			//Crea los items.
			for (String[] pedidosParseado : pedidosParseados) {
				tabla += "<tr>";
				tabla += "<td>" + pedidosParseado[0] + "</td>";	// Id viaje.
				tabla += "<td>" + pedidosParseado[1] + "</td>";	// Nombre cliente.
				tabla += "<td>" + pedidosParseado[2] + "</td>";	// Telefono Cliente.
				tabla += "<td>" + pedidosParseado[3] + "</td>";	// Direccion cliente.
				tabla += "<td>" + pedidosParseado[4] + "</td>";	// Nombre Delivery.
				tabla += "<td>" + pedidosParseado[5] + "</td>";	// Telefono Delivery.
				tabla += "<td>" + pedidosParseado[6] + "</td>";	// Fecha del viaje.
				tabla += "<td style=\"display:none;\">" + pedidosParseado[8] + "</td>";	// Id del pedido.
				tabla += "</tr>";
			}
		}
		tabla += "</tbody>";
		return tabla;
	}

	private String tablaPrincipalTerminado(String[][] pedidosParseados) {
		String tabla = "";

		tabla += "<thead>";
		tabla += "<tr>";
		tabla += "<th>" + "Viaje" + "</th>";	// Id viaje.
		tabla += "<th>" + "Calificacion" + "</th>";	// Calificacion.
		tabla += "<th>" + "Direccion" + "</th>"; // Direccion Clientey.
		tabla += "<th>" + "Cliente" + "</th>";	// Nombre cliente.
		tabla += "<th>" + "Delivery" + "</th>";	// Delivery.
		tabla += "<th style=\"display:none;\">" + "PedidoId" + "</th>";	// Id del pedido.
		tabla += "</tr>";
		tabla += "</thead>";

		tabla += "<tbody>";
		if (pedidosParseados != null) {
			//Crea los items.
			for (String[] pedidosParseado : pedidosParseados) {
				tabla += "<tr>";
				tabla += "<td>" + pedidosParseado[0] + "</td>";	// Id viaje.
				tabla += "<td>" + "<div id=\"stars-existing\" class=\"starrr\" data-rating='3'></div>" + "</td>";	// Calificacion Delivery.
				tabla += "<td>" + pedidosParseado[3] + "</td>";	// Direccion cliente.
				tabla += "<td>" + pedidosParseado[4] + "</td>";	// Nombre Delivery.
				tabla += "<td>" + pedidosParseado[1] + "</td>";	// Nombre cliente.
				tabla += "<td style=\"display:none;\">" + pedidosParseado[8] + "</td>";	// Id del pedido.
				tabla += "</tr>";
			}
		}
		tabla += "</tbody>";
		return tabla;
	}

	public String toJSON(Pedido[] pedidos) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(pedidos);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(ViajeControllerHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}

	public String getOpciones(String contextPath, String estadoId) {
		ObjectMapper mapper = new ObjectMapper();
		OpcionesJavascript opciones = new OpcionesJavascript();

		// Agrego la url del para la llamada ajax para obtener la ubicacion del dleivery.
		opciones.setUrl(contextPath + Parametros.URL_DELIVERY);
		
		// Agrego los colores de los markadores.
		Arrays.asList(Parametros.COLORES_MARKADORES).forEach((k) -> {
			String color = Parametros.UBICACION_MARKADORES + k + Parametros.EXTENSION_MARKADORES;
			opciones.getColoresMarkadores().add(color);
		});
		
		// Agrego la ubicacion de la moto.
		opciones.setMoto(Parametros.UBICACION_MOTO);
		
		// Agrego el zoom del mapa.
		opciones.setDefZoomMap(Parametros.ZOOM_MAPA);
		
		// Agrego las opciones de la DataTable.
		opciones.setDataTableOptions(Parametros.OPCIONES);
		
		// Agrego la latitud y longitud por defecto.
		opciones.setDefLat(Parametros.DEFAULT_LATITUDE);
		opciones.setDefLon(Parametros.DEFAULT_LONGITUDE);
		
		// Agrego el estado actual.
		opciones.setEstadoIdActual(estadoId);
		
		// Agrego la url de calificar.
		opciones.setUrlCalificar(contextPath + Parametros.URL_CALIFICAR);
		String jsonObject = "";
		try {
			jsonObject = mapper.writeValueAsString(opciones);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(ViajeControllerHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonObject;
	}
}
