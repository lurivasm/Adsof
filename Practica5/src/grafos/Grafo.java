package grafos;

import java.util.*;

public abstract class Grafo<T> {
	protected Map<Integer, Vertice<T>> vertices;
	protected Map<Integer,Integer> arcos ;
	
	public Vertice<T> addVertice(T datos){
		Vertice<T> v = new Vertice(vertices.size()-1,datos);
		vertices.put(v.getId(), v);
		return v;
	}
	protected Vertice<T> addVertice(int id, T datos){
		
	}
	public List<Vertice<T>> getVertices(){
		
	}
	public int getNumVertices() {
		
	}
	
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		
	}
	public int getNumArcos() {
		
	}
	
	public String toString() {// los vértices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
		
	}
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); // devuelve los vértices que tienen un arco con v
	 // (en grafo dirigido, v ha de ser origen de los arcos)
}
