package algoritmo;
import individuo.*;
import interfaces.*;
import java.util.*;
import excepciones.*;

/**
 * @author danist
 *
 */
public class Algoritmo implements IAlgoritmo{
	private List<Terminal> terminales;
	private List<Funcion> funciones;
	private List<IIndividuo> poblacion = new ArrayList<IIndividuo>();
	private int profundidad;
	private int individuos;
	private int maxgen;
	
	
	
	
	/**
	 * @param profundidad
	 * @param individuos
	 */
	public Algoritmo(int profundidad, int individuos, int maxgen) {
		this.profundidad = profundidad;
		this.individuos = individuos;
		this.maxgen = maxgen;
	}

	public void defineConjuntoTerminales(List<Terminal> terminales) {
		this.terminales = terminales;		
	}

	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException {
		this.funciones = funciones;		
	}

	
	public void crearPoblacion() {
		IIndividuo ind;
		for(int i = 0; i < individuos; i++) {
			ind = new Individuo();
			ind.crearIndividuoAleatorio(profundidad, terminales, funciones);
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

	
	public void crearNuevaPoblacion() throws Exception {
		int i,maxpos = -1,minpos1 = -1,minpos2 = -1;
		double max = 0.0,min1 = 11, min2 = 11;
		/*buscamos el mejor individuo de la poblacion y los dos peores*/
		for(i = 0; i < poblacion.size(); i++) {
			if(poblacion.get(i).getFitness() > max) {
				maxpos = i;
				max = poblacion.get(i).getFitness();
			}
			if(poblacion.get(i).getFitness() < min1) {
				minpos1 = i;
				min2 = min1;
				min1 = poblacion.get(i).getFitness();
			}
			if(poblacion.get(i).getFitness() > min1 && poblacion.get(i).getFitness() < min2) {
				minpos2 = i;
				min2 = poblacion.get(i).getFitness();
			}
		}
		
		Random r = new Random();
		int ind1,ind2;
		
		while(true) {
			ind1 = r.nextInt(poblacion.size());
			if(ind1 == maxpos || ind1 == minpos1 || ind1 == minpos2) continue;
			break;
		}
		
		while(true) {
			ind2 = r.nextInt(poblacion.size());
			if(ind2 == maxpos || ind2 == minpos1 || ind2 == minpos2 || ind2 == ind1) continue;
			break;
		}
		
		List<IIndividuo> lista;
		try {
			lista= this.cruce(poblacion.get(ind1), poblacion.get(ind2));
		}
		catch(CruceNuloException e){
			System.out.println(e);
			return;
		}
		poblacion.remove(minpos1);
		poblacion.remove(minpos2);
		poblacion.add(lista.get(0));
		poblacion.add(lista.get(1));	
		
	}

	public void ejecutar(IDominio dominio) throws Exception {
		this.crearPoblacion();
		int i,gen = 1,maxpos = -1;
		double max = 0;
		while(gen <= maxgen) {
			if(gen !=1) this.crearNuevaPoblacion();	
			for(IIndividuo ind :poblacion) {
				dominio.calcularFitness(ind);
			}			
			for(i = 0; i < poblacion.size();i++) {
				if(poblacion.get(i).getFitness() > max) {
					maxpos = i;
					max = poblacion.get(i).getFitness();
				}
			}
			
			if(max == 21) {
				break;
			}
			else {
				System.out.println("GENERACION " + gen);
				System.out.println("Individuo con mayor fitness(fitness = " + poblacion.get(maxpos).getFitness() + " ): ");
				poblacion.get(maxpos).writeIndividuo();
			}
			gen++;
		}
		
		System.out.println("Se ha llegado hasta la generacion  " + gen);
		System.out.println("Individuo resultante(con fitness = " + poblacion.get(maxpos).getFitness() + " ): ");
		poblacion.get(maxpos).writeIndividuo();
		
	}

}
