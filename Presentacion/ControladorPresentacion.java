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
    private static ControladorDominio CDominio = new ControladorDominio();
    private static boolean usuarioInvitado = true;
    private static String nombreUsuario;
    private static int puntuacionTotal;
    private static Date fechaCreacion;
    
    /*   CREADORES   */
    
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
    private static ControladorPresentacion getInstance() {
        return instance;
    }
    
    
    /*   MENU PRINCIPAL   */
    
    /*
    PRE: -
    POST: Se ha inicializado el juego con el usuario introducido o cerrado el programa, a
        elección del usuario
    */
    private void iniciar() {
        
        while (!salir) {
            
            opcion = this.introducirOpcion();
            
            if ((opcion < 1) || (opcion > 5)) 
                System.out.println("    Opción incorrecta.\n\n");
            
            else {
                
                if (opcion == 1) this.gestionUsuario();
                
                else if (opcion == 2) {
                    if (usuarioInvitado) CDominio.jugarInvitado();
                    else CDominio.jugar();
                }
                
                else if(opcion == 3) {
                    //DAR REPOSITORIO DE MAPAS
                }
                
                else if(opcion == 4) {
                    //DAR RANKINGS Y RECORDS
                }
                
                else if (opcion == 5) salir = true;
                
            }
        }
        
        System.exit(0); //Salimos del juego
    }
    
    /*  PRE: -
        POST: Se lee la opción que el jugador escoge
    */
    private int introducirOpcion() {
	int opcion;
	System.out.println("    ############################");
        System.out.println("    ####   MENÚ PRINCIPAL   ####");
        System.out.println("    ############################\n");
        if(this.usuarioInvitado) 
            System.out.println("    Usuario invitado\n\n");
        else{
            System.out.println("    Usuario: "+nombreUsuario+"\n");
            System.out.println("    Puntuación Total: "+puntuacionTotal+"\n");
            if (CDominio.getApareceRanking())
                System.out.println("    Sí aparece en Ránkings\n");
            else System.out.println("    No aparece en Ránkings\n");
            System.out.println("    Fecha Creación: "+fechaCreacion+"\n\n");
        }
	System.out.println("    Escoje opción:\n\n");
        System.out.println("        1) Gestión de Usuario\n");
	System.out.println("        2) Jugar\n");
	System.out.println("        3) Repositorio de Hidatos\n");
        System.out.println("        4) Rankings y Récords\n\n");
        System.out.println("        5) Salir\n");
        System.out.print("\n      > opción:  ");
	Scanner in = new Scanner(System.in);
	opcion = in.nextInt(); //lectura de datos
        System.out.print("\n");
	return opcion;
    }
    
    /*   FUNCIONES   */
    
    /*  PRE: -
        POST: Se leen los datos del usuario (nombre y contraseña), se validan y
        se loguea.
    */
    private void logIn() {
        
        System.out.println("    ############################");
        System.out.println("    ####       LOG IN       ####");
        System.out.println("    ############################");
        
        boolean nombreCompletado = false;
        boolean contrasenaCompletada = false;
        boolean salirOpcion = false;
        boolean opcionInvalida = true;
        String nombreUsuario = "";
        String nombreContrasena = "";
        
        System.out.println("    Introduce tu nombre de usuario:\n");
        
        while (!nombreCompletado && !salirOpcion) {
            System.out.print("      > usuario: ");
            Scanner in = new Scanner(System.in);
            nombreUsuario = in.nextLine();
            if (CDominio.nombreExistente(nombreUsuario) == false) {
                System.out.println("\n  Ese nombre de usuario no existe.\n");
                opcionInvalida = true;
                if (!salirOpcion) {
                    while (opcionInvalida) {
                        System.out.println("    ¿Quieres intentarlo otra vez? (S/N)\n");
                        System.out.print("      > ");
                        in = new Scanner(System.in);
                        String salirString = in.nextLine();
                        if (salirString.equals("N") || salirString.equals("n")) {
                            salirOpcion = true;
                            opcionInvalida = false;
                        }
                        else if (salirString.equals("S") || salirString.equals("s")){
                            System.out.println("\n  Introduce tu nombre de usuario:\n");
                            opcionInvalida = false;
                        }
                        else 
                            System.out.println("\n  Solo puedes usar S / N. Vuelve a intentarlo.\n");
                    }
                }
            }
            else nombreCompletado = true;
        }
        
        System.out.println("\n  Nombre de usuario válido.\n");
        System.out.println ("   Introduce tu contraseña:\n");
        
        while (!contrasenaCompletada && !salirOpcion) {
            System.out.print("      > contraseña: ");
            Scanner in = new Scanner(System.in);
            nombreContrasena = in.nextLine();
            if (CDominio.contrasenaValida(nombreUsuario,nombreContrasena) == false) {
                System.out.println("\n  La contraseña no es correcta.\n");
                opcionInvalida = true;
                if (!salirOpcion) {
                    while (opcionInvalida) {
                        System.out.println("    ¿Quieres intentarlo otra vez? (S/N)\n");
                        System.out.print("      > (S/N): ");
                        in = new Scanner(System.in);
                        String salirString = in.nextLine();
                        if (salirString.equals("N") || salirString.equals("n")) {
                            salirOpcion = true;
                            opcionInvalida = false;
                        }
                        else if (salirString.equals("S") || salirString.equals("s")){
                            System.out.println("\n  Introduce tu contraseña:\n");
                            opcionInvalida = false;
                        }
                        else 
                            System.out.println("\n  Solo puedes usar S / N. Vuelve a intentarlo.\n");
                    }
                }
            }
            else contrasenaCompletada = true;
        }
        
        if (salirOpcion == false){
            CDominio.loginUsuario(nombreUsuario, nombreContrasena);
            System.out.println("\n  Contraseña válida, usuario logueado.\n");
            ControladorPresentacion.usuarioInvitado = false;
            ControladorPresentacion.nombreUsuario = nombreUsuario;
            ControladorPresentacion.puntuacionTotal = CDominio.getPuntuacionUsuario();
            ControladorPresentacion.fechaCreacion = CDominio.getFechaCreacion();
        }
        else System.out.println("\n Usuario NO logueado.\n");
        
        System.out.println("    Volviendo al Menú Principal.\n");
        
    }
    
    /*  PRE: -
        POST: Se desloguea el usuario que estaba cargado.
    */
    private void logOut(){
        usuarioInvitado = true;
        CDominio.guardarDatosUsuario();
    }
    
    /*  PRE: -
        POST: Se leen los datos del usuario (nombre y contraseña), se validan, se creaun usuario nuevo y
        se loguea.
    */
    private void crearUsuario(){
        
        System.out.println("    ############################\n");
        System.out.println("    #### CREADOR DE USUARIO ####\n");
        System.out.println("    ############################\n");
        
        boolean nombreCompletado = false;
        boolean contrasenaCompletada = false;
        boolean salirOpcion = false;
        boolean opcionInvalida = true;
        String nombreUsuario = "";
        String nombreContrasena = "";
        
        System.out.println("    Introduce un nombre de usuario: (6 o más caracteres)\n");
        
        while (!nombreCompletado && !salirOpcion) {
            System.out.print("      > usuario: ");
            Scanner in = new Scanner(System.in);
            nombreUsuario = in.nextLine();
            if (CDominio.nombreValido(nombreUsuario) == false) {
                System.out.println("\n  Ese nombre de usuario ya existe o es inválido.\n");
                opcionInvalida = true;
                if (!salirOpcion) {
                    while (opcionInvalida) {
                        System.out.println("    ¿Quieres elegir otro nombre? (S/N)\n");
                        System.out.print("      > (S/N): ");
                        in = new Scanner(System.in);
                        String salirString = in.nextLine();
                        if (salirString.equals("N") || salirString.equals("n")) {
                            salirOpcion = true;
                            opcionInvalida = false;
                        }
                        else if (salirString.equals("S") || salirString.equals("s")){
                            System.out.println("\n  Elige otro nombre de usuario:\n");
                            opcionInvalida = false;
                        }
                        else 
                            System.out.println("\n  Solo puedes usar S / N. Vuelve a intentarlo.\n");
                    }
                }
            }
            else nombreCompletado = true;
        }
        
        System.out.println("\n  Nombre de usuario válido.");
        System.out.println("    Introduce una contraseña: (6 o más caracteres)\n");
        
        while (!contrasenaCompletada && !salirOpcion) {
            System.out.print("      > contraseña: ");
            Scanner in = new Scanner(System.in);
            nombreContrasena = in.nextLine();
            if (CDominio.contrasenaValida(nombreContrasena)) {
                System.out.println("\n  Esa contraseña no es válida.\n");
                opcionInvalida = true;
                if (!salirOpcion) {
                    while (opcionInvalida) {
                        System.out.println("    ¿Quieres elegir otra contraseña? (S/N)\n");
                        System.out.print("      > (S/N): ");
                        in = new Scanner(System.in);
                        String salirString = in.nextLine();
                        if (salirString.equals("N") || salirString.equals("n")) {
                            salirOpcion = true;
                            opcionInvalida = false;
                        }
                        else if (salirString.equals("S") || salirString.equals("s")){
                            System.out.println("\n  Elige otra contraseña:\n");
                            opcionInvalida = false;
                        }
                        else 
                            System.out.println("\n  Solo puedes usar S / N. Vuelve a intentarlo.\n");
                    }
                }
            }
            else contrasenaCompletada = true;
        }
        
        if (salirOpcion == false){
            CDominio.crearUsuario(nombreUsuario, nombreContrasena);
            System.out.println("\n  Contraseña válida, usuario Creado.\n");
            ControladorPresentacion.usuarioInvitado = false;
            ControladorPresentacion.nombreUsuario = nombreUsuario;
            ControladorPresentacion.puntuacionTotal = CDominio.getPuntuacionUsuario();
        }
        else System.out.println("\n Usuario NO creado.\n");
        
        System.out.println("    Volviendo al Menú Principal.\n");
        
    }
    
    /*   MENU GENERAL DE GESTION DE USUARIO   */
    private void gestionUsuario(){
        int opcion = 0;
        /*
        System.out.println("    ############################");
        System.out.println("    ####    MENÚ USUARIO    ####");
        System.out.println("    ############################\n");
        */
        if(this.usuarioInvitado) {
            opcion = this.menuUsuarioInvitado(opcion);
            if (opcion == 1) this.logIn();
            else if (opcion == 2) this.crearUsuario();
        }
        else {
            opcion = this.menuUsuarioLogueado(opcion);
            if (opcion == 1) this.logOut();
            else if(opcion == 2) {
                CDominio.toggleApareceRanking();
            }
            else if (opcion == 3) {
                
                System.out.print("      > Confirma tu contraseña: ");
                Scanner in = new Scanner(System.in);
                String auxContrasena = in.nextLine();
                
                if (CDominio.contrasenaValida(nombreUsuario,auxContrasena) == false) {
                    System.out.println("\n  La contraseña no es correcta. No se borrará el usuario.\n");
                }
                else {
                    System.out.println("\n  La contraseña es correcta. El usuario ha sido eliminado.\n");
                    usuarioInvitado = true;
                    CDominio.borrarUsuario();
                }
            }
        }
    }
    
    /*   MENU DE GESTION DE USUARIO INVITADO   */
    private int menuUsuarioInvitado(int opcion){
        System.out.println("    ############################");
        System.out.println("    #### MENÚ USUARIO GUEST ####");
        System.out.println("    ############################\n");
        while (opcion < 1 || opcion > 4) {
            System.out.println("        1) Login\n");
            System.out.println("        2) Registrarse\n");
            System.out.println("        3) Volver\n");
            System.out.print("\n      > opción:  ");
            Scanner in = new Scanner(System.in);
            opcion = in.nextInt();
        }
        return opcion;
    }
    
    /*   MENU DE GESTION DE USUARIO LOGUEADO   */
    private int menuUsuarioLogueado(int opcion){
        System.out.println("    ###############################");
        System.out.println("    #### MENÚ USUARIO LOGUEADO ####");
        System.out.println("    ###############################\n");
        System.out.println("    (Eres "+nombreUsuario+")\n");
        while (opcion < 1 || opcion > 4) {
            System.out.println("        1) LogOut\n");
            if (CDominio.getApareceRanking())
                System.out.println("        2) No aparecer en Ránking\n");
            else
                System.out.println("        2) Sí aparecer en Ránking\n");
            System.out.println("        3) Borrar Usuario\n");
            System.out.println("        4) Salir\n");
            System.out.print("\n      > opción:  ");
            Scanner in = new Scanner(System.in);
            opcion = in.nextInt();
        }
        return opcion;
    }
                    
}
