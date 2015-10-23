/**
 *
 * @author Raúl Ibáñez Pérez
 */
package Persistencia;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParsePosition;
public class ControladorPersistencia {
    ControladorDatosUsuario CDUsuario = new ControladorDatosUsuario();
    /*  PRE: -
        POST: Inicialización de la clase, que se deja vacía
    */
    public ControladorPersistencia() {
        
    }
    
    public boolean nombreUsuarioExistente(String s){
        
        return this.CDUsuario.nombreUsuarioExistente(s);
    }
    
    public void crearUsuario(String n, String c){
        this.CDUsuario.crearUsuario(n,c);
    }
    
    /* PRE: n es un nombre de usuario válido.
    
    */
    public boolean contrasenaValida(String n, String c){
        
        return this.CDUsuario.contrasenaValida(n,c);
                
    }
    
    /* PRE: n es un nombre de usuario válido.
    
    */
    public int cargarPuntuacionUsuario(String n){
        
        return this.CDUsuario.cargarPuntuacionUsuario(n);
    }
    
    /* PRE: n es un nombre de usuario válido.
    
    */
    public boolean cargarApareceRankingUsuario(String n){
        
        return this.CDUsuario.cargarApareceRankingUsuario(n);
    }
    
    public Date cargarFechaUsuario(String n){
                
        return this.CDUsuario.cargarFechaUsuario(n);
    }
    
    /* PRE: n es un nombre de usuario válido.
    
    */
    public void borrarUsuario(String n){
        this.CDUsuario.borrarUsuario(n);
    }
    
    public void guardarUsuario(String n,int p,boolean b, Date d){
        
        this.CDUsuario.guardarUsuario(n,p,b,d);
                
    }
    
}
