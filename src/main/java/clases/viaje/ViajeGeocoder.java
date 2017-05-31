/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.viaje;

import clases.configuration.Parametros;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class ViajeGeocoder {

	private float lat;
	private float lng;

	public ViajeGeocoder(String calle, String puerta, String esquina) {
		String direccion = calle + " " + puerta + ", " + Parametros.DEPARTAMENTO + ", " + Parametros.PAIS;
		Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(direccion).getGeocoderRequest();
		GeocodeResponse geocoderResponse = null;
		try {
			geocoderResponse = geocoder.geocode(geocoderRequest);
		} catch (IOException ex) {
			Logger.getLogger(ViajeGeocoder.class.getName()).log(Level.SEVERE, null, ex);
		}
		List<GeocoderResult> results = geocoderResponse.getResults();
		lat = results.get(0).getGeometry().getLocation().getLat().floatValue();
		lng = results.get(0).getGeometry().getLocation().getLng().floatValue();
	}

	public float getLat() {
		return lat;
	}

	public float getLng() {
		return lng;
	}

}