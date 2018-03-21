package cine;
import java.util.*;

/**
 * Clase Sala
 * @author Lucia Rivas Molina <lucia.rivasmolina@estudiante.uam.es>
 * @author Daniel Santo-Tomás López <daniel.santo-tomas@estudiante.uam.es>
 *
 */
public class Sala {
	private int identificador;
	private int butacas;
	private List<Sesion> sesiones = new ArrayList<Sesion>();
	
	
	/**
	 * Constructor de Sala
	 * @param identificador
	 * @param butacas
	 */
	public Sala(int identificador, int butacas) {		
		this.identificador = identificador;
		this.butacas = butacas;
	}

	/**
	 * 
	 * @param butacas de la sala
	 */
	public void setButacas(int butacas) {
		this.butacas = butacas;
	}

	/**
	 * 
	 * @param sesiones de la sala
	 */
	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}

	/**
	 * Identificador no tiene setter
	 * @return identificador de la sala
	 */
	public int getIdentificador() {
		return identificador;
	}

	/**
	 * 
	 * @return butacas de la sala
	 */
	public int getButacas() {
		return butacas;
	}

	/**
	 * 	
	 * @return lista de sesiones de la sala
	 */
	public List<Sesion> getSesiones() {
		return sesiones;
	}

	/**
	 * Annade una sesion a la lista de sesiones de la sala
	 * Si ya existe una sesion con esa fecha devuelve false
	 * @param sesion que queremos annadir
	 */
	
	public Boolean addSesion(Sesion sesion) {
		for(Sesion s : sesiones) {
			if((s.getFecha().compareTo(sesion.getFecha())) == 0){
				return false;
			}
		}
		sesiones.add(sesion);
		return true;
	}
	
	/**
	 * Muestra la sala junto a todos sus atributos
	 */
	public void mostrarSala() {
		System.out.println("Sala " + identificador + ", " + butacas + " butacas\n" + "Sesiones :\n");
		for(Sesion s: sesiones) {
			s.mostrarSesion();
			
		}
	}
	
	
}
