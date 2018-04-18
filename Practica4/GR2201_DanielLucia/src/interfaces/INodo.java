package interfaces;

import java.util.*;

/**
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public interface INodo {
	
/**
 * Devuelve el simbolo que representa el Nodo
 * @return simbolo
 */
public String getRaiz();

/**
 * Devuelve la lista de descendientes del Nodo.Si es un Terminal, devuelve la lista vacia
 * @return lista de descendientes
 */
public List<INodo> getDescendientes();

/**
 * Esta funcion calcula cuantos nodos exactamente tiene este nodo por debajo, incluyendo nodos hijos, nietos etc.
 * @return numero de descendientes
 */
public int getnumDescendientes();

/**
 * Establece este nodo como el padre del nodo pasado como argumento, y despues incluye una copia del nodo pasado al la lista de descendientes de este nodo.
 * En caso de ser un Terminal,la funcion no hace nada
 * @param nodo : nodo a incluir
 */
public void incluirDescendiente(INodo nodo);

/**
 * Si el nodo es una funcion, obtiene el valor de calcular() en cada uno de sus descendientes y les aplica la operacion correspondiente(suma,resta o multiplicacion,depende del tipo de Funcion)
 * Si el nodo es un Terminal, devuelve el valor que tenga asignado en su campo valor. Importante inicializar antes este valor con el metodo correspondiente.
 * @return valor resultante del nodo
 */
public double calcular();

/**
 * Devuelve una copia exacta del nodo, en casoo de ser funcion, con su lista de descendientes copiada tambien
 * @return Copia del nodo
 */
public INodo copy();

/**
 * En caso de ser un Terminal, establece el valor de este como el dado.
 * En caso de ser una Funcion, aplica este método a sus descendientes.
 * @param valor : valor a asignar
 */
public void setValorNodo(double valor);

/**
 * Etiqueta un nodo y sus descendientes ,de izquierda a derecha y de abajo a arriba
 * @param etiactual : La primera etiqueta que se le pondra a un nodo, y desde la que se ira hacia atras.
 */
public void etiquetar(int etiactual);

/**
 * Devuelve la etiqueta de un nodo
 * @return etiqueta del nodo
 */
public int getEtiqueta();

/**
 * Establece el valor de la etiqueta de un nodo al dado
 * @param etiqueta : valor a dar a la etiqueta
 */
public void setEtiqueta(int etiqueta);

/**
 * Establece p como el valor del puntero al padre del nodo
 * @param p : Nodo a establecer en el campo padre del nodo
 */
public void setPadre(INodo p);

/**
 * Devuelve el puntero al padre del nodo
 * @return puntero l padre
 */

public INodo getPadre();

/**
 * Busca el nodo etiquetado con el valor dado
 * @param etiqueta : etiqueta del nodo a buscar
 * @return nodo buscado
 */
public INodo buscar(int etiqueta);
} 
