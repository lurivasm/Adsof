/**
* Esta aplicación genera el triángulo de Tartaglia de n filas
*
* @author Lucia Rivas Molina lucia.rivasmolina@estudiante.uam.es
* @author Daniel Santo-Tomás López daniel.santo-tomas@estudiante.uam.es
*/
public class Tartaglia {

  private Combinatoria c ;
  private int n;


  public Tartaglia (Combinatoria c, int n){
    this.c = c;
    this.n = n;

  }

  public String toString(){
    int i,j;
    String t = "";
    for(i = 0; i < n; i++){
      for(j = 0; j <= i; j++){
        t = t + c.combinaciones(i,j) + " ";
      }
      t = t + "\n";
    }

    return t;
  }

  /**
  * Punto de entrada a la aplicación.
  *
  * @param args el argumento n = número de filas del triángulo
  */
  public static void main (String[] args){
    if (args.length!=1) {
    System.out.println("Se espera un número como parámetro, n ");
    System.out.println(" n = Número total de filas del triángulo ");
    System.out.println("Devuelve el triángulo de Tartaglia de n filas");
    }
    else{
      int n = Integer.parseInt(args[0]);
      Combinatoria c = new Combinatoria();
      System.out.println(new Tartaglia(c, n));
    }
  }
}
