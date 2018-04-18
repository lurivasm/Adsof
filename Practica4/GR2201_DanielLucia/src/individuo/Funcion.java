package individuo;

import java.util.ArrayList;


import interfaces.INodo;


/**
 * Implementacion de la clase abstrata Funcion
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public abstract class  Funcion extends Nodo{
	
	/**
	 * Constructor de la clase
	 * @param s : simbolo del nodo
	 * @param narg : numero de argumentos(descendientes) de la funcion
	 */
	public Funcion(String s, int narg) {
		super(s);
		descendientes = new ArrayList<INodo>(narg);
	}
	
	public void incluirDescendiente(INodo nodo) {
		nodo.setPadre(this);
		descendientes.add(nodo.copy());
		
	}
	
	public String toString() {
		String s = "";
		for(INodo n : descendientes) {
			s = s + n.toString();
		}
		for(int i = 1; i < descendientes.size() ; i++ ) {
			s = simbolo + " "+ s;
		}
		return "( " + s + ") ";
	}
	
}
