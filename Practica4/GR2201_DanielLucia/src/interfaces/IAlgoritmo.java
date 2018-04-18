package interfaces;

import java.util.*;
import individuo.*;
import excepciones.*;

/**
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public interface IAlgoritmo {
	/**
	 * Establece como conjunto de terminales del algoritmo la lista pasada
	 * @param terminales : lista de terminales
	 */
	public void defineConjuntoTerminales(List<Terminal> terminales);

	/**
	 * Establece como conjunto de funciones del algoritmo la lista pasada
	 * @param funciones : lista de funciones
	 */
	public void defineConjuntoFunciones(List<Funcion> funciones);

	/**
	 * Crea la primera poblacion, creando tantos individuos aleatorios como indique el algoritmo
	 */
	public void crearPoblacion();

	/**
	 * Cruza los arboles prog1 y prog2 , generando dos hijos. Los arboles se cruzan por un punto aleatorio en cada arbol.
	 * @param prog1 : primer arbol
	 * @param prog2 : segundo arbol
	 * @return los dos hijos generados
	 * @throws CruceNuloException si se intenta mezclar dos arboles por el nodo raiz
	 */
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException;

	/**
	 * A raiz de la poblacion anterior, genera una nueva poblacion, haciendo los cruces necesarios.
	 * @throws CruceNuloException
	 */
	public void crearNuevaPoblacion() throws CruceNuloException;

	/**
	 * Ejecuta el algoritmo, haciendo uso del dominio para calcular el fitness de los individuos, comprobando en cada generacion 
	 * cual tiene mas fitness y si llega a converger el algoritmo. El algoritmo acaba si converge o si se llega a maximo de 
	 * generaciones indicadas
	 * @param dominio : dominio a utilizar
	 * @throws CruceNuloException
	 */
	public void ejecutar(IDominio dominio) throws CruceNuloException;
}
