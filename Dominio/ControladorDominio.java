/**
 *
 * @author Raúl Ibáñez Pérez
 */
package Dominio;
import java.util.*;
import Persistencia.ControladorPersistencia;
import Dominio.Estructuras.Usuario;
import Dominio.Estructuras.Tablero;

public class ControladorDominio {
    ControladorPersistencia CPersistencia = new ControladorPersistencia();
    Usuario usuario = new Usuario();
    
    /*  PRE: -
        POST: La clase queda inicializada
    */
    public ControladorDominio() {}
        
    /*  PRE: -
    POST: Se retorna true si eltablero es válido y falsosiel tablero es inválido
    */
    public boolean inciar_sesion(String nombre, String contrasena) {
        return CPersistencia.iniciar_sesion(nombre, contrasena);
    }
    
    public boolean nombreTableroValido(String s){
        return CPersistencia.nombreTableroValido(s);
    }
    
    public boolean nombreValido(String s){
        return (s.length() > 5 && (CPersistencia.nombreExistente(s) == false));
    }
    
    public boolean contrasenaValida(String c){
        return (c.length() < 6);
    }
    
    /* Pre: n es un nombre de usuario valido y c es una contraseña valida.
    */
    public void crearUsuario(String n, String c){
        CPersistencia.crearUsuario(n,c);
    }
    
    public boolean nombreExistente(String n){
        return CPersistencia.nombreExistente(n);
    }
    
    public boolean contrasenaValida(String n, String c){
        return CPersistencia.contrasenaValida(n,c);
    }
    
    public void escribirBDUsuarios(){
        CPersistencia.crearBDUsuarios();
    }
    
    /* PRE: n es un nombre de usuario válido y c es su contraseña
    
    */
    public void loginUsuario(String n, String c){
        usuario.setNombre(n);
        usuario.setContrasena(c);
        usuario.setPuntuacionTotal(CPersistencia.cargarPuntuacionUsuario(n));
    }
    
    public int getPuntuacionUsuario(){
        return usuario.getPuntuacionTotal();
    }
    
}
