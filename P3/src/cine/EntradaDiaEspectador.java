/**
 * 
 */
package cine;

/**
 * @author eps
 *
 */
public class EntradaDiaEspectador extends Entrada {
	
	private int descuento;
	/**
	 * @param precio
	 */
	public EntradaDiaEspectador(double precio, int descuento) {
		super(precio);
		this.descuento = descuento;
	}
	
	public double getPrecio() {
		return (precio*descuento/100);
	}

}
