/**
 * Aquesta classe soluciona i verifica els Hidatos.
 * @author Raúl Ibáñez Pérez
 */
package Dominio;
import Dominio.Estructuras.*;

public class ControladorHidato {
    
    /*  PRE: -
        POST: La clase queda inicializada.
    */
    public ControladorHidato() {}
    
    /*  PRE: -
    POST: Se retorna true si el nombre de usuario es correcto y false en caso contrario.
    */
    public boolean verificaHidato(TableroHidato th) {
        return false;
    }
    
    /*  PRE: - th es un TableroHidato valido.
    POST: Se devuelve una solución de th.
    */
    public TableroHidato solucionaHidato(TableroHidato th) {
        return th;
    }
    
    /*  PRE: - th es un TableroHidato valido.
    POST: Devuelve true si, con la situación actual th tiene solución y false en caso contrario.
    */
    public boolean teSolucio(TableroHidato th) {
        return false;
    }
    
}
