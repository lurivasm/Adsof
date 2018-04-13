package algoritmo;
import individuo.*;
import interfaces.*;

import java.util.List;

import excepciones.*;
public class Algoritmo implements IAlgoritmo{
	private List<Terminal> terminales;
	private List<Funcion> funciones;
	private PruebaCruce p;
	private List<IIndividuo> poblacion;
	private int profundidad;
	private int individuos;
	private int probCruce;
	private int kTorneo;
	
	
	
	/**
	 * @param profundidad
	 * @param individuos
	 * @param probCruce
	 * @param kTorneo
	 */
	public Algoritmo(int profundidad, int individuos, int probCruce, int kTorneo) {
		this.profundidad = profundidad;
		this.individuos = individuos;
		this.probCruce = probCruce;
		this.kTorneo = kTorneo;
	}

	public void defineConjuntoTerminales(List<Terminal> terminales) {
		this.terminales = terminales;		
	}

	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException {
		this.funciones = funciones;		
	}

	
	public void crearPoblacion() {
		
		
	}

	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException {
		return p.cruce(prog1, prog2);
	}

	public void crearNuevaPoblacion() {
		// TODO Auto-generated method stub
		
	}

	public void ejecutar(IDominio dominio) {
		// TODO Auto-generated method stub
		
	}

}
