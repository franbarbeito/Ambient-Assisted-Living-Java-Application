package model;

import java.util.Vector;

public class SensorTemperaturaDatos {
	
	private Vector<SensorTemperatura> datosSensor;

	
	//Funciones
	public void aniadirDato(SensorTemperatura dato) {
		datosSensor.add(dato);
	}
	public float ultimoDato() {
		return datosSensor.get(datosSensor.size()-1).getTemperatura();
	}
	
	public Vector<Integer> estadoTemperatura(){
		
		Vector<Integer> numeros = new Vector<Integer>();
		
		for(int i = 0; i<datosSensor.size(); i++) {			
			if(datosSensor.get(i).getTemperatura()<36 || datosSensor.get(i).getTemperatura()>37.9) {
				numeros.addElement(i);
			}			
		}		
		
		return numeros;		
	}
	
	//Constructor, getters y setters
	public SensorTemperaturaDatos(Vector<SensorTemperatura> datosSensor) {
		this.datosSensor = datosSensor;
	}

	public Vector<SensorTemperatura> getDatosSensor() {
		return datosSensor;
	}
	public void setDatosSensor(Vector<SensorTemperatura> datosSensor) {
		this.datosSensor = datosSensor;
	}
	public SensorTemperaturaDatos() {
		this.datosSensor = new Vector<SensorTemperatura>();
	}
	
	

}
