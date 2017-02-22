/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.viaje;

import org.springframework.web.client.RestTemplate;
import dominio.*;
import java.util.AbstractList;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public final class ViajeUtil {
	
	private static int sucursal = 1;
	private static int restaurant = 1;
	private static int estado = 1;
	private static ArrayList<Pedido> pedidos = new ArrayList<>();

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

	/**
	 * @return the pedidos
	 */
	public static ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	/**
	 * @param aPedidos the pedidos to set
	 */
	public static void setPedidos(ArrayList<Pedido> aPedidos) {
		pedidos = aPedidos;
	}

	public static String popularTablaPrincipal() {
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
	
	public static String popularTablaPedidos() {
		String tabla = "";
		int i = 1;
		for (Pedido pedido : pedidos) {
			tabla += "<tr>";
			tabla += "<td>" + i + "</td>";
			tabla += "<td>" + pedido.getCliente().getNombre() + "</td>";
			tabla += "<td>" + pedido.getCliente().getDireccion().getCalle() +
					pedido.getCliente().getDireccion().getNroPuerta() + "</td>";
			tabla += "<td>" + pedido.getCliente().getClienteTelefonoCollection().iterator().next().getClienteTelefonoPK().getTelefono() + "</td>";
			tabla += "</tr>";
			i ++;
		}
		return tabla;
	}

	private static Pedido[] obtenerPedidos(String sucursal, String restaurant) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:38526/backcore/ws/sucursal/findPedidos/" + restaurant + "/" + sucursal;
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
					pedidos[i].getCliente().getClienteTelefonoCollection() == null? "Telefono no encontrado" : pedidos[i].getCliente().getClienteTelefonoCollection().iterator().next().getClienteTelefonoPK().getTelefono().toString();
		}
		return parser;
	}

	public static String test() {
		//Obtener todos los viajes
		RestTemplate restTemplate = new RestTemplate();
//		Viaje[] viajes = restTemplate.getForObject("http://192.168.1.43:8080/BackCore/ws/viaje/", Viaje[].class);
//		return viajes[0].getPedidoCollection().toString();

		//Insertar viaje
//		RestTemplate restTemplate = new RestTemplate();
//		Viaje[] viajes = restTemplate.getForObject("http://localhost:38526/backcore/ws/viaje/", Viaje[].class);
//		Viaje insertarViaje = viajes[0];
//		insertarViaje.setId(6);
//		Pedido pedido = restTemplate.getForObject("http://localhost:38526/backcore/ws/pedido/1;id=1;viaje=1", Pedido.class);
//		pedido.setPedidoPK(new PedidoPK(1, 6));
//		ArrayList<Pedido> pedidos = new ArrayList<>();
//		pedidos.add(pedido);
//		insertarViaje.setPedidoCollection(pedidos);
//		restTemplate.postForObject("http://192.168.1.43:8080/BackCore/ws/viaje", insertarViaje, Viaje.class);
//		restTemplate.postForObject("http://192.168.1.43:8080/BackCore/ws/pedido", pedido, Pedido.class);

//		RestTemplate restTemplate = new RestTemplate();
//		Viaje viaje = restTemplate.getForObject("http://localhost:38526/backcore/ws/viaje/1", Viaje.class);
//		restTemplate.postForObject("http://localhost:38526/backcore/ws/viaje/", viaje, Viaje.class);

		Direccion dir = new Direccion(1, "no se", (short)123, "asdf", 50d, 50d, new ArrayList<Cliente>(), new ArrayList<Sucursal>());
		Direccion dirResp = restTemplate.postForObject("http://localhost:38526/backcore/ws/direccion", dir, Direccion.class);
		
		//Cliente cli = new Cliente(1, "Pedro", dir, new ArrayList<Pedido>(), new ArrayList<ClienteTelefono>());
		System.out.println("DIR: " + dirResp.getId().toString());
		//Cliente cli2 = restTemplate.postForObject("http://localhost:38526/backcore/ws/cliente", cli, Cliente.class);
		return "sdf";
	}
	
	public static boolean crearViaje(Viaje viaje) {
		//Insertar viaje.
		RestTemplate restTemplate = new RestTemplate();
		Viaje v = restTemplate.postForObject("http://localhost:38526/backcore/ws/viaje", viaje, Viaje.class);
		System.out.println("Se inserto el viaje.");
		//Insertar pedidos.
		for (Pedido pedido : pedidos) {
			pedido.setViaje(v);
			System.out.println("Se asocio el viaje.");
			
			Direccion dir = restTemplate.postForObject("http://localhost:38526/backcore/ws/direccion", pedido.getCliente().getDireccion(), Direccion.class);
			pedido.getCliente().setDireccion(dir);
			System.out.println("Se inserto la direccion.");
			
			Cliente cli = restTemplate.postForObject("http://localhost:38526/backcore/ws/cliente", pedido.getCliente(), Cliente.class);
			pedido.setCliente(cli);
			System.out.println("Se inserto el cliente.");
			
			ClienteTelefono cliTel = restTemplate.postForObject("http://localhost:38526/backcore/ws/clientetelefono", pedido.getCliente().getClienteTelefonoCollection().iterator().next(), ClienteTelefono.class);
			cli.setClienteTelefonoCollection(new ArrayList<ClienteTelefono>());
			cli.getClienteTelefonoCollection().add(cliTel);
			pedido.setCliente(cli);
			System.out.println("Se inserto el telefono.");
			
			restTemplate.postForObject("http://localhost:38526/backcore/ws/pedido", pedido, Pedido.class);
			System.out.println("Se inserto el pedido.");
		}
		pedidos.clear();
		return true;
	}

	private static Pedido[] filtrarPedidos(Pedido[] pedidosBase) {
		ArrayList<Pedido> pedidosTemp = new ArrayList<>();
		for (Pedido pedido : pedidosBase) {
			if (pedido.getViaje().getEstado().getId() == getEstado()){
				pedidosTemp.add(pedido);
			}
		}
		if (pedidosTemp.isEmpty())
			return null;
		else {
			Pedido[] pedidos = new Pedido[pedidosTemp.size()];
			int i = 0;
			for (Pedido pedido : pedidosTemp) {
				pedidos[i] = pedido;
			}
			return pedidos;
		}		
	}
}