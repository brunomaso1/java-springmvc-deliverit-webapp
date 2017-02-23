package clases.viaje;

import org.springframework.web.client.RestTemplate;
import dominio.*;
import java.util.ArrayList;
import org.springframework.ui.Model;

/**
 * Clase que prove utilidades para el controlador y las vistas de viaje.
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

	/**
	 * Devuelve un String conteniendo los items de la tabla ubicada en la pagina
	 * del viaje. Estos items ya estan filtrados segun lo que esté en el
	 * parametro estado.
	 *
	 * @return String Una cadena conteniendo los items.
	 */
	public static String popularTablaPrincipal() {
		String tabla = "";

		Pedido[] pedidosBase = obtenerPedidos(String.valueOf(getSucursal()), String.valueOf(getRestaurant()));
		Pedido[] pedidosTablaPrincipal = filtrarPedidos(pedidosBase);
		String[][] pedidosParseados = parsearPedidos(pedidosTablaPrincipal);

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
	 * Realiza lo mismo que el método "popularTablaPrincipal", solo que esta vez
	 * polula la tabla pedidos.
	 *
	 * @return String Cadena conteniendo los items de la tabla.
	 */
	public static String popularTablaPedidos() {
		String tabla = "";

		if (pedidos != null) {
			int i = 1;
			for (Pedido pedido : pedidos) {
				tabla += "<tr>";
				tabla += "<td>" + i + "</td>";
				tabla += "<td>" + pedido.getCliente().getNombre() + "</td>";
				tabla += "<td>" + pedido.getCliente().getDireccion().getCalle()
						+ pedido.getCliente().getDireccion().getNroPuerta() + "</td>";
				tabla += "<td>" + pedido.getCliente().getClienteTelefonoCollection().iterator().next().getClienteTelefonoPK().getTelefono() + "</td>";
				tabla += "</tr>";
				i++;
			}
		}

		return tabla;
	}

	/**
	 * Consume un servicio rest y obtiene todos los pedidos de una sucursal.
	 *
	 * @param sucursal Id de la sucursal.
	 * @param restaurant Id del restaurant.
	 * @return Pedido[] Una lista conteniendo entidades pedidos.
	 */
	private static Pedido[] obtenerPedidos(String sucursal, String restaurant) {
		RestTemplate restTemplate = new RestTemplate();

		//Ejecuta el servicio.
		String uri = "http://192.168.1.45:8080/BackCore/ws/sucursal/findPedidos/" + restaurant + "/" + sucursal;
		//Obtiene la respuesta.
		Pedido[] pedidos = restTemplate.getForObject(uri, Pedido[].class);

		return pedidos;
	}

	/**
	 * Parsea un arreglo de entidades Pedidos acorde a los valores de la tabla
	 * principal.
	 *
	 * @param pedidos Es un arreglo de pedidos.
	 * @return String[][] Un arreglo multidimensional, en donde: La primera
	 * diemnsion contienen los pedidos y la segunda los datos de la tabla.
	 */
	private static String[][] parsearPedidos(Pedido[] pedidos) {
		if (pedidos != null) {
			String[][] parser = new String[pedidos.length][5];
			for (int i = 0; i < pedidos.length; i++) {
				parser[i][0] = pedidos[i].getViaje() == null ? "Viaje no encontrado" : pedidos[i].getViaje().getId().toString();
				parser[i][1] = pedidos[i].getCliente() == null ? "Cliente no encontrado" : pedidos[i].getCliente().getNombre();
				parser[i][2] = pedidos[i].getCliente() == null ? "Cliente no encontrado"
						: pedidos[i].getCliente().getDireccion() == null ? "Direcccion no encontrada"
						: pedidos[i].getCliente().getDireccion().getCalle().toString() + " "
						+ pedidos[i].getCliente().getDireccion().getNroPuerta();;
				parser[i][3] = pedidos[i].getViaje().getDelivery() == null
						? "No asignado" : pedidos[i].getViaje().getDelivery().getUsuario().getNombre().toString();
				parser[i][4] = pedidos[i].getCliente() == null ? "Cliente no encontrado"
						: pedidos[i].getCliente().getClienteTelefonoCollection() == null ? "Telefono no encontrado" : pedidos[i].getCliente().getClienteTelefonoCollection().iterator().next().getClienteTelefonoPK().getTelefono().toString();
			}
			return parser;
		}
		return null;
	}

	/**
	 * Crea un viaje en la base de datos consumiendo servicios rest. Utiliza el
	 * arreglo de pedidos de esa clase que se fue populando a medida que se iba
	 * cargando en la vista.
	 *
	 * @param viaje Nuevo viaje a crear.
	 * @return True si y solo si se ha creado correctamente el viaje.
	 */
	public static boolean crearViaje(Viaje viaje) {
		//Insertar viaje.
		RestTemplate restTemplate = new RestTemplate();
		Viaje v = restTemplate.postForObject("http://192.168.1.45:8080/BackCore/ws/viaje", viaje, Viaje.class);
		System.out.println("Se inserto el viaje.");
		System.out.println(v.getId());
		//Insertar pedidos.
		for (Pedido pedido : pedidos) {
			//Seto el id de viaje al pedido.
			pedido.setViaje(v);
			System.out.println("Se asocio el viaje.");

			//Obtengo la direccion del pedido y la inserto.
			Direccion dir = restTemplate.postForObject("http://192.168.1.45:8080/BackCore/ws/direccion", pedido.getCliente().getDireccion(), Direccion.class);
			//Le asigno el id de la direccion que traje a la direccion en el pedido .
			pedido.getCliente().setDireccion(dir);
			System.out.println("Se inserto la direccion.");

			//Obtengo el cliente y lo inserto.
			Cliente cli = restTemplate.postForObject("http://192.168.1.45:8080/BackCore/ws/cliente", pedido.getCliente(), Cliente.class);
			//Le asigno el id del cliente que traje al pedido.
			pedido.setCliente(cli);
			System.out.println("Se inserto el cliente.");

			//Obtengo los telefonos del cliente y lo inserto.
			ClienteTelefono cliTel = restTemplate.postForObject("http://192.168.1.45:8080/BackCore/ws/clientetelefono", pedido.getCliente().getClienteTelefonoCollection().iterator().next(), ClienteTelefono.class);
			//Le asigno el id del telefono que traje al cliente.
			cli.setClienteTelefonoCollection(new ArrayList<ClienteTelefono>());
			cli.getClienteTelefonoCollection().add(cliTel);
			pedido.setCliente(cli);
			System.out.println("Se inserto el telefono.");

			//Finalmente inserto el pedido que ya tiene todo lo asociado.
			restTemplate.postForObject("http://192.168.1.45:8080/BackCore/ws/pedido", pedido, Pedido.class);
			System.out.println("Se inserto el pedido.");
		}
		//Limpio la lista de pedidos para la proxima inserccion.
		pedidos.clear();

		return true;
	}

	/**
	 * Filta los pedidos en base al estado seteado en esta clase.
	 *
	 * @param pedidosBase Un arreglo de pedidos.
	 * @return Pedidos[] Un arreglo con los pedidos filtrados por el estado.
	 */
	private static Pedido[] filtrarPedidos(Pedido[] pedidosBase) {
		ArrayList<Pedido> pedidosTemp = new ArrayList<>();

		for (Pedido pedido : pedidosBase) {
			if (pedido.getViaje().getEstado().getId() == getEstado()) {
				pedidosTemp.add(pedido);
			}
		}

		if (pedidosTemp.isEmpty()) //No hay ningun pedido para filtrar.
		{
			return null;
		} else {
			//Parseo el arraylist a Pedidos[]. Se hace manualmente porque el casteo da error.
			Pedido[] pedidos = new Pedido[pedidosTemp.size()];
			int i = 0;
			for (Pedido pedido : pedidosTemp) {
				pedidos[i] = pedido;
			}

			return pedidos;
		}
	}

	public static void nuevoPedido(FormBean bean) {
		Direccion dir = new Direccion(1, bean.getCalle(), Short.parseShort(bean.getPuerta()), bean.getEsquina(), -34.9166122d, -56.1568794d, new ArrayList<Cliente>(), new ArrayList<Sucursal>());
		Cliente cli = new Cliente(1, bean.getNombre(), dir, null, new ArrayList<ClienteTelefono>());
		ClienteTelefono ct = new ClienteTelefono(new ClienteTelefonoPK(cli.getId(), bean.getTelefono()), cli);
		cli.getClienteTelefonoCollection().add(ct);
		Pedido ped = new Pedido(null, bean.getAclaraciones(), "Contado", null, cli);
		pedidos.add(ped);
	}
	
	public static String test() {
		//Obtener todos los viajes
		RestTemplate restTemplate = new RestTemplate();
//		Viaje[] viajes = restTemplate.getForObject("http://192.168.1.45:8080/BackCore/ws/viaje/", Viaje[].class);
//		return viajes[0].getPedidoCollection().toString();

		//Insertar viaje
//		RestTemplate restTemplate = new RestTemplate();
//		Viaje[] viajes = restTemplate.getForObject("http://192.168.1.45:8080/BackCore/ws/viaje/", Viaje[].class);
//		Viaje insertarViaje = viajes[0];
//		insertarViaje.setId(6);
//		Pedido pedido = restTemplate.getForObject("http://192.168.1.45:8080/BackCore/ws/pedido/1;id=1;viaje=1", Pedido.class);
//		pedido.setPedidoPK(new PedidoPK(1, 6));
//		ArrayList<Pedido> pedidos = new ArrayList<>();
//		pedidos.add(pedido);
//		insertarViaje.setPedidoCollection(pedidos);
//		restTemplate.postForObject("http://192.168.1.43:8080/BackCore/ws/viaje", insertarViaje, Viaje.class);
//		restTemplate.postForObject("http://192.168.1.43:8080/BackCore/ws/pedido", pedido, Pedido.class);
//		RestTemplate restTemplate = new RestTemplate();
//		Viaje viaje = restTemplate.getForObject("http://192.168.1.45:8080/BackCore/ws/viaje/1", Viaje.class);
//		restTemplate.postForObject("http://192.168.1.45:8080/BackCore/ws/viaje/", viaje, Viaje.class);
		Direccion dir = new Direccion(null, "no se", (short) 123, "asdf", 50d, 50d, new ArrayList<Cliente>(), new ArrayList<Sucursal>());
 		Direccion dirResp = restTemplate.postForObject("http://192.168.1.45:8080/BackCore/ws/direccion", dir, Direccion.class);

		
		Cliente cli = new Cliente();
		cli.setDireccion(dirResp);
		cli.setNombre("Pedro");
		dir.getClienteCollection().add(cli);
		Cliente cli2 = restTemplate.postForObject("http://192.168.1.45:8080/BackCore/ws/cliente", cli, Cliente.class);
		System.out.println("Impimio."); System.out.println(cli2.getId());
		
		
//		Direccion dir = new Direccion(1, "Jose Ellauri", (short)2040, "Francisco Aguilar", -34.9166122d, -56.1568794d, new ArrayList<Cliente>(), new ArrayList<Sucursal>());
//		restTemplate.postForObject("http://192.168.1.45:8080/BackCore/ws/viaje", dir, Direccion.class);
		
		return "sdf";
	}
}