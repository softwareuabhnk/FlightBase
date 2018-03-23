package se.lexicon.ui;

import java.awt.Font;
import java.util.ArrayList;
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
import se.lexicon.exception.BusinessClassFullException;
import se.lexicon.exception.EconomyClassFullException;
import se.lexicon.exception.FlightFullException;
import se.lexicon.model.BookingManager;
import se.lexicon.model.Customer;
import se.lexicon.model.CustomerWindow;
import se.lexicon.model.Flight;
import se.lexicon.model.Ticket;
import se.lexicon.model.TicketType;

public class MainWindow extends Application {
	BookingManager manager;
	TextArea text1;
	BorderPane border;
	HBox hbox;
	Button buttonFlights;
	Button buttonCustomers;
	Button buttonNewCustomer;
	Button buttonMenu;
	Button buttonBookings;
	Button buttonNewBooking;
	HBox bottomBox;
	Label lblFlight;
	ComboBox<Integer> cmbFlights;
	ComboBox<Integer> cmbCustomers;
	Label lblCustomer;
	Label lblFlightType;
	Label lblFood;
	ComboBox<Integer> cmbFood;
	ComboBox<TicketType> flightTypes;
	//Button btnAddFood;
	Button buttonOK;
	Button buttonCancel;
	Scene scene;
	
	
	public void init(Stage aStage) {
		BookingManager manager = new BookingManager();
		
		text1 = new TextArea();
		border = new BorderPane();
		
        hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        //Flights
        buttonFlights = new Button("Flights");
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

        buttonCustomers = new Button("Customers");
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
        
        buttonNewCustomer = new Button("New Customers");
        buttonNewCustomer.setPrefSize(100, 20);
        buttonNewCustomer.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		CustomerWindow dlg = new CustomerWindow();
        		
        		Customer c = dlg.getCustomer();
        		
        		if(c != null) {
        			Customer newCustomer = manager.registerCustomer(c.getName(), c.getAdress(), c.getPhoneNumber());
        			if(newCustomer != null) {
        				cmbCustomers.getItems().add(newCustomer.getCustomerID());
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
        
        buttonMenu = new Button("Menu");
        buttonMenu.setPrefSize(100, 20);
        buttonMenu.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		TicketType type = flightTypes.getValue();
        		String s = manager.getMenu(type);
        		text1.setText(s);
        	}
        });
        
        buttonBookings = new Button("Bookings");
        buttonBookings.setPrefSize(100, 20);
        buttonBookings.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		Map<Integer, Ticket> tickets = manager.getTickets();
        		StringBuilder builder = new StringBuilder();
        		
        		for(Ticket T : tickets.values()) {
        			builder.append(T.toString() + "\n");
        		}
        		text1.setText(builder.toString());
        	}
        });
        
        buttonNewBooking = new Button("New Bookings");
        buttonNewBooking.setPrefSize(100, 20);
        buttonNewBooking.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		border.getBottom().setVisible(true);
        		//text1.setText("New Bookings............");
        	}
        });
        
        hbox.getChildren().addAll(buttonFlights, buttonCustomers,buttonNewCustomer,buttonMenu, buttonBookings, buttonNewBooking);
        
        text1.setFont(new javafx.scene.text.Font(16));
        text1.setPrefRowCount(10);
        text1.setPrefColumnCount(5);
        text1.setWrapText(true);
        text1.setPrefWidth(50);
        
//-------------------------------------------------------------------------------------------------------------        
        
        bottomBox = new HBox();
        bottomBox.setPadding(new Insets(15, 12, 15, 12));
        bottomBox.setSpacing(10);
        bottomBox.setStyle("-fx-background-color: #B3C7F7;");
        
        lblFlight = new Label("Flight: ");
        cmbFlights = new ComboBox<>();
        //cmbFlights.getItems().addAll(1);
        //extField txtFlight = new TextField();
        cmbCustomers = new ComboBox<>();
        //cmbCustomers.getItems().addAll(1);
        lblCustomer = new Label("Customer: ");
        //TextField txtCustomer = new TextField();
        lblFlightType = new Label("Type");
        flightTypes = new ComboBox<>();
        flightTypes.getItems().addAll( TicketType.ECONOMY, TicketType.BUSINESS);//   "Buisness","Economy");
        flightTypes.setValue(TicketType.ECONOMY);
        lblFood = new Label("Food");
        cmbFood = new ComboBox<>();
        cmbFood.getItems().addAll(1,2,3);
//        btnAddFood = new Button("Add");
//        btnAddFood.setPrefSize(100, 20);
        
        buttonOK = new Button("Reserve");
        buttonOK.setPrefSize(100, 20);
        buttonOK.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		if(cmbFlights.getValue() == null) {
        			text1.setText("Please select a flight");
        			return;
        		}
        		if(cmbCustomers.getValue() == null) {
        			text1.setText("Please select a customer");
        			return;
        		}
        		int flightid = cmbFlights.getValue();
        		int customerid = cmbCustomers.getValue();
        		TicketType ticketType = flightTypes.getValue();
        		ArrayList<Integer> arrayItems = new ArrayList<>();
        		
        		try {
        			int id = manager.reserveTicket(customerid, flightid, ticketType);
            		
            		if(cmbFood.getValue() != null) {
            			arrayItems.add(cmbFood.getValue());
            			manager.reserveFood(id, ticketType, arrayItems);
            		}
            		text1.setText("New reservation succeeded [id] = " + id);
            		border.getBottom().setVisible(false);
				} catch (FlightFullException e) {
					if (e instanceof EconomyClassFullException) {

						text1.setText("Economy Class Full");

					} else if (e instanceof BusinessClassFullException) {

						text1.setText("Business Class Full");
					}
				}
        		
        		
        		
        	}
        });
        
        buttonCancel = new Button("Cancel");
        buttonCancel.setPrefSize(100, 20);
        buttonCancel.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		border.getBottom().setVisible(false);
        	}
        });
        
        
        bottomBox.getChildren().addAll(lblFlight,cmbFlights,lblCustomer,cmbCustomers,lblFlightType,flightTypes,lblFood,cmbFood ,buttonOK,buttonCancel);
        
//---------------------------------------------------------------------------------------------------------          
        
        
        
        border.setTop(hbox);
        border.setCenter(text1);
        border.setBottom(bottomBox);
        
        scene = new Scene(border, 900, 650);
        
        aStage.setScene(scene);
        aStage.setTitle("FlightBase");
        aStage.setScene(scene);
        aStage.show();
        
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("FlightBase");
//        primaryStage.setScene(scene);
//        primaryStage.show();
        
        border.getBottom().setVisible(false);
        
        Map<Integer, Flight> flightKeys = manager.getFlights();
		cmbFlights.getItems().addAll(flightKeys.keySet());
		
		Map<Integer,Customer> customerKeys = manager.getCustomers();
		cmbCustomers.getItems().addAll(customerKeys.keySet());
		
	}
	
	@Override
    public void start(Stage primaryStage) {
		init(primaryStage);
		
		
    }
	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
