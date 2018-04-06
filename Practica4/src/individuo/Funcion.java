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
	
	
}
