/**
 * 
 */
package Testing;
import cine.*;

/**
 * Tester Clase Cartelera
 * @author Lucia Rivas Molina <lucia.rivasmolina@estudiante.uam.es>
 * @author Daniel Santo-Tomas Lopez <daniel.santo-tomas@estudiante.uam.es>
 *
 */
public class TesterCartelera {
	
	public static void main(String[] args) {
		/*Creamos una cartelera*/
		Cartelera cartelera = new Cartelera();
		cartelera.mostrarCartelera();
		
		/*A�adimos algunas peliculas*/
		cartelera.addPelicula("Toc Toc", "Danist", 2010, "Psicologos", Genero.COMEDIA);
		cartelera.addPelicula("Autobuses", "Guillermo del Toro", 2015, "Un viaje en bus", Genero.WESTERN);
		cartelera.addPelicula("CIREL", "Eps Uam", 2018, "Un brillante thriller en el que cientos de alumnos deber�n superar una prueba", Genero.SUSPENSE);
		cartelera.addPelicula("El laboratorio", "Luis Perez", 2018, "Romance cientifico", Genero.ROMANCE);
		cartelera.mostrarCartelera();
		
		/*Eliminamos una pelicula que no esta en la lista*/
		if (cartelera.eliminaPelicula("Todo") == false) {
			System.out.println("Esa pelicula no esta en la cartelera\n");
		}
		else {
			System.out.println("Pelicula eliminada con exito\n");
		}
		
		/*Eliminamos una pelicula que si esta en la lista*/
		if (cartelera.eliminaPelicula("Autobuses") == false) {
			System.out.println("Esa pelicula no esta en la cartelera\n");
		}
		else {
			System.out.println("Pelicula eliminada con exito\n");
		}
		
	}
}
