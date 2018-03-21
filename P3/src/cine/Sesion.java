package cine;
import java.time.*;

/**
 * Clase Sesion
 * @author Lucia Rivas Molina <lucia.rivasmolina@estudiante.uam.es>
 * @author Daniel Santo-Tom�s L�pez <daniel.santo-tomas@estudiante.uam.es>
 *
 */
public class Sesion {
	private LocalDate fecha;
	private Pelicula pelicula;
	private int butacasDisponibles;
	
	
	/**
	 * Constructor de Sesion
	 * @param dia de la sesion
	 * @param mes de la sesion
	 * @param anno de la sesion
	 * @param pelicula de la sesion
	 * @param sala de la sesion
	 */
	public Sesion(int dia, int mes, int anno, Pelicula pelicula, int butacasDisponibles) {
		this.fecha = LocalDate.of(anno, mes, dia);
		this.pelicula = pelicula;
		this.butacasDisponibles = butacasDisponibles;
	}
	

	
	/**
	 * @return fecha de la sesion
	 */
	public LocalDate getFecha() {
		return fecha;
	}



	/**
	 * @param fecha de la sesion
	 */
	public void setFecha(int dia, int mes, int anno) {
		this.fecha = LocalDate.of(anno, mes, dia);
	}



	/**
	 * @return pelicula de la sesion
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}



	/**
	 * @param pelicula de la sesion
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}



	/**
	 * @return butacas disponibles de la sesion
	 */
	public int getButacasDisponibles() {
		return butacasDisponibles;
	}



	/**
	 * @param butacasDisponibles the butacasDisponibles to set
	 */
	public void setButacasDisponibles(int butacasDisponibles) {
		this.butacasDisponibles = butacasDisponibles;
	}


	/**
	 * Devuelve false si queremos comprar mas entradas de las disponibles
	 * @param butacas que queremos comprar
	 * @return boolean
	 */
	public Boolean disminuirButacasDisponibles(int butacas) {
		if((butacasDisponibles - butacas) < 0) return false;
		butacasDisponibles -= butacas;
		return true;
	}
	
		
	/**
	 * Muestra la sesion completa con todos sus atributos
	 */
	public void mostrarSesion() {
		System.out.println("Fecha : " + fecha.toString() + "\n" + "Pelicula : " + pelicula.getTitulo() + "\n" + "Butacas Disponibles : " + butacasDisponibles + "\n\n");
		
	}
	
	/**
	 * Compara la sesion con otra dados el titulo de la pelicula y la fecha de la otra sesion
	 * @param Titulo
	 * @param dia
	 * @param mes
	 * @param anno
	 * @return true i son iguales,false si son distintos
	 */
	public Boolean compareSesion(String Titulo, int dia, int mes, int anno) {
		LocalDate fech = LocalDate.of(anno, mes, dia);
		if(Titulo.equals(pelicula.getTitulo()) == true) {
			if(fech.isEqual(fecha) == true) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
