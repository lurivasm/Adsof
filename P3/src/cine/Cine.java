/**
 * 
 */
package cine;
import java.util.*;

/**
 * @author Lucia Rivas Molina <lucia.rivasmolina@estudiante.uam.es>
 * @author Daniel Santo-Tomás López <daniel.santo-tomas@estudiante.uam.es>
 *
 */
public class Cine {
	
	

	private String nombre;
	private String direccion;
	private Cartelera cartelera = new Cartelera();
	private List<Sala> listaSalas = new ArrayList<Sala>();
	private List<Entrada> listaEntradas = new ArrayList<Entrada>(); /*Lista de entradas vendidass*/
	
	/**
	 * @param nombre del  cine
	 * @param direccion del cine
	 */
	public Cine(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;	
	}
	
	
	/**
	 * @return el nombre del cine
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @return la direccion del cine
	 */
	public String getDireccion() {
		return direccion;
	}


	/**
	 * @return la cartelera del cine
	 */
	public Cartelera getCartelera() {
		return cartelera;
	}


	/**
	 * @return la lista de las salas
	 */
	public List<Sala> getListaSalas() {
		return listaSalas;
	}


	/**
	 * @return la lista de las entradas
	 */
	public List<Entrada> getListaEntradas() {
		return listaEntradas;
	}

	

	/**
	 * @param nueva direccion del cine
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @param butacas
	 * @return
	 */
	public Boolean addSala(int butacas) {
		int id = listaSalas.size();
		Sala s = new Sala(id+1, butacas);
		listaSalas.add(s);
		System.out.println("Sala añadida con exito\n");
		return true;
	}
	
	
	public Boolean nuevaSesion(String Titulo, int dia, int mes, int anno, int sala)	{
		for(Pelicula p : cartelera.getListaPeliculas()) {
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
		if(cartelera.addPelicula(Titulo, Director, Anno, Sinopsis, Genero) == false) {
			System.out.println("Error añadiendo la pelicula\n");
			return false;
		}
		System.out.println("Pelicula añadida con exito\n");
		
		return true;
	}
	
	
	public Boolean venderEntradas(Sesion s, int nentradas, double precio, int descuento) {
		List<Entrada> e = new ArrayList<Entrada>();
		if(descuento > 0) {	
			Entrada en =  new EntradaDiaEspectador(precio, descuento);
			for(int i = 0; i < nentradas; i++) {
				 e.add(en);
			}
			
		}
		else {	
			Entrada en = new Entrada(precio);
			for(int i = 0; i < nentradas; i++) {
				e.add(en);
			}
		}
		
		for(Sala sal : listaSalas) {
			for(Sesion ses : sal.getSesiones()) {
				if(ses.equals(s)) {
					if(s.disminuirButacasDisponibles(nentradas) == false) {
						System.out.println("No se pueden vender "+ nentradas + " para la sesion pedida\n");
						return false;
					}
					else {
						for(int i = 0; i < nentradas; i++) {
							listaEntradas.add(e.get(i));
						}			
					}
					return true;
				}
			}
		}
		System.out.println("No existe la sesion \n");
		return false;
		
	}
	
	
	public double getRecaudacion() {
		double rec = 0;
		for(Entrada e : listaEntradas) {
			rec += e.getPrecio(); 
		}
		return rec;
	}
	
	
	
	
	public Boolean removePelicula(String Titulo) {
		if(cartelera.eliminaPelicula(Titulo) == false) {
			System.out.println("La pelicula " + Titulo + " no esta en la cartelera");
			return false;
		}
		
		System.out.println("Eliminada la pelicula " + Titulo + " de las siguientes salas:\n");
		for(Sala sal : listaSalas) {
			int cont = 0;
			for(Sesion ses : sal.getSesiones()) {
				if(ses.getPelicula().getTitulo().equals(Titulo)) {
					sal.getSesiones().remove(ses);
					cont++;
				}
			}
			System.out.println("Sala " + sal.getIdentificador() + "\n Eliminadas " + cont + " sesiones\n");
		}
		return true;
	}
		
		
	

	
	
	public void mostrarCine() {
		System.out.println("Cines " + nombre + " , " + direccion +"\n Cartelera y Sesiones : \n");
		for(Sala s : listaSalas) {
			s.mostrarSala();
		}
	}
	
	

	
	
}
