package algoritmo;
import individuo.*;
import interfaces.*;

import java.util.*;

import excepciones.*;

/**
 * @author Daniel Santo-Tomas daniel.santo-tomas@estudiante.uam.es
 * @author Lucia Rivas Molina lucia.rivas@estudiante.uam.es 
 */
public class PruebaCruce {
	public List<IIndividuo> cruce(IIndividuo p1, IIndividuo p2) throws CruceNuloException {
		List<IIndividuo> res = new ArrayList<IIndividuo>(2);
		IIndividuo in = new Individuo();
		res.add(in);
		in = new Individuo();
		res.add(in);
		
		res.get(0).setExpresion(p1.getExpresion().copy());
		res.get(1).setExpresion(p2.getExpresion().copy());
		
		Random r = new Random();
		int punto1 = r.nextInt(p1.getNumeroNodos()) + 1;
		System.out.println("Punto de cruce del progenitor 1: " + punto1);
		int punto2 = r.nextInt(p2.getNumeroNodos())+1;
		System.out.println("Punto de cruce del progenitor 2: " + punto2);
		
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
}
