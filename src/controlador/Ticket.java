package controlador;

import javafx.beans.property.SimpleStringProperty;

public class Ticket {
	
	public SimpleStringProperty asunto = new SimpleStringProperty();
	public SimpleStringProperty destinatario = new SimpleStringProperty();
	public SimpleStringProperty ticket = new SimpleStringProperty();
	
	
	public String getAsunto() {
		return asunto.get();
	}
	
	public String getDestinatario() {
		return destinatario.get();
		
	}
	
	public String getTicket() {
		return ticket.get();
		
	}

	
}
