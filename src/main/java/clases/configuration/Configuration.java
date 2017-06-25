package clases.configuration;

import java.util.Date;

public final class Configuration {

	private static final String ambienteJuan = "http://192.168.43.15:8080/BackCore/ws/";

	private static final String ambienteBruno = "http://localhost:32794/BackCore/ws/";

	private static final String test = "http://localhost:38526/backcore/ws/";

	private static final String produccion = "http://localhost:38526/backcore/ws/";

	private static String ambiente = ambienteBruno;

	public static String restFindPedidosTodayGet(String sucursal) {
		return ambiente + "sucursal/findPedidosToday/" + sucursal;
	}

	public static String restFindPedidosGet(String sucursal) {
		return ambiente + "sucursal/findPedidos/" + sucursal;
	}

	public static String restFindViajesGet(String sucursal) {
		return ambiente + "sucursal/findViajes/" + sucursal;
	}

	public static String restViajeGet() {
		return ambiente + "viaje";
	}

	public static String restViajeGet(Date fechaDesde, Date fechaHasta) {
		return ambiente + "viaje/" + fechaDesde.toString() + "/" + fechaHasta.toString();
	}

	public static String restViajePost() {
		return ambiente + "viaje";
	}

	public static String restDireccionGet() {
		return ambiente + "direccion";
	}

	public static String restDireccionPost() {
		return ambiente + "direccion";
	}

	public static String restClienteGet() {
		return ambiente + "cliente";
	}

	public static String restClientePost() {
		return ambiente + "cliente";
	}

	public static String restClienteTelefonoGet() {
		return ambiente + "clientetelefono";
	}

	public static String restClienteTelefonoPost() {
		return ambiente + "clientetelefono";
	}

	public static String restPedidoGet() {
		return ambiente + "pedido";
	}

	public static String restPedidoPost() {
		return ambiente + "pedido";
	}

	public static String restSucursalGet(String sucursal) {
		//return ambiente + "sucursal/1;" + "id=" + sucursal + ";" + "restaurant=" + restaurant;
		return ambiente + "sucursal/" + sucursal;
	}

	public static String restUsuarioGet() {
		return ambiente + "usuario";
	}

	public static String restUsuarioPost() {
		return ambiente + "usuario";
	}

	public static String restUsuarioGetByName(String username) {
		return ambiente + "usuario/findUserByName/" + username;
	}

	public static String restFindClientesGet(String sucursalId) {
		return ambiente + "cliente/findBySucursal/" + sucursalId;
	}

	public static String restFindDeliverysGet(String sucursalId) {
		return ambiente + "delivery/findBySucursal/" + sucursalId;
	}

	public static String restCountPedidosViaje(String viajeId) {
		return ambiente + "viaje/countPedidos/" + viajeId;
	}
	
	public static String restUbicacionDelivery(String deliveryId){
		return ambiente + "delivery/getUbicacion/" + deliveryId;
	}
	
	public static String restFindDeliverysEnProceso(String sucursalId){
		return ambiente + "viaje/findDeliverysEnProceso/" + sucursalId;
	}
	
	public static String restCalificarDelivery(String idViaje, String calificacion){
		return ambiente + "viaje/calificar/" + idViaje + "/" + calificacion;
	}
}
