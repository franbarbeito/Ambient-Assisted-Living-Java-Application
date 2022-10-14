package model;

public class UsuarioClinico extends UsuarioGeneral {
	
	private String correo;
	private String pacientes[]=new String[8];
	

	public UsuarioClinico(int tipo, String dni, String nombre, String apellidos, String tlfn, String sexo,
			String contrasenia, String correo, String[] pacientes) {
		super(tipo, dni, nombre, apellidos, tlfn, sexo, contrasenia);
		this.correo = correo;
		this.pacientes = pacientes;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String[] getPacientes() {
		return pacientes;
	}

	public void setPacientes(String[] pacientes) {
		this.pacientes = pacientes;
	}
	
	
	
}
