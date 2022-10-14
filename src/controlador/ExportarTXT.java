package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.UsuarioClinico;
import model.UsuarioCuidador;
import model.UsuarioGeneral;
//import model.UsuarioAdmn;
import model.UsuarioPaciente;
import controlador.ImportarTXT;

public class ExportarTXT {

	private void exportarValidarTxt(int tipo, String dni, String contrasenia) {
		ImportarTXT imp = new ImportarTXT();

		List<UsuarioGeneral> usuarios = new ArrayList<UsuarioGeneral>();

		usuarios.add(new UsuarioGeneral(tipo, dni, contrasenia));

		String outputFile = "ArchivoValidar.txt";
		File ArchivoUsuarios = new File(outputFile);
		boolean alreadyExists = ArchivoUsuarios.exists();

		if (alreadyExists) {
			usuarios.addAll(imp.lecturaLogin());
			ArchivoUsuarios.delete();
		}

		try {

			BufferedWriter txtOutput = new BufferedWriter(new FileWriter(outputFile, true));
			for (UsuarioGeneral user : usuarios) {

				String numberAsString = Integer.toString(user.getTipo());
				txtOutput.write(numberAsString);
				txtOutput.write(",");
				txtOutput.write(user.getDni());
				txtOutput.write(",");
				txtOutput.write(user.getContrasenia());
				txtOutput.write("\r\n");
			}
			txtOutput.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean exportarClinicoTXT(int tipo, String dni, String nombre, String apellidos, String tlfn, String sexo,
			String contrasenia, String correo, String[] pacientes) {
		ImportarTXT imp = new ImportarTXT();

		boolean grabado = false;
		List<UsuarioClinico> usuarios = new ArrayList<UsuarioClinico>();

		usuarios.add(new UsuarioClinico(tipo, dni, nombre, apellidos, tlfn, sexo, contrasenia, correo, pacientes));

		String outputFile = "ArchivoClinicoTXT.txt";
		File ArchivoUsuarios = new File(outputFile);
		boolean alreadyExists = ArchivoUsuarios.exists();

		if (alreadyExists) {

			//usuarios.addAll(imp.lecturaDoctor());
			ArchivoUsuarios.delete();
		}

		exportarValidarTxt(tipo, dni, contrasenia);
		try {

			BufferedWriter txtOutput = new BufferedWriter(new FileWriter(outputFile, true));

			for (UsuarioClinico user : usuarios) {

				String numberAsString = Integer.toString(user.getTipo());
				txtOutput.write(numberAsString);
				txtOutput.write(",");
				txtOutput.write(user.getDni());
				txtOutput.write(",");
				txtOutput.write(user.getNombre());
				txtOutput.write(",");
				txtOutput.write(user.getApellidos());
				txtOutput.write(",");
				txtOutput.write(user.getTlfn());
				txtOutput.write(",");
				txtOutput.write(user.getSexo());
				txtOutput.write(",");
				txtOutput.write(user.getContrasenia());
				txtOutput.write(",");
				txtOutput.write(user.getCorreo());
				txtOutput.write(",");
				String[] pacientesAux = user.getPacientes();
				for (int i = 0; i < pacientes.length; i++) {
					if(pacientesAux[i]!=null)
						txtOutput.write(pacientesAux[i]);
					else
						txtOutput.write("null");
					if (i < (pacientes.length - 1)) {
						txtOutput.write(",");
					} else if (i == (pacientes.length - 1)) {
						txtOutput.write("\r\n");
					}

				}
			}

			txtOutput.close();
			grabado = true;

		} catch (IOException e) {
			e.printStackTrace();
			grabado = false;
		}
		return grabado;
	}

	public boolean exportarCuidadorTXT(int tipo, String dni, String nombre, String apellidos, String tlfn, String sexo,
			String contrasenia, String correo, String[] pacientes) {
		ImportarTXT imp = new ImportarTXT();

		boolean grabado = false;
		List<UsuarioCuidador> usuarios = new ArrayList<UsuarioCuidador>();

		//usuarios.add(new UsuarioCuidador(tipo, dni, nombre, apellidos, tlfn, sexo, contrasenia, correo, pacientes));

		String outputFile = "ArchivoCuidadorTXT.txt";
		File ArchivoUsuarios = new File(outputFile);
		boolean alreadyExists = ArchivoUsuarios.exists();

		if (alreadyExists) {
		//	usuarios.addAll(imp.lecturaFamiliar());
			ArchivoUsuarios.delete();
		}
		exportarValidarTxt(tipo, dni, contrasenia);
		try {

			BufferedWriter txtOutput = new BufferedWriter(new FileWriter(outputFile, true));

			for (UsuarioCuidador user : usuarios) {

				String numberAsString = Integer.toString(user.getTipo());
				txtOutput.write(numberAsString);
				txtOutput.write(",");
				txtOutput.write(user.getDni());
				txtOutput.write(",");
				txtOutput.write(user.getNombre());
				txtOutput.write(",");
				txtOutput.write(user.getApellidos());
				txtOutput.write(",");
				txtOutput.write(user.getTlfn());
				txtOutput.write(",");
				txtOutput.write(user.getSexo());
				txtOutput.write(",");
				txtOutput.write(user.getContrasenia());
				txtOutput.write(",");
				String[] pacientesAux = user.getPacientes();
				for (int i = 0; i < pacientes.length; i++) {
					if(pacientesAux[i]!=null)
						txtOutput.write(pacientesAux[i]);
					else
						txtOutput.write("null");
					if (i < (pacientes.length - 1)) {
						txtOutput.write(",");
					} else if (i == (pacientes.length - 1)) {
						txtOutput.write("\r\n");
					}

				}
			}

			txtOutput.close();
			grabado = true;

		} catch (IOException e) {
			e.printStackTrace();
			grabado = false;
		}
		return grabado;
	}
	
	public boolean registarPaciente (int tipo, String dni, String nombre, String apellidos, String tlfn, String sexo,
			 String doctor, String contrasenia) {
		
		ImportarTXT imp = new ImportarTXT();
		boolean grabado = false;
	
		List<UsuarioPaciente> pacientesReg = new ArrayList<UsuarioPaciente>();
		
		pacientesReg.add(new UsuarioPaciente(tipo, dni, nombre, apellidos, tlfn, sexo, contrasenia, doctor));

		String outputFile = "ArchivoPacienteTXT.txt";
		File ArchivoRegistro = new File(outputFile);
		boolean alreadyExists = ArchivoRegistro.exists();
		
		if (alreadyExists) {
			pacientesReg.addAll(imp.lecturaPaciente());
			ArchivoRegistro.delete();
		}
		
		exportarValidarTxt(tipo, dni, contrasenia);
		
		try {

			BufferedWriter txtOutput = new BufferedWriter(new FileWriter(outputFile, true));

			for (UsuarioPaciente userReg : pacientesReg) {

				String numberAsString = Integer.toString(userReg.getTipo());
				txtOutput.write(numberAsString);
				txtOutput.write(",");
				txtOutput.write(userReg.getDni());
				txtOutput.write(",");
				txtOutput.write(userReg.getNombre());
				txtOutput.write(",");
				txtOutput.write(userReg.getApellidos());
				txtOutput.write(",");
				txtOutput.write(userReg.getTlfn());
				txtOutput.write(",");
				txtOutput.write(userReg.getSexo());
				txtOutput.write(",");
				txtOutput.write(userReg.getContrasenia());
				txtOutput.write(",");	
				txtOutput.write(userReg.getIdDoctor());
				txtOutput.write("\r\n");
				
			}

			txtOutput.close();
			grabado = true;

		} catch (IOException e) {
			e.printStackTrace();
			grabado = false;
		}
		
		return grabado;
	}
	
	
	

	/* public boolean exportarAdmnTXT(int tipo, String dni, String nombre, String apellidos, String tlfn, String sexo,
			String contrasenia, String correo) {
		ImportarTXT imp = new ImportarTXT();

		boolean grabado = false;
		List<UsuarioAdmn> usuarios = new ArrayList<UsuarioAdmn>();

		usuarios.add(new UsuarioAdmn(tipo, dni, nombre, apellidos, tlfn, sexo, contrasenia, correo));

		String outputFile = "ArchivoAdmnTXT.txt";
		File ArchivoUsuarios = new File(outputFile);
		boolean alreadyExists = ArchivoUsuarios.exists();

		if (alreadyExists) {
			usuarios.addAll(imp.lecturaAdmn());
			ArchivoUsuarios.delete();
		}
		exportarValidarTxt(tipo, dni, contrasenia);
		try {

			BufferedWriter txtOutput = new BufferedWriter(new FileWriter(outputFile, true));

			for (UsuarioAdmn user : usuarios) {

				String numberAsString = Integer.toString(user.getTipo());
				txtOutput.write(numberAsString.charAt(0));
				txtOutput.write(",");
				txtOutput.write(user.getDni());
				txtOutput.write(",");
				txtOutput.write(user.getNombre());
				txtOutput.write(",");
				txtOutput.write(user.getApellidos());
				txtOutput.write(",");
				txtOutput.write(user.getTlfn());
				txtOutput.write(",");
				txtOutput.write(user.getSexo());
				txtOutput.write(",");
				txtOutput.write(user.getContrasenia());
				txtOutput.write(",");
				txtOutput.write(user.getCorreo());
				txtOutput.write("\r\n");

			}

			txtOutput.close();
			grabado = true;

		} catch (IOException e) {
			e.printStackTrace();
			grabado = false;
		}
		return grabado;
	} */

	public boolean exportarPacienteTXT(int tipo, String dni, String nombre, String apellidos, String tlfn, String sexo,
			String contrasenia, String numeroSS, String historialMedico, String idDoctor, String[] familiares) {
		ImportarTXT imp = new ImportarTXT();

		boolean grabado = false;
		List<UsuarioPaciente> usuarios = new ArrayList<UsuarioPaciente>();

		usuarios.add(new UsuarioPaciente(tipo, dni, nombre, apellidos, tlfn, sexo, contrasenia));

		String outputFile = "ArchivoPacienteTXT.txt";
		File ArchivoUsuarios = new File(outputFile);
		boolean alreadyExists = ArchivoUsuarios.exists();

		if (alreadyExists) {
			usuarios.addAll(imp.lecturaPaciente());
			ArchivoUsuarios.delete();
		}
		exportarValidarTxt(tipo, dni, contrasenia);
		try {

			BufferedWriter txtOutput = new BufferedWriter(new FileWriter(outputFile, true));

			for (UsuarioPaciente user : usuarios) {

				String numberAsString = Integer.toString(user.getTipo());
				txtOutput.write(numberAsString);
				txtOutput.write(",");
				txtOutput.write(user.getDni());
				txtOutput.write(",");
				txtOutput.write(user.getNombre());
				txtOutput.write(",");
				txtOutput.write(user.getApellidos());
				txtOutput.write(",");
				txtOutput.write(user.getTlfn());
				txtOutput.write(",");
				txtOutput.write(user.getSexo());
				txtOutput.write(",");
				txtOutput.write(user.getContrasenia());
				txtOutput.write(",");
				/*
				txtOutput.write(user.getNumeroSS());
				txtOutput.write(",");
				txtOutput.write(user.getHistorialMedico());
				txtOutput.write(",");
				txtOutput.write(user.getIdDoctor());
				txtOutput.write(",");
				String[] familiaresAux = user.getFamiliares();
				for (int i = 0; i < familiares.length; i++) {
					if(familiaresAux[i]!=null)
						txtOutput.write(familiaresAux[i]);
					else
						txtOutput.write("null");
					if (i < (familiares.length - 1)) {
						txtOutput.write(",");
					} else if (i == (familiares.length - 1)) {
						txtOutput.write("\r\n");
					}

				}*/
			}

			txtOutput.close();
			grabado = true;

		} catch (IOException e) {
			e.printStackTrace();
			grabado = false;
		}
		return grabado;
	}

	

	
	// metodos para actualizacion/modificar:
	/*
	public void actualizarDoctor(UsuarioDoctor usuario) {

		String outputFile = "ArchivoDoctorTXT.txt";

		ImportarTXT imp = new ImportarTXT();
		ArrayList<UsuarioDoctor> usuarios = imp.lecturaDoctor();

		try {
			BufferedWriter txtOutput = new BufferedWriter(new FileWriter(outputFile));

			for (UsuarioDoctor user : usuarios) {

				// nuevo dni
				if (user.getDni().equals(usuario.getDni())) {
					user = usuario;
				}

				String numberAsString = Integer.toString(user.getTipo());
				txtOutput.write(numberAsString);
				txtOutput.write(",");
				txtOutput.write(user.getDni());
				txtOutput.write(",");
				txtOutput.write(user.getNombre());
				txtOutput.write(",");
				txtOutput.write(user.getApellidos());
				txtOutput.write(",");
				txtOutput.write(user.getTlfn());
				txtOutput.write(",");
				txtOutput.write(user.getSexo());
				txtOutput.write(",");
				txtOutput.write(user.getContrasenia());
				txtOutput.write(",");
				txtOutput.write(user.getCorreo());
				txtOutput.write(",");
				String[] pacientesAux = user.getPacientes();
				for (int i = 0; i < pacientesAux.length; i++) {
					if(pacientesAux[i]!=null)
						txtOutput.write(pacientesAux[i]);
					else
						txtOutput.write("null");
					if (i < (pacientesAux.length - 1)) {
						txtOutput.write(",");
					} else if (i == (pacientesAux.length - 1)) {
						txtOutput.write("\r\n");
					}

				}
			}

			txtOutput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actualizarPaciente(UsuarioPaciente usuario) {
		
		String outputFile = "ArchivoPacienteTXT.txt";

		ImportarTXT imp = new ImportarTXT();
		ArrayList<UsuarioPaciente> usuarios = imp.lecturaPaciente();
		
		try {
			BufferedWriter txtOutput = new BufferedWriter(new FileWriter(outputFile));
			
			for (UsuarioPaciente user : usuarios) {
				
				// nuevo dni
				if (user.getDni().equals(usuario.getDni())) {
					user = usuario;
				}
				
				String numberAsString = Integer.toString(user.getTipo());
				txtOutput.write(numberAsString);
				txtOutput.write(",");
				txtOutput.write(user.getDni());
				txtOutput.write(",");
				txtOutput.write(user.getNombre());
				txtOutput.write(",");
				txtOutput.write(user.getApellidos());
				txtOutput.write(",");
				txtOutput.write(user.getTlfn());
				txtOutput.write(",");
				txtOutput.write(user.getSexo());
				txtOutput.write(",");
				txtOutput.write(user.getContrasenia());
				txtOutput.write(",");
				txtOutput.write(user.getNumeroSS());
				txtOutput.write(",");
				txtOutput.write(user.getHistorialMedico());
				txtOutput.write(",");
				txtOutput.write(user.getIdDoctor());
				txtOutput.write(",");
				String[] familiaresAux = user.getFamiliares();
				for (int i = 0; i < familiaresAux.length; i++) {
					if(familiaresAux[i]!=null)
						txtOutput.write(familiaresAux[i]);
					else
						txtOutput.write("null");
					if (i < (familiaresAux.length - 1)) {
						txtOutput.write(",");
					} else if (i == (familiaresAux.length - 1)) {
						txtOutput.write("\r\n");
					}

				}
			}
			
			txtOutput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 public void actualizarFamiliar(UsuarioFamiliar usuario) {

		String outputFile = "ArchivoFamiliarTXT.txt";

		ImportarTXT imp = new ImportarTXT();
		ArrayList<UsuarioFamiliar> usuarios = imp.lecturaFamiliar();
		
		try {
			BufferedWriter txtOutput = new BufferedWriter(new FileWriter(outputFile));
		
			for (UsuarioFamiliar user : usuarios) {
	
				// nuevo dni
				if (user.getDni().equals(usuario.getDni())) {
					user = usuario;
				}
				
				String numberAsString = Integer.toString(user.getTipo());
				txtOutput.write(numberAsString);
				txtOutput.write(",");
				txtOutput.write(user.getDni());
				txtOutput.write(",");
				txtOutput.write(user.getNombre());
				txtOutput.write(",");
				txtOutput.write(user.getApellidos());
				txtOutput.write(",");
				txtOutput.write(user.getTlfn());
				txtOutput.write(",");
				txtOutput.write(user.getSexo());
				txtOutput.write(",");
				txtOutput.write(user.getContrasenia());
				txtOutput.write(",");
				txtOutput.write(user.getCorreo());
				txtOutput.write(",");
				String[] pacientesAux = user.getPacientes();
				for (int i = 0; i < pacientesAux.length; i++) {
					if(pacientesAux[i]!=null)
						txtOutput.write(pacientesAux[i]);
					else
						txtOutput.write("null");
					if (i < (pacientesAux.length - 1)) {
						txtOutput.write(",");
					} else if (i == (pacientesAux.length - 1)) {
						txtOutput.write("\r\n");
					}
	
				}
			}

			txtOutput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} */
 
}