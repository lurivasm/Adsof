package got;

public class PersonajeGOT {
	
	private String nombre;
	private String casa;
	
	public PersonajeGOT(String n, String c) {
		nombre = n;
		casa = c;		
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the casa
	 */
	public String getCasa() {
		return casa;
	}

	/**
	 * @param casa the casa to set
	 */
	public void setCasa(String casa) {
		this.casa = casa;
	}
	
}