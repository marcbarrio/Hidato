package Dominio.Estructuras;

/**
 *
 * @author Marc Barrio Ruiz
 */
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Collections;

public class Ranking {
    protected List<Fila> Ranking;
    
    /*  PRE: -
        POST: Se crea un objeto Ranking.
    */
    public Ranking(){
        List<Fila> f = new ArrayList<>();
    }
    /*  PRE: -
        POST: Se inserta una fila en el Ranking en la posición ordenada según un criterio descendente de puntuacion.
    */
    public void insertarFila(Fila f){
        Ranking.add(f);
        ListIterator<Fila> RankingIt = Ranking.listIterator(Ranking.size());
        boolean done = false;
        Fila tmp;
        while(RankingIt.hasPrevious() && done == false){
            tmp = RankingIt.previous();
            if(tmp.getPuntuacion() < f.getPuntuacion()){
                Collections.swap(Ranking,RankingIt.nextIndex() , RankingIt.nextIndex() - 1);
            }
            else{
                done = true;
            }
        }
    }
    /*  PRE: -
        POST: Borra la fila que conté el nombreUsuario especificat als parametres.
    */
    public void borrarFila(String nombreUsuario){
        ListIterator<Fila> RankingIt = Ranking.listIterator();
        boolean done = false;
        while(done == false && RankingIt.hasNext()){
            if(RankingIt.next().getNombre().equals(nombreUsuario)){
                RankingIt.remove();
                done = true;
            }
        }
    }
    /*  PRE: El nombreUsuario de la Fila del paràmetre ha d'existir al Ranking.
        POST: La fila del Ranking amb nom igual a la fila del paràmetre son substituits
              significant que l'usuari ha quedat actualitzat.
    */
    public void actualitzarUsuari(Fila f){
        ListIterator<Fila> RankingIt = Ranking.listIterator();
        boolean done = false;
        Fila tmp;
        while(done == false && RankingIt.hasNext()){
            tmp = RankingIt.next();
            if(tmp.getNombre().equals(f.getNombre())){
                tmp = f;
                done = true;
            }
        }
    }
    /*  PRE: -
        POST: Retorna la fila del ranking amb nombreUsuario especificat als parametres.
    */
    public Fila getFila(String nombreUsuario){
        ListIterator<Fila> RankingIt = Ranking.listIterator();
        Fila ret = new Fila();
        Fila tmp;
        boolean found = false;
        while(found == false && RankingIt.hasNext()){
                tmp = RankingIt.next();
                if(tmp.getNombre().equals(nombreUsuario)){
                    ret = tmp;
                    found = true;
            }  
        }
        return ret;
    }
    /*  PRE: -
        POST: Retorna la mida del ranking.
    */
    public int getSize(){
        return Ranking.size();
    }
}
