package cine;

/**
 * Clase Pelicula
 * @author Lucia Rivas Molina <lucia.rivasmolina@estudiante.uam.es>
 * @author Daniel Santo-Tomás López <daniel.santo-tomas@estudiante.uam.es>
 *
 */

public class Pelicula {
	private String titulo;
	private String director;
	private int anno;
	private String sinopsis;
	private Genero genero;
	
	/**
	 * Constructor de Pelicula
	 * @param Titulo
	 * @param Director
	 * @param Anno
	 * @param Sinopsis
	 * @param Genero
	 * En caso de pasar un anno negativo, lo establecemos como -1 para el control de errores
	 */
	public Pelicula(String Titulo, String Director, int Anno, String Sinopsis, Genero Genero) {
		if(Anno < 0) {
			this.anno = -1;
		}
		else {
			this.anno = Anno;
		}
		
		this.titulo = Titulo;
		this.director = Director;
		this.sinopsis = Sinopsis;
		this.genero = Genero;
	}
	
	/**
	 * 
	 * @param titulo de la pelicula
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * 
	 * @param director de la pelicula
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * 
	 * @param anno de la pelicula
	 */
	public void setAnno(int anno) {
		this.anno = anno;
	}

	/**
	 * 
	 * @param sinopsis de la pelicula
	 */
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	/**
	 * 
	 * @param genero de la pelicula
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * 
	 * @return titulo de la pelicula
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * 
	 * @return director de la pelicula
	 */
	public String getDirector() {
		return director;
	}
	
	/**
	 * 
	 * @return anno de la pelicula
	 */
	public int getAnno() {
		return anno;
	}
	
	/**
	 * 	
	 * @return sinopsis de la pelicula
	 */
	public String getSinopsis() {
		return sinopsis;
	}
	
	
	/**
	 * 
	 * @return genero de la pelicula
	 */
	public Genero getGenero() {
		return genero;
	}
	
	/**
	 * Mostrar la pelicula completa con todos sus datos
	 */
	public void mostrarPelicula() {
		System.out.println("Titulo : " + titulo + "\n" + "Director : " + director + "\n" + "Anno : " + anno + "\n" + "Sinopsis : " + sinopsis + "\n" + "Genero : " + genero.name() + "\n");
		
	}
	
}
