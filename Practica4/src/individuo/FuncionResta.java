/**
 * 
 */
package individuo;

import interfaces.*;

/**
 * @author danist
 *
 */
public class FuncionResta extends Funcion{
	
	/**
	 * @param s
	 * @param narg
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
		for(INodo n1 : descendientes) {
			n.incluirDescendiente(n1);
		}
		return n;
	}
	
}
