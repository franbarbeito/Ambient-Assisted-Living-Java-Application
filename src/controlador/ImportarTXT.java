package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import model.SensorAlarmaDatos;
import model.SensorPulso;
import model.SensorPulsoDatos;
import model.SensorTemperatura;
import model.SensorTemperaturaDatos;
import model.UsuarioClinico;
import model.UsuarioCuidador;
import model.UsuarioGeneral;
import model.UsuarioPaciente;

public class ImportarTXT {

	// Array que lee y escribe los nombres y contrase�as logueados en un txt
	public ArrayList<UsuarioGeneral> lecturaLogin() {
		
		String ruta="ArchivoValidar.txt";
		ArrayList<UsuarioGeneral> arrayValidar= new ArrayList<UsuarioGeneral>();
		int tipoG=4;
		String dniG = "";
		String contraseniaG = "";
		Scanner br=null;
		try {

			br = new Scanner(new FileReader(ruta));
			while(br.hasNextLine()) {
				
				String linea = br.nextLine();
				String[] lineaDividida = linea.split("[,\n\"\r]");

				tipoG = Integer.parseInt(lineaDividida[0]);
				dniG = lineaDividida[1];
				contraseniaG = lineaDividida[2];

				UsuarioGeneral userAux= new UsuarioGeneral(tipoG,dniG,contraseniaG);
				arrayValidar.add(userAux);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return arrayValidar;
	}
	
	// Array que lee los pacientes del txt
	public ArrayList<UsuarioPaciente> lecturaPaciente() {
		
		String ruta="ArchivoPacienteTXT.txt";
		ArrayList<UsuarioPaciente> arrayPaciente= new ArrayList<UsuarioPaciente>();
		int tipo=0;
		String dni="";
		String nombre="";
		String apellidos="";
		String tlfn="";
		String sexo="";
		String contrasenia="";
		String idDoctor="";
		Scanner sc=null;
		
		try {

			sc = new Scanner(new FileReader(ruta));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] lineaDividida = linea.split("[,\n\"]");

				tipo = Integer.parseInt(lineaDividida[0]);
				dni = lineaDividida[1];						
				nombre = lineaDividida[2];						
				apellidos = lineaDividida[3];						
				tlfn = lineaDividida[4];					
				sexo = lineaDividida[5];						
				contrasenia = lineaDividida[6];
				idDoctor=lineaDividida[7];
				

				UsuarioPaciente userAux= new UsuarioPaciente(tipo,dni,nombre,apellidos,tlfn,sexo,contrasenia,idDoctor);
				arrayPaciente.add(userAux);		
			}
			sc.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return arrayPaciente;
	}
	
	public ArrayList<UsuarioCuidador> lecturaCuidador() {
		
		String ruta="ArchivoCuidadorTXT.txt";
		ArrayList<UsuarioCuidador> arrayCuidador= new ArrayList<UsuarioCuidador>();
		int tipo=0;
		String dni="";
		String nombre="";
		String apellidos="";
		String tlfn="";
		String sexo="";
		String contrasenia="";
		String correo="";
		String paciente1;
		String paciente2;
		String paciente3;
		//String correo="";
		//String pacientes[]=new String[3];
		Scanner sc=null;
		try {

			sc = new Scanner(new FileReader(ruta));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] lineaDividida = linea.split("[,\n\"]");


				tipo = Integer.parseInt(lineaDividida[0]);
				dni = lineaDividida[1];
				nombre = lineaDividida[2];
				apellidos = lineaDividida[3];
				tlfn = lineaDividida[4];
				sexo = lineaDividida[5];
				contrasenia = lineaDividida[6];
				correo = lineaDividida[7];
				paciente1 = lineaDividida[8];
				paciente2 = lineaDividida[9];
				paciente3 = lineaDividida[10];
				String pacientes[] = {paciente1, paciente2, paciente3};
				

				
				UsuarioCuidador userAux= new UsuarioCuidador(tipo, dni, nombre, apellidos, tlfn, sexo, contrasenia, correo, pacientes);
				arrayCuidador.add(userAux);
			}

			sc.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return arrayCuidador;
	}
	
public ArrayList<UsuarioClinico> lecturaClinico() {
		
		String ruta="ArchivoClinicoTXT.txt";
		ArrayList<UsuarioClinico> arrayClinico= new ArrayList<UsuarioClinico>();
		int tipo=0;
		String dni="";
		String nombre="";
		String apellidos="";
		String tlfn="";
		String sexo="";
		String contrasenia="";
		String correo="";
		String paciente1;
		String paciente2;
		String paciente3;
		String paciente4;
		String paciente5;
		String paciente6;
		String paciente7;
		String paciente8;
		Scanner sc=null;
		try {

			sc = new Scanner(new FileReader(ruta));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] lineaDividida = linea.split("[,\n\"]");


				tipo = Integer.parseInt(lineaDividida[0]);
				dni = lineaDividida[1];
				nombre = lineaDividida[2];
				apellidos = lineaDividida[3];
				tlfn = lineaDividida[4];
				sexo = lineaDividida[5];
				contrasenia = lineaDividida[6];
				correo = lineaDividida[7];
				paciente1 = lineaDividida[8];
				paciente2 = lineaDividida[9];
				paciente3 = lineaDividida[10];
				paciente4 = lineaDividida[11];
				paciente5 = lineaDividida[12];
				paciente6 = lineaDividida[13];
				paciente7 = lineaDividida[14];
				paciente8 = lineaDividida[15];
				String pacientes[] = {paciente1, paciente2, paciente3, paciente4, paciente5, paciente6, paciente7, paciente8};
				

				
				UsuarioClinico userAux= new UsuarioClinico(tipo, dni, nombre, apellidos, tlfn, sexo, contrasenia, correo, pacientes);
				arrayClinico.add(userAux);
			}

			sc.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return arrayClinico;
	}
	
	// Lee todos los pulsos de cada paciente (60 ppm por paciente, experimento de 1
	// hora)
	// Devuelve una lista de pacientes que contienen los pulsometros de cada uno
	
	/*public ArrayList<UsuarioPaciente> leerPulsometros(String fichero, String separador) {
		ArrayList<UsuarioPaciente> pacientesPulsometros = new ArrayList<UsuarioPaciente>();
		UsuarioPaciente p = null;

		File f = new File(fichero);
		String line = "";
		int i = 0;

		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));
			// Lee el texto linea a linea
			line = lector.readLine(); // Lee linea
			while (line != null) {
				
					String[] ppmHora = line.split(separador);
					//p.estadisticas.datos[i] = Integer.parseInt(ppmHora[0]); 	// Lee el pulso
					//p.estadisticas.horas[i] = ppmHora[1];					// y su hora
					i++; // Contador incrementa
				}
				line = lector.readLine(); // Lee linea
			 // fin while
			lector.close();
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
		}
		return pacientesPulsometros;
	}*/
public SensorPulsoDatos leerFicheroPulso() {
		
		String elegido;
		
		Vector<String> opciones = new Vector();
		opciones.addElement("ArchivoPulso.txt");
		opciones.addElement("ArchivoPulsoBajo.txt");
		
		elegido = opciones.get((int) (Math.random() * 2));
		
		File fichero = new File(elegido);
		Scanner s = null;
		SensorPulso sensor = null;
		SensorPulsoDatos datosSensor = new SensorPulsoDatos();
		

		try {
			// Leemos el contenido del fichero
			s = new Scanner(fichero);

			while (s.hasNextLine()) {
				String linea = s.nextLine();
				String datos[] = linea.split(";");

				String parte1 = datos[0];
				String parte2 = datos[1];
				
				sensor = new SensorPulso(Long.parseLong(parte1),Integer.parseInt(parte2));
				
				datosSensor.aniadirDato(sensor);
			}
		} catch (Exception ex) {
			System.out.println("No se puede leer el contenido del fichero " + ex.getMessage());
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null) {
					s.close();
				}
			} catch (Exception ex2) {
				System.out.println("No se puede cerrar el fichero " + ex2.getMessage());
			}
		}

		
		return datosSensor;		
	}
// TEMPERATURA LECTOR
public SensorTemperaturaDatos leerFicheroTemperatura() {

	String elegido;
	
	Vector<String> opciones = new Vector();
	opciones.addElement("ArchivoTemperatura.txt");
	opciones.addElement("ArchivoTemperaturaAlta.txt");
	
	elegido = opciones.get((int) (Math.random() * 2));
	
	File fichero = new File(elegido);
	Scanner s = null;
	SensorTemperatura sensor = null;
	SensorTemperaturaDatos datosSensor = new SensorTemperaturaDatos();
	

	try {
		// Leemos el contenido del fichero
		s = new Scanner(fichero);

		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String datos[] = linea.split(";");

			String parte1 = datos[0];
			String parte2 = datos[1];
			
			sensor = new SensorTemperatura(Long.parseLong(parte1),Float.parseFloat(parte2));
			
			datosSensor.aniadirDato(sensor);
		}
	} catch (Exception ex) {
		System.out.println("No se puede leer el contenido del fichero " + ex.getMessage());
	} finally {
		// Cerramos el fichero tanto si la lectura ha sido correcta o no
		try {
			if (s != null) {
				s.close();
			}
		} catch (Exception ex2) {
			System.out.println("No se puede cerrar el fichero " + ex2.getMessage());
		}
	}

	
	return datosSensor;		
}

public SensorAlarmaDatos leerFicheroAlarma() {
	// TODO Auto-generated method stub
	return null;
}
	
	
}
