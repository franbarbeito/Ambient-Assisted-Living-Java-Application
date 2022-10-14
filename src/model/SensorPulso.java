package model;

public class SensorPulso {

	private long hora;
	private int pulso;
	
	
	//Constructor, getters y setters
	public SensorPulso(long hora, int pulso) {
		this.hora = hora;
		this.pulso = pulso;
	}
	public long getHora() {
		return hora;
	}
	public void setHora(long hora) {
		this.hora = hora;
	}
	public int getPulso() {
		return pulso;
	}
	public void setPulso(int pulso) {
		this.pulso = pulso;
	}
	
	
	
}
