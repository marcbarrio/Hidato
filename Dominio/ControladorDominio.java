/**
 *
 * @author Hamid Latif
 */
package Dominio;
import Persistencia.ControladorPersistencia;

public class ControladorDominio {
    ControladorPersistencia Persistencia = new ControladorPersistencia();
    
    /*  PRE: -
        POST: La clase queda inicializada
    */
    public ControladorDominio() {}
        
    /*  PRE: -
    POST: Se retorna true si eltablero es válido y falsosiel tablero es inválido
    */
    public boolean inciar_sesion(String nombre, String contrasena) {
        return Persistencia.iniciar_sesion(nombre, contrasena);
    }
}
