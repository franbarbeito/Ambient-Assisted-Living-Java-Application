package model;

public class SensorAlarma {
	
	private long hora;
	private int valor;
	
	//Constructor, getters y setters
	public SensorAlarma(long hora, int valor) {
		this.hora = hora;
		this.valor = valor;
		
	}
	public long getHora() {
		return hora;
		
	}
	public void setHora() {
		this.hora = hora;
		
	}
	
	public int getValor () {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor; 
	}
	public int getAlarma() {
		// TODO Auto-generated method stub
		return 0;
	}


}
