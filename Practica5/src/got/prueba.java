package got;
import grafos.*;
import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class prueba {

	public static void main(String[] args) throws Exception {
//		List<Vertice<PersonajeGOT>> l = new ArrayList<>();
//		for(int i = 0;i < 8 ;i++) {
//			l.add(new Vertice<PersonajeGOT>(i,new PersonajeGOT(Integer.toString(i),"micasa")));
//		}
//		System.out.println(l.stream().filter((Vertice<PersonajeGOT> v) -> v.getDatos().getNombre().equals("5")).collect(Collectors.toList()).get(0).getDatos().getNombre());
		GrafoGOT<PersonajeGOT> g = new GrafoGOT("got-s01-vertices.csv","got-s01-arcos.csv");
		System.out.println(g.getVertice("Aegon I Targaryen").getDatos().getNombre());
	}
}
