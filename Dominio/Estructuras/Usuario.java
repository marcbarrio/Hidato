package Dominio.Estructuras;

/**
 *
 * @author Raúl Ibáñez Pérez
 */
public class Usuario {
    private String nombre;
    private String contrasena;
    private int puntuacionTotal;
    
    
    public Usuario() {}
    
    public Usuario(String n, String c) {
        this.nombre = n;
        this.contrasena = c;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getContrasena(){
        return this.contrasena;
    }
    
    public int getPuntuacionTotal(){
        return this.puntuacionTotal;
    }
    
    public void setPuntuacionTotal(int p){
        this.puntuacionTotal = p;
    }
    
    public void setNombre(String n) {
        this.nombre = n;
    }
    
    public void setContrasena(String c) {
        this.contrasena = c;
    }
}
