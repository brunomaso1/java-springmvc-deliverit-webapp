/**
 * Implementa la interfaz User Service.
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
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	private final static Logger LOGGER = Logger.getLogger(ACUserServiceImpl.class.getName());

	/**
 	 * Guarda el usuario hasheando la contraseña con BCrypt.
	 */
	@Override
	public void save(Usuario user) {
		// Para hashear el pasword andes de guardarlo.
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		RestTemplate restTemplate = new RestTemplate();
		RespuestaGeneral rgUsr = restTemplate.postForObject(Configuration.restUsuarioPost(), user, RespuestaGeneral.class);
		if (rgUsr.getCodigo() == RespuestaGeneral.CODIGO_OK) {
			LOGGER.log(Level.FINEST, "Se inserto el usuario correctamente.");
		} else {
			LOGGER.log(Level.SEVERE, "No se pudo el usuario -> ", rgUsr.getCodigo() + " " + rgUsr.getMensaje());
		}
	}

	/**
	 * Obtiene el usuario de la API. Deuvelve null en caso de que no se encuentre.
	 */
	@Override
	public Usuario findByUsername(String username) {
		RestTemplate restTemplate = new RestTemplate();
		Usuario usr = restTemplate.getForObject(Configuration.restUsuarioGetByName(username), Usuario.class);
		return usr;
	}
}