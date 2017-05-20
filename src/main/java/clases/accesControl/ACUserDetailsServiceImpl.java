package clases.accesControl;

import clases.dominio.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;

public class ACUserDetailsServiceImpl implements UserDetailsService{

	/**
	 * Logea un usuario segun su nombre de usuario. En este punto es que se
	 * administran los roles que tiene habilitado ese usuario. 
	 */
    @Override
	@Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ACIUserService userService = new ACUserServiceImpl();
        Usuario user = userService.findByUsername(username);
		if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		// Para mas roles, se debe agregar en este HASH.
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(user.getNombre(), user.getPassword(), grantedAuthorities);
    }
}