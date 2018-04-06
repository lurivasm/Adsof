/**
 * 
 */
package individuo;
import java.util.*;

import interfaces.*;


/**
 * @author eps
 *
 */
public abstract class Nodo implements INodo {
	protected String simbolo;
	protected List<INodo> descendientes;
	public Nodo(String s) {
		simbolo = s;
	}
	public String getRaiz() {
		return simbolo;
	}
	public List<INodo> getDescendientes(){
		return descendientes;
	}
	
}
