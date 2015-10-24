package Dominio.Estructuras;

/**
 *
 * @author Marc Barrio Ruiz
 */
import java.util.*;


public class Fila {
    protected int puntuacion;
    protected String nombreUsuario;
    protected Date fecha;
    
    /*  PRE: -
        POST: Es crea un objecte Fila sense inicialitzar.
    */
    public Fila(){
    }
    /*  PRE: -
        POST: Es crea un objecte fila amb els atributs especificats als parametres.
    */
    public Fila(int puntuacion, String nombreUsuario, Date fecha){
        this.puntuacion = puntuacion;
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
    }
    /*  PRE: -
        POST: Retorna la puntuacion de la fila.
    */
    public int getPuntuacion(){
        return puntuacion;
    }
    /*  PRE: -
        POST: Retorna el nombreUsuario de la fila.
    */
    public String getNombre(){
        return nombreUsuario;
    }
    /*  PRE: -
        POST: Retorna la fecha de la fila.
    */
    public Date getFecha(){
        return fecha;
    }
    /*  PRE: -
        POST: Es canvia la puntuacion per el valor especificat al parametre.
    */
    public void setPuntuacion(int puntuacion){
        this.puntuacion = puntuacion;
    }
    /*  PRE: -
        POST: S'afegeix el valor del parametre a la puntuacion actual.
    */
    public void addPuntuacion(int puntuacion){
        this.puntuacion = this.puntuacion + puntuacion;
    }
    /*  PRE: -
        POST: Es canvia el nombreUsuario de la Fila pel valor del parametre.
    */
    public void setNombre(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }
    /*  PRE: -
        POST: Es canvia el valor de la fecha de la Fila pel valor del parametre.
    */
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
}
