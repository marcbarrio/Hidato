/**
 *
 * @author Raúl Ibáñez Pérez
 */
package Persistencia;
import java.io.*;
public class ControladorPersistencia {
    
    /*  PRE: -
        POST: Inicialización de la clase, que se deja vacía
    */
    public ControladorPersistencia() {} 
    
    /*  PRE: -
        POST: Se retorna true si el usuario existe en la base de datos, false en 
        caso contrario
    */
    public boolean iniciar_sesion(String nombre, String contrasena) {
        return true;
        /* AQUÍ SE HACE EL PROCESO NECESARIO PARA COMPROBAR EL USUARIO EN LA BASE DE DATOS */
    }
    
    public boolean nombreTableroValido(String s) {
        return true;
        /* AQUÍ SE HACE EL PROCESO NECESARIO PARA COMPROBAR EL USUARIO EN LA BASE DE DATOS */
    }
    
    public boolean nombreExistente(String s){
        
        boolean encontrado = false;
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("Persistencia/BD/BDUsuarios.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null){
                if (s.equals(linea)) encontrado = true;
                br.readLine();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{                   
                if( null != fr ){  
                    fr.close();    
                }                 
            }
            catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return encontrado;
    }
    
    public void crearUsuario(String n, String c){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("Persistencia/BD/BDUsuarios.txt", true);
            pw = new PrintWriter(fichero);
 
            pw.println(n);
            pw.println(c);
            
            this.crearBDUsuario(n);
 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           }
           catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    /* PRE: n es un nombre de usuario válido.
    
    */
    public boolean contrasenaValida(String n, String c){
        
        boolean encontrado = false;
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        boolean solucio = false;
        
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("Persistencia/BD/BDUsuarios.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            // Lectura del fichero
            String linea;
            while(((linea=br.readLine())!=null) && (!encontrado)){
                if (n.equals(linea)) encontrado = true;
            }
            if (encontrado) 
                solucio = (c.equals(linea));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{                   
                if( null != fr ){  
                    fr.close();    
                }                 
            }
            catch (Exception e2){
                e2.printStackTrace();
            }
        }
        
        return solucio;
    }
    
    public void crearBDUsuario(String n){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("Persistencia/BD/Usuarios/"+n+".txt",true);
            pw = new PrintWriter(fichero);
 
            pw.println(+0);
 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           }
           catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    public void crearBDUsuarios(){
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            
            archivo = new File ("Persistencia/BD/BDUsuarios.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null){
                System.out.println("Usuario: "+ linea +"\n");
                System.out.println("Contraseña: '"+ br.readLine() +"'\n");
                System.out.println("@@@@@@@");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{                   
                if( null != fr ){  
                    fr.close();    
                }                 
            }
            catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public int cargarPuntuacionUsuario(String n){
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        int solucio = 0;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("Persistencia/BD/Usuarios/"+n+".txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            // Lectura del fichero
            String linea = br.readLine();            
            solucio = Integer.parseInt(linea);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{                   
                if( null != fr ){  
                    fr.close();    
                }                 
            }
            catch (Exception e2){
                e2.printStackTrace();
            }
        }
        
        return solucio;
    }
}
