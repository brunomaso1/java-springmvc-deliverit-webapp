package clases.viaje;

import clases.dominio.*;
import clases.configuration.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.runtime.Context.DEBUG;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

public class ViajeLogica {

	private final static Logger LOGGER = Logger.getLogger(ViajeLogica.class.getName());

	private int pedidosPendientes;
	private int pedidosPublicados;
	private int pedidosEnProceso;
	private int pedidosTerminados;
	private ArrayList<Pedido> pedidos;

	public ViajeLogica() {
		this.pedidos = new ArrayList<>();
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public int getPedidosPendientes() {
		return pedidosPendientes;
	}

	public int getPedidosPublicados() {
		return pedidosPublicados;
	}

	public int getPedidosEnProceso() {
		return pedidosEnProceso;
	}

	public int getPedidosTerminados() {
		return pedidosTerminados;
	}

	/**
	 * Consume un servicio rest y obtiene todos los pedidos de una sucursal.
	 *
	 * @param sucursal Id de la sucursal.
	 * @param restaurant Id del restaurant.
	 * @return Pedido[] Una lista conteniendo entidades pedidos.
	 */
	public Pedido[] obtenerPedidos(String sucursal, String restaurant) {
		RestTemplate restTemplate = new RestTemplate();

		//Obtiene la respuesta.
		Pedido[] pedidosTablaPrincipal = restTemplate.getForObject(Configuration.restFindPedidosGet(restaurant, sucursal), Pedido[].class);

		return pedidosTablaPrincipal;
	}

	/**
	 * Crea un viaje en la base de datos consumiendo servicios rest. Utiliza el
	 * arreglo de pedidos de esa clase que se fue populando a medida que se iba
	 * cargando en la vista.
	 *
	 * @param precio
	 * @param estadoid
	 */
	public void crearViaje(String precio, short estadoid) {
		RestTemplate restTemplate = new RestTemplate();

		//Insertar viaje.
		Viaje viaje = new Viaje(null, null, Short.valueOf(precio),
				new ArrayList<Transaccion>(), new ArrayList<Pedido>(), null,
				new Sucursal((short) 1, 1, null, null, null, new ArrayList<Viaje>()),
				new EstadoViaje(estadoid, null, new ArrayList<Viaje>()));

		Viaje v = restTemplate.postForObject(Configuration.restViajePost(), viaje, Viaje.class);

		LOGGER.log(Level.FINEST, "Se inserto el viaje.");

		int pedidoId = 1;
		for (Pedido pedido : pedidos) {
			//Seto el id de viaje al pedido.
			pedido.setViaje(v);
			pedido.setPedidoPK(new PedidoPK(pedidoId, v.getId()));
			LOGGER.log(Level.FINEST, "Se asocio el viaje.");

			//Obtengo la direccion del pedido y la inserto.
			Direccion dir = restTemplate.postForObject(Configuration.restDireccionPost(), pedido.getCliente().getDireccion(), Direccion.class);
			//Le asigno el id de la direccion que traje a la direccion en el pedido .
			pedido.getCliente().setDireccion(dir);
			LOGGER.log(Level.FINEST, "Se inserto la direccion.");

			//Obtengo el cliente y lo inserto.
			Cliente cli = restTemplate.postForObject(Configuration.restClientePost(), pedido.getCliente(), Cliente.class);
			//Le asigno el id del cliente que traje al pedido.
			//cli.getPedidoCollection().add(pedido);
			pedido.setCliente(cli);
			LOGGER.log(Level.FINEST, "Se inserto el cliente.");

			//Finalmente inserto el pedido que ya tiene todo lo asociado.
			Pedido p = restTemplate.postForObject(Configuration.restPedidoPost(), pedido, Pedido.class);
			LOGGER.log(Level.FINEST, "Se inserto el pedido.", p.getPedidoPK().toString());

			pedidoId++;
		}
		//Limpio la lista de pedidos para la proxima inserccion.
		pedidos.clear();
	}

	/**
	 * Filta los pedidos en base al estado seteado en esta clase.
	 *
	 * @param pedidos Un arreglo de pedidos.
	 * @param estado
	 * @return Pedidos[] Un arreglo con los pedidos filtrados por el estado.
	 */
	public Pedido[] filtrarPedidos(Pedido[] pedidos, int estado) {
		ArrayList<Pedido> pedidosTemp = new ArrayList<>();

		this.pedidosPendientes = 0;
		this.pedidosPublicados = 0;
		this.pedidosEnProceso = 0;
		this.pedidosTerminados = 0;

		for (Pedido pedido : pedidos) {
			switch (pedido.getViaje().getEstado().getId()) {
				case 1:
					pedidosPendientes++;
					if (estado == 1) {
						pedidosTemp.add(pedido);
					}
					break;
				case 2:
					pedidosPublicados++;
					if (estado == 2) {
						pedidosTemp.add(pedido);
					}
					break;
				case 3:
					pedidosEnProceso++;
					if (estado == 3) {
						pedidosTemp.add(pedido);
					}
					break;
				case 4:
					pedidosTerminados++;
					if (estado == 4) {
						pedidosTemp.add(pedido);
					}
					break;
			}
		}

		if (pedidosTemp.isEmpty()) //No hay ningun pedido para filtrar.
		{
			return null;
		} else {
			//Parseo el arraylist a Pedidos[]. Se hace manualmente porque el casteo da error.
			Pedido[] cast = new Pedido[pedidosTemp.size()];
			int i = 0;
			for (Pedido pedido : pedidosTemp) {
				cast[i] = pedido;
				i++;
			}

			return cast;
		}
	}

	/**
	 * Crea un nuevo pedido desde un formulario dinamico.
	 *
	 * @param bean Formulario dinamico.
	 */
	public void nuevoPedido(ViajeFormBean bean) {
		Direccion dir;
		if ("".equals(bean.getApartamento())) {
			dir = new Direccion(null, bean.getCalle(), Short.parseShort(bean.getPuerta()), (short) 0, bean.getEsquina(), -34.9166122d, -56.1568794d, new ArrayList<Cliente>(), new ArrayList<Sucursal>());
		} else {
			dir = new Direccion(null, bean.getCalle(), Short.parseShort(bean.getPuerta()), Short.parseShort(bean.getApartamento()), bean.getEsquina(), -34.9166122d, -56.1568794d, new ArrayList<Cliente>(), new ArrayList<Sucursal>());
		}

		Cliente cli = new Cliente(null, bean.getNombre(), dir, new ArrayList<Pedido>(), bean.getTelefono());
		Pedido ped = new Pedido(null, bean.getAclaraciones(), "E", null, cli);

		pedidos.add(ped);
	}

	public String test() {
		RestTemplate restTemplate = new RestTemplate();

		Viaje viaje = new Viaje(null, null, Short.valueOf("50"),
				new ArrayList<Transaccion>(), new ArrayList<Pedido>(), null,
				new Sucursal((short) 1, 1, null, null, null, new ArrayList<Viaje>()),
				new EstadoViaje((short) 1, null, new ArrayList<Viaje>()));

		try {
			Viaje v = restTemplate.postForObject(Configuration.restViajePost(), viaje, Viaje.class);
		} catch (Exception e) {
			System.out.println("Hubo exepcion.");
			e.printStackTrace();
		}

		return null;
	}
}
