/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.delivery;

import clases.dominio.Delivery;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author bruno
 */

@RestController
@RequestMapping(path = "/delivery")
public class DeliveryController {
	
	//Logger
	private final static Logger LOGGER = Logger.getLogger(DeliveryController.class.getName());

	private DeliveryLogica dl;

	public DeliveryController() {
		this.dl = new DeliveryLogica();
	}
	
	@GetMapping
	public Delivery[] doRequest(){
		return dl.getDeliverys();
	}
}