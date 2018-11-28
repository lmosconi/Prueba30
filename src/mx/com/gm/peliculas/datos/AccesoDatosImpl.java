/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
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
       
      File archivo = new File(nombreArchivo);
      List<Pelicula> peliculas = new ArrayList();
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return peliculas;
    }
    
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx{
        
        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i = 0;
            linea = entrada.readLine();
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula " + linea + " encontrada en indice " + i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            }
            entrada.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    
}
    
    
 
