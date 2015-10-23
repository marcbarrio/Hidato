package Dominio.Estructuras;
import java.util.*;

/**
 *
 * @author Raúl Ibáñez Pérez
 */
public class Usuario {
    private String nombre;
    private String contrasena;
    private boolean apareceRanking;
    private Date fechaCreacion;
   
    
    
    public Usuario() {
        this.fechaCreacion = new Date();
    }
    
    public Usuario(String n, String c) {
        this.nombre = n;
        this.contrasena = c;
        this.apareceRanking = true;
        
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getContrasena(){
        return this.contrasena;
    }
    
    public void setApareceRanking(boolean b){
        this.apareceRanking = b;
    }
    
    public void setNombre(String n) {
        this.nombre = n;
    }
    
    public void setContrasena(String c) {
        this.contrasena = c;
    }
    
    public boolean getApareceRanking(){
        return this.apareceRanking;
    }
    
    public void toggleApareceRanking(){
        this.apareceRanking = !this.apareceRanking;
    }
    
    public Date getFecha(){
        return this.fechaCreacion;
    }
    
    public void setFecha(Date f){
        this.fechaCreacion = f;
    }
}
