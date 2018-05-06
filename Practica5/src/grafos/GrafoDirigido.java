
package grafos;

import java.util.*;

/**
 * @author danist
 *
 */
public class GrafoDirigido<T> extends Grafo<T> {

	@Override
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		Map<Integer,Integer> m = new HashMap<>();
		m.put(v1.getId(), v2.getId());
		arcos.put(m, peso);		
	}

	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		Map<Integer,Integer> m = new HashMap<>();
		m.put(v1.getId(), v2.getId());
		if(arcos.get(m) == null) return 0;
		return arcos.get(m);
	}

	@Override
	public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
		List<Vertice<T>> list = new ArrayList<Vertice<T>>();
		Set<Map<Integer,Integer>> keys = arcos.keySet();
		for(Map<Integer,Integer> m : keys) {
			if(m.get(v.getId()) != null) list.add(vertices.get(m.get(v.getId())));
		}
		return list;
	}



}
