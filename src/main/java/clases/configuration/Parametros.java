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
	public static String URL_OBTENERPEDIDOSTABLA = "/obtenerViajesTabla/";

	public static String DEPARTAMENTO = "Montevideo";
	public static String PAIS = "Uruguay";
	public static int SERVERHOURPADDING = 3;

	public static String[] COLORES_MARKADORES = {"blue", "brown", "gray", "green", "orange", "purple", "red", "yellow"};
	public static String UBICACION_MARKADORES = "resources/img/iconosMaps/";
	public static String EXTENSION_MARKADORES = ".png";
	public static String UBICACION_MOTO = "resources/img/moto.png";
	public static int ZOOM_MAPA = 14;
	public static String IDENTIFICADOR_JS = "#";

	public static double DEFAULT_LATITUDE = -34.9082249;
	public static double DEFAULT_LONGITUDE = -56.1664964;
	public static String DEFAULT_CALIFICACION_VIAJE = "3";

	public static String NOMBRE_TABLA_VIAJE = "viajes";
	public static String NOMBRE_TABLA_CLIENTE = "clientes";
	public static String NOMBRE_TABLA_DELIVERY = "deliverys";
	public static String NOMBRE_TABLA_HISTVIAJE = "viajes";
	public static String NOMBRE_CHART_DONUT = "chartDona";
	public static String NOMBRE_CHART_LINE = "chartLinea";
	public static String NOMBRE_CHART_BAR = "chartBaras";
	public static String NOMBRE_MAPA_VIAJE = "map";

	public static String DATATABLE_SINDATOS = "No hay datos.";
	public static String DATATABLE_SINDATOSBUSQUEDA = "No se han encontrado datos.";

	public static int TIEMPOACTIVACIONCAMBIOCOLORES = 5000;
	public static int MARKERBOUNCETIMEOUT = 3000; //Milisegundos.
	public static int ZOOMRESALTARMARKADOR = 17;
	public static int TIMEOUTRESALTARMARKADOR = 3000; // Milisegundos.
	public static int ACTUALIZARDELIVERYSTIME = 5000; // Milisegundos.
	public static int TIEMPOACTIVACIONUPDATES = 2000;

	public static Map<Object, Object> NOMBREFILTROS;

	static {
		NOMBREFILTROS = new HashMap<>();
		NOMBREFILTROS.put("filtroPendiende", "filtroPendiende");
		NOMBREFILTROS.put("filtroPublicado", "filtroPublicado");
		NOMBREFILTROS.put("filtroProceso", "filtroProceso");
		NOMBREFILTROS.put("filtroTerminado", "filtroTerminado");
		NOMBREFILTROS.put("backgroundColorFiltros", "#000000");
	}

	public static Map<Object, Object> TIEMPOCOLORES;

	static {
		TIEMPOCOLORES = new HashMap<>();
		TIEMPOCOLORES.put("tiempo1", 60); // 1 minuto
		TIEMPOCOLORES.put("tiempo2", 120); // 2 minutos
		TIEMPOCOLORES.put("tiempo3", 240); // 4 minutos
		TIEMPOCOLORES.put("tiempo4", 480); // 8 minutos

		TIEMPOCOLORES.put("colorTiempo2", "#ffe6e6");
		TIEMPOCOLORES.put("colorTiempo3", "#ff9999");
		TIEMPOCOLORES.put("colorTiempo4", "#ff6666");
		TIEMPOCOLORES.put("colorTiempoDefault", "#ff1a1a");
	}

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
		LANGUAJE_VIAJE.put("infoEmpty", DATATABLE_SINDATOS);
		LANGUAJE_VIAJE.put("infoFiltered", "");
		LANGUAJE_VIAJE.put("infoPostFix", "");
		LANGUAJE_VIAJE.put("loadingRecords", "Cargando viajes...");
		LANGUAJE_VIAJE.put("zeroRecords", DATATABLE_SINDATOSBUSQUEDA);
		LANGUAJE_VIAJE.put("emptyTable", DATATABLE_SINDATOS);
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
		LANGUAJE_CLIENTE.put("infoEmpty", DATATABLE_SINDATOS);
		LANGUAJE_CLIENTE.put("infoFiltered", "");
		LANGUAJE_CLIENTE.put("infoPostFix", "");
		LANGUAJE_CLIENTE.put("loadingRecords", "Cargando clientes...");
		LANGUAJE_CLIENTE.put("zeroRecords", DATATABLE_SINDATOSBUSQUEDA);
		LANGUAJE_CLIENTE.put("emptyTable", DATATABLE_SINDATOS);
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
		LANGUAJE_DELIVERY.put("infoEmpty", DATATABLE_SINDATOS);
		LANGUAJE_DELIVERY.put("infoFiltered", "");
		LANGUAJE_DELIVERY.put("infoPostFix", "");
		LANGUAJE_DELIVERY.put("loadingRecords", "Cargando deliverys...");
		LANGUAJE_DELIVERY.put("zeroRecords", DATATABLE_SINDATOSBUSQUEDA);
		LANGUAJE_DELIVERY.put("emptyTable", DATATABLE_SINDATOS);
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
		LANGUAJE_HISTVIAJE.put("infoEmpty", DATATABLE_SINDATOS);
		LANGUAJE_HISTVIAJE.put("infoFiltered", "");
		LANGUAJE_HISTVIAJE.put("infoPostFix", "");
		LANGUAJE_HISTVIAJE.put("loadingRecords", "Cargando viajes...");
		LANGUAJE_HISTVIAJE.put("zeroRecords", DATATABLE_SINDATOSBUSQUEDA);
		LANGUAJE_HISTVIAJE.put("emptyTable", DATATABLE_SINDATOS);
		LANGUAJE_HISTVIAJE.put("paginate", PAGINATE);
	}
	public static Map<Object, Object> DATATABLE_OPCIONES_HISTVIAJE;

	static {
		DATATABLE_OPCIONES_HISTVIAJE = new HashMap<>();
		DATATABLE_OPCIONES_HISTVIAJE.put("language", LANGUAJE_HISTVIAJE);
	}

	public static Map<Object, Object> CHART_OPCIONES_DONUT;

	static {
		CHART_OPCIONES_DONUT = new HashMap<>();
		CHART_OPCIONES_DONUT.put("element", NOMBRE_CHART_DONUT);
		CHART_OPCIONES_DONUT.put("data", "ESPECIFICAR");
	}

	public static Map<Object, Object> CHART_OPCIONES_LINE;

	static {
		CHART_OPCIONES_LINE = new HashMap<>();
		CHART_OPCIONES_LINE.put("element", NOMBRE_CHART_LINE);
		CHART_OPCIONES_LINE.put("data", "ESPECIFICAR");
	}

	public static Map<Object, Object> CHART_OPCIONES_BAR;

	static {
		CHART_OPCIONES_BAR = new HashMap<>();
		CHART_OPCIONES_BAR.put("element", NOMBRE_CHART_BAR);
		CHART_OPCIONES_BAR.put("data", "ESPECIFICAR");
	}

	public static Map<Object, Object> MENSAJES;

	static {
		MENSAJES = new HashMap<>();
		MENSAJES.put("geolocalizacion", "El navegador no soporta la geolocalizacion, no se puede obtener su ubicacion.");
		MENSAJES.put("sinDatos", DATATABLE_SINDATOS);
		MENSAJES.put("sinDatosBusqueda", DATATABLE_SINDATOSBUSQUEDA);
	}

	public static Map<Object, Object> ICONSIZE;
	static {
		ICONSIZE = new HashMap<>();
		ICONSIZE.put("altura", 25);
		ICONSIZE.put("ancho", 35);
	}

	public static Map<Object, Object> LABELORIGIN;
	static {
		LABELORIGIN = new HashMap<>();
		LABELORIGIN.put("altura", 12);
		LABELORIGIN.put("ancho", 12);
		LABELORIGIN.put("color", "black");
	}
}
