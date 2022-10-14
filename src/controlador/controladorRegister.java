package controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.UsuarioPaciente;

public class controladorRegister {

	@FXML
	private TextField tTipo;
	
	@FXML
    private TextField tDNI;
	
	@FXML
    private TextField tNombre;
	
	@FXML
	private TextField tApellido;
	
    @FXML
    private TextField tTel;
    
    @FXML
    private TextField tSexo;
    
    @FXML
    private PasswordField tPass;
    
    @FXML
    private TextField tDoctor;

    @FXML
    private Button btVolver;  

    @FXML
    private Button btnReg;
   
    String labelNombre;
    String labelApellido;
    String labelDni;
    String labelTel;
    String labelSexo;
    String labelContra;
    String labelDoctor;

    
    ExportarTXT exTxt = new ExportarTXT();
    
    public controladorRegister(String dn) {
    	
    
    	/*exTxt.registarPaciente(registrarUsuario(labelTipo), registrarUsuario(labelDni), registrarUsuario(labelNombre),
    			registrarUsuario(labelApellido), registrarUsuario(labelTel),
    			registrarUsuario(labelSexo), registrarUsuario(labelContra));
    			*/
	}
    
    public controladorRegister(TextField tipo, TextField dni,TextField nombre, TextField apellido, 
    		TextField telefono,TextField sexo, PasswordField contrasenia,TextField doctor, Button confirmarReg) {
    	
    	this.tTipo = tipo;
    	this.tDNI = dni;
    	this.tNombre = nombre;
    	this.tApellido = apellido;
    	this.tTel = telefono;
    	this.tSexo = sexo;
    	this.tPass = contrasenia;
    	this.tDoctor = doctor;
    	this.btnReg = confirmarReg;
    	
    	
    	this.btnReg.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
    		
    		registro();
    	});
    }
    
    public void registro() {
    	
    	if 		(tDNI .getText().isEmpty() 
    			|| tNombre.getText().isEmpty()
    			|| tApellido.getText().isEmpty()
    			|| tTel.getText().isEmpty() 
    			|| tSexo.getText().isEmpty()
    			|| tPass.getText().isEmpty()
    			|| tSexo.getText().isEmpty()
    			|| tDoctor.getText().isEmpty()){
    		
    	   Alert alert = new Alert(AlertType.INFORMATION);
 		   alert.setTitle("Error");
 		   alert.setHeaderText(null);
 		   alert.setContentText("Rellene todos los campos porfavor");
 		   alert.showAndWait();
    	   return;
    		
    	}  else {
    		
    		int labelTipo = Integer.parseInt(tTipo.getText());
    		labelNombre = tNombre.getText();
    		labelApellido = tApellido.getText();
    		labelDni = tDNI.getText();
    		labelTel = tTel.getText();
    		labelSexo = tSexo.getText();
    		labelDoctor = tDoctor.getText();
    		labelContra = tPass.getText();
    		
    		exTxt.registarPaciente(labelTipo, labelDni, labelNombre, labelApellido, labelTel, labelSexo, labelDoctor, labelContra);
    		System.out.println(labelTipo + labelNombre + labelApellido + labelDni + labelTel + labelSexo + labelContra + labelDoctor);
    		
    		
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(); 
	        	fxmlLoader.setLocation(getClass().getResource("/FXML/login.fxml"));
	    		Scene scene2;
				scene2 = new Scene((Parent) fxmlLoader.load());
				 Stage stage2 = new Stage();
	    	       stage2.setTitle("Login");
	    	       stage2.setScene(scene2);
	    	       stage2.show();
	    	       Stage stage22 = (Stage) btVolver.getScene().getWindow();
	    		   stage22.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Alert alert = new Alert(AlertType.INFORMATION);
	 		   alert.setTitle("Registro");
	 		   alert.setHeaderText(null);
	 		   alert.setContentText("Registrado Confirmado");
	 		   alert.showAndWait();
	    	   return;
    	}
    	
    } // registro()

    @FXML
    void volver(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(); 
    	fxmlLoader.setLocation(getClass().getResource("/FXML/login.fxml"));
		   Scene scene2 = new Scene((Parent) fxmlLoader.load());
	       Stage stage2 = new Stage();
	       stage2.setTitle("Login");
	       stage2.setScene(scene2);
	       stage2.show();
	       Stage stage22 = (Stage) btVolver.getScene().getWindow();
		   stage22.close();
    }
    
}
