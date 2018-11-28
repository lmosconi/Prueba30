/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpjlaboratoriofinal;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;


/**
 *
 * @author GMO
 */
public class CPJLaboratorioFinal {
    
    public static final String NOMBRE_ARCHIVO = "C:\\catalogoPeliculas\\peliculas.txt";
    public static CatalogoPeliculasImpl catalogoPeliculas = new CatalogoPeliculasImpl();
    
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        System.out.println("===============Menú===============");
        System.out.println("1.- Iniciar catalogo de peliculas.");
        System.out.println("2.- Agregar pelicula.");
        System.out.println("3.- Listar Peliculas.");
        System.out.println("4.- Buscar Pelicula.");
        System.out.println("0.- Salir.");
        System.out.println("Introduzca una Opción: ");
        int opcion = teclado.nextInt();
        
        do{
            
            switch(opcion){
                
                case 1:
                    
                    catalogoPeliculas.iniciar(NOMBRE_ARCHIVO);
                    System.out.println("Introduzca una Opción: ");
                    opcion = teclado.nextInt();
                    
                break;
                    
                case 2:
                    
                    System.out.println("Ingrese nueva Pelicula: ");
                    String pelicula = teclado.next();
                    catalogoPeliculas.agregarPelicula(pelicula, NOMBRE_ARCHIVO);
                    System.out.println("Se a ingresado su pelicula satisfactoriamente.");
                    System.out.println("Introduzca una Opción: ");
                    opcion = teclado.nextInt();
                    
                break;
                    
                case 3:
                    
                    catalogoPeliculas.listar(NOMBRE_ARCHIVO);
                    System.out.println("Introduzca una Opción: ");
                    opcion = teclado.nextInt();
                    
                break;
                    
                case 4:

                    System.out.println("Ingrese nombre de la pelicula: ");
                    String busquedaPelicula = teclado.next();
                    catalogoPeliculas.buscarPelicula( NOMBRE_ARCHIVO, busquedaPelicula);
                    System.out.println("Introduzca una Opción: ");
                    opcion = teclado.nextInt();
                    
                break;
                    
                case 0:
                    
                    System.out.println("Adios.");
                    
                break;
                    
                default:
                    
                    System.out.println("Error: Opcion invalida.");
                    
                break;
                
            }
            
        } while (opcion != 0);
        
    }
    
}
