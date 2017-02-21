/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.viaje;

import org.springframework.web.client.RestTemplate;
import dominio.*;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class ViajeUtil {

	public String popularTabla(String sucursal, String restaurant) {
		String tabla = "";
		Pedido[] pedidos = obtenerPedidos(sucursal, restaurant);
		String[][] pedidosParseados = parsearPedidos(pedidos);
		for (String[] pedidosParseado : pedidosParseados) {
			tabla += "<tr>";
			for (String string : pedidosParseado) {
				tabla += "<td>" + string + "</td>";
			}
			tabla += "</tr>";
		}
		return tabla;
	}

	private Pedido[] obtenerPedidos(String sucursal, String restaurant) {
		RestTemplate restTemplate = new RestTemplate();
		Pedido[] pedidos = restTemplate.getForObject("http://192.168.1.43:8080/BackCore/ws/sucursal/findPedidos/1/1", Pedido[].class);
		return pedidos;
	}

	private String[][] parsearPedidos(Pedido[] pedidos) {
		String[][] parser = new String[pedidos.length][5];
		for (int i = 0; i < pedidos.length; i++) {
			System.out.println("****************************************");
			parser[i][0] = pedidos[i].getViaje().getId().toString(); System.out.println(parser[i][0]);
			parser[i][1] = pedidos[i].getCliente().getNombre().toString(); System.out.println(parser[i][1]);
			parser[i][2] = pedidos[i].getCliente().getDireccion().getCalle().toString() + " " +
					pedidos[i].getCliente().getDireccion().getNroPuerta(); System.out.println(parser[i][2]);
			parser[i][3] = (pedidos[i].getViaje().getDelivery() == null) ?
					"No asignado" : pedidos[i].getViaje().getDelivery().getUsuario().getNombre().toString(); System.out.println(parser[i][3]);
			parser[i][4] = pedidos[i].getCliente().getClienteTelefonoCollection().iterator().next().toString(); System.out.println(parser[i][4]);
			System.out.println("****************************************");
		}
		return parser;
	}

	public String test() {
		//Obtener todos los viajes
//		RestTemplate restTemplate = new RestTemplate();
//		Viaje[] viajes = restTemplate.getForObject("http://192.168.1.43:8080/BackCore/ws/viaje/", Viaje[].class);
//		return viajes[0].getPedidoCollection().toString();

		//Insertar viaje
		RestTemplate restTemplate = new RestTemplate();
		Viaje[] viajes = restTemplate.getForObject("http://192.168.1.43:8080/BackCore/ws/viaje/", Viaje[].class);
		Viaje insertarViaje = viajes[0];
		insertarViaje.setId(6);
		Pedido pedido = restTemplate.getForObject("http://192.168.1.43:8080/BackCore/ws/pedido/1;id=1;viaje=1", Pedido.class);
		pedido.setPedidoPK(new PedidoPK(1, 6));
		ArrayList<Pedido> pedidos = new ArrayList<>();
		pedidos.add(pedido);
		insertarViaje.setPedidoCollection(pedidos);
		restTemplate.postForObject("http://192.168.1.43:8080/BackCore/ws/viaje", insertarViaje, Viaje.class);
		restTemplate.postForObject("http://192.168.1.43:8080/BackCore/ws/pedido", pedido, Pedido.class);
		return "sdf";
	}
}