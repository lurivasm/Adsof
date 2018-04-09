package tests;
import interfaces.*;

import java.util.*;

import individuo.*;
public class Prueba {

	public static void main(String[] args) {
		List<String> p1 = new ArrayList<String>();
		List<String> p2;
		p1.add("1");
		p1.add("2");
		p2 = p1;
		p1 = new ArrayList<String>();
		p1.add("Platano");
		System.out.println(p1.get(0) + p2.get(0));

	}

}
