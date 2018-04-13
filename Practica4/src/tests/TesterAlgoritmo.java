package tests;
import interfaces.*;
import java.util.*;
import algoritmo.*;
import individuo.*;
import dominio.*;
public class TesterAlgoritmo {

	public static void main(String[] args) throws Exception {
		IDominio dominio = new DominioAritmetico();
		IAlgoritmo algoritmo = new Algoritmo(3,10,10);
		dominio.definirValoresPrueba("valores.txt");
		int[] arg = {2,2,2};
		
		algoritmo.defineConjuntoFunciones(dominio.definirConjuntoFunciones(arg,"*","-","+"));
		algoritmo.defineConjuntoTerminales(dominio.definirConjuntoTerminales("x"));
		algoritmo.ejecutar(dominio);
	}

}
