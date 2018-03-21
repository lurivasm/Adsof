package Testing;
import java.util.*;
import cine.*;

/**
 * Tester de la clase Sala
 * @author Daniel Santo-Tomas Lopez <daniel.santo-tomas@estudiante.uam.es>
 * @author Lucia Rivas Molina <lucia.rivasmolina@estudiante.uam.es>
 *
 */
public class TesterSala {


	
	public static void main(String[] args) {
		/*Creamos la pelicula*/
		Genero g = Genero.DRAMA;
		Pelicula p = new Pelicula("Mad Max","Lucia Rivas",2018,"Muchos coches",g);
		
		/*Creamos la sala*/
		System.out.println("Creando sala...\n");
		Sala s = new Sala(0, 50);
		System.out.println("Creada la sala " + s.getIdentificador() + " con " + s.getButacas() + " butacas \n");
		
		/*Creando las sesiones para la sala*/
		Sesion s1 = new Sesion(1, 2, 2018, p, s.getButacas());
		Sesion s2 = new Sesion(28, 4, 2018, p,s.getButacas());
		Sesion s3 = new Sesion(4, 9, 2020, p,s.getButacas());
		System.out.println("Añadiendo sesiones...\n");
		s.addSesion(s1);
		s.addSesion(s2);
		s.addSesion(s3);
		List<Sesion> ses = new ArrayList<Sesion>();
		ses = s.getSesiones();
		System.out.println("Añadidas " + ses.size() + " sesiones \n");
		
		System.out.println("Mostrando sala....\n");
		s.mostrarSala();
		
		/*Comprobamos que falla metiendo dos sesiones en la misma fecha*/
		System.out.println("Introduciendo una sesion con una fecha ya existente...\n");
		if((s.addSesion(s1)) == false) System.out.println("Fecha invalida" + "\n");
		

	}

}
