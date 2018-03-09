/**
 * 
 */
package cine;
import java.util.*;

/**
 * @author eps
 *
 */
public class Cine {
	
	private String nombre;
	private String direccion;
	private List<Pelicula> peliculas = new ArrayList<Pelicula>();
	private List<Sala> salas = new ArrayList<Sala>();
	private List<Entrada> entradas = new ArrayList<Entrada>();
	private int numSalas;
	
	/**
	 * @param nombre
	 * @param direccion
	 * @param numSalas
	 */
	public Cine(String nombre, String direccion, int numSalas) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.numSalas = numSalas;
		int i;
		Sala[] s = new Sala[numSalas];
		for(i = 0; i < numSalas; i ++) {
			s[i] = new Sala(i,50);
		}
	}
	
	
	
	public Boolean addPelicula(String Titulo, String Director, int Anno, String Sinopsis, Genero Genero) {
		Pelicula p = new Pelicula(String Titulo, String Director, int Anno, String Sinopsis, Genero Genero);
		peliculas.add(p);
		
	}
	
	
}
