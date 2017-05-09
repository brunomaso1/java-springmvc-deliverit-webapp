/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.accesControl;

import clases.configuration.Configuration;
import clases.dominio.RespuestaGeneral;
import clases.dominio.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ACUserServiceImpl implements ACIUserService {
//	@Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

	private final static Logger LOGGER = Logger.getLogger(ACUserServiceImpl.class.getName());

	@Override
	public void save(Usuario user) {
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		RestTemplate restTemplate = new RestTemplate();
		RespuestaGeneral rgUsr = restTemplate.postForObject(Configuration.restUsuarioPost(), user, RespuestaGeneral.class);
		if (rgUsr.getCodigo() == RespuestaGeneral.CODIGO_OK) {
			LOGGER.log(Level.FINEST, "Se inserto el usuario correctamente.");
		} else {
			LOGGER.log(Level.SEVERE, "No se pudo el cliente -> ", rgUsr.getCodigo() + " " + rgUsr.getMensaje());
		}
	}

	@Override
	public Usuario findByUsername(String username) {
		RestTemplate restTemplate = new RestTemplate();
		Usuario usr = restTemplate.getForObject(Configuration.restUsuarioGetByName(username), Usuario.class);
		return usr;
	}
}