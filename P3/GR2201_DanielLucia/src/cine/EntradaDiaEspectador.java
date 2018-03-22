/**
 * 
 */
package cine;

/**
 * Clase EntradaDiaEspectador
 * @author Lucia Rivas Molina <lucia.rivasmolina@estudiante.uam.es>
 * @author Daniel Santo-Tomas Lopez <daniel.santo-tomas@estudiante.uam.es>
 *
 */
public class EntradaDiaEspectador extends Entrada {
	
	private int descuento;
	/**
	 * 
	 * @param precio
	 */
	public EntradaDiaEspectador(double precio, int descuento) {
		super(precio);
		if(descuento < 0) {
			descuento = -descuento;
		}
		while(descuento > 100) {
			descuento = descuento - 100;
		}
		this.descuento = descuento;
		
	}
	
	/**
	 * Getter del descuento
	 * @return descuento de la entrada especial
	 */
	public int getDescuento() {
		return descuento;
	}

	/**
	 * Setter del descuento
	 * @param descuento de la entrada especial
	 */
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	/**
	 * Getter del precio total
	 * @return precio final con descuento de la entrada especial
	 */
	public double getPrecio() {
		return (precio - precio*descuento/100);
	}

	
}
