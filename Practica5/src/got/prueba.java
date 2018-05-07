package got;
import grafos.*;
import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class prueba {

	public static void main(String[] args) throws Exception {
		GrafoGOT<PersonajeGOT> g = new GrafoGOT("got-s01-vertices.csv","got-s01-arcos.csv");
		System.out.println("Grafo creado, mostrando casas en orden alfabetico\n");
		g.casas().forEach((s) ->{System.out.println(s);});
		System.out.println("\nMostrando los miembros de la casa Stark\n");
		g.miembrosCasa("Stark").forEach((s) ->{System.out.println(s);});
		System.out.println("\nMostrando los personajes y su grado\n");
		g.gradoPersonajes().keySet().forEach((s) ->{System.out.println(s + " " + g.gradoPersonajes().get(s));});
		System.out.println("\nMostrando los personajes y su grado ponderado\n");
		g.gradoPonderadoPersonajes().keySet().forEach((s) ->{System.out.println(s + " " + g.gradoPonderadoPersonajes().get(s));});
		System.out.println("\nMostrando los personajes importantes y grado ponderados\n");
		g.personajesRelevantes().keySet().forEach((s) ->{System.out.println(s + " " + g.personajesRelevantes().get(s));});
	}
}
