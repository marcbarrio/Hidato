package Dominio.Tiempo;

/**
 *
 * @author Lock
 */
public class Tiempo {
    int Segundos;
    int Minutos;
    int Horas;
    long time = 0;
    public Tiempo () {
        time = System.currentTimeMillis();
    }
}
