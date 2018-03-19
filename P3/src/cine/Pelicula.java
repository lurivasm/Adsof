package cine;

public class Pelicula {
	private String titulo;
	private String director;
	private int anno;
	private String sinopsis;
	private Genero genero;
	
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
	
		
	public String getTitulo() {
		return titulo;
	}
	
		
	public String getDirector() {
		return director;
	}
	
	
	public int getAnno() {
		return anno;
	}
	
		
	public String getSinopsis() {
		return sinopsis;
	}
	
	
	
	public Genero getGenero() {
		return genero;
	}
	
	public void mostrarPelicula() {
		System.out.println("Titulo : " + titulo + "\n" + "Director : " + director + "\n" + "Año : " + anno + "\n" + "Sinopsis : " + sinopsis + "\n" + "Genero : " + genero.name() + "\n");
		
	}
	
}
