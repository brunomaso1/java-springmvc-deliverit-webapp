/**
 * Interfaz del Control de Acceso
 */
package clases.accesControl;

public interface ACISecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
