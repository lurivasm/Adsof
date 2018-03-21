/**
 * 
 */
package Testing;
import cine.*;


/**
 * Tester Clase Pelicula
 * @author Lucia Rivas Molina <lucia.rivasmolina@estudiante.uam.es>
 * @author Daniel Santo-Tom·s LÛpez <daniel.santo-tomas@estudiante.uam.es>
 *
 */
public class TesterPelicula {

	
	public static void main(String[] args) {
		/*Creamos una pelicula*/
		System.out.println("Creando pelicula...\n");
		Pelicula p1 = new Pelicula("Kingsman:The Secret Service", "Matthew Vaughn",2014,"Cosas de espias ingleses",Genero.ACCION);
		System.out.println("Pelicula creada.Mostrando pelicula...\n");
		p1.mostrarPelicula();
		
		/*Creamos una pelicula con una fecha incorrecta*/
		System.out.println("Creando pelicula introduciendo un numero negativo como a√±o...\n");
		Pelicula p2 = new Pelicula("Kingsman:The Secret Service", "Matthew Vaughn",-2014,"Cosas de espias ingleses",Genero.ACCION);
		if(p2.getAnno() == -1) {
			System.out.println("Pelicula con anio invalido");
			
		}
		
	}

}
