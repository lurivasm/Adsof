/**
 * 
 */
package interfaces;

import java.util.List;

import individuo.Funcion;
import individuo.Terminal;

/**
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public interface IIndividuo {
	
	/**
	 * Devuelve el nodo raiz del individuo
	 * @return expresion del individuo
	 */
	public INodo getExpresion();
	
	/**
	 * Establece la expresion(nodo raiz) del individuo
	 * @param expresion
	 */
	public void setExpresion(INodo expresion);
	
	/**
	 * Devuelve el valor del fitness del individuo
	 * @return fitness
	 */
	public double getFitness();
	
	/**
	 * Establece el valor del fitness del individuo
	 * @param fitness: valor a establecer
	 */
	public void setFitness(double fitness);
	
	/**
	 * Crea un individuo aleatorio de la profundidad dada ,a raiz de terminales y funciones obtenidos de los conjuntos pasados
	 * Todos los nodos funciones tienen 2 argumentos
	 * @param profundidad : prof del individuo a crear
	 * @param terminales: conjunto de terminales
	 * @param funciones : conjunto de funciones
	 */
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones);
	
	/**
	 * Llama al metodo calcular sobre el nodo expresion del individuo, calculando el valor asociado a la expresion que
	 * representa el arbol
	 * @return valor de la expresion
	 */
	public double calcularExpresion();
	
	/**
	 * Devuelve el numero de nodos del individuo
	 * @return numero de nodos
	 */
	public int getNumeroNodos();
	
	/**
	 * Imprime por pantalla la expresion del  individuo
	 */
	public void writeIndividuo();
	
	/**
	 * Establece el avlor dado en los terminales del arbol
	 * @param valor : valor a establecer
	 */
	public void setValorTerminales(double valor);
	
	/**
	 * Etiqueta los nodos del individuo
	 */
	public void etiquetaNodos();
	
	/**
	 * Busca entre los nodos aquel con la etiqueta dada
	 * @param etiqueta: etiqueta del nodo a buscar
	 * @return nodo
	 */
	public INodo buscar(int etiqueta);
} 
