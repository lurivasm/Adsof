/**
 * 
 */
package cine;

/**
 * @author eps
 *
 */
public class TesterCine {

	/**
	 * @param args
	 */
	public static void  main(String[] args) {
		Cine c = new Cine("Hola","Somewhere over the raimbow");
			
		c.addSala(50);
		c.addPelicula("Mad Max", "Lucia Rivas",2018,"Muchos coches",Genero.ACCION);
		c.nuevaSesion("Mad Max", 1, 11, 1930, 1);
		Sesion ses = c.getListaSalas().get(0).getSesiones().get(0);
		c.venderEntradas(ses, 5, 20, 20);
		
		
		}
}
