package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GrafoNoDirigido<T> extends Grafo<T> {

	@Override
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		Map<Integer,Integer> m1 = new HashMap<>();
		Map<Integer,Integer> m2 = new HashMap<>();
		m1.put(v1.getId(), v2.getId());
		m2.put(v2.getId(), v1.getId());
		arcos.put(m1, peso);
		arcos.put(m2, peso);		
	}

	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		Map<Integer,Integer> m = new HashMap<>();
		m.put(v1.getId(), v2.getId());
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
