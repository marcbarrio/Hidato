package Dominio.Estructuras;

/**
 *
 * @author Raúl Ibáñez Pérez
 */
public class Usuario {
    private String nombre;
    private String contrasena;
    private int puntuacionTotal;
    private boolean apareceRanking;
    
    
    public Usuario() {}
    
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
    
    public int getPuntuacionTotal(){
        return this.puntuacionTotal;
    }
    
    public void setPuntuacionTotal(int p){
        this.puntuacionTotal = p;
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
}
