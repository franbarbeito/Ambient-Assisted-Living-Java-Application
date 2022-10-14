package model;

public class UsuarioCuidador extends UsuarioGeneral {

	private String idPacientes;
	private String pacientes[]=new String[3];
	private String correo;


	public UsuarioCuidador(int tipo, String dni, String nombre, String apellidos, String tlfn, 
			String sexo, String contrasenia, String correo, String[] pacientes) {
		
		super(tipo, dni, nombre, apellidos, tlfn, sexo, contrasenia);
		this.pacientes = pacientes;
		this.correo = correo;
		
		
	}

	
	public String[] getPacientes() {
		return pacientes;
	}
	public void setPacientes(String[] pacientes) {
		this.pacientes = pacientes;
	}


}
