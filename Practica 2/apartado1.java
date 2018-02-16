/**
* @author Lucia Rivas Molina lucia.rivasmolina@estudiante.uam.es
* @author Daniel Santo-Tomás López daniel.santo-tomas@estudiante.uam.es
*/

/*Implementamos la clase Fecha*/
public class Fecha{
    private int anyo;
    private int mes;
    private int dia;

    public Fecha(int anyo, int mes, int dia){
      this.anyo = anyo;
      this.mes = mes;
      this.dia = dia;
    }

    public String toString(){
      String s = anyo + "-" + mes + "-" + dia + "/n";
      return s;
    }

    public Bool isFechaValida(){
      if (anyo < 0 || mes > 12 || mes < 1 || dia < 1 || dia > 31) return False;
      /*Comprobamos que el mes y el número de días es correcto*/
      if((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) return False;
      if(mes == 2 && dia > 28) return False;
      return True;
    }

}


public class Alumno{
  private String DNI;
  private String Nombre;
  private String Apellido;
  private Fecha fechaMatr;
  private String carnetMatr;
  private long telefono;
  private Fecha fechaNacim;
  private String TipoCarnet;
  private int descuento;
  private Fecha fechaExTeo;
  private Fecha fechaExPrac;

  /*Primer constructor adecuado al ejercicio*/
  public Alumno(String DNI, String Nombre, String Apellido, int anyo, int mes, int dia, String carnetMatr){
    this.DNI = DNI;
    this.Nombre = Nombre;
    this.Apellido = Apellido;
    this.fechaMatr = Fecha(anyo, mes, dia);
    this.carnetMatr = carnetMatr;
  }

  /*Constructor completo*/
  public Alumno(String DNI, String Nombre, String Apellido, int anyo, int mes, int dia, String carnetMatr){
    this.DNI = DNI;
    this.Nombre = Nombre;
    this.Apellido = Apellido;
    this.fechaMatr = Fecha(anyo, mes, dia);
    this.carnetMatr = carnetMatr;
  }
}
