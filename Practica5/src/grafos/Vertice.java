package grafos;

public class Vertice <T>{
	private final int id; // identificador del vértice dentro del grafo
	private T datos; // datos almacenados en el vértice 
	
	public Vertice(int id, T dat){
		this.id = id;
		datos = dat;		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the datos
	 */
	public T getDatos() {
		return datos;
	}
	
}
