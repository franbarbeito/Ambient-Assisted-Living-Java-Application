package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class controladorLogin {
	
	   // Atributos aplicacion
	   @FXML
	   private TextField txtUsuario;
	   
	   @FXML
	   private PasswordField jpassClave;
	  
	   @FXML
	   private Button jbEnviar;
	   
	   @FXML
	   private Button btRegistrar;
	   
	   // Funcion registrarse
	   @FXML
	   void registrar(ActionEvent event) throws IOException {
	     	
		    String dn = txtUsuario.getText();
		   
	     	FXMLLoader fxmlLoader = new FXMLLoader(); 
	     	fxmlLoader.setLocation(getClass().getResource("/FXML/Register.fxml"));
	     	controladorRegister controladorReg = new controladorRegister(dn);
	     	fxmlLoader.setController(controladorReg);
	     	
	 		Scene scene1 = new Scene((Parent) fxmlLoader.load());
	 	    Stage stage1 = new Stage();
	 	    stage1.setTitle("Registrar");
	 	    stage1.setScene(scene1);
	 	    stage1.show();
	 	    Stage stage11 = (Stage) btRegistrar.getScene().getWindow();
	 		stage11.close();
	     } 
	   
	   // Funcion login dependiendo del tipo de usuario
	   @FXML
	   private void jbEnviarActionPerformed(ActionEvent event) throws IOException {
		  
		   String clave = jpassClave.getText();
		   String dn = txtUsuario.getText();
		   
		   FXMLLoader fxmlLoader = new FXMLLoader();
		   FuncionesUtiles login = new FuncionesUtiles();
		   int opcion = login.puertaLogin(dn, clave);
		   
	   boolean estado = false;
	   
	   switch(opcion) {
	   
	   // Login si eres paciente
	   case 1: 
		   
		   fxmlLoader.setLocation(getClass().getResource("/FXML/VistaPaciente.fxml"));
		   controladorVistaPaciente controlador1 = new controladorVistaPaciente(dn);
		   fxmlLoader.setController(controlador1);
		   Scene scene1 = new Scene((Parent) fxmlLoader.load());
	       Stage stage1 = new Stage();
	       stage1.setTitle("Paciente");
	       stage1.setScene(scene1);
	       stage1.setResizable(false);
	       stage1.show();
	       Stage stage11 = (Stage) jbEnviar.getScene().getWindow();
	       stage11.close();	
	       estado = true;
	       break;
	   
	   // Login si eres cuidador
	   case 2: 
		   
		   fxmlLoader.setLocation(getClass().getResource("/FXML/VistaCuidador.fxml"));
		   controladorVistaCuidador controlador2 = new controladorVistaCuidador(dn);
		   fxmlLoader.setController(controlador2);
		   Scene scene2 = new Scene((Parent) fxmlLoader.load());
	       Stage stage2 = new Stage();
	       stage2.setTitle("Cuidador");
	       stage2.setScene(scene2);
	       stage2.setResizable(false);
	       stage2.show();
	       Stage stage21 = (Stage) jbEnviar.getScene().getWindow();
	       stage21.close();	
	       estado = true;
	       break;
	       
	   // Login si eres doctor/clï¿½nico
	   case 3: 
		   
		   fxmlLoader.setLocation(getClass().getResource("/FXML/VistaClinico.fxml"));
		   controladorVistaClinico controlador3 = new controladorVistaClinico(dn);
		   fxmlLoader.setController(controlador3);
		   Scene scene3 = new Scene((Parent) fxmlLoader.load());
	       Stage stage3 = new Stage();
	       stage3.setTitle("Doctor");
	       stage3.setScene(scene3);
	       stage3.setResizable(false);
	       stage3.show();
	       Stage stage31 = (Stage) jbEnviar.getScene().getWindow();
	       stage31.close();	
	       estado = true;
	       break;
	       
	       
	   		} // cierre switch (opcion)  
	   
	   if(estado==false) {
		   Alert alert = new Alert(AlertType.INFORMATION);
		   alert.setTitle("Alerta");
		   alert.setHeaderText("Error en los datos");
		   alert.setContentText("Los datos introducidos no son correctos. Por favor, inténtelo de nuevo.");

		   alert.showAndWait();
	   }
	   } // cierre jbEnviar
	   
	   public void initialize(URL location, ResourceBundle resources) {
	
		   
	   }
	   
}
