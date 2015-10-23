/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParsePosition;

/**
 *
 * @author Raúl Ibáñez Pérez
 */
public class ControladorDatosUsuario {
    
    /*   CREADORAS   */
    
    /*  PRE: -
        POST: Inicialización de la clase, que se deja vacía
    */
    public ControladorDatosUsuario() {
        
    }
    
    /*   CONSULTORAS   */
    
    /*  PRE: -
        POST: devuelve true si s es un usuario que ya existe y false si no.
    */
    public boolean nombreUsuarioExistente(String s){
        
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
    
    /*  PRE: n es un nombre de usuario existente.
        POST: devuelve true si c es la contraseña de usuario n y false si no lo es.
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
    
    /*  PRE: n es un nombre de usuario existente.
        POST: devuelve la puntuacion del usuario con nombre n,
    */
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
    
    /*  PRE: n es un nombre de usuario existente.
        POST: devuelve el boolean apareceRanking del usuario con nobre n.
    */
    public boolean cargarApareceRankingUsuario(String n){
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        boolean solucio = false;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("Persistencia/BD/Usuarios/"+n+".txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            // Lectura del fichero
            br.readLine(); //Leo la puntuacion;
            String linea = br.readLine();            
            if (linea.equals("true")) solucio = true;
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
    
    /*  PRE: n es un nombre de usuario existente.
        POST: devuelve la fecha de creacion del usuario con nombre n.
    */
    public Date cargarFechaUsuario(String n){
        Date f=null;
        String auxFecha;
        ParsePosition p = new ParsePosition(0);
        SimpleDateFormat formateador = new SimpleDateFormat("EEE MMM ddd HH:mm:ss zzzz yyyy");
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("Persistencia/BD/Usuarios/"+n+".txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            br.readLine(); //Leo la puntuacion;
            br.readLine(); 
            auxFecha = br.readLine();
            f = formateador.parse(auxFecha,p);
            System.out.println(f);
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
        
        return f;
    }
    
    /*   MODIFICADORAS   */
    
    /*  PRE: -
        POST: crea un usuario con nombre n y contraseña c.
    */
    public void crearUsuario(String n, String c){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("Persistencia/BD/BDUsuarios.txt", true);
            pw = new PrintWriter(fichero);
 
            pw.println(n);
            pw.println(c);
 
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
    
    /*  PRE: n es un nombre de usuario existente.
        POST: se borran todos los datos del usuario con nombre n.
    */
    public void borrarUsuario(String n){
        
        //LEO ARCHIVO = BDUsuarios.txt
        //ESCRIBO FICHERO = BDUsuarios2.txt
        
        //LEO BDUsuarios.txt y ESCRIBO EN BDUsuarios2.txt
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        archivo = new File ("Persistencia/BD/BDUsuarios.txt");
        
        FileWriter fichero = null;
        
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            // Lectura del fichero
            String linea;
            while(((linea=br.readLine())!=null)){
                if (n.equals(linea)) {
                    //Si es l'usuari que busco paso al següent nom d'usuari.
                    br.readLine();
                }
                else{
                    //Si no, guardo l'usuri a la BD auxiliar.
                    
                    PrintWriter pw = null;
                    try
                    {
                        fichero = new FileWriter("Persistencia/BD/BDUsuarios2.txt",true);
                        pw = new PrintWriter(fichero);

                        pw.println(linea);
                        linea=br.readLine();
                        pw.println(linea);

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
        
        // Borro BDUsuarios.txt
        
        archivo.delete();
        
        //Escric a BDUsuarios.txt el que hi ha a BDUsuarios2.txt
        
        archivo = null;
        fr = null;
        br = null;
        archivo = new File ("Persistencia/BD/BDUsuarios2.txt");
        
        fichero = null;
        
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            // Lectura del fichero
            String linea;
            while(((linea=br.readLine())!=null)){
                //Guardo l'usuri a la BD.
                PrintWriter pw = null;
                try
                {
                    fichero = new FileWriter("Persistencia/BD/BDUsuarios.txt",true);
                    pw = new PrintWriter(fichero);

                    pw.println(linea);
                    linea=br.readLine();
                    pw.println(linea);

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
        
        //Elimino BDUsuarios2.txt
        
        archivo = new File ("Persistencia/BD/BDUsuarios2.txt");
        
        archivo.delete();
        
        //Elimino Usuaiors/n.txt
        
        this.borrarBDUsuario(n);
        
    }
    
    /*  PRE: n es un nombre de usuario existente.
        POST: guarda todos los datos en el usuario con nombre n.
    */
    public void guardarUsuario(String n,int p,boolean b, Date d){
        
        this.borrarBDUsuario(n);
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("Persistencia/BD/Usuarios/"+n+".txt",true);
            pw = new PrintWriter(fichero);
            pw.println(p);
            if(b == true) pw.println("true");
            else pw.println("false");
            String auxFecha = d.toString();
            pw.println(auxFecha);
 
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
    
    /*  PRE: n es un nombre de usuario existente.
        POST: se borra la bae de datos del usuario con nombre n.
    */ 
    private void borrarBDUsuario(String n){
        
        File archivo = null;
        
        boolean solucio = false;
        
        try {
            archivo = new File ("Persistencia/BD/Usuarios/"+n+".txt");
            archivo.delete();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
