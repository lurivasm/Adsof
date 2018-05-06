package got;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

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
	
	
	
	
	
//	public List<String> casas();// devuelve una lista con los nombres de las casas sin repeticiones, ordenadas, y sin valores
////	null.
//	 public List<String> miembrosCasa(String casa);// devuelve una lista con los nombres de los personajes de una casa
////	indicada como argumento de entrada. En este caso, se pide explícitamente crear y usar un Predicate.
//	 public Map<String, Integer> gradoPersonajes();// devuelve los personajes y sus “grados”, esto es el número de
////	vecinos que tiene cada vértice.
//	 public Map<String, Integer> gradoPonderadoPersonajes();//devuelve los personajes y sus “grados ponderados”, esto
////	es la suma de los pesos de los arcos que unen a cada vértice con sus vecinos.
//	 public Map<String, Integer> personajesRelevantes();// devuelve los personajes y sus “grados ponderados”, pero
////	sólo para aquellos personajes cuyo grado ponderado es superior al grado ponderado medio en la red social. 
}
