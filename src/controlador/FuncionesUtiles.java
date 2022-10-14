package controlador;

import java.util.ArrayList;

import model.UsuarioClinico;
import model.UsuarioCuidador;
import model.UsuarioGeneral;
import model.UsuarioPaciente;

public class FuncionesUtiles {

	// Funcion que autentifica si existe el usuario
	public int puertaLogin(String dni, String contrasenia) {
		ArrayList<UsuarioGeneral> usuarios;
		ImportarTXT imp = new ImportarTXT();
		usuarios=imp.lecturaLogin();	
		int tipoAux=4;
		int count=0;
		boolean encontrado=false;
		while( count<usuarios.size() && encontrado==false){
	
			if((usuarios.get(count).getDni().equals(dni))&&(usuarios.get(count).getContrasenia().equals(contrasenia))) {
				tipoAux=usuarios.get(count).getTipo();
				encontrado=true;
				}
			else {
				count++;
			}
			
        }
		
		return tipoAux;
	}
	
	// Funcion que lee los usuarios del txt 
	public UsuarioPaciente buscaPaciente(String dni) {
		
		UsuarioPaciente userFind=null;
		ImportarTXT imp= new ImportarTXT();
		ArrayList<UsuarioPaciente> arrayUser= new ArrayList<UsuarioPaciente>();
		arrayUser=imp.lecturaPaciente();
		
		for (int i=0; i<arrayUser.size();i++) {
			if(arrayUser.get(i).getDni().equals(dni)) {
				userFind=arrayUser.get(i);
			}			
		}
		
		return userFind;
	}
	
	public UsuarioCuidador buscaCuidador (String dni) {
		UsuarioCuidador userFind=null;
		ImportarTXT imp= new ImportarTXT();
		ArrayList<UsuarioCuidador> arrayUser= new ArrayList<UsuarioCuidador>();
		arrayUser=imp.lecturaCuidador();		
		for (int i=0; i<arrayUser.size();i++) {
			if(arrayUser.get(i).getDni().equals(dni)) {
				userFind=arrayUser.get(i);
			}			
		}
		
		return userFind;
	}
	
	public UsuarioClinico buscaClinico (String dni) {
		UsuarioClinico userFind=null;
		ImportarTXT imp= new ImportarTXT();
		ArrayList<UsuarioClinico> arrayUser= new ArrayList<UsuarioClinico>();
		arrayUser=imp.lecturaClinico();		
		for (int i=0; i<arrayUser.size();i++) {
			if(arrayUser.get(i).getDni().equals(dni)) {
				userFind=arrayUser.get(i);
			}			
		}
		
		return userFind;
	}
}
