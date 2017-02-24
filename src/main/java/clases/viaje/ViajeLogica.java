package clases.viaje;

import clases.dominio.*;
import clases.configuration.*;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.math.BigInteger;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;

/**
 * Clase que prove utilidades para el controlador y las vistas de viaje.
 */
public final class ViajeLogica {

	private static int sucursal = 1;
	private static int restaurant = 1;
	private static int estado = 1;
	private static int pedidosPendientes = 0;
	private static int pedidosPublicados = 0;
	private static int pedidosEnProceso = 0;
	private static int pedidosTerminados = 0;
	private static ArrayList<Pedido> pedidos = new ArrayList<>();

	public static int getSucursal() {
		return sucursal;
	}

	public static void setSucursal(int aSucursal) {
		sucursal = aSucursal;
	}

	public static int getRestaurant() {
		return restaurant;
	}

	public static void setRestaurant(int aRestaurant) {
		restaurant = aRestaurant;
	}

	public static int getEstado() {
		return estado;
	}

	public static void setEstado(int aEstado) {
		estado = aEstado;
	}

	public static int getPedidosPendientes() {
		return pedidosPendientes;
	}

	public static int getPedidosPublicados() {
		return pedidosPublicados;
	}

	public static int getPedidosEnProceso() {
		return pedidosEnProceso;
	}

	public static int getPedidosTerminados() {
		return pedidosTerminados;
	}

	/**
	 * Devuelve un String conteniendo los items de la tabla ubicada en la pagina
	 * del viaje. Estos items ya estan filtrados segun lo que esté en el
	 * parametro estado.
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
				tabla += "<td>" + pedido.getCliente().getTelefono() + "</td>";
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

		//Obtiene la respuesta.
		Pedido[] pedidosTablaPrincipal = restTemplate.getForObject(Configuration.restFindPedidosGet(restaurant, sucursal), Pedido[].class);

		return pedidosTablaPrincipal;
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

	/**
	 * Crea un viaje en la base de datos consumiendo servicios rest. Utiliza el
	 * arreglo de pedidos de esa clase que se fue populando a medida que se iba
	 * cargando en la vista.
	 *
	 * @param viaje Nuevo viaje a crear.
	 * @return True si y solo si se ha creado correctamente el viaje.
	 */
	public static boolean crearViaje(String precio, short estadoid) {
		RestTemplate restTemplate = new RestTemplate();

		//Insertar viaje.
		Viaje viaje = new Viaje(null, null, Short.valueOf(precio),
				new ArrayList<Transaccion>(), new ArrayList<Pedido>(), null,
				new Sucursal((short) 1, 1, null, null, null, new ArrayList<Viaje>()),
				new EstadoViaje(estadoid, null, new ArrayList<Viaje>()));

		Viaje v = restTemplate.postForObject(Configuration.restViajePost(), viaje, Viaje.class);
		System.out.println("Se inserto el viaje.");
		//Insertar pedidos.
		int pedidoId = 1;
		for (Pedido pedido : pedidos) {
			//Seto el id de viaje al pedido.
			//v.getPedidoCollection().add(pedido);
			pedido.setViaje(v);
			pedido.setPedidoPK(new PedidoPK(pedidoId, v.getId()));
			System.out.println("Se asocio el viaje.");

			//Obtengo la direccion del pedido y la inserto.
			Direccion dir = restTemplate.postForObject(Configuration.restDireccionPost(), pedido.getCliente().getDireccion(), Direccion.class);
			//Le asigno el id de la direccion que traje a la direccion en el pedido .
			//dir.getClienteCollection().add(pedido.getCliente());
			pedido.getCliente().setDireccion(dir);
			System.out.println("Se inserto la direccion.");

			//Obtengo el cliente y lo inserto.
			Cliente cli = restTemplate.postForObject(Configuration.restClientePost(), pedido.getCliente(), Cliente.class);
			//Le asigno el id del cliente que traje al pedido.
			//cli.getPedidoCollection().add(pedido);
			pedido.setCliente(cli);
			System.out.println("Se inserto el cliente.");

			//Finalmente inserto el pedido que ya tiene todo lo asociado.
			Pedido p = restTemplate.postForObject(Configuration.restPedidoPost(), pedido, Pedido.class);
			System.out.println("Se inserto el pedido.");
			
			pedidoId++;
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
		
		pedidosPendientes = 0;
		pedidosPublicados = 0;
		pedidosEnProceso = 0;
		pedidosTerminados = 0;
		
		for (Pedido pedido : pedidosBase) {
			switch (pedido.getViaje().getEstado().getId()) {
				case 1 : pedidosPendientes++; if (estado == 1) pedidosTemp.add(pedido); break;
				case 2 : pedidosPublicados++; if (estado == 2) pedidosTemp.add(pedido); break;
				case 3 : pedidosEnProceso++; if (estado == 3) pedidosTemp.add(pedido); break;
				case 4 : pedidosTerminados++; if (estado == 4) pedidosTemp.add(pedido); break;
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
				i++;
			}

			return pedidos;
		}
	}
	
	/**
	 * Crea un nuevo pedido desde un formulario dinamico.
	 * @param bean Formulario dinamico.
	 */
	public static void nuevoPedido(ViajeFormBean bean) {
		Direccion dir;
		if (bean.getApartamento() == "") {
			dir = new Direccion(null, bean.getCalle(), Short.parseShort(bean.getPuerta()), (short) 0, bean.getEsquina(), -34.9166122d, -56.1568794d, new ArrayList<Cliente>(), new ArrayList<Sucursal>());
		} else {
			dir = new Direccion(null, bean.getCalle(), Short.parseShort(bean.getPuerta()), Short.parseShort(bean.getApartamento()), bean.getEsquina(), -34.9166122d, -56.1568794d, new ArrayList<Cliente>(), new ArrayList<Sucursal>());
		}

		Cliente cli = new Cliente(null, bean.getNombre(), dir, new ArrayList<Pedido>(), bean.getTelefono());
		Pedido ped = new Pedido(null, bean.getAclaraciones(), "E", null, cli);

		pedidos.add(ped);
	}
}
