package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.SensorPulsoDatos;
import model.SensorTemperaturaDatos;

public class controladorVistaCuidador implements Initializable {
	
	
	@FXML
    private ChoiceBox<String> choiceBox_pacientes;
	
	@FXML
    private Label telcuidador;

    @FXML
    private Label dnicuidador;

    @FXML
    private Label apellidoscuidador;

    @FXML
    private Label nombrecuidador;


	@FXML
	private Button CerrarSesionButton;

	@FXML
	private Label nombrepaciente;

	@FXML
	private Label apellidospaciente;

	@FXML
	private Label dnipaciente;

	@FXML
	private Label telfpaciente;

	@FXML
	private Label sexopaciente;

	@FXML
    private Button btCerrarSesion;
	
	@FXML
    private Label labelNombreUsuario;
	
	
	@FXML
    private LineChart<String,Number> grafica_temp;
    
    @FXML
    private LineChart<String, Number> grafica_pulso;
    
	
	@FXML
	private ComboBox combobox;
	
	@FXML
    private Button buttoncargardatos;
	
	@FXML 
	private String[] pacientes;
	private String[] pacientesaux;
	private String[] pacientesaux1;	
	
	String labelNombre;
	String labelApellido;
	String labelDni;
	String labelTelefono;
	String labelPacDni;
	
	FuncionesUtiles nmb = new FuncionesUtiles();
	
    public controladorVistaCuidador(String dn) {
		
    labelNombre = nmb.buscaCuidador(dn).getNombre();
    labelApellido = nmb.buscaCuidador(dn).getApellidos();
    labelDni = nmb.buscaCuidador(dn).getDni();
    labelTelefono = nmb.buscaCuidador(dn).getTlfn();
    //
    pacientes = nmb.buscaCuidador(dn).getPacientes();
	/*for(int i=0; i<pacientes.length; i++) {
		System.out.print("pacientes "+i+": "); System.out.println(pacientes[i]);		
	}*/
	
	int j = 0;
	
	for(int i=0; i<pacientes.length; i++) {
		if (!pacientes[i].equals("null")) {
			j++;
        }			
	}
	pacientesaux = new String[j];
	for(int i=0; i<pacientes.length; i++) {
		if (!pacientes[i].equals("null")) {
			pacientesaux[i]=pacientes[i];
        }			
	}
	int k = pacientesaux.length;
	String dn2;
	pacientesaux1 = new String[k];
	for(int i=0; i < pacientesaux.length;i++) {
		dn2 = pacientesaux[i];
		pacientesaux1[i] = nmb.buscaPaciente(dn2).getDni();
	}
	
}
    
    public void controladorVistaPaciente(String dn) {
    	
    	
    }
    

  
    // Funcion log-out
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
    
    
    @Override
	public void initialize(URL arg0, ResourceBundle resources) {
    	
    	nombrecuidador.setText(labelNombre);
    	apellidoscuidador.setText(labelApellido);
    	dnicuidador.setText(labelDni);
    	telcuidador.setText(labelTelefono);
    	
    	ObservableList<String> valores = FXCollections.observableArrayList(pacientesaux1);
		choiceBox_pacientes.setItems(valores);
		/*labelPacDni = choiceBox_pacientes.getSelectionModel().getSelectedItem();
   	 	String aux1 = nmb.buscaPaciente(labelPacDni).getNombre();
   	 	nombrepaciente.setText(aux1);*/
    	
    	
    	
	}
    
    @FXML
    void cargardatos (ActionEvent event) {
    
    	
    	labelPacDni = choiceBox_pacientes.getSelectionModel().getSelectedItem();
    	if(labelPacDni!=null) { 
    	String aux1 = nmb.buscaPaciente(labelPacDni).getNombre();
    	 nombrepaciente.setText(aux1);
    	 String aux2 = nmb.buscaPaciente(labelPacDni).getApellidos();
    	 apellidospaciente.setText(aux2);
    	 dnipaciente.setText(labelPacDni);
    	 String aux3 = nmb.buscaPaciente(labelPacDni).getTlfn();
    	 telfpaciente.setText(aux3);
    	 String aux4 = nmb.buscaPaciente(labelPacDni).getSexo();
    	 sexopaciente.setText(aux4);}
    	else {
    		Alert alert = new Alert(AlertType.INFORMATION);
  		   alert.setTitle("Error");
  		   alert.setHeaderText(null);
  		   alert.setContentText("Seleccione un paciente, porfavor.");
  		   alert.showAndWait();
    	}
    	//graficas al inicializar
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
    	
    	for(int i=0; i<sensorTemperatura.getDatosSensor().size(); i++) {
    		Date hora = new Date(sensorTemperatura.getDatosSensor().get(i).getHora());
    		String fecha = hora.getHours() + ":" + hora.getMinutes() + " h";
        	float pulso = sensorTemperatura.getDatosSensor().get(i).getTemperatura();
        	seriesTempteratura.getData().add(new XYChart.Data<String,Number>(fecha, pulso));
    	}
    	seriesTempteratura.setName("Temperatura durante el dia");
    	grafica_temp.getData().add(seriesTempteratura);
    }
    	
    	
	
}
