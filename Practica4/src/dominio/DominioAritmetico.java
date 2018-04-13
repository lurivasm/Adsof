package dominio;

import interfaces.*;
import individuo.*;
import java.util.*;
import java.io.*;
import excepciones.*;

/** Implemetacion de la clase DominioAritmetico
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public class DominioAritmetico implements IDominio {
	
	
	/**
	 * Un dominio tiene una lista de valores y otra de resultados. El valor i tiene asignado el resultado i
	 */
	private List<String> valores = new ArrayList<String>();
	private List<String> resultados = new ArrayList<String>();

	public List<Terminal> definirConjuntoTerminales(String... terminales) {
		List<Terminal> term = new ArrayList<Terminal>();
		Terminal t;
		for(String s : terminales) {
			t = new TerminalAritmetico(s);
			term.add(t);
		}
		return term;
	}

	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws ArgsDistintosFuncionesException {
		int cont = 0;
		List<Funcion> func = new ArrayList<Funcion>();
		Funcion f;
		try {
			for(String s : funciones) {
				if(s.equals("+")) {
					f = new FuncionSuma(s,argumentos[cont]);
					func.add(f);
					cont ++;
				}
				else if(s.equals("-")) {
					f = new FuncionResta(s,argumentos[cont]);
					func.add(f);
					cont ++;
				}
				else if(s.equals("*")) {
					f = new FuncionMultiplicacion(s,argumentos[cont]);
					func.add(f);
					cont ++;
				}
			}
			return func;
		}
		catch(ArrayIndexOutOfBoundsException excep) {
			throw new ArgsDistintosFuncionesException();
		}
		
		
	}

	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException {
		BufferedReader buffer = new BufferedReader(	new InputStreamReader(new FileInputStream(ficheroDatos)));
		String linea;
		while((linea = buffer.readLine()) != null) {
			String[] datos = linea.split(" ");
			valores.add(datos[0]);
			resultados.add(datos[1]);
		}
		buffer.close();
		
	}

	public double calcularFitness(IIndividuo individuo) {
		double res,fit = 0;
		for(int i = 0 ; i < valores.size() ; i++) {
			individuo.setValorTerminales(Double.parseDouble(valores.get(i)));
			res = individuo.calcularExpresion();
			if(Math.abs(Double.parseDouble(resultados.get(i)) - res) <= 1) fit++;
			/*Para testear el test TesterLecturaYFitness hace falta descomentar la linea de abajo*/
			/*System.out.println("Valor " + valores.get(i) +  " <-> Rdo estimado: " + res + " <-> Rdo real: " + resultados.get(i));*/
		}
		individuo.setFitness(fit);
		return fit;
	}

}
