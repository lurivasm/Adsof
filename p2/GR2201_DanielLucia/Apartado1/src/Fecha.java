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
      String s = anyo + "-" + mes + "-" + dia ;
      return s;
    }

    public Boolean isFechaValida(){
      if (anyo < 0 || mes > 12 || mes < 1 || dia < 1 || dia > 31) return false;
      /*Comprobamos que el mes y el número de días es correcto*/
      if((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) return false;
      if(mes == 2 && dia > 28) return false;
      return true;
    }

}
