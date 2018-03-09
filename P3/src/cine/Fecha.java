package cine;



public class Fecha{
    

	private int anyo;
    private int mes;
    private int dia;

    public Fecha(int anyo, int mes, int dia){
      this.anyo = anyo;
      this.mes = mes;
      this.dia = dia;
    }

    /**
	 * @return the anyo
	 */
	public int getAnyo() {
		return anyo;
	}

	/**
	 * @param anyo the anyo to set
	 */
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	/**
	 * @return the mes
	 */
	public int getMes() {
		return mes;
	}

	/**
	 * @param mes the mes to set
	 */
	public void setMes(int mes) {
		this.mes = mes;
	}

	/**
	 * @return the dia
	 */
	public int getDia() {
		return dia;
	}

	/**
	 * @param dia the dia to set
	 */
	public void setDia(int dia) {
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
      if((Math.abs(anyo-2000)%4) == 0 && mes == 2 && dia > 29) return false;
      if(mes == 2 && dia > 28) return false;
      return true;
    }

}

