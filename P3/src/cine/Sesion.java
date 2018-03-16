package cine;
import java.time.*;

/**
 * @author eps
 *
 */
public class Sesion {
	private LocalDate fecha;
	private Pelicula pelicula;
	private int butacasDisponibles;
	
	
	/**
	 * @param dia
	 * @param mes
	 * @param anno
	 * @param pelicula
	 * @param sala
	 */
	public Sesion(int dia, int mes, int anno, Pelicula pelicula, int butacasDisponibles) {
		this.fecha = LocalDate.of(anno, mes, dia);
		this.pelicula = pelicula;
		this.butacasDisponibles = butacasDisponibles;
	}
	

	
	/**
	 * @return fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}



	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	/**
	 * @return the pelicula
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}



	/**
	 * @param pelicula the pelicula to set
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}



	/**
	 * @return the butacasDisponibles
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
	 * @param butacas
	 * @return
	 */
	public Boolean disminuirButacasDisponibles(int butacas) {
		if((butacasDisponibles - butacas) < 0) return false;
		butacasDisponibles -= butacas;
		return true;
	}
	
		
	public String mostrarSesion() {
		String s = "Fecha : " + fecha.toString() + "\n" + "Pelicula : " + pelicula.getTitulo() + "\n" + "Butacas Disponibles : " + butacasDisponibles + "\n";
		return s;
	}
	
	
	
}
