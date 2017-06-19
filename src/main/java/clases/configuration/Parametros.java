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
	private static Map<String, String> PAGINATE;

	static {
		PAGINATE = new HashMap<>();
		PAGINATE.put("first", "<<");
		PAGINATE.put("previous", "<");
		PAGINATE.put("next", ">");
		PAGINATE.put("last", ">>");
	}

	private static Map<Object, Object> LANGUAGE;

	static {
		LANGUAGE = new HashMap<>();
		LANGUAGE.put("processing", "Procesando");
		LANGUAGE.put("search", "Busqueda&nbsp;:");
		LANGUAGE.put("lengthMenu", "Mostrar _MENU_ viajes");
		LANGUAGE.put("info", "");
		LANGUAGE.put("infoEmpty", "Ningun viaje");
		LANGUAGE.put("infoFiltered", "");
		LANGUAGE.put("infoPostFix", "");
		LANGUAGE.put("loadingRecords", "Cargando viajes...");
		LANGUAGE.put("zeroRecords", "No se han encontrado viajes");
		LANGUAGE.put("emptyTable", "No hay viajes hoy");
		LANGUAGE.put("paginate", PAGINATE);
	}
	public static Map<Object, Object> OPCIONES;

	static {
		OPCIONES = new HashMap<>();
		OPCIONES.put("sScrollX", "110%");
		OPCIONES.put("sScrollXInner", "110%");
		OPCIONES.put("language", LANGUAGE);
	}
	
	public static double DEFAULT_LATITUDE = -34.9082249;
	public static double DEFAULT_LONGITUDE = -56.1664964;
}