/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.configuration;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bruno
 */
public class Parametros {

	public static String ESTADO_DEFAULT = "2";
	public static String ESTADO_PENDIENTE = "1";
	public static String ESTADO_PUBLICADO = "2";
	public static String ESTADO_ENPROCESO = "3";
	public static String ESTADO_TERMINADO = "4";

	public static String HISTORIALVIAJE_EXCEL_TOPE = "10000";
	public static String HISTORIALVIAJE_EXCEL_FECHA_DESDE = "";
	public static String DIA_DEFAULT = "2000-01-01";
	public static String SEPARADOR_FECHA = " - ";

	public static String URL_DELIVERY = "/delivery/";
	public static String URL_CALIFICAR = "/calificar/";

	public static String DEPARTAMENTO = "Montevideo";
	public static String PAIS = "Uruguay";
	public static int HORA_PADING_SERVER = 3;

	public static String[] COLORES_MARKADORES = {"blue", "brown", "gray", "green", "orange", "purple", "red", "yellow"};
	public static String UBICACION_MARKADORES = "resources/img/iconosMaps/";
	public static String EXTENSION_MARKADORES = ".png";
	public static String UBICACION_MOTO = "resources/img/moto.png";
	public static int ZOOM_MAPA = 14;
	public static String IDENTIFICADOR_JS = "#";

	private static Map<String, String> PAGINATE;

	static {
		PAGINATE = new HashMap<>();
		PAGINATE.put("first", "<<");
		PAGINATE.put("previous", "<");
		PAGINATE.put("next", ">");
		PAGINATE.put("last", ">>");
	}

	private static Map<Object, Object> LANGUAJE_VIAJE;

	static {
		LANGUAJE_VIAJE = new HashMap<>();
		LANGUAJE_VIAJE.put("processing", "Procesando");
		LANGUAJE_VIAJE.put("search", "Busqueda&nbsp;:");
		LANGUAJE_VIAJE.put("lengthMenu", "Mostrar _MENU_ viajes");
		LANGUAJE_VIAJE.put("info", "");
		LANGUAJE_VIAJE.put("infoEmpty", "Ningun viaje");
		LANGUAJE_VIAJE.put("infoFiltered", "");
		LANGUAJE_VIAJE.put("infoPostFix", "");
		LANGUAJE_VIAJE.put("loadingRecords", "Cargando viajes...");
		LANGUAJE_VIAJE.put("zeroRecords", "No se han encontrado viajes");
		LANGUAJE_VIAJE.put("emptyTable", "No hay viajes hoy");
		LANGUAJE_VIAJE.put("paginate", PAGINATE);
	}
	public static Map<Object, Object> DATATABLE_OPCIONES_VIAJE;

	static {
		DATATABLE_OPCIONES_VIAJE = new HashMap<>();
		DATATABLE_OPCIONES_VIAJE.put("sScrollX", "110%");
		DATATABLE_OPCIONES_VIAJE.put("sScrollXInner", "110%");
		DATATABLE_OPCIONES_VIAJE.put("language", LANGUAJE_VIAJE);
	}

	private static Map<Object, Object> LANGUAJE_CLIENTE;

	static {
		LANGUAJE_CLIENTE = new HashMap<>();
		LANGUAJE_CLIENTE.put("processing", "Procesando");
		LANGUAJE_CLIENTE.put("search", "Busqueda&nbsp;:");
		LANGUAJE_CLIENTE.put("lengthMenu", "Mostrar _MENU_ clientes");
		LANGUAJE_CLIENTE.put("info", "");
		LANGUAJE_CLIENTE.put("infoEmpty", "Ningun cliente.");
		LANGUAJE_CLIENTE.put("infoFiltered", "");
		LANGUAJE_CLIENTE.put("infoPostFix", "");
		LANGUAJE_CLIENTE.put("loadingRecords", "Cargando clientes...");
		LANGUAJE_CLIENTE.put("zeroRecords", "No se han encontrado clientes");
		LANGUAJE_CLIENTE.put("emptyTable", "No hay clientes");
		LANGUAJE_CLIENTE.put("paginate", PAGINATE);
	}
	public static Map<Object, Object> DATATABLE_OPCIONES_CLIENTE;

	static {
		DATATABLE_OPCIONES_CLIENTE = new HashMap<>();
		DATATABLE_OPCIONES_CLIENTE.put("language", LANGUAJE_CLIENTE);
	}

	private static Map<Object, Object> LANGUAJE_DELIVERY;

	static {
		LANGUAJE_DELIVERY = new HashMap<>();
		LANGUAJE_DELIVERY.put("processing", "Procesando");
		LANGUAJE_DELIVERY.put("search", "Busqueda&nbsp;:");
		LANGUAJE_DELIVERY.put("lengthMenu", "Mostrar _MENU_ deliverys");
		LANGUAJE_DELIVERY.put("info", "");
		LANGUAJE_DELIVERY.put("infoEmpty", "Ningun delivery.");
		LANGUAJE_DELIVERY.put("infoFiltered", "");
		LANGUAJE_DELIVERY.put("infoPostFix", "");
		LANGUAJE_DELIVERY.put("loadingRecords", "Cargando deliverys...");
		LANGUAJE_DELIVERY.put("zeroRecords", "No se han encontrado deliverys");
		LANGUAJE_DELIVERY.put("emptyTable", "No hay deliverys");
		LANGUAJE_DELIVERY.put("paginate", PAGINATE);
	}
	public static Map<Object, Object> DATATABLE_OPCIONES_DELIVERY;

	static {
		DATATABLE_OPCIONES_DELIVERY = new HashMap<>();
		DATATABLE_OPCIONES_DELIVERY.put("language", LANGUAJE_DELIVERY);
	}

		private static Map<Object, Object> LANGUAJE_HISTVIAJE;

	static {
		LANGUAJE_HISTVIAJE = new HashMap<>();
		LANGUAJE_HISTVIAJE.put("processing", "Procesando");
		LANGUAJE_HISTVIAJE.put("search", "Busqueda&nbsp;:");
		LANGUAJE_HISTVIAJE.put("lengthMenu", "Mostrar _MENU_ viajes");
		LANGUAJE_HISTVIAJE.put("info", "");
		LANGUAJE_HISTVIAJE.put("infoEmpty", "Ningun viaje.");
		LANGUAJE_HISTVIAJE.put("infoFiltered", "");
		LANGUAJE_HISTVIAJE.put("infoPostFix", "");
		LANGUAJE_HISTVIAJE.put("loadingRecords", "Cargando viajes...");
		LANGUAJE_HISTVIAJE.put("zeroRecords", "No se han encontrado viajes");
		LANGUAJE_HISTVIAJE.put("emptyTable", "No hay viajes");
		LANGUAJE_HISTVIAJE.put("paginate", PAGINATE);
	}
	public static Map<Object, Object> DATATABLE_OPCIONES_HISTVIAJE;

	static {
		DATATABLE_OPCIONES_HISTVIAJE = new HashMap<>();
		DATATABLE_OPCIONES_HISTVIAJE.put("language", LANGUAJE_HISTVIAJE);
	}

	public static double DEFAULT_LATITUDE = -34.9082249;
	public static double DEFAULT_LONGITUDE = -56.1664964;

	public static String NOMBRE_TABLA_PRINCIPAL = "pedidos";
	public static String NOMBRE_TABLA_CLIENTE = "clientes";
	public static String NOMBRE_TABLA_DELIVERY = "deliverys";
	public static String NOMBRE_TABLA_HISTVIAJE = "";
}
