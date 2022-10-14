package model;

public class SensorTemperatura {

	private long hora;
	private float temperatura;
	
	
	
	
	//Constructor, getters y setters
	public SensorTemperatura(long hora, float temperatura) {
		this.hora = hora;
		this.temperatura = temperatura;
	}
	public long getHora() {
		return hora;
	}
	public void setHora(long hora) {
		this.hora = hora;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
	
	
	
}
