/**
 * 
 */
package individuo;

import interfaces.*;

/**
 * @author danist
 *
 */
public class FuncionMultiplicacion extends Funcion {
	 
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
		for(INodo n1 : descendientes) {
			n.incluirDescendiente(n1);
		}
		return n;
	}

}
