package clases.viaje;

import clases.dominio.*;
import clases.configuration.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.AbstractSet;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViajeLogica {

	private final static Logger LOGGER = Logger.getLogger(ViajeLogica.class.getName());

	private int viajesPendientes;
	private int viajesPublicados;
	private int viajesEnProceso;
	private int viajesTerminados;
	private ArrayList<Pedido> pedidos;

	public ViajeLogica() {
		this.pedidos = new ArrayList<>();
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public int getViajesPendientes() {
		return viajesPendientes;
	}

	public int getViajesPublicados() {
		return viajesPublicados;
	}

	public int getViajesEnProceso() {
		return viajesEnProceso;
	}

	public int getViajesTerminados() {
		return viajesTerminados;
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
	public void crearViaje(String precio, int estadoid, int sucursalId, int restaurantId) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();

		//Insertar viaje.
		Viaje viaje = new Viaje(precio, sucursalId, restaurantId, estadoid);
		
		/***************************************************************** TEST ARREGLAR!! ***********************************************/
		Sucursal sucursal = restTemplate.getForObject(Configuration.restSucursalGet(String.valueOf(sucursalId),String.valueOf(restaurantId)), Sucursal.class);
		viaje.setSucursal(sucursal);
		/***************************************************************** TEST ARREGLAR!! ***********************************************/

		RespuestaGeneral rgVje = restTemplate.postForObject(Configuration.restViajePost(), viaje, RespuestaGeneral.class);
		if (rgVje.getCodigo() == RespuestaGeneral.CODIGO_OK) {
			LOGGER.log(Level.FINEST, "Se inserto el viaje correctamente.");
		} else {
			LOGGER.log(Level.SEVERE, "No se pudo insertar el viaje -> ", rgVje.getCodigo() + " " + rgVje.getMensaje());
		}

		Object v = rgVje.getObjeto();
		Viaje vje = mapper.readValue(v.toString(), Viaje.class);
		int pedidoId = 1;
		for (Pedido pedido : pedidos) {
			//Seto el id de viaje al pedido.
			pedido.setViaje(vje);
			pedido.setPedidoPK(pedidoId, vje.getId());
			LOGGER.log(Level.FINEST, "Se asocio el viaje.");

			//Obtengo la direccion del pedido y la inserto.
			RespuestaGeneral rgDir = restTemplate.postForObject(Configuration.restDireccionPost(), pedido.getCliente().getDireccion(), RespuestaGeneral.class);
			if (rgDir.getCodigo() == RespuestaGeneral.CODIGO_OK) {
				LOGGER.log(Level.FINEST, "Se inserto la direccion correctamente.");
			} else {
				LOGGER.log(Level.SEVERE, "No se pudo insertar la direccion -> ", rgDir.getCodigo() + " " + rgDir.getMensaje());
			}

			//Le asigno el id de la direccion que traje a la direccion en el pedido .
			Object d = rgDir.getObjeto();
			Direccion dir = mapper.readValue(d.toString(), Direccion.class);
			pedido.getCliente().setDireccion(dir);

			//Obtengo el cliente y lo inserto.
			RespuestaGeneral rgCli = restTemplate.postForObject(Configuration.restClientePost(), pedido.getCliente(), RespuestaGeneral.class);
			if (rgCli.getCodigo() == RespuestaGeneral.CODIGO_OK) {
				LOGGER.log(Level.FINEST, "Se inserto el cliente correctamente.");
			} else {
				LOGGER.log(Level.SEVERE, "No se pudo insertar el cliente -> ", rgCli.getCodigo() + " " + rgCli.getMensaje());
			}

			//Le asigno el id del cliente que traje al pedido.
			Object c = rgCli.getObjeto();
			Cliente cli = mapper.readValue(c.toString(), Cliente.class);
			pedido.setCliente(cli);

			//Finalmente inserto el pedido que ya tiene todo lo asociado.
			RespuestaGeneral rgPed = restTemplate.postForObject(Configuration.restPedidoPost(), pedido, RespuestaGeneral.class);
			if (rgPed.getCodigo() == RespuestaGeneral.CODIGO_OK) {
				LOGGER.log(Level.FINEST, "Se inserto el pedido correctamente.");
			} else {
				LOGGER.log(Level.SEVERE, "No se pudo insertar el pedido -> ", rgPed.getCodigo() + " " + rgPed.getMensaje());
			}
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

		ArrayList<Pedido> pedidosPend = new ArrayList<>();
		ArrayList<Pedido> pedidosPubl = new ArrayList<>();
		ArrayList<Pedido> pedidosEnPr = new ArrayList<>();
		ArrayList<Pedido> pedidosTerm = new ArrayList<>();

		this.viajesPendientes = 0;
		this.viajesPublicados = 0;
		this.viajesEnProceso = 0;
		this.viajesTerminados = 0;

		for (Pedido pedido : pedidos) {
			switch (pedido.getViaje().getEstado().getId()) {
				case 1:
					pedidosPend.add(pedido);
					if (estado == 1) {
						pedidosTemp.add(pedido);
					}
					break;
				case 2:
					pedidosPubl.add(pedido);
					if (estado == 2) {
						pedidosTemp.add(pedido);
					}
					break;
				case 3:
					pedidosEnPr.add(pedido);
					if (estado == 3) {
						pedidosTemp.add(pedido);
					}
					break;
				case 4:
					pedidosTerm.add(pedido);
					if (estado == 4) {
						pedidosTemp.add(pedido);
					}
					break;
			}
		}

		//Contadores de los filtros
		if (!pedidosPend.isEmpty()) {
			Set<Integer> conjunto = new HashSet<Integer>();
			for (Pedido pedido : pedidosPend) {
				conjunto.add(pedido.getViaje().getId());
			}
			viajesPendientes = conjunto.size();
		}

		if (!pedidosPubl.isEmpty()) {
			Set<Integer> conjunto = new HashSet<Integer>();
			for (Pedido pedido : pedidosPubl) {
				conjunto.add(pedido.getViaje().getId());
			}
			viajesPublicados = conjunto.size();
		}

		if (!pedidosEnPr.isEmpty()) {
			Set<Integer> conjunto = new HashSet<Integer>();
			for (Pedido pedido : pedidosEnPr) {
				conjunto.add(pedido.getViaje().getId());
			}
			viajesEnProceso = conjunto.size();
		}

		if (!pedidosTerm.isEmpty()) {
			Set<Integer> conjunto = new HashSet<Integer>();
			for (Pedido pedido : pedidosTerm) {
				conjunto.add(pedido.getViaje().getId());
			}
			viajesTerminados = conjunto.size();
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
			dir = new Direccion(bean.getCalle(), bean.getPuerta(), "0", bean.getEsquina(), -34.9166122d, -56.1568794d);
		} else {
			dir = new Direccion(bean.getCalle(), bean.getPuerta(), bean.getApartamento(), bean.getEsquina(), -34.9166122d, -56.1568794d);
		}

		Cliente cli = new Cliente(bean.getNombre(), dir, bean.getTelefono());

		Pedido ped = new Pedido(bean.getAclaraciones(), "E", cli);

		pedidos.add(ped);
	}
}
