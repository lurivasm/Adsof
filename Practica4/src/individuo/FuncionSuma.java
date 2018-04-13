/**
 * 
 */
package individuo;

import interfaces.INodo;

/**
 * Implementacion de la clase  FuncionSuma
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public class FuncionSuma extends Funcion{

	/**Constructor del objeto. LLama al constructor de funcion
	 * @param s : simbolo del nodo
	 * @param narg : numero de argumentos(descendientes) de la funcion
	 */
	public FuncionSuma(String s, int narg) {
		super(s,narg);
	}
	public double calcular() {
		double res = 0;
		for(INodo n : descendientes) {
			res += n.calcular();
		}
		return res;
	}
	public INodo copy() {
		INodo n = new FuncionSuma(simbolo, descendientes.size());
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

