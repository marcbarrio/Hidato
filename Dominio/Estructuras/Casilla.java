package Dominio.Estructuras;

/**
 *
 * @author Hamid Latif
 */
public class Casilla {
    private int valor;
    
    /*  PRE: -
        POST: Retorna el valor que tiene la casilla 
    */
    public int getValor() {
        return valor;
    }
    
    /*  PRE: -
        POST: La casilla adopta el valor del parámetro "valor"
    */
    public void setValor(int valor) {
        if (valor <= 0) System.out.println("Valor no válido");
        else this.valor = valor;
    }
}
