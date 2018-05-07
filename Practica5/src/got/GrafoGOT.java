package got;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;



import grafos.*;
public class GrafoGOT<T> extends GrafoNoDirigido<PersonajeGOT> {
	
	public GrafoGOT(String ficheroVertices, String ficheroArcos) throws Exception {
		
		BufferedReader buffer = new BufferedReader(
				new InputStreamReader(
				new FileInputStream(ficheroVertices)));
		
		String linea;
		while((linea = buffer.readLine()) != null) {
			String[] s = linea.split(",");
			PersonajeGOT p = new PersonajeGOT(s[1],s[2]);
			this.addVertice(Integer.parseInt(s[0]), p);
		}
		buffer.close();
		
		buffer = new BufferedReader(
				new InputStreamReader(
				new FileInputStream(ficheroArcos)));
		
		while((linea = buffer.readLine()) != null) {
			String[] s = linea.split(",");
			this.addArco(vertices.get(Integer.parseInt(s[0])), vertices.get(Integer.parseInt(s[1])), Double.parseDouble(s[2]));
		}
		buffer.close();
	}
	
	public Vertice<PersonajeGOT> getVertice(String nombre){//devuelve el vértice que contiene el personaje cuyo nombre se indica como argumento de entrada.
		return vertices.values().stream().filter((Vertice<PersonajeGOT> v) -> v.getDatos().getNombre().equals(nombre)).collect(Collectors.toList()).get(0);
	}	
	
	public List<String> casas(){// devuelve una lista con los nombres de las casas sin repeticiones, ordenadas, y sin valores null
		List<String> l = vertices.values().stream().map((Vertice<PersonajeGOT> v)-> (v.getDatos().getCasa())).sorted().distinct().collect(Collectors.toList());
		l.remove("null");		
		return l;
	}

	 public List<String> miembrosCasa(String casa){  // devuelve una lista con los nombres de los personajes de una casa indicada como argumento de entrada. En este caso, se pide explícitamente crear y usar un Predicate.
		Predicate<Vertice<PersonajeGOT>> check = (p)-> p.getDatos().getCasa().equals(casa);
		return vertices.values().stream().filter(check).map((Vertice<PersonajeGOT> v ) -> v.getDatos().getNombre()).sorted().collect(Collectors.toList());
	 }

	 public Map<String, Integer> gradoPersonajes(){		 // devuelve los personajes y sus “grados”, esto es el número de vecinos que tiene cada vértice.
		 Map<String,Integer> res = new HashMap<>();
		 for(Vertice<PersonajeGOT> v : vertices.values()) {
			 res.put(v.getDatos().getNombre(), this.getVecinosDe(v).size());
		 }
		 return res;
	 }
	
	 public Map<String, Integer> gradoPonderadoPersonajes(){ //devuelve los personajes y sus “grados ponderados”, esto es la suma de los pesos de los arcos que unen a cada vértice con sus vecinos.
		 Map<String,Integer> res = new HashMap<>();		
		 double cont = 0;
		 for(Vertice<PersonajeGOT> v1 : vertices.values()) {
			  cont = 0;
			  for(Vertice<PersonajeGOT> v2 : this.getVecinosDe(v1)) cont+= this.getPesoDe(v1, v2);
			  res.put(v1.getDatos().getNombre(), (int)cont);
		 }
		 return res;
	 }
	 
	 public double gradoPonderadoMedio() {
		double grad = 0;
		for(Double d :arcos.values()) grad+=d;
		return grad/this.getNumArcos();
	}
	
	 public Map<String, Integer> personajesRelevantes(){// devuelve los personajes y sus “grados ponderados”, pero sólo para aquellos personajes cuyo grado ponderado es superior al grado ponderado medio en la red social. 
		 Map<String,Integer> res = new HashMap<>();	
		 double grad = this.gradoPonderadoMedio();
		 double cont = 0;
		 for(Vertice<PersonajeGOT> v1 : vertices.values()) {
			  cont = 0;
			  for(Vertice<PersonajeGOT> v2 : this.getVecinosDe(v1)) cont+= this.getPesoDe(v1, v2);
			  if(cont > grad) res.put(v1.getDatos().getNombre(), (int)cont);
		 }
		 return res;
	}

}
