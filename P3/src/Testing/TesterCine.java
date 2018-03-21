/**
 * 
 */
package Testing;
import cine.*;

/**
 * Tester de cine
 * @author Lucia Rivas Molina <lucia.rivasmolina@estudiante.uam.es>
 * @author Daniel Santo-Tom�s L�pez <daniel.santo-tomas@estudiante.uam.es>
 *
 */
public class TesterCine {

	/**
	 * @param args
	 */
	public static void  main(String[] args) {
		System.out.println("Creando el cine...\n");
		Cine c = new Cine("Cinesa","Avenida de Manoteras");
		System.out.println("Cine creado. Mostrando cine...\n");
		c.mostrarCine();
		System.out.println("Aniadiendo 2 salas al cine con 10 butacas cada uno...\n");
		c.addSala(10);
		c.addSala(10);
		System.out.println("Salas aniadidas con exito.Mostrando cine: ");
		c.mostrarCine();
		System.out.println("Aniadiendo 2 peliculas distintas a la cartelera...");
		c.addPelicula("Kingsman:The Secret Service", "Matthew Vaughn",2014,"Cosas de espias ingleses",Genero.ACCION);
		c.addPelicula("La Forma del Agua", "Guillermo del Toro", 2018, "Un bicho y una mujer se enamoran", Genero.ROMANCE);
		System.out.println("Peliculas aniadidas. Mostrando cartelera...");
		c.getCartelera().mostrarCartelera();
		System.out.println("Probamos a introducir una pelicula otra vez");
		c.addPelicula("La Forma del Agua", "Guillermo del Toro", 2018, "Un bicho y una mujer se enamoran", Genero.ROMANCE);
		System.out.println("Creamos 2 sesiones por sala ");
		c.nuevaSesion("La Forma del Agua", 21, 3, 2018, 1);
		c.nuevaSesion("La Forma del Agua", 22, 3, 2018, 2);
		c.nuevaSesion("Kingsman:The Secret Service", 22, 3, 2018, 1);
		c.nuevaSesion("Kingsman:The Secret Service", 21, 3, 2018, 2);
		System.out.println("Sesiones creadas. Mostrando cine...\n");
		c.mostrarCine();
		System.out.println("Anadiendo a a sala 1 una sesion de un dia ya ocupado...\n");
		c.nuevaSesion("Kingsman:The Secret Service", 21, 3, 2018, 1);
		System.out.println("Anadiendo una pelicula a la sala 3...\n");
		c.nuevaSesion("Kingsman:The Secret Service", 21, 3, 2018, 3);
		System.out.println("Anadiendo una pelicula que no esta en la cartelera...\n");
		c.nuevaSesion("Matrix", 21, 3, 2018, 3);
		System.out.println("Probamos a vender dos entradas para una de las sesiones de la sala 1");
		c.venderEntradas(1,"LA Forma del Agua",21,3,2018, 2, 10, 0);
		
		
		
		}
}
