package controlador;



import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class controladorTicket implements Initializable {
	
	//Declaramos los botones
	
	 @FXML private Button eliminarBT;

	 @FXML private Button enviarBT;

	 @FXML private Button nuevoticketBT;

	 @FXML private Button modificarBT;
	 
	 //Declaramos los textfields 
	 
	 @FXML private TextField filterTicket;
	 
	 @FXML private TextField asuntoM;

	 @FXML private TextField destinatarioM;

	 @FXML private TextArea ticketM;
	 
	


	 
	 //Declaramos la tabla y las columnas 
	 
	 @FXML private TableView<Ticket> tablaRegistroMensajes;
	 @FXML private TableColumn asuntoTabla;
     @FXML private TableColumn destinatarioTabla;
     @FXML private TableColumn ticketTabla;
     ObservableList<Ticket> tickets;
     
     
     private int posicionTicketEnTabla;
	 
	 
    //Metodo que crea nuevo ticket
    @FXML
 	private void nuevoticket (ActionEvent event) {
    	 asuntoM.setText("");
    	 destinatarioM.setText("");
    	 ticketM.setText("");
    	 modificarBT.setDisable(true);
  		 eliminarBT.setDisable(true);
  		 enviarBT.setDisable(false);		
 	}
    //Metodo que envia el ticket
	@FXML
	private void enviarticket (ActionEvent event) {
		Ticket ticket = new Ticket();
 		ticket.asunto.set(asuntoM.getText());
 		ticket.destinatario.set(destinatarioM.getText());
 		ticket.ticket.set(ticketM.getText());
 		tickets.add(ticket);
 		
	}

	@FXML
	private void modificarticket (ActionEvent event) {
		Ticket ticket = new Ticket();
 		ticket.asunto.set(asuntoM.getText());
 		ticket.destinatario.set(destinatarioM.getText());
 		ticket.ticket.set(ticketM.getText());
 		tickets.set(posicionTicketEnTabla, ticket);		
	}

	@FXML
	private void eliminarticket (ActionEvent event) {
		tickets.remove(posicionTicketEnTabla);
			
	}
	
	//PARA SELECCIONAR UNA CELDA DE LA TABLA 
	private final ListChangeListener<Ticket> selectorTablaTicket = new ListChangeListener<Ticket>() {
		@Override
		public void onChanged(ListChangeListener.Change<? extends Ticket> c ) {
			ponerTicketSeleccionado();
		}
		
	};

	public Ticket getTablaTicketsSeleccionado() {
		if (tablaRegistroMensajes != null) {
			List<Ticket> tabla = tablaRegistroMensajes.getSelectionModel().getSelectedItems();
			if (tabla.size() == 1) {
				final Ticket competicionSeleccionada = tabla.get(0);
				return competicionSeleccionada;
				
			}
			
		}
		return null;
		
	}
	
	private void ponerTicketSeleccionado() {
		final Ticket ticket = getTablaTicketsSeleccionado();
		posicionTicketEnTabla = tickets.indexOf(ticket);
		
		if (ticket != null) {
			
			//Pongo los textfields con los datos correspondientes 
			asuntoM.setText(ticket.getAsunto());
			destinatarioM.setText(ticket.getDestinatario());
			ticketM.setText(ticket.getTicket());
			
			//Pongo los botones en su estado correspondiente 
			modificarBT.setDisable(false);
			eliminarBT.setDisable(false);
			enviarBT.setDisable(true);
		}
		
		
		
	}
	
	private void inicializarTablaTickets () {
		asuntoTabla.setCellValueFactory(new PropertyValueFactory<Ticket, String> ("asunto"));
		destinatarioTabla.setCellValueFactory(new PropertyValueFactory<Ticket, String> ("destinatario"));
		ticketTabla.setCellValueFactory(new PropertyValueFactory<Ticket, String> ("ticket"));
		
		
		tickets = FXCollections.observableArrayList();
		tablaRegistroMensajes.setItems(tickets);
	
		
		
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.inicializarTablaTickets();
		
		modificarBT.setDisable(true);
		eliminarBT.setDisable(true);
		
		
		
		//Seleccionar las tuplas de la tabla de tickets 
		
		final ObservableList<Ticket> tablaTicketSel = tablaRegistroMensajes.getSelectionModel().getSelectedItems();
		tablaTicketSel.addListener(selectorTablaTicket);
				
	}
	
	

}
