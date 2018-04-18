package excepciones;

/**
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public class ArgsDistintosFuncionesException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5281376210797289816L;
	
	public String toString() {
		return "El numero de argumentos dados es distinto al numero de funciones dadas";
	}

}
