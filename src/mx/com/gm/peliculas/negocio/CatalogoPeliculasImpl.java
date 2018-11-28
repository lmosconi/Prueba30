/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.negocio;

import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

/**
 *
 * @author GMO
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas {
    
    private AccesoDatosImpl datos = new AccesoDatosImpl();

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        
        Pelicula pelicula = new Pelicula(nombrePelicula);
        datos.escribir(pelicula, nombreArchivo, true);
        
    }

    @Override
    public void listar(String nombreArchivo) {
        
        try {
            for(Pelicula listar: datos.listar(nombreArchivo)){
                
                System.out.println("Pelicula: " + listar.getNombre());
                
            }
        } catch (LecturaDatosEx ex) {
            Logger.getLogger(CatalogoPeliculasImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String nombrePelicula) {
        
        String busqueda = null;
        try {
            busqueda = datos.buscar(nombreArchivo, nombrePelicula);
        } catch (LecturaDatosEx ex) {
            Logger.getLogger(CatalogoPeliculasImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (busqueda.equals(nombrePelicula)){
            
            try {
                System.out.println("La pelicula buscada se encuentra registrada: " + datos.buscar(nombreArchivo, nombrePelicula));
            } catch (LecturaDatosEx ex) {
                Logger.getLogger(CatalogoPeliculasImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            
            System.out.println("La pelicula a buscar no se encuentra Registrada.");
            
        }
        
    }
        

    @Override
    public void iniciar(String nombreArchivo) {
        
        datos.crear(nombreArchivo);
        
    }
    
    
    
}
