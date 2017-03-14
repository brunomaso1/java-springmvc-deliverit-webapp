package clases.configuration;

public final class Configuration {
	
	private static final String ambienteJuan = "http://10.4.1.214:8080/BackCore/ws/";
	
	private static final String ambienteBruno = "http://localhost:38526/backcore/ws/";
	
	private static final String test = "http://localhost:38526/backcore/ws/";
	
	private static final String produccion = "http://localhost:38526/backcore/ws/";
	
	private static String ambiente = ambienteBruno;
	
	public static String restFindPedidosGet(String restaurant, String sucursal) {
		return ambiente + "sucursal/findPedidos/" + restaurant + "/" + sucursal;
	}
	
	public static String restViajeGet() {
		return ambiente + "viaje";
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
	
	public static String restSucursalGet(String restaurant, String sucursal) {
		return ambiente + "sucursal/1;" + "id=" + sucursal + ";" + "restaurant=" + restaurant;
	}
}