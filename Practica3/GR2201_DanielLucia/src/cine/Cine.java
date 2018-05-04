/**
 * 
 */
package cine;
import java.util.*;

/**
 * @author Lucia Rivas Molina <lucia.rivasmolina@estudiante.uam.es>
 * @author Daniel Santo-Tomas Lopez <daniel.santo-tomas@estudiante.uam.es>
 *
 */
public class Cine {
	
	

	private String nombre;
	private String direccion;
	private Cartelera cartelera = new Cartelera();
	private List<Sala> listaSalas = new ArrayList<Sala>();
	private List<Entrada> listaEntradas = new ArrayList<Entrada>(); /*Lista de entradas vendidass*/
	
	/**
	 * Constructor de cine
	 * @param nombre del  cine
	 * @param direccion del cine
	 */
	public Cine(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;	
	}
	
	
	/**
	 * Getter de nombre
	 * @return el nombre del cine
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * getter de la direccion
	 * @return la direccion del cine
	 */
	public String getDireccion() {
		return direccion;
	}


	/**
	 * getter de la catelera
	 * @return la cartelera del cine
	 */
	public Cartelera getCartelera() {
		return cartelera;
	}


	/**
	 * getter de las salas
	 * @return la lista de las salas
	 */
	public List<Sala> getListaSalas() {
		return listaSalas;
	}


	/**
	 * getter de las entradas
	 * @return la lista de las entradas
	 */
	public List<Entrada> getListaEntradas() {
		return listaEntradas;
	}

	

	/**
	 * Setter de la direccion
	 * @param  direccion del cine
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	/**
	 * Setter de nombre
	 * @param nombre del cine
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * Aniade una sala nuev al cine,asignandole el id que correspona al siguiente de la lista de salas del cine
	 * @param butacas de la sala
	 * @return true si se crea la sala con exito,false en otro caso 
	 */
	public Boolean addSala(int butacas) {
		int id = listaSalas.size();
		Sala s = new Sala(id+1, butacas);
		listaSalas.add(s);
		System.out.println("Sala aniadida con exito\n");
		return true;
	}
	
	
	/**
	 * Crea una nueva sesion a partir de una de las peliculas que esta en la cartelera del cine y la aniade a la sala indicada
	 * @param Titulo de la pelicula
	 * @param dia de la sesion
	 * @param mes de la sesion
	 * @param anno de la sesion
	 * @param sala : identificador de la sala donde se aniadir� la sesion
	 * @return true si se crea la sesion con exito,false en otrpo caso
	 */
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
	
	
	
	/**
	 * Crea una pelicula y la aniade a la cartelera del cine
	 * @param Titulo de la pelicula
	 * @param Director de la pelicula
	 * @param Anno de la pelicula
	 * @param Sinopsis de lal pelicula
	 * @param Genero de la pelicula
	 * @return true si se crea y anaiade correctamente ,false en otro caso
	 */
	public Boolean addPelicula(String Titulo, String Director, int Anno, String Sinopsis, Genero Genero) {
		if(cartelera.addPelicula(Titulo, Director, Anno, Sinopsis, Genero) == false) {
			System.out.println("Esa pelicula ya esta en la cartelera\n");
			return false;
		}
		System.out.println("Pelicula aniadida con exito\n");
		
		return true;
	}
	

	 
	/**
	 * Vende una entrada para una sesion ,aniadiendola al array de entradas vendidas del cine y disminuyendo de la sala correspondiente el numero de entradas
	 * Si el campo descuento es 0,se asume que la entrada es normal,si el campo descuento tiene un valor ,se asume que es entrada del dia del espectador
	 * @param sala donde es la sesion
	 * @param pelicula de la sesion
	 * @param dia de la sesion
	 * @param mes de la sesion
	 * @param anno de la sesion
	 * @param nentradas a vender
	 * @param precio de las entradas
	 * @param descuento de la entrada(0 si es normal)
	 * @return true si se vende correctamente,false en caso contrario
	 */
	public Boolean venderEntradas(int sala, String pelicula, int dia , int mes, int anno,  int nentradas, double precio, int descuento) {
		if(listaSalas.size() < sala) {
			System.out.println("No existe la sala " + sala);
			return false;
		}
		
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
		
		Sala sal = listaSalas.get(sala-1);
		
		for(Sesion ses : sal.getSesiones()) {
			if(ses.compareSesion(pelicula,dia, mes ,anno) == true) {
				if(ses.disminuirButacasDisponibles(nentradas) == false) {
					System.out.println("No se pueden vender "+ nentradas + " para la sesion pedida\n");
					return false;
				}
				else {
					for(int i = 0; i < nentradas; i++) {
						listaEntradas.add(e.get(i));
					}			
				}
				System.out.println("Entradas para la pelicula " + pelicula + " en la sala " + sala+ " en la fecha " + anno + "-" + mes + "-" + dia + " vendidas con exito\n");
				return true;
			}
		}
		
		System.out.println("No existe la sesion \n");
		return false;
		
	}
	
	
	/**
	 * Calcula la recaudacion total del cine a raiz de las entradas vendidas
	 * @return recaudacion del cine
	 */
	public double getRecaudacion() {
		double rec = 0;
		for(Entrada e : listaEntradas) {
			rec += e.getPrecio(); 
		}
		return rec;
	}
	
	
	
	
	/**
	 * Elimina una pelicula de la cartelera y de las sesiones de las salas,informando de cuantas sesiones por sala ha sido eliminada
	 * @param Titulo de la pelicula
	 * @return true si se elimina correctamente,false en otro caso 
	 */
	public Boolean removePelicula(String Titulo) {
		if(cartelera.eliminaPelicula(Titulo) == false) {
			System.out.println("La pelicula " + Titulo + " no esta en la cartelera");
			return false;
		}
		
		System.out.println("Eliminada la pelicula " + Titulo + " de las siguientes salas:\n");
		for(Sala sal : listaSalas) {
			int cont = 0;
			for(Sesion ses : sal.getSesiones()) {
				if(ses.getPelicula().getTitulo().equals(Titulo) == true) {
					sal.getSesiones().remove(ses);
					cont++;
				}
			}
			System.out.println("Sala " + sal.getIdentificador() + "\n Eliminadas " + cont + " sesiones\n");
		}
		return true;
	}
		
		
	

	
	
	/**
	 * Muestra la informacion del cine,enseniando las salas con sus sesiones etc 
	 */
	public void mostrarCine() {
		System.out.println("Cines " + nombre + " , " + direccion +"\n Cartelera y Sesiones : \n");
		for(Sala s : listaSalas) {
			s.mostrarSala();
		}
	}
	
	

	
	
}