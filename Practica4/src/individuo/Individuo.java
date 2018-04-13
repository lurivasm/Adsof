/**
 * 
 */
package individuo;
import java.util.*;


import interfaces.*;

/**
 * Implementacion de a clase individuo
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public class Individuo implements IIndividuo{
	
	/**
	 * Un individuo tiene un nod oexpresion(raiz) y un valor de fitness
	 */
	private INodo expresion;
	private double fitness;
	
	public INodo getExpresion() {
		return expresion;
	}
	public void setExpresion(INodo expresion) {
		this.expresion = expresion.copy();
		this.expresion.setPadre(null);
	}
	public double getFitness() {
		return fitness;
	}
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		Random r = new Random();
		List<INodo> l1 =new ArrayList<INodo>((int)Math.pow(2, profundidad));
		List<INodo> l2;
		
		/*Creamos una lista con todos los terminales. El tamaño de la lista depende de la profundidad*/
		for(int i = 0;i < Math.pow(2, profundidad); i++){
			l1.add(terminales.get(r.nextInt(terminales.size())).copy());
		}
		/*En este bucle, se crea una lista con funciones aleatorias del conjunto de funciones, y de tamaño dependiente de la profundidad.
		 * A continuacion, se enlaza esta lista con la anterior, que corresponde a los nodos de la profundidad anterior.
		 * De esta manera, vamos generando un arbol de abajo a arriba, hasta llegar al nodo raiz,que se establece como expresion del individuo
		 */
		for(int i = profundidad -1; i >= 0 ; i--) {
			l2 = new ArrayList<INodo>((int)Math.pow(2, i));
			int cont = 0;
			for(int j = 0; j < Math.pow(2, i); j++) {
				l2.add(funciones.get(r.nextInt(funciones.size())).copy());
				l2.get(j).incluirDescendiente(l1.get(cont));
				l2.get(j).incluirDescendiente(l1.get(cont +1));
				cont += 2;
				
			}
			l1 = l2;
		}
		expresion = l1.get(0);
	}
		
	public double calcularExpresion() {
		return expresion.calcular();
	}
	public int getNumeroNodos() {
		return expresion.getnumDescendientes() + 1;
	}
	public void writeIndividuo() {
		System.out.println("Expresion: " + expresion);
	}
	
	public void setValorTerminales(double valor) {
		expresion.setValorNodo(valor);
	}
	
	public void etiquetaNodos() {
		expresion.etiquetar(expresion.getnumDescendientes()+1);
	}
	
	public INodo buscar(int etiqueta) {
		return expresion.buscar(etiqueta);
	}
}
