package grafos;

import java.util.*;

public abstract class Grafo<T> {
	protected Map<Integer, Vertice<T>> vertices = new HashMap<Integer,Vertice<T>>();
	protected Map<Map<Integer,Integer>,Double> arcos = new HashMap<Map<Integer,Integer>,Double>() ;
	
	public Vertice<T> addVertice(T datos){
		Vertice<T> v = new Vertice<T>(vertices.size(),datos);
		vertices.put(v.getId(), v);
		return v;
	}
	protected Vertice<T> addVertice(int id, T datos){
		Vertice<T> v = new Vertice<T>(id,datos);
		Vertice<T> v1;
		if((v1 = vertices.putIfAbsent(id, v)) == null){
			return v;
		}
		else return v1;		
	}
	public List<Vertice<T>> getVertices(){
		List<Vertice<T>> list = new ArrayList<Vertice<T>>();
		list.addAll(vertices.values());
		Collections.reverse(list);
		return list;		
	}
	public int getNumVertices() {
		return vertices.size();
	}
	
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		Map<Integer,Integer> m = new HashMap<>();
		m.put(v1.getId(), v2.getId());
		if(arcos.get(m) == null) return false;
		else return true;
		
	}
	public int getNumArcos() {
		return arcos.size()/2;
	}
	
	public String toString() {// los vértices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
		String s = "";
		for(Vertice<T> v : this.getVertices()) s += "Id : " + v.getId() + " , Datos : " + v.getDatos() + "\n";
		return s;
	}
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); // devuelve los vértices que tienen un arco con v
	 // (en grafo dirigido, v ha de ser origen de los arcos)
}
