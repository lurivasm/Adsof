package cine;

public class Pelicula {
	private String titulo;
	private String director;
	private int anno;
	private String sinopsis;
	private Genero genero;
	
	public Pelicula(String Titulo, String Director, int Anno, String Sinopsis, Genero Genero) {
		this.titulo = Titulo;
		this.director = Director;
		this.anno = Anno;
		this.sinopsis = Sinopsis;
		this.genero = Genero;
	}
	
	public Boolean setTitulo(String Titulo) {
		this.titulo = Titulo;
		return true;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public Boolean setDirector(String Director) {
		this.director = Director;
		return true;
	}
	
	public String getDirector() {
		return director;
	}
	
	public Boolean setAnno(int Anno) {
		this.anno = Anno;
		return true;
	}
	
	public int getAnno() {
		return anno;
	}
	
	public Boolean setSinopsis(String Sinopsis) {
		this.sinopsis = Sinopsis;
		return true;
	}
	
	public String getSinopsis() {
		return sinopsis;
	}
	
	public Boolean setGenero(Genero Genero) {
		this.genero = Genero;
		return true;
	}
	
	public Genero getGenero() {
		return genero;
	}
	
	public String mostrarDatos() {
		String s = "Titulo : " + titulo + "\n" + "Director : " + director + "\n" + "Año : " + anno + "\n" + "Sinopsis : " + sinopsis + "\n" + "Genero : " + genero.name() + "\n";
		return s;
	}
	
}
