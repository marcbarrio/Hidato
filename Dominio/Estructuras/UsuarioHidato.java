package Dominio.Estructuras;

/**
 *
 * @author Raúl Ibáñez Pérez
 */
public class UsuarioHidato extends Usuario {
    private int puntuacionTotal;
    
    
    public UsuarioHidato() {}
    
    public UsuarioHidato(String n, String c) {
        super.setNombre(n);
        super.setContrasena(c);
        super.setApareceRanking(true);
    }
    
    public int getPuntuacionTotal(){
        return this.puntuacionTotal;
    }
    
    public void setPuntuacionTotal(int p){
        this.puntuacionTotal = p;
    }
}
