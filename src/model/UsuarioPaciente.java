package model;

public class UsuarioPaciente extends UsuarioGeneral {
	
	private String idDoctor;
	private String cuidadores[]=new String[5];
	
	// Creamos objeto Paciente
	public UsuarioPaciente(int tipo, String dni, String nombre, String apellidos, String tlfn, String sexo,
			String contrasenia, String idDoctor) {
		
		super(tipo, dni, nombre, apellidos, tlfn, sexo, contrasenia);
		this.idDoctor = idDoctor;
	}
	

	public UsuarioPaciente(int tipo, String dni, String nombre, String apellidos, String tlfn, String sexo, String contrasenia) {
		
			super(tipo, dni, nombre, apellidos, tlfn,sexo, contrasenia);
	}


		// Generamos getters y setters
		public String getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(String idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String[] getCuidadores() {
		return cuidadores;
	}

	public void setCuidadores(String[] cuidadores) {
		this.cuidadores = cuidadores;
	}

}