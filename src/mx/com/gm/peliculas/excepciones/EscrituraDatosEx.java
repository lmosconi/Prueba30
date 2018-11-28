/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.excepciones;

/**
 *
 * @author GMO
 */
public class EscrituraDatosEx extends Exception{
    
    String mensaje;
    
    public EscrituraDatosEx (String Mensaje){
        
        this.mensaje=mensaje;
    
    }
    
}
