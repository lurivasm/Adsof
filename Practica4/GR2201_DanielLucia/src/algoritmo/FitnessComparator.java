package algoritmo;
import java.util.*;
import interfaces.*;

/**
 * Comparator utilizado para ordenar las poblaciones segun el fitness de mayor a menor
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public class FitnessComparator implements Comparator<IIndividuo> {
	public int compare(IIndividuo a, IIndividuo b) {
		return a.getFitness() < b.getFitness() ? 1 : a.getFitness() == b.getFitness() ? 0 : -1;
	}
}
