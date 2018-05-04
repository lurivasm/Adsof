package grafos;
import java.util.*;
public class prueba {

	public static void main(String[] args) {
		Map<Integer,Vertice<String>> map = new HashMap<>();
		map.put(12, new Vertice<String>(12,"B"));
		map.put(39, new Vertice<String>(39,"A"));
		map.put(1, new Vertice<String>(1,"W"));
		System.out.println(map.size());
	}

}
