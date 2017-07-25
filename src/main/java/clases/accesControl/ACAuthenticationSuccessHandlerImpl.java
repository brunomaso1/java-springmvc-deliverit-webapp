/**
 * Implementacion del funcionamiento cuando se ingresa correctamente.
 */
package clases.accesControl;

import static clases.configuration.Parametros.ESTADO_DEFAULT;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Implementación del funcionamiento cuando se ingresa correctamente a la aplicación.
 */
public class ACAuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	private final static Logger LOGGER = Logger.getLogger(ACAuthenticationSuccessHandlerImpl.class.getName());

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {

		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
	}

	protected void handle(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException {

		String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted()) {
			LOGGER.log(Level.SEVERE, "No se puede redirigir, la respuesta ya fue comiteada."
					+ targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	/**
	 * Determina hacia donde se debe redirigir segun el rol que ha ingresado.
	 */
	protected String determineTargetUrl(Authentication authentication) {
		/* // Para varios roles
		boolean isUser = false;
		boolean isAdmin = false;
		Collection<? extends GrantedAuthority> authorities
				= authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
				isUser = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
				break;
			}
		}

		if (isUser) {
			return "/homepage.html";
		} else if (isAdmin) {
			return "/console.html";
		} else {
			throw new IllegalStateException();
		} 
		 */
		return "/viaje.html";
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		
		// Guardo el estado que se deben filtrar los pedidos por defecto.
		session.setAttribute("ESTADO_ID", ESTADO_DEFAULT);
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
}
