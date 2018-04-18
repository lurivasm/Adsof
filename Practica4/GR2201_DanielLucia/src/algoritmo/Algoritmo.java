package algoritmo;
import individuo.*;
import interfaces.*;
import java.util.*;
import excepciones.*;

/**
 * Clase Algoritmo
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public class Algoritmo implements IAlgoritmo{
		
	
	private List<Terminal> terminales;
	private List<Funcion> funciones;
	private List<IIndividuo> poblacion = new ArrayList<IIndividuo>();
	private int profundidad;
	private int individuos;
	private int maxgen;
	private int probCruce;
	
	
	
	/**
	 * El constructor de algoritmo recibe la profundidad de los individuos aleatorios de la primera poblacion, el numero de
	 * individuos de la poblacion, el numero maximo de generaciones y el porcentaje de individuos a cruzar al pasar de generacion	 * 
	 * @param profundidad : prof de individuos
	 * @param individuos : numero de individuos
	 * @param maxgen : maximo de generaciones
	 * @param probCruce : porcentaje de individuos a cruzar
	 */
	public Algoritmo(int profundidad, int individuos, int maxgen, int probCruce) {
		this.profundidad = profundidad;
		this.individuos = individuos;
		this.maxgen = maxgen;
		this.probCruce = probCruce;
	}

	public void defineConjuntoTerminales(List<Terminal> terminales) {
		this.terminales = terminales;		
	}

	public void defineConjuntoFunciones(List<Funcion> funciones) {
		this.funciones = funciones;		
	}

	
	public void crearPoblacion() {
		IIndividuo ind;
		for(int i = 0; i < individuos; i++) {
			ind = new Individuo();
			ind.crearIndividuoAleatorio(profundidad, terminales, funciones);
			ind.etiquetaNodos();
			poblacion.add(ind);
		}
		
	}

	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException {
		List<IIndividuo> res = new ArrayList<IIndividuo>(2);
		IIndividuo in = new Individuo();
		res.add(in);
		in = new Individuo();
		res.add(in);
		
		res.get(0).setExpresion(prog1.getExpresion().copy());
		res.get(1).setExpresion(prog2.getExpresion().copy());
		
		Random r = new Random();
		int punto1 = r.nextInt(prog1.getNumeroNodos()) + 1;
		int punto2 = r.nextInt(prog2.getNumeroNodos())+1;
				
		if(punto1 == punto2 && punto1 == 1) throw new CruceNuloException();
		
		
		INodo nodo1 = res.get(0).buscar(punto1);
		INodo nodo2 = res.get(1).buscar(punto2);
		INodo aux1 = nodo1.copy();
		INodo aux2 = nodo2.getPadre();
				
		nodo2.setPadre(nodo1.getPadre());
		if(nodo1.getPadre() != null) {
			for(int i = 0; i < nodo1.getPadre().getDescendientes().size(); i++) {
				if(nodo1.getPadre().getDescendientes().get(i).getEtiqueta() == nodo1.getEtiqueta()) {
					nodo1.getPadre().getDescendientes().remove(i);
					nodo1.getPadre().getDescendientes().add(i, nodo2);				
				}
			}
		}
		else {
			res.get(0).setExpresion(nodo2);
		}
		
		aux1.setPadre(aux2);
		if(aux2 != null) {
			for(int i = 0; i < aux2.getDescendientes().size(); i++) {
				if(aux2.getDescendientes().get(i).getEtiqueta() == nodo2.getEtiqueta()) {
					aux2.getDescendientes().remove(i);
					aux2.getDescendientes().add(i, aux1);
				}
			}
		}
		else {
			res.get(1).setExpresion(aux1);
		}
		
		res.get(0).etiquetaNodos();
		res.get(1).etiquetaNodos();
		
		return res;
	}

	
	public void crearNuevaPoblacion() throws CruceNuloException {
		int i;
		/*ordenamos la poblacion de mayor a menor fitness*/
		Collections.sort(poblacion,new FitnessComparator());
		/*El primer individuo de la lista es el mejor, a ese no se le cruza*/
		
		Random r = new Random();
		int ind;
		int max_ind = probCruce*individuos/100;
		/*Obtenemos la lista de max_ind a cruzar*/
		List<IIndividuo> cruces = new ArrayList<IIndividuo>(max_ind);
		for(i = 0; i < max_ind;i++) {
			while(true) {
				ind = r.nextInt(poblacion.size());
				if(ind == 0 || cruces.contains(poblacion.get(ind))) continue;
				break;				
			}
			cruces.add(poblacion.get(ind));						
		}
		
		/*Para cruzarles dos a dos, no aseguramos de que el tama�o de la lista es par, y si no lo es, quitamos un individuo*/
		if(cruces.size()%2 == 1) cruces.remove(0);
		
		List<IIndividuo> lista = new ArrayList<IIndividuo>();
		int cont = 0,flag = 0;
		while(cont < cruces.size()) {
			while(true) {
				try {
					lista= this.cruce(cruces.get(cont), cruces.get(cont +1));
					break;
				}
				catch(CruceNuloException e){
					/*si la excepcion salta porque ambos individuos tienen solo un nodo, se pone un flag a 1 para indicar que no ha habido cruce*/
					if(cruces.get(cont).getExpresion().getRaiz().equals("x") != true || cruces.get(cont+1).getExpresion().getRaiz().equals("x") != true) continue;
					flag = 1;
					break;
				}
			}
			/*Si el flag esta a 0 es que ha habido cruce, asi que se actualiza la poblacion*/
			if(flag == 0) {
				poblacion.remove(cruces.get(cont));
				poblacion.remove(cruces.get(cont+1));
				poblacion.add(lista.get(0));
				poblacion.add(lista.get(1));
			}
			
			flag = 0;
			cont +=2;						
		}	
	}

	public void ejecutar(IDominio dominio) throws CruceNuloException {
		this.crearPoblacion();
		int gen = 0;
		
		FitnessComparator comp = new FitnessComparator();
		while(gen < maxgen) {
			gen++;
			if(gen !=1) this.crearNuevaPoblacion();	
			for(IIndividuo ind :poblacion) {
				dominio.calcularFitness(ind);
			}			
			Collections.sort(poblacion,comp);
			System.out.println(poblacion.size());
			
			if(poblacion.get(0).getFitness() == 21) {
				break;
			}
			else {
				System.out.println("GENERACION " + gen);
				System.out.println("Individuo con mayor fitness(fitness = " + poblacion.get(0).getFitness() + " ): ");
				poblacion.get(0).writeIndividuo();
			}			
		}
		
		System.out.println("Se ha llegado hasta la generacion  " + gen );
		System.out.println("Individuo resultante(con fitness = " + poblacion.get(0).getFitness() + " ): ");
		poblacion.get(0).writeIndividuo();
		
	}

}
