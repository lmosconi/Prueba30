/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.negocio;

/**
 *
 * @author GMO
 */
public interface CatalogoPeliculas {
    
    public void agregarPelicula(String nombrePelicula, String nombreArchivo);
    public void listar(String nombreArchivo);
    public void buscarPelicula(String nombreArchivo, String nombrePelicula);
    public void iniciar(String nombreArchivo);
    
}
