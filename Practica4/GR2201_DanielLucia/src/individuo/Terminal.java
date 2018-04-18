/**
 * 
 */
package individuo;

import java.util.ArrayList;


import interfaces.INodo;


/**
 * Implementacion de la clase Terminal
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public abstract class Terminal extends Nodo {
	
	/**
	 * Los terminales tienen un campo con su valor. Este campo no esta inicializado
	 */
	private double valor;
	
	/**Constructor del objeto. Establece el simbolo e inicializa la lista de descendientes como vacia
	 * @param s : simbolo del nodo
	 */
	public Terminal(String s) {
		super(s);
		descendientes = new ArrayList<INodo>();
	}
	public void incluirDescendiente(INodo nodo) {
		return;
	}
	
	public double calcular() {
		return valor;
	}
	public String toString() {
		return simbolo + " ";
	}
	public void setValorNodo(double valor) {
		this.valor = valor;
	}
}
