package individuo;

import interfaces.INodo;

/**
 * Implementacion de la clase TerminalAritmetico
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public class TerminalAritmetico extends Terminal {
	
	/**Constructor del objeto. LLama al constructor de Terminal
	 * @param s: simbolo del nodo
	 */
	public TerminalAritmetico(String s) {
		super(s);
	}
	public INodo copy() {
		INodo n = new TerminalAritmetico(simbolo);
		n.setPadre(padre);
		n.setEtiqueta(etiqueta);
		return n;
	}
	
}
