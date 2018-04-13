package tests;
import interfaces.*;

import java.util.*;

import algoritmo.*;
import individuo.*;
public class Prueba {

	public static void main(String[] args) throws Exception {
		 Terminal x = new TerminalAritmetico("x");
		 Funcion suma = new FuncionSuma("+", 2);
		 Funcion multi = new FuncionMultiplicacion("*", 2);
		 Funcion resta = new FuncionResta("-", 2);
		 
		 List<Terminal> t = new ArrayList<Terminal>();
		 List<Funcion> f = new ArrayList<Funcion>();
		 t.add(x);
		 f.add(suma);
		 f.add(resta);
		 f.add(multi);
		
		 IIndividuo indiv1 = new Individuo();
		 IIndividuo indiv2 = new Individuo();
		 indiv1.crearIndividuoAleatorio(1,t,f);
		 indiv2.crearIndividuoAleatorio(2, t, f);
		 indiv1.writeIndividuo();
		 System.out.println();
		 indiv2.writeIndividuo();
		 
		 indiv1.etiquetaNodos();
		 indiv2.etiquetaNodos();
			System.out.println( indiv1.getExpresion().getDescendientes().get(0).getEtiqueta());
			System.out.println( indiv2.getExpresion().getDescendientes().get(0).getDescendientes().get(0).getEtiqueta());

	}

}
