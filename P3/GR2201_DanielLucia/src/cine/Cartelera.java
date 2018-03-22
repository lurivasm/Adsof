/**
 * 
 */
package cine;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Cartelera
 * @author Lucia Rivas Molina <lucia.rivasmolina@estudiante.uam.es>
 * @author Daniel Santo-Tomas Lopez <daniel.santo-tomas@estudiante.uam.es>
 *
 */
public class Cartelera {
	private List<Pelicula> listaPeliculas;
	
	
	/**
	 * Constructor de cartelera
	 * Crea una lista vacia de peliculas
	 */
	public Cartelera() {
		this.listaPeliculas = new ArrayList<Pelicula>();
	}
	
	
	/**
	 * 
	 * @return la lista de peliculas de la cartelera
	 */
	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}
	
	
	/**
	 * Agrega una pelicula a la lista de la cartelera
	 * Sustituye, junto con eliminaPelicula al setter de la lista para su mayor facilidad
	 * 
	 * @param Titulo de la pelicula
	 * @param Director de la pelicula
	 * @param Anno de la pelicula
	 * @param Sinopsis de la pelicula
	 * @param Genero de la pelicula
	 * @return boolean
	 */
	public Boolean addPelicula(String Titulo, String Director, int Anno, String Sinopsis, Genero Genero) {
		Pelicula p = new Pelicula( Titulo, Director, Anno, Sinopsis, Genero);
		
		for(Pelicula pel : listaPeliculas) {
			if(pel.getTitulo().equals(Titulo) == true) {
				return false;
			}
		}
		
		listaPeliculas.add(p);		
		return true;
	}
	
	
	/**
	 * Mostrar cartelera completa
	 */
	public void mostrarCartelera() {
		if(listaPeliculas.size() == 0) {
			System.out.println("La cartelera est� vac�a");
		}
		else{
			for(Pelicula p : listaPeliculas) {
			p.mostrarPelicula();
			}
		}
	}
	
	
	/**
	 * Elimina una pelicula de la lista de la cartelera
	 * Sustituye, junto con addPelicula al setter de la lista para su mayor facilidad
	 * Si la pelicula no esta devuelve false
	 * @param titulo de la pelicula a eliminar
	 * @return boolean
	 */
	public boolean eliminaPelicula(String titulo) {
		for (Pelicula p : listaPeliculas) {
			if (p.getTitulo().compareTo(titulo) == 0) {
				if(listaPeliculas.remove(p) == true) {
					return true;
				}
				break;
			}
		}
		return false;
	}
}
