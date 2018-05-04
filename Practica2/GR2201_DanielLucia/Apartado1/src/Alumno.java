/**
* @author Lucia Rivas Molina lucia.rivasmolina@estudiante.uam.es
* @author Daniel Santo-Tomás López daniel.santo-tomas@estudiante.uam.es
*/

/*Implementamos la clase Alumno*/



public class Alumno{
  private String DNI;
  private String nombre;
  private String apellido;
  private Fecha fechaMatr;
  private String carnetMatr;
  private long telefono;
  private Fecha fechaNacim;
  private String tipoCarnet;
  private int descuento;
  private Fecha fechaExTeo;
  private Fecha fechaExPrac;

  /*Primer constructor adecuado al ejercicio*/
  public Alumno(String DNI, String nombre, String apellido, int anyo, int mes, int dia, String carnetMatr){
    this.DNI = DNI;
    this.nombre = nombre;
    this.apellido = apellido;
    fechaMatr = new Fecha(anyo, mes, dia);
    this.carnetMatr = carnetMatr;
  }

  /*Constructor completo*/
  public Alumno(String DNI, String nombre, String apellido, int anyo, int mes, int dia, String carnetMatr, int anyoNac, int mesNac, int diaNac, long telefono, String tipoCarnet, int descuento ,int anyoTeo, int mesTeo, int diaTeo, int anyoPr, int mesPr, int diaPr ){
    this.DNI = DNI;
    this.nombre = nombre;
    this.apellido = apellido;
    fechaMatr = new Fecha(anyo, mes, dia);
    this.carnetMatr = carnetMatr;
    fechaNacim = new Fecha(anyoNac, mesNac, diaNac);
    this.telefono = telefono;
    this.tipoCarnet = tipoCarnet;
    this.descuento = descuento;
    fechaExTeo = new Fecha(anyoTeo, mesTeo, diaTeo);
    fechaExPrac = new Fecha(anyoPr, mesPr, diaPr);
  }

  public Fecha getFechaMatr(){
    return fechaMatr;
  }

  public String toString(){
    String s;
    s = "\n" + "Nombre : " + nombre + "\n" + "Apellido: " + apellido + "\n" + "DNI: " + DNI + "\n" + "Fecha Matricula: " + fechaMatr + "\n" + "Tipo Carnet: " + carnetMatr;
    return s;
  }
}
