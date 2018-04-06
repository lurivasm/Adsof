/**
 * 
 */
package individuo;

import interfaces.INodo;

/**
 * @author eps
 *
 */
public class FuncionSuma extends Funcion{

	/**
	 * 
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
		return n;
	}
}
