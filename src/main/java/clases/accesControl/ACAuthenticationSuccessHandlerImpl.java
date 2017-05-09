/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.accesControl;

import static clases.configuration.Parametros.ESTADO_DEFAULT;
import static clases.configuration.Parametros.RESTAURANT_DEFAULT;
import static clases.configuration.Parametros.SUCURSAL_DEFAULT;
import clases.viaje.ViajeController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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
			LOGGER.log(Level.SEVERE, "Response has already been committed. Unable to redirect to "
					+ targetUrl);
			return;
		}
		
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication) {
//		boolean isUser = false;
//		boolean isAdmin = false;
//		Collection<? extends GrantedAuthority> authorities
//				= authentication.getAuthorities();
//		for (GrantedAuthority grantedAuthority : authorities) {
//			if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
//				isUser = true;
//				break;
//			} else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
//				isAdmin = true;
//				break;
//			}
//		}
//
//		if (isUser) {
//			return "/homepage.html";
//		} else if (isAdmin) {
//			return "/console.html";
//		} else {
//			throw new IllegalStateException();
//		}
		return "/viaje.html";
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		session.setAttribute("SUCURSAL_ID", SUCURSAL_DEFAULT);
		session.setAttribute("RESTAURANT_ID", RESTAURANT_DEFAULT);
		session.setAttribute("ESTADO_ID", ESTADO_DEFAULT);
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
}