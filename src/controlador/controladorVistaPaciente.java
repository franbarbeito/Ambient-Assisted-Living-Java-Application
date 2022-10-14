package controlador;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import controlador.ImportarTXT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.SensorPulso;
import model.SensorPulsoDatos;
import model.SensorTemperaturaDatos;

public class controladorVistaPaciente implements Initializable {

	// Atributos de la ventana
	@FXML
    private Label doctor1;
	
	@FXML
    private DatePicker idDate;
	
    @FXML
    private Label tel1;
    
    @FXML
    private Label fecha1;

    @FXML
    private PasswordField contra1;
	
    @FXML
    private Label dni1;
    
    @FXML
    private Label apellidos1;
    
    @FXML
    private Label name1;
    
    @FXML
    private ImageView imgCerrarSesion;

    @FXML
    private Button btCerrarSesion;
    
    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnMensajeria;
    
    @FXML
    private Button btVolver;  
    
    @FXML
    private Label labelNombreUsuario;
    
    @FXML
    private Label labelApellidoUsuario;
    
    @FXML
    private LineChart<String, Number> grafica_alarma;
   
    @FXML
    private LineChart<String,Number> grafica_temp;
    
    @FXML
    private LineChart<String, Number> grafica_pulso;      
     
    String labelNombre;
    String labelDoctor;
    String labelApellido;
    String labelDni;
    String labelTel;
    String labelContra;
    
	FuncionesUtiles nmb = new FuncionesUtiles();
	
	public controladorVistaPaciente(String dn) {
		
    	labelNombre = nmb.buscaPaciente(dn).getNombre();
    	labelApellido = nmb.buscaPaciente(dn).getApellidos();
    	labelDni = nmb.buscaPaciente(dn).getDni();
    	labelTel = nmb.buscaPaciente(dn).getTlfn();
    	labelContra = nmb.buscaPaciente(dn).getContrasenia();
    	labelDoctor = nmb.buscaPaciente(dn).getIdDoctor(); 
	}

	    @FXML
	    void labelNombreusuario(ActionEvent event) {

	    }

		// Funcion Log-Out
	 	@FXML
	    void logoutEnviarActionPerformed(ActionEvent event) throws IOException {
	    	
	    	FXMLLoader fxmlLoader = new FXMLLoader(); 
	    	fxmlLoader.setLocation(getClass().getResource("/FXML/login.fxml"));
			   Scene scene1 = new Scene((Parent) fxmlLoader.load());
		       Stage stage1 = new Stage();
		       stage1.setTitle("Login");
		       stage1.setScene(scene1);
		       stage1.show();
		       Stage stage11 = (Stage) btCerrarSesion.getScene().getWindow();
			   stage11.close();
	   }
	 	
	 	// Funcion abrir Ticket
	 	 @FXML
	     void ClicMensaje(ActionEvent event) throws IOException {
	     	
	     	FXMLLoader fxmlLoader = new FXMLLoader(); 
	     	fxmlLoader.setLocation(getClass().getResource("/FXML/Tickets.fxml"));
	 		Scene scene = new Scene((Parent) fxmlLoader.load());
	 	    Stage stage = new Stage();
	 	    stage.setTitle("Ticket");
	 	    stage.setScene(scene);
	 	    stage.show();
	 	    Stage stage1 = (Stage) btnMensajeria.getScene().getWindow();
	 		stage1.close();
	     }
	 
	 
	@SuppressWarnings("deprecation")
	@Override
	public void initialize(URL arg0, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//labelNombreUsuario.setText(labelNombre);
		//labelApellidoUsuario.setText(labelApellido);
    	doctor1.setText(labelDoctor);
    	name1.setText(labelNombre);
    	apellidos1.setText(labelApellido);
    	dni1.setText(labelDni);
    	tel1.setText(labelTel);
    	contra1.setText(labelContra);
    	
    	
	}
	
	String fecha2;
	
	@FXML
    void graficar1(ActionEvent event) {

		
    	if(fecha1!= null) {
ImportarTXT imp = new ImportarTXT();
        	
        	//PULSO
        	SensorPulsoDatos sensorPulso;
        	sensorPulso = imp.leerFicheroPulso();
        	XYChart.Series<String,Number> seriesPulso = new Series<String,Number>();
        	
        	for(int i=0; i<sensorPulso.getDatosSensor().size(); i++) {
        		Date hora = new Date(sensorPulso.getDatosSensor().get(i).getHora());
        		String fecha = hora.getHours() + ":" + hora.getMinutes() + " h";
            	int pulso = sensorPulso.getDatosSensor().get(i).getPulso();
            	seriesPulso.getData().add(new XYChart.Data<String,Number>(fecha, pulso));
        	}
        	seriesPulso.setName("Pulso durante el dia");
        	grafica_pulso.getData().add(seriesPulso);
        	//TEMPERATURA
        	SensorTemperaturaDatos sensorTemperatura;
        	sensorTemperatura = imp.leerFicheroTemperatura();
        	XYChart.Series<String,Number> seriesTempteratura = new Series<String,Number>();
        	int axu1 = sensorTemperatura.getDatosSensor().size()-20;
        	for(int i=axu1; i<sensorTemperatura.getDatosSensor().size(); i++) {
        		Date hora = new Date(sensorTemperatura.getDatosSensor().get(i).getHora());
        		String fecha = hora.getHours() + ":" + hora.getMinutes() + " h";
            	float pulso = sensorTemperatura.getDatosSensor().get(i).getTemperatura();
            	seriesTempteratura.getData().add(new XYChart.Data<String,Number>(fecha, pulso));
        	}
        	seriesTempteratura.setName("Temperatura durante el dia");
        	grafica_temp.getData().add(seriesTempteratura);
        	fecha1.setText(fecha2);
		}
    	else {
    		  Alert alert = new Alert(AlertType.INFORMATION);
   		   alert.setTitle("Alerta");
   		   alert.setContentText("Por favor, inserte una fecha.");

   		   alert.showAndWait();
    	}
    	
    }
	

}
