/**
 * Interfaz del Control de Acceso.
 */
package clases.accesControl;

import clases.dominio.Usuario;

public interface ACIUserService {
	void save(Usuario user);
	
	Usuario findByUsername(String username);
}
