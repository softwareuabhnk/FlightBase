package se.lexicon.ui;

import java.awt.Font;
import java.util.Map;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import se.lexicon.model.BookingManager;
import se.lexicon.model.Customer;
import se.lexicon.model.CustomerWindow;
import se.lexicon.model.Flight;
import se.lexicon.model.TicketType;

public class MainWindow extends Application {
	
	@Override
    public void start(Stage primaryStage) {
		BookingManager manager = new BookingManager();
		
		TextArea text1 = new TextArea();
		BorderPane border = new BorderPane();
		
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        //Flights
        Button buttonFlights = new Button("Flights");
        buttonFlights.setPrefSize(100, 20);
        buttonFlights.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
            public void handle(ActionEvent event) {
        		Map<Integer, Flight> flights = manager.getFlights();
        		StringBuilder builder = new StringBuilder();
        		
        		for(Flight F : flights.values()) {
        			builder.append(F.toString());
        		}
        		
        		text1.setText(builder.toString());
            }
        });

        Button buttonCustomers = new Button("Customers");
        buttonCustomers.setPrefSize(100, 20);
        buttonCustomers.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		Map<Integer, Customer> customers = manager.getCustomers();
        		StringBuilder builder = new StringBuilder();
        		
        		for(Customer C : customers.values()) {
        			builder.append(C.toString() + "\n");
        		}
        		
        		text1.setText(builder.toString());
        	}
        });
        
        Button buttonNewCustomer = new Button("New Customers");
        buttonNewCustomer.setPrefSize(100, 20);
        buttonNewCustomer.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		CustomerWindow dlg = new CustomerWindow();
        		
        		Customer c = dlg.getCustomer();
        		
        		if(c != null) {
        			Customer newCustomer = manager.registerCustomer(c.getName(), c.getAdress(), c.getPhoneNumber());
        			if(newCustomer != null) {
        				text1.setText("New customer added \n" + newCustomer.toString());
        			}
        			else {
        				text1.setText("Operation failed");
        			}        			
        		}
        		else {
        			text1.setText("Action canceled............");
        		}
        		
        		
        	}
        });
        
        Button buttonBookings = new Button("Bookings");
        buttonBookings.setPrefSize(100, 20);
        buttonBookings.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		text1.setText("Bookings..............");
        	}
        });
        
        Button buttonNewBooking = new Button("New Bookings");
        buttonNewBooking.setPrefSize(100, 20);
        buttonNewBooking.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		border.getBottom().setVisible(true);
        		//text1.setText("New Bookings............");
        	}
        });
        
        hbox.getChildren().addAll(buttonFlights, buttonCustomers,buttonNewCustomer, buttonBookings, buttonNewBooking);
        
        text1.setFont(new javafx.scene.text.Font(16));
        text1.setPrefRowCount(10);
        text1.setPrefColumnCount(5);
        text1.setWrapText(true);
        text1.setPrefWidth(50);
        
//-------------------------------------------------------------------------------------------------------------        
        
        HBox bottomBox = new HBox();
        bottomBox.setPadding(new Insets(15, 12, 15, 12));
        bottomBox.setSpacing(10);
        bottomBox.setStyle("-fx-background-color: #B3C7F7;");
        
        Label lblFlight = new Label("Flight: ");
        TextField txtFlight = new TextField();
        Label lblCustomer = new Label("Customer: ");
        TextField txtCustomer = new TextField();
        Label lblFlightType = new Label("Type");
        final ComboBox<TicketType> flightTypes = new ComboBox<>();
        flightTypes.getItems().addAll( TicketType.ECONOMY, TicketType.BUSINESS);//   "Buisness","Economy");
        flightTypes.setValue(TicketType.ECONOMY);
        
        Button buttonOK = new Button("Reserve");
        buttonOK.setPrefSize(100, 20);
        buttonOK.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		border.getBottom().setVisible(false);
        		//String type = (String) flightTypes.getValue();
        		int customerid = Integer.parseInt(txtCustomer.getText());
        		int flightid = Integer.parseInt(txtFlight.getText());
        		TicketType ticketType = flightTypes.getValue();
        		
        		int id = manager.reserveTicket(customerid, flightid, ticketType);
        		
        		text1.setText("Ok: " + id);
        	}
        });
        
        Button buttonCancel = new Button("Cancel");
        buttonCancel.setPrefSize(100, 20);
        buttonCancel.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		border.getBottom().setVisible(false);
        	}
        });
        
        
        bottomBox.getChildren().addAll(lblFlight,txtFlight,lblCustomer,txtCustomer,flightTypes,buttonOK,buttonCancel);
        
//---------------------------------------------------------------------------------------------------------          
        
        
        
        border.setTop(hbox);
        border.setCenter(text1);
        border.setBottom(bottomBox);
        
        Scene scene = new Scene(border, 800, 650);
        primaryStage.setScene(scene);
        
        primaryStage.setTitle("FlightBase");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        border.getBottom().setVisible(false);
        
    }
	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
