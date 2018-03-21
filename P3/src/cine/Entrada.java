/**
 * 
 */
package cine;

/**
 * Clase Entrada
 * @author Lucia Rivas Molina <lucia.rivasmolina@estudiante.uam.es>
 * @author Daniel Santo-Tomás López <daniel.santo-tomas@estudiante.uam.es>
 *
 */
public class Entrada {
	protected double precio;

	/**
	 * Constructor de la clase Entrada
	 * @param precio
	 */
	public Entrada(double precio) {
		this.precio = precio;
	}

	/**
	 * Getter de precio
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	
	
	/**
	 * Setter de precio
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
