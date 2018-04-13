/**
 * 
 */
package individuo;

import interfaces.*;

/**
 * Implementacion de la clase  FuncionResta
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public class FuncionResta extends Funcion{
	
	/**Constructor del objeto. LLama al constructor de funcion
	 * @param s : simbolo del nodo
	 * @param narg : numero de argumentos(descendientes) de la funcion
	 */
	public FuncionResta(String s, int narg) {
		super(s,narg);
	}
	public double calcular() {
		double res = descendientes.get(0).calcular();
		for(int i = 1;i < descendientes.size(); i++) {
			res -= descendientes.get(i).calcular();
		}
		return res;
	}
	public INodo copy() {
		INodo n = new FuncionResta(simbolo, descendientes.size());
		INodo nodo;
		for(INodo n1 : descendientes) {
			nodo = n1.copy();
			n.incluirDescendiente(nodo);
		}
		n.setPadre(padre);
		n.setEtiqueta(etiqueta);
		return n;
	}
	
}
