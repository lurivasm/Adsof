package cine;
import java.util.*;

public class TesterSesion {


	public static void main(String[] args) {
		Genero g = Genero.DRAMA;
		Pelicula p = new Pelicula("Juan Callate","Lucia Rivas",2018,"La trepidante historia de un bebe que no se callaba la boca",g);
		Sala s = new Sala(0, 50);
		Sesion s1 = new Sesion(1, 2, 2018, p, s.getButacas());
		Sesion s2 = new Sesion(28, 4, 2018, p,s.getButacas());
		Sesion s3 = new Sesion(4, 9, 2020, p,s.getButacas());
		s.addSesion(s1);
		s.addSesion(s2);
		s.addSesion(s3);
		List<Sesion> ses = new ArrayList<Sesion>();
		ses = s.getSesiones();
		
		for(Sesion aux :ses) {
			System.out.println(aux.mostrarSesion());
		}
		
		
		
		s1.disminuirButacasDisponibles(5);
		for(Sesion aux :ses) {
			System.out.println(aux.mostrarSesion());
		}
		
		if((s.addSesion(s1)) == false) System.out.println("Fecha invalida" + "\n");
		

	}

}
