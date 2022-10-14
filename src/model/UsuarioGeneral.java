package model;

// Clase que crea el usuario estándar (general)
public class UsuarioGeneral {
	
	private int tipo;
	private String dni;
	private String nombre;
	private String apellidos;
	private String tlfn;
	private String sexo;
	private String contrasenia;	
	

	public UsuarioGeneral(int tipo, String dni, String contrasenia) {
		super();
		this.tipo = tipo;
		this.dni = dni;
		this.contrasenia = contrasenia;
	}

	public UsuarioGeneral(int tipo, String dni, String nombre, String apellidos, String tlfn, 
			String sexo, String contrasenia) {
		super();
		this.tipo = tipo;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tlfn = tlfn;
		this.sexo = sexo;
		this.contrasenia = contrasenia;
	}
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTlfn() {
		return tlfn;
	}
	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	@Override
	public String toString() { //
		// TODO Auto-generated method stub
		return nombre + " " + apellidos;
	}

}
