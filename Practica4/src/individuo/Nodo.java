/**
 * 
 */
package individuo;
import java.util.*;

import interfaces.*;


/**
 * Implementacion de la clase abstracta Nodo
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es
 *
 */
public abstract class Nodo implements INodo {
	/**
	 * La clase tiene de campos el simbolo del nodo, la lista de descendientes del nodo, la etiqueta y un
	 * puntero al padre del nodo
	 */
	protected String simbolo;
	protected List<INodo> descendientes;
	protected int etiqueta;
	protected INodo padre = null;
	
	/**
	 * Constructor del objeto
	 * Crea un nodo ,asignandole como simbolo el pasado como argumento
	 * @param s : simbolo del nodo
	 */
	public Nodo(String s) {
		simbolo = s;
	}
	
	public String getRaiz() {
		return simbolo;
	}
	
	public List<INodo> getDescendientes(){
		return descendientes;
	}
	
	public int getnumDescendientes() {
		int res = 0;
		for(INodo n : descendientes) {
			res += n.getnumDescendientes();
		}
		return res + descendientes.size();
	}
	
	public void setValorNodo(double valor) {
		for(INodo n : descendientes) {
			n.setValorNodo(valor);
		}
	}
	
	public void etiquetar(int etiactual) {
		for(INodo n : descendientes) {
			n.etiquetar(etiactual);
			etiactual = etiactual - 1 - n.getnumDescendientes();
		}
		etiqueta = etiactual;
		
	}
	public INodo buscar(int etiqueta) {
		if(this.etiqueta == etiqueta) return this;
		INodo res;
		for(INodo n : descendientes) {
			if((res = n.buscar(etiqueta)) !=null) {
				return res;
			}
		}
		return null;
	}
	public int getEtiqueta() {
		return etiqueta;
	}
	
	public void setEtiqueta(int etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	public INodo getPadre() {
		return padre;
	}
	
	public void setPadre(INodo p) {
		padre = p;
	}
	
}
