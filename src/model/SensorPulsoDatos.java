package model;

import java.util.Vector;

public class SensorPulsoDatos {

	private Vector<SensorPulso> datosSensor;

	
	//Funciones
	public void aniadirDato(SensorPulso dato) {
		datosSensor.add(dato);
	}
	public int primerDato() {
		return datosSensor.get(0).getPulso();
	}
	public int ultimoDato() {
		return datosSensor.get(datosSensor.size()-1).getPulso();
	}
	public Vector<Integer> estadoPulso(){
		
		Vector<Integer> numeros = new Vector<Integer>();
		
		for(int i = 0; i<datosSensor.size(); i++) {			
			if(datosSensor.get(i).getPulso()<60 || datosSensor.get(i).getPulso()>100) {
				numeros.addElement(i);
			}			
			System.out.println();
		}		
		
		return numeros;		
	}

	
	//Constructor, getters y setters
	public Vector<SensorPulso> getDatosSensor() {
		return datosSensor;
	}
	public void setDatosSensor(Vector<SensorPulso> datosSensor) {
		this.datosSensor = datosSensor;
	}

	public SensorPulsoDatos(Vector<SensorPulso> datosSensor) {
		this.datosSensor = datosSensor;
	}
	public SensorPulsoDatos() {
		this.datosSensor = new Vector<SensorPulso>();
	}
	
}
