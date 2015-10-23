/**
 *
 * @author Raúl Ibáñez Pérez
 */
package Dominio;
import java.util.*;
import Persistencia.ControladorPersistencia;
import Dominio.Estructuras.UsuarioHidato;
import Dominio.Estructuras.Tablero;

public class ControladorDominio {
    ControladorPersistencia CPersistencia = new ControladorPersistencia();
    UsuarioHidato usuario = new UsuarioHidato();
    
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
        return (s.length() > 5 && (CPersistencia.nombreUsuarioExistente(s) == false));
    }
    
    public boolean contrasenaValida(String c){
        return (c.length() < 6);
    }
    
    /* Pre: n es un nombre de usuario valido y c es una contraseña valida.
    */
    public void crearUsuario(String n, String c){
        CPersistencia.crearUsuario(n,c);
        String auxNombre = this.usuario.getNombre();
        int auxPuntuacion = this.usuario.getPuntuacionTotal();
        boolean auxRanking = this.usuario.getApareceRanking();
        Date auxFecha = this.usuario.getFecha();
        CPersistencia.guardarUsuario(n, auxPuntuacion, auxRanking, auxFecha);
    }
    
    public boolean nombreExistente(String n){
        return CPersistencia.nombreUsuarioExistente(n);
    }
    
    public boolean contrasenaValida(String n, String c){
        return CPersistencia.contrasenaValida(n,c);
    }
    
    /* PRE: n es un nombre de usuario válido y c es su contraseña
    
    */
    public void loginUsuario(String n, String c){
        this.usuario = new UsuarioHidato();
        this.usuario.setNombre(n);
        this.usuario.setContrasena(c);
        this.usuario.setPuntuacionTotal(CPersistencia.cargarPuntuacionUsuario(n));
        this.usuario.setApareceRanking(CPersistencia.cargarApareceRankingUsuario(n));
        this.usuario.setFecha(CPersistencia.cargarFechaUsuario(n));
    }
    
    public int getPuntuacionUsuario(){
        return this.usuario.getPuntuacionTotal();
    }
    
    public Date getFechaCreacion(){
        return this.usuario.getFecha();
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
    
    public void jugarInvitado(){
        
    }
    
    public void jugar(){
        
    }
    
    public void toggleApareceRanking(){
        this.usuario.toggleApareceRanking();
        String auxNombre = this.usuario.getNombre();
        int auxPuntuacion = this.usuario.getPuntuacionTotal();
        boolean auxRanking = this.usuario.getApareceRanking();
        Date auxFecha = this.usuario.getFecha();
        CPersistencia.guardarUsuario(auxNombre,auxPuntuacion,auxRanking,auxFecha);
    }
    
}
