/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.accesControl;

import clases.dominio.Usuario;

/**
 *
 * @author bruno
 */
public interface ACIUserService {
	void save(Usuario user);
	
	Usuario findByUsername(String username);
}
