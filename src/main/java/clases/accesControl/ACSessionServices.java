/**
 * Servicios extra para el Control de Acceso.
 */
package clases.accesControl;

import clases.dominio.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author bruno
 */
public class ACSessionServices {
	
	public String getUserId(){
		//Obtener el usuario del SecurityContextHolder
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		
		ACIUserService acius = new ACUserServiceImpl();
		Usuario usr = acius.findByUsername(username);
		return usr.getId().toString();
	}	

	public String getUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		return username;
	}
}
