/**
 *
 * @author Hamid Latif
 */
package Presentacion;
import java.util.*;
import Dominio.ControladorDominio;

public class ControladorPresentacion {
    static int opcion;
    static boolean salir = false;
    private static final ControladorPresentacion instance = new ControladorPresentacion();
    //private static ControladorPartida Partida = new ControladorPartida();
    private static ControladorDominio Dominio = new ControladorDominio();
    
    
    /*  PRE: -
        POST: La clase queda inicializada
    */
    private ControladorPresentacion() {}
    
    /*  PRE: -
    POST: Inicialización por método Singleton (Eager). Se usa para evitar el error
        de llamar a una función no static desde el main (que es static)
    */
    public static ControladorPresentacion getInstance() {
        return instance;
    }
    
    /*  PRE: -
        POST: Se ha inicializado el juego con el usuario introducido o cerrado el programa, a
            elección del usuario
    */
    public void iniciar() {
        while (!salir) {
            opcion = introducir_opcion();
            if ((opcion < 1) || (opcion > 4)) 
                System.out.println("Opción incorrecta, intentalo de nuevo\n\n");
            else {
                if (opcion == 4) salir = true;
                //if (opcion == 3) Partida.iniciar_invitado(); //controlador de partida
                else {
                    introducir_usuario();
                }
            }
        }
        System.exit(0); //Salimos del juego
    }
    
    /*  PRE: -
        POST: Se lee la opción que el jugador escoge
    */
    private int introducir_opcion() {
	int opcion;
	System.out.println("////////////////////////////////////////////////////\n");
        System.out.println("Para iniciar el programa es necesario loguearse\n");
	System.out.println("////////////////////////////////////////////////////\n\n");
	System.out.println("Escoje opción:\n" + "1)Crear usuario\n");
	System.out.println("2)Introducir usuario\n");
	System.out.println("3)Usar usuario invitado\n");
        System.out.println("4)Salir del programa\n");
	Scanner in = new Scanner(System.in);
	opcion = in.nextInt(); //lectura de datos
	return opcion;
    }
    
    /*  PRE: -
        POST: Se leen los datos del usuario (nombre y contraseña) y se validan,
        si son correctos se inicia la partida con dicho usuario
    */
    private void introducir_usuario() {
        String nombre, contrasena;
        Scanner in = new Scanner(System.in);
        nombre = in.next();
        contrasena = in.next();
        if (Dominio.inciar_sesion(nombre, contrasena)) 
            System.out.println("Los datos introducidos no son correctos");
        //else Partida.iniciar(nombre, contrasena);
    }
                
}
