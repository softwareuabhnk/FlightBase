package se.lexicon.model;

import java.util.Optional;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class CustomerWindow {
	Dialog<Customer> dialog = new Dialog<>();
	
	public CustomerWindow() {
		init();
	}
	
	private void init() {
		dialog.setTitle("Add new customer");
		dialog.setHeaderText("press Okay (or click title bar 'X' for cancel).");
		dialog.setResizable(true);

		Label label1 = new Label("Name: ");
		//Label label2 = new Label("Customer number: ");
		Label label3 = new Label("Address: ");
		Label label4 = new Label("Phone number: ");
		TextField txtName = new TextField();
		//TextField txtCustomerID = new TextField();
		TextField txtAddress = new TextField();
		TextField txtPhone = new TextField();
				
		GridPane grid = new GridPane();
		grid.add(label1, 1, 1);
		grid.add(txtName, 2, 1);
		//grid.add(label2, 1, 2);
		//grid.add(txtCustomerID, 2, 2);
		grid.add(label3, 1, 2);
		grid.add(txtAddress, 2, 2);
		grid.add(label4, 1, 3);
		grid.add(txtPhone, 2, 3);
		
		dialog.getDialogPane().setContent(grid);
				
		ButtonType buttonTypeOk = new ButtonType("Okay", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

		dialog.setResultConverter(new Callback<ButtonType, Customer>() {
		    @Override
		    public Customer call(ButtonType b) {

		        if (b == buttonTypeOk) {
		        	// return new Customer(Integer.parseInt(txtCustomerID.getText()), txtName.getText(),txtAddress.getText(),txtPhone.getText());
		            return new Customer(0, txtName.getText(),txtAddress.getText(),txtPhone.getText());
		        }

		        return null;
		    }
		});
	}
	
	public Customer getCustomer() {
		Optional<Customer> result = dialog.showAndWait();
		
		if (result.isPresent()) {
			return result.get();
		}
		else {
			return null;
		}
	}
	
}
