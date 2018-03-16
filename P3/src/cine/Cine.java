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
	private List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
	private List<Sala> listaSalas = new ArrayList<Sala>();
	private List<Entrada> listaEntradas = new ArrayList<Entrada>(); /*Lista de entradas vendidass*/
	
	/**
	 * @param nombre
	 * @param direccion
	 * @param numSalas
	 */
	public Cine(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;	
	}
	

	public Boolean addSala(int butacas) {
		int id = listaSalas.size();
		Sala s = new Sala(id+1, butacas);
		listaSalas.add(s);
		System.out.println("Sala añadida con exito\n");
		return true;
	}
	
	
	public Boolean nuevaSesion(String Titulo, int dia, int mes, int anno, int sala)	{
		for(Pelicula p : listaPeliculas) {
			if( (p.getTitulo().equals(Titulo)) == true) {				
				for(Sala s : listaSalas) {
					if(s.getIdentificador() == sala) {
						Sesion ses = new Sesion(dia, mes, anno, p, s.getButacas());
						if(s.addSesion(ses) == false) {
							System.out.println("Ya existe una sesion con esta fecha en la sala "+ sala + "\n");
							return false;
						}
						System.out.println("Creada la sesion en la sala"+ sala +"\n");
						return true;
					}
				}
				System.out.println("No existe sala con el id "+ sala + "\n");
				return false;
			}
		}
		System.out.println("No existe la pelicula "+ Titulo +" en la cartelera." + "\n");
		return false;
	}
	
	public Boolean addPelicula(String Titulo, String Director, int Anno, String Sinopsis, Genero Genero) {
		Pelicula p = new Pelicula( Titulo, Director, Anno, Sinopsis, Genero);
		if(p.getAnno() == -1) {
			System.out.println("Error añadiendo la pelicula\n");
			return false;
		}
		
		listaPeliculas.add(p);
		System.out.println("Pelicula añadida con exito\n");
		
		return true;
	}
	
	
	public Boolean venderEntradas()
	
}
