/**
 * 
 */
package grafos;

import java.util.*;

/**
 * @author danist
 *
 */
public class GrafoDirigido extends Grafo<T> {

	
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		Map<Integer,Double> m = new HashMap<Integer,Double>();
		m.put(v2.getId(), peso);
		arcos.put(v1.getId(), m);
	}

	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
		// TODO Auto-generated method stub
		return null;
	}



}
