/**
 *
 * @author Raúl Ibáñez Pérez
 */
package Persistencia;
import java.util.*;

public class ControladorPersistencia {
    
    ControladorDatosUsuario CDUsuario = new ControladorDatosUsuario();
    
    /*   CREADORAS   */
    
    /*  PRE: -
        POST: Inicialización de la clase, que se deja vacía
    */
    public ControladorPersistencia() {
        
    }
    
    /*   FUNCIONES CON USUARIO   */
    
    /*  PRE: -
        POST: devuelve true si s es un usuario que ya existe y false si no.
    */
    public boolean nombreUsuarioExistente(String s){
        return this.CDUsuario.nombreUsuarioExistente(s);
    }
    
    /*  PRE: -
        POST: crea un usuario con nombre n y contraseña c.
    */
    public void crearUsuario(String n, String c){
        this.CDUsuario.crearUsuario(n,c);
    }
    
    /*  PRE: n es un nombre de usuario existente.
        POST: devuelve true si c es la contraseña de usuario n y false si no lo es.
    */
    public boolean contrasenaValida(String n, String c){
        return this.CDUsuario.contrasenaValida(n,c);
    }
    
    /*  PRE: n es un nombre de usuario existente.
        POST: devuelve la puntuacion del usuario con nombre n,
    */
    public int cargarPuntuacionUsuario(String n){
        return this.CDUsuario.cargarPuntuacionUsuario(n);
    }
    
    /*  PRE: n es un nombre de usuario existente.
        POST: devuelve el boolean apareceRanking del usuario con nobre n.
    */
    public boolean cargarApareceRankingUsuario(String n){
        return this.CDUsuario.cargarApareceRankingUsuario(n);
    }
    
    /*  PRE: n es un nombre de usuario existente.
        POST: devuelve la fecha de creacion del usuario con nombre n.
    */
    public Date cargarFechaUsuario(String n){
        return this.CDUsuario.cargarFechaUsuario(n);
    }
    
    /*  PRE: n es un nombre de usuario existente.
        POST: se borran todos los datos del usuario con nombre n.
    */
    public void borrarUsuario(String n){
        this.CDUsuario.borrarUsuario(n);
    }
    
    /*  PRE: n es un nombre de usuario existente.
        POST: guarda todos los datos en el usuario con nombre n.
    */
    public void guardarUsuario(String n,int p,boolean b, Date d){
        this.CDUsuario.guardarUsuario(n,p,b,d);
    }
    
}
