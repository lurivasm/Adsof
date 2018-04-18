package interfaces;
import individuo.*;
import java.util.*;
import java.io.*;
import excepciones.*;

/**
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public interface IDominio {
	
	/**
	 * Define un conjunto de terminales  a raiz de los tipos de terminales indicados por strings
	 * @param terminales : strings que representan los terminales a crear
	 * @return conjunto de terminales
	 */
	public List<Terminal> definirConjuntoTerminales(String... terminales);
	
	/**
	 * Define un conjunto de funciones, araiz de los simbolos pasados como strings y del array de int que 
	 * representa los argumentos de las funciones
	 * @param argumentos : array que en cada posicion i tiene el numero de argumentos de la funcion i a crear
	 * @param funciones : simbolos de las funciones a crear. Si es + sera suma, - sera resta y * sera multiplicacion
	 * @return lista de funciones
	 * @throws ArgsDistintosFuncionesException si hay menos argumentos en el array qu efunciones a crear
	 */
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws ArgsDistintosFuncionesException;
	
	/**
	 * Define los valores y los resultados del dominio. Lee de fichero la columna de valores de la funcion y lo guarda en 
	 * el array de valores del dominio , y lee la columna de resultados esperados y la guarda en la lista de resultados
	 * @param ficheroDatos : fichero del que leer
	 * @throws FileNotFoundException si no encuentra el fichero
	 * @throws IOException
	 */
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;
	
	/**
	 * Coge los valores del dominio, se los asigna a los terminales del individuo, calcula la expresion del mismo y la compara 
	 * con el resultado esperado. Si el valor absoluto del valor obtenido menos el esperado es menor o igual que 1, se aumenta el valor del fitness
	 * Al final,se cambia el valor del campo fitnessd el individuo al obtenido, y se devuelve este valor
	 * @param individuo : individuo cuyo fitness se calcula
	 * @return valor del fitness
	 */
	public double calcularFitness(IIndividuo individuo);
}
