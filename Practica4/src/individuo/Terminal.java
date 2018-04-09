/**
 * 
 */
package individuo;

import java.util.ArrayList;


import interfaces.INodo;

/**
 * @author eps
 *
 */
public abstract class Terminal extends Nodo {
	protected double value;
	public Terminal(String s) {
		super(s);
		descendientes = new ArrayList<INodo>();
	}
	public void incluirDescendiente(INodo nodo) {
		return;
	}
	
	public double calcular() {
		return value;
	}
	public String toString() {
		return simbolo + " ";
	}
}
