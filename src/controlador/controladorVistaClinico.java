
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controlador.FuncionesUtiles;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class controladorVistaClinico implements Initializable{

    @FXML
    private TextField dnifamiliar;

    /*@FXML
    private TableColumn<?, ?> ApellidosColumn;*/

    @FXML
    private TextField firstname;

   /* @FXML
    private TableColumn<?, ?> dni_pacientecolumn;*/

    @FXML
    private Button Ver;

    @FXML
    private Button BTN_borrar_usuario;

    @FXML
    private TextField dniadmin;

    /*@FXML
    private TableColumn<?, ?> Nombrecolunm;*/

    @FXML
    private Button btnCerrarSesion;

   /* @FXML
    private TableColumn<?, ?> MailColumn;*/

    @FXML
    private Button clearFields;

   /* @FXML
    private TableColumn<?, ?> telefonocolumn;

    @FXML
    private TableColumn<?, ?> dni_admincolumn;*/

    @FXML
    private TextField dnipaciente;

   /* @FXML
    private TableView<?> pacientetable;*/

    @FXML
    private TextField lastname;

    @FXML
    private Label doctor1;

    @FXML
    private Button adduser;

    @FXML
    private TextField contrasena;

    @FXML
    private Button btnMensajeria;
    
    @FXML
    private Button btVolver;  

   /* @FXML
    private ComboBox<?> combobox;*/

    @FXML
    private TextField email;
    
    
    FuncionesUtiles nmb = new FuncionesUtiles();
    
    String labelDoctor;
    
    public controladorVistaClinico(String dn) {
    		labelDoctor = nmb.buscaClinico(dn).getNombre();
    	}
    
    @FXML
    void controladorCombobox(ActionEvent event) {

    }

    @FXML
    void cerrarSesion(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(); 
    	fxmlLoader.setLocation(getClass().getResource("/FXML/login.fxml"));
		   Scene scene1 = new Scene((Parent) fxmlLoader.load());
	       Stage stage1 = new Stage();
	       stage1.setTitle("Login");
	       stage1.setScene(scene1);
	       stage1.show();
	        Stage stage11 = (Stage) btnCerrarSesion.getScene().getWindow();
		    stage11.close();
    	
    }
    
 // Funcion abrir Ticket
	 @FXML
    void ClicMensaje (ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(); 
    	fxmlLoader.setLocation(getClass().getResource("/FXML/Tickets.fxml"));
		Scene scene1 = new Scene((Parent) fxmlLoader.load());
	    Stage stage1 = new Stage();
	    stage1.setTitle("Ticket");
	    stage1.setScene(scene1);
	    stage1.show();
	    Stage stage11 = (Stage) btnMensajeria.getScene().getWindow();
		stage11.close();
    }
	 
	
    @Override
	public void initialize(URL location, ResourceBundle resources) { 
    		doctor1.setText(labelDoctor);
		  
		
	}


    @FXML
    void SoloLetras(ActionEvent event) {

    }

    @FXML
    void add_choice_user_familiar(ActionEvent event) {

    }

    @FXML
    void clearFields(ActionEvent event) {

    }

    @FXML
    void CargarInformacion(ActionEvent event) {

    }

    

    @FXML
    void VerClick(ActionEvent event) {

    }


    @FXML
    void borrar_usuarios(ActionEvent event) {

    }

}

