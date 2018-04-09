package individuo;

import java.util.ArrayList;


import interfaces.INodo;

public abstract class  Funcion extends Nodo{
	public Funcion(String s, int narg) {
		super(s);
		descendientes = new ArrayList<INodo>(narg);
	}
	
	public void incluirDescendiente(INodo nodo) {
		descendientes.add(nodo);
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
