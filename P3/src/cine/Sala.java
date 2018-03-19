package cine;
import java.util.*;

/**
 * @author Daniel 
 *
 */
public class Sala {
	private int identificador;
	private int butacas;
	private List<Sesion> sesiones = new ArrayList<Sesion>();
	
	
	/**
	 * @param identificador
	 * @param butacas
	 */
	public Sala(int identificador, int butacas) {		
		this.identificador = identificador;
		this.butacas = butacas;
	}

	
	public int getIdentificador() {
		return identificador;
	}

	
	public int getButacas() {
		return butacas;
	}

		
	public List<Sesion> getSesiones() {
		return sesiones;
	}

	/**
	 * @param sesion
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
	
	public void mostrarSala() {
		System.out.println("Sala " + identificador + ", " + butacas + " butacas\n" + "Sesiones :\n");
		for(Sesion s: sesiones) {
			s.mostrarSesion();
			
		}
	}
	
	
}
