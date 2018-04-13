/**
 * 
 */
package individuo;

import interfaces.*;

/**
 * Implementacion de la clase FuncionMultiplicacion
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public class FuncionMultiplicacion extends Funcion {
	 
	/**Constructor del objeto. LLama al constructor de funcion
	 * @param s : simbolo del nodo
	 * @param narg : numero de argumentos(descendientes) de la funcion
	 */
	public FuncionMultiplicacion(String s, int narg) {
		super(s,narg);
	}
	public double calcular() {
		double res = 1;
		for(INodo n : descendientes) {
			res = res*n.calcular();
		}
		return res;
	}
	public INodo copy() {
		INodo n = new FuncionMultiplicacion(simbolo, descendientes.size());
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
