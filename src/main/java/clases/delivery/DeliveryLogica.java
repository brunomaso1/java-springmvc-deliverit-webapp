/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.delivery;

import clases.configuration.Configuration;
import clases.dominio.Delivery;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author bruno
 */
class DeliveryLogica {

	public Delivery[] getDeliverys() {
		RestTemplate rt = new RestTemplate();
		Delivery[] del = rt.getForObject(Configuration.restDeliveryGet(), Delivery[].class);
		return del;
	}	
}
