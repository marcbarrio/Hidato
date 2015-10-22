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
        this.usuario = new Usuario(n,c);
        int auxPuntuacion = this.usuario.getPuntuacionTotal();
        boolean auxRanking = this.usuario.getApareceRanking();
        CPersistencia.crearBDUsuario(n, auxPuntuacion, auxRanking);
    }
    
    public boolean nombreExistente(String n){
        return CPersistencia.nombreExistente(n);
    }
    
    public boolean contrasenaValida(String n, String c){
        return CPersistencia.contrasenaValida(n,c);
    }
    
    /* PRE: n es un nombre de usuario válido y c es su contraseña
    
    */
    public void loginUsuario(String n, String c){
        this.usuario = new Usuario();
        this.usuario.setNombre(n);
        this.usuario.setContrasena(c);
        this.usuario.setPuntuacionTotal(CPersistencia.cargarPuntuacionUsuario(n));
        this.usuario.setApareceRanking(CPersistencia.cargarApareceRankingUsuario(n));
    }
    
    public int getPuntuacionUsuario(){
        return usuario.getPuntuacionTotal();
    }
    
    public boolean getApareceRanking(){
        return this.usuario.getApareceRanking();
    }
    
    /* PRE: el usuario debe estar inicializado.
    
    */
    public void guardarDatosUsuario(){
        //CPersistencia.guardarDatosUsuario(this.usuario.getNombre());
    }
    
    /* PRE: el usuario debe estar inicializado.
    
    */
    public void borrarUsuario(){
        CPersistencia.borrarUsuario(this.usuario.getNombre());
    }
    
    /* PRE: el usuario debe estar inicializado.
    
    */
    public void noAparecerRanking(){
        
    }
    
    public void jugarInvitado(){
        
    }
    
    public void jugar(){
        
    }
    
    public void toggleApareceRanking(){
        this.usuario.toggleApareceRanking();
        String auxNombre = this.usuario.getNombre();
        int auxPuntuacion = this.usuario.getPuntuacionTotal();
        boolean auxRanking = this.usuario.getApareceRanking();
        CPersistencia.guardarUsuario(auxNombre,auxPuntuacion,auxRanking);
    }
    
}
