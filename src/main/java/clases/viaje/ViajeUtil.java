/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.viaje;

import org.springframework.web.client.RestTemplate;
import dominio.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.HttpMethod;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author bruno
 */
public class ViajeUtil {

	public String popularTabla(String sucursal, String restaurant) {
		String tabla = "";
		Viaje[] viajes = obtenerViajes(sucursal, restaurant);
		String[][] viajesParseados = parsearViajes(viajes);
		for (String[] viajesParseado : viajesParseados) {
			tabla += "<tr>";
			for (String string : viajesParseado) {
				tabla += "<td>" + string + "</td>";
			}
			tabla += "</tr>";
		}
		return tabla;
	}

	private Viaje[] obtenerViajes(String sucursal, String restaurant) {
		RestTemplate restTemplate = new RestTemplate();
		Viaje[] viajes = restTemplate.getForObject("http://192.168.1.43:8080/BackCore/ws/viaje/", Viaje[].class);
		return viajes;
	}

	private String[][] parsearViajes(Viaje[] viajes) {
		String[][] parser = new String[viajes.length][5];
		return parser;
	}
	
	public String test() { /*
		//Obtener todos los viajes
		RestTemplate restTemplate = new RestTemplate();
		Viaje[] viajes = restTemplate.getForObject("http://192.168.1.43:8080/BackCore/ws/viaje/", Viaje[].class);
		return viajes[1].toString();*/
		
		//Insertar viaje
		/*RestTemplate restTemplate = new RestTemplate();
		Viaje[] viajes = restTemplate.getForObject("http://192.168.1.43:8080/BackCore/ws/viaje/", Viaje[].class);
		Viaje insertarViaje = viajes[0];
		insertarViaje.setId(3);
		restTemplate.postForObject("http://192.168.1.43:8080/BackCore/ws/viaje", insertarViaje, Viaje.class);
		return "sdf";*/
		return "";
	}
}