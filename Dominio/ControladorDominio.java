/**
 *
 * @author Raúl Ibáñez Pérez
 */
package Dominio;
import java.util.*;
import Persistencia.ControladorPersistencia;
import Dominio.Estructuras.UsuarioHidato;

public class ControladorDominio {
    
    ControladorPersistencia CPersistencia = new ControladorPersistencia();
    UsuarioHidato usuario = new UsuarioHidato();
    
    /*   CREADORAS DE USUARIO   */
    
    /*  PRE: -
        POST: La clase queda inicializada
    */
    public ControladorDominio() {}
    
    /*   CONSULTORAS DE USUARIO   */
    
    /*  PRE: -
        POST: devuelve true si el nombre es válido y no existe y false en caso contrario.
    */
    public boolean nombreValido(String s){
        int longitud = s.length();
        int i;
        for (i=0;i<longitud;++i){
            char a = s.charAt(i);
            if( a < 'a' || (a > 90 && a < 97) || a > 122 || a < 48 || a > 57 && a < 65){
                return false;
            }
        }
        return (s.length() > 5 && (this.nombreExistente(s) == false));
    }
    
    /*  PRE: -
        POST: Devuelve true si la contrasena cumple los requisitos y false si no.
    */
    public boolean contrasenaValida(String c){
        int longitud = c.length();
        int i;
        for (i=0;i<longitud;++i){
            char a = c.charAt(i);
            if( a < 'a' || (a > 90 && a < 97) || a > 122 || a < 48 || a > 57 && a < 65){
                return false;
            }
        }
        return (c.length() < 6);
    }
    
    /*  PRE: -
        POST: Devuelve true si el nombre existe en la base de datos y false si no.
    */
    public boolean nombreExistente(String n){
        return CPersistencia.nombreUsuarioExistente(n);
    }
    
    /*  PRE: n es un nombre de usuario válido.
        POST: devuelve trye si la contraseña es la contraseña del usuario y false en caso contrario.
    */
    public boolean contrasenaValida(String n, String c){
        return CPersistencia.contrasenaValida(n,c);
    }
    
    /*  PRE: hay un usuario no vacío cargado.
        POST: devuelve la puntuación total del usuario cargado.
    */
    public int getPuntuacionUsuario(){
        return this.usuario.getPuntuacionTotal();
    }
    
    /*  PRE: hay un usuario no vacío cargado..
        POST: devuelve la fecha de creacion del usuario cargado.
    */
    public Date getFechaCreacion(){
        return this.usuario.getFecha();
    }
    
    /*  PRE: hay un usuario no vacío cargado..
        POST: devuelve el boolean apareceRanking del usuario cargado.
    */
    public boolean getApareceRanking(){
        return this.usuario.getApareceRanking();
    }
    
    /*   MODIFICADORAS DE USUARIO   */
    
    /*  PRE: n es un nombre de usuario válido (no repetido).
        POST: Se crea un usuario nuevo con nombre = n y contraseña = c.
    */
    public void crearUsuario(String n, String c){
        CPersistencia.crearUsuario(n,c);
        String auxNombre = this.usuario.getNombre();
        int auxPuntuacion = this.usuario.getPuntuacionTotal();
        boolean auxRanking = this.usuario.getApareceRanking();
        Date auxFecha = this.usuario.getFecha();
        CPersistencia.guardarUsuario(n, auxPuntuacion, auxRanking, auxFecha);
    }
    
    /*  PRE: n es un nombre de usuario válido.
        POST: se carga el usuario con nombre = n y contraseña= c.
    */
    public void loginUsuario(String n, String c){
        this.usuario = new UsuarioHidato();
        this.usuario.setNombre(n);
        this.usuario.setContrasena(c);
        this.usuario.setPuntuacionTotal(CPersistencia.cargarPuntuacionUsuario(n));
        this.usuario.setApareceRanking(CPersistencia.cargarApareceRankingUsuario(n));
        this.usuario.setFecha(CPersistencia.cargarFechaUsuario(n));
    }
    
    /*  PRE: hay un usuario no vacío cargado.
        POST: niega el valor del boolean aoareceRanking del usuario cargado.
    */
    public void toggleApareceRanking(){
        this.usuario.toggleApareceRanking();
        String auxNombre = this.usuario.getNombre();
        int auxPuntuacion = this.usuario.getPuntuacionTotal();
        boolean auxRanking = this.usuario.getApareceRanking();
        Date auxFecha = this.usuario.getFecha();
        CPersistencia.guardarUsuario(auxNombre,auxPuntuacion,auxRanking,auxFecha);
    }
    
    /*  PRE: hay un usuario no vacío cargado.
        POST: guarda en la base de datos el usuario cargado.
    */
    public void guardarDatosUsuario(){
        //CPersistencia.guardarDatosUsuario(this.usuario.getNombre());
    }
    
    /*  PRE: hay un usuario no vacío cargado.
        POST: borra todos los datos del usuario cargado y se hace log out.
    */
    public void borrarUsuario(){
        CPersistencia.borrarUsuario(this.usuario.getNombre());
    }
    
    /*  PRE: 
        POST: 
    */
    
    /*   JUGAR   */
    
    public void jugarInvitado(){
        
    }
    
    /*  PRE: 
        POST: 
    */
    public void jugar(){
        
    }
    
}
