/**
 * 
 */
package cine;

/**
 * Tester de la clase Pelicula
 * @author danist
 *
 */
public class TesterPelicula {

	
	public static void main(String[] args) {
		System.out.println("Creando pelicula...\n");
		Pelicula p1 = new Pelicula("Kingsman:The Secret Service", "Matthew Vaughn",2014,"Cosas de espias ingleses",Genero.ACCION);
		System.out.println("Pelicula creada.Mostrando pelicula...\n");
		p1.mostrarPelicula();
		
		System.out.println("Creando pelicula introduciendo un numero negativo como año...\n");
		Pelicula p2 = new Pelicula("Kingsman:The Secret Service", "Matthew Vaughn",-2014,"Cosas de espias ingleses",Genero.ACCION);
		if(p2.getAnno() == -1) {
			System.out.println("Pelicula con año invalido");
			
		}
		
	}

}
