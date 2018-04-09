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
	/**
	 * Esta funcion calcula cuantos nodos exactamente tiene este nodo por debajo, incluyendo nodos hijos, nietos etc.
	 * @return
	 */
	public int getnumDescendientes() {
		int res = 0;
		for(INodo n : descendientes) {
			res += n.getnumDescendientes();
		}
		return res + descendientes.size();
	}
	
}
