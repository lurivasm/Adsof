/**
 * 
 */
package individuo;
import java.util.*;


import interfaces.*;

/**
 * @author danist
 *
 */
public class Individuo implements IIndividuo{
	private INodo expresion;
	private double fitness;
	
	public INodo getExpresion() {
		return expresion;
	}
	public void setExpresion(INodo expresion) {
		this.expresion = expresion;
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
		
		for(int i = 0;i < l1.size(); i++){
			l1.add(funciones.get(r.nextInt(funciones.size())));
		}
		for(int i = profundidad -1; i >= 0 ; i--) {
			l2 = new ArrayList<INodo>((int)Math.pow(2, i));
			int cont = 0;
			for(int j = 0; j < Math.pow(2, i); j++) {
				l2.add(terminales.get(r.nextInt(terminales.size())));
				l2.get(j).incluirDescendiente(l1.get(cont));
				l2.get(j).incluirDescendiente(l1.get(cont +1));
				cont += 2;
			}
			l1 = l2;
		}
		expresion = l1.get(0);
	}
		
	public double calcularExpresion();
	public int getNumeroNodos();
	public void writeIndividuo();
}
