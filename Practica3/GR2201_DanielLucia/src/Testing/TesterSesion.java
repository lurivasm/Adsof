/**
 * 
 */
package Testing;
import cine.*;

/**
 * Tester de la clase Sesion
 * @author Lucia Rivas Molina <lucia.rivasmolina@estudiante.uam.es>
 * @author Daniel Santo-Tomas Lopez <daniel.santo-tomas@estudiante.uam.es>
 *
 */
public class TesterSesion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Creamos una pelicula para la sesion*/
		Genero genero = Genero.SUSPENSE;
		Pelicula p = new Pelicula("CIREL", "Eps Uam", 2018, "Un brillante thriller en el que cientos de alumnos deber�n superar una prueba", genero);
		
		/*Creamos la sesion*/
		System.out.println("Nueva sesi�n creada: \n");
		Sesion sesion = new Sesion(4, 11, 1315, p, 100);
		sesion.mostrarSesion();
		
		/*Probamos los setters*/
		sesion.setButacasDisponibles(50);
		sesion.setFecha(28, 4, 2018);
		Pelicula pelicula = new Pelicula("Los otros", "Alex de la Iglesia", 2010, "Muertos, vivos", Genero.TERROR);
		sesion.setPelicula(pelicula);
		System.out.println("Mostrando sesion modificada:\n");
		sesion.mostrarSesion();
		
		/*Comprobamos que disminuir entradas funciona*/
		System.out.println("Vendiendo 10 entradas.");
		if(sesion.disminuirButacasDisponibles(10) == false) {
			System.out.println("No hay suficiente espacio");
		}
		System.out.println(sesion.getButacasDisponibles() + " butacas disponiles\n");
		sesion.mostrarSesion();
		
		
		
		/*Si intentamos vender mas entradas de las disponibles*/
		System.out.println("Vendiendo 45 entradas.");
		if(sesion.disminuirButacasDisponibles(45) == false) {
			System.out.println("No hay suficiente espacio");
		}
		System.out.println(sesion.getButacasDisponibles() + " butacas disponiles\n");
		sesion.mostrarSesion();
	}

}
