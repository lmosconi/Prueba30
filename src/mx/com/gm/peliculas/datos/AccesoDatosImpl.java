/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;


/**
 *
 * @author GMO
 */
public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo){
        
        File archivo = new File(nombreArchivo);
        boolean existir;
        existir=archivo.exists();
        return existir;
        
    }
    
    @Override
    public void crear(String nombreArchivo) {
        
        File archivo = new File(nombreArchivo);
        
        if(archivo.exists()){
        
            System.out.println("El archivo ya existe.");

        }else{
            PrintWriter salida = null;
            try {
                salida = new PrintWriter(new FileWriter(archivo));
            } catch (IOException ex) {
                Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("El archivo se ha creado correctamente.");
            salida.close();

        }
    }
    
    @Override
    public void borrar(String nombreArchivo){
        
        File archivo = new File(nombreArchivo);
        
        try {
            if (archivo.exists()){
                
                archivo.delete();
                System.out.println("Archivo borrado Exitosamente.");
             
            }
        } catch (Exception ex){
            
            System.out.println(ex.getMessage());
            
        }
    }
    

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        
    File archivo = new File(nombreArchivo);
    PrintWriter salida = null;
        
    if (archivo.exists()){
            
        try {
            
            salida = new PrintWriter(new FileWriter(archivo, anexar));
            
        } catch (IOException ex){
            
            ex.printStackTrace();
            
        }
        
        String contenido = pelicula.getNombre();
        salida.println(contenido);
        salida.close();
            
    } else {
            
        System.out.println("El Catalogo de Peliculas no existe.");
            
    }
        
    }
    
    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
       
        List<Pelicula> pelicula = new ArrayList();
        
        File archivo = new File(nombreArchivo);
        
        BufferedReader entrada = null;
        
        if (archivo.exists()){
          
        try {
            entrada = new BufferedReader(new FileReader(archivo));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String lectura = null;
            try {
                lectura = entrada.readLine();
            } catch (IOException ex) {
                Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        while (lectura!=null){
            
            pelicula.add(new Pelicula(lectura));
            
            try {
                entrada.readLine();
            } catch (IOException ex) {
                Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }
        return pelicula;
    }   
    
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx{
        
        File archivo = new File(nombreArchivo);
        String busqueda = null;
        
        if (archivo.exists()){
            
            for (Pelicula contador: listar(nombreArchivo)){
                
                busqueda = contador.getNombre();
                
            }
            
        }
       return busqueda; 
    }
    
}
    
    
 
