/**
 *
 * @author Raúl Ibáñez Pérez
 */
package Presentacion;
import java.util.*;
import Dominio.*;

public class ControladorPresentacion {
    private static int opcion;
    private static boolean salir = false;
    private static final ControladorPresentacion instance = new ControladorPresentacion();
    private static ControladorPartida CPartida = new ControladorPartida();
    private static ControladorDominio CDominio = new ControladorDominio();
    private static boolean usuarioInvitado = true;
    private static String nombreUsuario;
    private static int puntuacionTotal;
    
    /*
    PRE: -
    POST: La clase queda inicializada
    */
    private ControladorPresentacion() {}
    
    /*
    PRE: -
    POST: Inicialización por método Singleton (Eager). Se usa para evitar el error
        de llamar a una función no static desde el main (que es static)
    */
    public static ControladorPresentacion getInstance() {
        return instance;
    }
    
    /*
    PRE: -
    POST: Se ha inicializado el juego con el usuario introducido o cerrado el programa, a
        elección del usuario
    */
    public void iniciar() {
        while (!salir) {
            opcion = this.introducirOpcion();
            if ((opcion < 1) || (opcion > 4)) 
                System.out.println("Opción incorrecta, intentalo de nuevo\n\n");
            else {
                if (opcion == 1) this.crearUsuario();
                else if (opcion == 2) this.logIn();
                else if (opcion == 4) salir = true;
                else if(opcion == 5) CDominio.escribirBDUsuarios();
                //else if (opcion == 3) Partida.iniciar_invitado(); //controlador de partida
                /*else {
                    introducirUsuario();
                }*/
            }
        }
        System.exit(0); //Salimos del juego
    }
    
    /*  PRE: -
        POST: Se lee la opción que el jugador escoge
    */
    private int introducirOpcion() {
	int opcion;
	System.out.println("############################\n");
        System.out.println("####   MENÚ PRINCIPAL   ####\n");
        System.out.println("############################\n");
        System.out.println("############################\n");
        if(this.usuarioInvitado) 
            System.out.println("Usuario invitado\n");
        else{
            System.out.println("Usuario: "+nombreUsuario+"\n");
            System.out.println("Puntuación Total: "+puntuacionTotal+"\n");
        }
        System.out.println("############################\n");
	System.out.println("Escoje opción:\n");
        System.out.println("1) Crear usuario\n");
	System.out.println("2) Introducir usuario\n");
	System.out.println("3) Escribir BD usuarios\n");
        System.out.println("4) Salir del programa\n");
	Scanner in = new Scanner(System.in);
	opcion = in.nextInt(); //lectura de datos
	return opcion;
    }
    
    /*  PRE: -
        POST: Se leen los datos del usuario (nombre y contraseña) y se validan,
        si son correctos se inicia la partida con dicho usuario
    */
    private void logIn() {
        
        System.out.println("############################\n");
        System.out.println("####       LOG IN       ####\n");
        System.out.println("############################\n");
        
        boolean nombreCompletado = false;
        boolean contrasenaCompletada = false;
        boolean salirOpcion = false;
        boolean opcionInvalida = true;
        String nombreUsuario = "";
        String nombreContrasena = "";
        
        System.out.println("Introduce tu nombre de usuario:\n");
        
        while (!nombreCompletado && !salirOpcion) {
            System.out.print("  > ");
            Scanner in = new Scanner(System.in);
            nombreUsuario = in.nextLine();
            if (CDominio.nombreExistente(nombreUsuario) == false) {
                System.out.println("\nEse nombre de usuario no existe.\n");
                opcionInvalida = true;
                if (!salirOpcion) {
                    while (opcionInvalida) {
                        System.out.println("¿Quieres intentarlo otra vez? (S/N)\n");
                        System.out.print("  > ");
                        in = new Scanner(System.in);
                        String salirString = in.nextLine();
                        if (salirString.equals("N") || salirString.equals("n")) {
                            salirOpcion = true;
                            opcionInvalida = false;
                        }
                        else if (salirString.equals("S") || salirString.equals("s")){
                            System.out.println("\nIntroduce tu nombre de usuario:\n");
                            opcionInvalida = false;
                        }
                        else 
                            System.out.println("\nSolo puedes usar S / N. Vuelve a intentarlo.\n");
                    }
                }
            }
            else nombreCompletado = true;
        }
        
        System.out.println("\nNombre de usuario válido.\nIntroduce tu contraseña:\n");
        
        while (!contrasenaCompletada && !salirOpcion) {
            System.out.print("  > ");
            Scanner in = new Scanner(System.in);
            nombreContrasena = in.nextLine();
            if (CDominio.contrasenaValida(nombreUsuario,nombreContrasena) == false) {
                System.out.println("\nEsa contraseña no es válida.\n");
                opcionInvalida = true;
                if (!salirOpcion) {
                    while (opcionInvalida) {
                        System.out.println("¿Quieres intentarlo otra vez? (S/N)\n");
                        System.out.print("  > ");
                        in = new Scanner(System.in);
                        String salirString = in.nextLine();
                        if (salirString.equals("N") || salirString.equals("n")) {
                            salirOpcion = true;
                            opcionInvalida = false;
                        }
                        else if (salirString.equals("S") || salirString.equals("s")){
                            System.out.println("\nIntroduce tu contraseña:\n");
                            opcionInvalida = false;
                        }
                        else 
                            System.out.println("\nSolo puedes usar S / N. Vuelve a intentarlo.\n");
                    }
                }
            }
            else contrasenaCompletada = true;
        }
        
        if (salirOpcion == false){
            CDominio.loginUsuario(nombreUsuario, nombreContrasena);
            System.out.println("\nContraseña válida, usuario logueado.\n");
            ControladorPresentacion.usuarioInvitado = false;
            ControladorPresentacion.nombreUsuario = nombreUsuario;
            ControladorPresentacion.puntuacionTotal = CDominio.getPuntuacionUsuario();
        }
        else System.out.println("\nUsuario NO logueado.\n");
        
        System.out.println("Volviendo al Menú Principal.\n");
        
    }
    
    private void crearUsuario(){
        
        System.out.println("############################\n");
        System.out.println("#### CREADOR DE USUARIO ####\n");
        System.out.println("############################\n");
        
        boolean nombreCompletado = false;
        boolean contrasenaCompletada = false;
        boolean salirOpcion = false;
        boolean opcionInvalida = true;
        String nombreUsuario = "";
        String nombreContrasena = "";
        
        System.out.println("Introduce un nombre de usuario: (6 o más caracteres)\n");
        
        while (!nombreCompletado && !salirOpcion) {
            System.out.print("  > ");
            Scanner in = new Scanner(System.in);
            nombreUsuario = in.nextLine();
            if (CDominio.nombreValido(nombreUsuario) == false) {
                System.out.println("\nEse nombre de usuario ya existe o es inválido.\n");
                opcionInvalida = true;
                if (!salirOpcion) {
                    while (opcionInvalida) {
                        System.out.println("¿Quieres elegir otro nombre? (S/N)\n");
                        System.out.print("  > ");
                        in = new Scanner(System.in);
                        String salirString = in.nextLine();
                        if (salirString.equals("N") || salirString.equals("n")) {
                            salirOpcion = true;
                            opcionInvalida = false;
                        }
                        else if (salirString.equals("S") || salirString.equals("s")){
                            System.out.println("\nElige otro nombre de usuario:\n");
                            opcionInvalida = false;
                        }
                        else 
                            System.out.println("\nSolo puedes usar S / N. Vuelve a intentarlo.\n");
                    }
                }
            }
            else nombreCompletado = true;
        }
        
        System.out.println("\nNombre de usuario válido, introduce una contraseña: (6 o más caracteres)\n");
        
        while (!contrasenaCompletada && !salirOpcion) {
            System.out.print("  > ");
            Scanner in = new Scanner(System.in);
            nombreContrasena = in.nextLine();
            if (CDominio.contrasenaValida(nombreContrasena)) {
                System.out.println("\nEsa contraseña no es válida.\n");
                opcionInvalida = true;
                if (!salirOpcion) {
                    while (opcionInvalida) {
                        System.out.println("¿Quieres elegir otra contraseña? (S/N)\n");
                        System.out.print("  > ");
                        in = new Scanner(System.in);
                        String salirString = in.nextLine();
                        if (salirString.equals("N") || salirString.equals("n")) {
                            salirOpcion = true;
                            opcionInvalida = false;
                        }
                        else if (salirString.equals("S") || salirString.equals("s")){
                            System.out.println("\nElige otra contraseña:\n");
                            opcionInvalida = false;
                        }
                        else 
                            System.out.println("\nSolo puedes usar S / N. Vuelve a intentarlo.\n");
                    }
                }
            }
            else contrasenaCompletada = true;
        }
        
        if (salirOpcion == false){
            CDominio.crearUsuario(nombreUsuario, nombreContrasena);
            System.out.println("\nContraseña válida, usuario Creado.\n");
        }
        else System.out.println("\nUsuario NO creado.\n");
        
        System.out.println("Volviendo al Menú Principal.\n");
        
    }
                
}
