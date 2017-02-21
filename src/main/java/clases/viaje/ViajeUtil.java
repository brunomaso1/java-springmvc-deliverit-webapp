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
public final class ViajeUtil {
	
	private static int sucursal;
	private static int restaurant;
	private static int estado;

	/**
	 * @return the sucursal
	 */
	public static int getSucursal() {
		return sucursal;
	}

	/**
	 * @param aSucursal the sucursal to set
	 */
	public static void setSucursal(int aSucursal) {
		sucursal = aSucursal;
	}

	/**
	 * @return the restaurant
	 */
	public static int getRestaurant() {
		return restaurant;
	}

	/**
	 * @param aRestaurant the restaurant to set
	 */
	public static void setRestaurant(int aRestaurant) {
		restaurant = aRestaurant;
	}

	/**
	 * @return the estado
	 */
	public static int getEstado() {
		return estado;
	}

	/**
	 * @param aEstado the estado to set
	 */
	public static void setEstado(int aEstado) {
		estado = aEstado;
	}

	public static String popularTabla() {
		String tabla = "";
		Pedido[] pedidosBase = obtenerPedidos(String.valueOf(getSucursal()), String.valueOf(getRestaurant()));
		Pedido[] pedidos = filtrarPedidos(pedidosBase);
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

	private static Pedido[] obtenerPedidos(String sucursal, String restaurant) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://192.168.1.43:8080/BackCore/ws/sucursal/findPedidos/" + restaurant + "/" + sucursal;
		System.out.println("Bk1");
		Pedido[] pedidos = restTemplate.getForObject(uri, Pedido[].class);
		return pedidos;
	}

	private static String[][] parsearPedidos(Pedido[] pedidos) {
		String[][] parser = new String[pedidos.length][5];
		for (int i = 0; i < pedidos.length; i++) {
			parser[i][0] = pedidos[i].getViaje()== null? "Viaje no encontrado" : pedidos[i].getViaje().getId().toString();
			parser[i][1] = pedidos[i].getCliente() == null? "Cliente no encontrado" : pedidos[i].getCliente().getNombre();
			parser[i][2] = pedidos[i].getCliente() == null? "Cliente no encontrado" : 
					pedidos[i].getCliente().getDireccion() == null? "Direcccion no encontrada" :
					pedidos[i].getCliente().getDireccion().getCalle().toString() + " " +
					pedidos[i].getCliente().getDireccion().getNroPuerta();;
			parser[i][3] = pedidos[i].getViaje().getDelivery() == null ?
					"No asignado" : pedidos[i].getViaje().getDelivery().getUsuario().getNombre().toString();
			parser[i][4] = pedidos[i].getCliente() == null? "Cliente no encontrado" : 
					pedidos[i].getCliente().getClienteTelefonoCollection() == null? "Telefono no encontrado" : pedidos[i].getCliente().getClienteTelefonoCollection().iterator().next().toString();
		}
		return parser;
	}

	public static String test() {
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

	// Falta ver cuando no se trae ningun pedido.
	private static Pedido[] filtrarPedidos(Pedido[] pedidosBase) {
		Pedido[] pedidosFiltrados = new Pedido[pedidosBase.length];
		int i = 0;
		for (Pedido pedido : pedidosBase) {
			if (pedido.getViaje().getEstado().getId() == getEstado()){
				pedidosFiltrados[i] = pedido;
				i ++;
			}
		}
		Pedido[] temp = new Pedido[i + 1];
		for (int j = 0; j < temp.length; j++) {
			temp[j] = pedidosFiltrados[j];
		}
		return temp;
	}
}