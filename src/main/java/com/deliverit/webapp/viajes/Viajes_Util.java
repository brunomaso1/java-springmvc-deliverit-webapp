/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deliverit.webapp.viajes;

/**
 *
 * @author bruno
 */
public class Viajes_Util {
	
	public String popularTabla(String sucursal, String restaurant){
		String tabla = "";
		String[][] viajes = obtenerViajes(sucursal, restaurant);
		for (String[] viaje : viajes) {
			tabla += "<tr>";
			for (String string : viaje) {
				tabla += "<td>" + string + "</td>";
			}
			tabla += "</tr>";
		}
		return tabla;
	}
	
	private String[][] obtenerViajes(String sucursal, String restaurant) {
		return null;
	}
}
