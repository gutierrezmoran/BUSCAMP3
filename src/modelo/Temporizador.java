package modelo;

public class Temporizador {

	private int segundos;
	private int minutos;

	public void incrementarSegundos() {
		if(this.segundos == 59) {
			this.segundos = 0;
		} else if(this.minutos == 59 && this.segundos == 59) {
			this.segundos++;
		}
	}

	public void incrementarMinutos() {
		this.minutos++;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public String getSegundosString() {
		return String.valueOf(this.segundos);
	}

	public String getMinutosString() {
		return String.valueOf(this.minutos);
	}

}
