package application;

//General Imports for FXML Usages
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class editShipController 
{
	@FXML	// Instantiation of elements utilized in editShip Scene
	private Label label1;
	@FXML
	private Label label2;
	@FXML
    private Label availLabel;
	@FXML
	private Label errorBox;
	@FXML
	private Label successBox;
	@FXML
	private TextField editShipNameBox;
	@FXML
	private TextField editAvailabiltyBox;
	@FXML
	private TextField searchShip;
	@FXML
	private Button backToMenuButton;
	@FXML
	private Button searchButton;
	@FXML
	private Button updateButton;
	@FXML
	private Label errorBox2;
	@FXML
	private Label successBox2;
	
	// New ArrayLists to be overwritten
	public ArrayList<Cruise> cruises = new ArrayList<>(); 
	public ArrayList<Passenger> passengers = new ArrayList<>();
	public ArrayList<Ship> ships = new ArrayList<>();
			
	public void initData(ArrayList<Passenger> p) // This Method accepts an updated Version of the Passenger ArrayList 
	{
		passengers = p; 
	}
	public void initCruises(ArrayList<Cruise> c) // This Method accepts an updated Version of the Cruise ArrayList 
	{
		cruises = c; 
	}
	public void initShips(ArrayList<Ship> s) // This Method accepts an updated Version of the Ship ArrayList 
	{
		ships = s; 
	}
	@FXML	// This Method is used to check if a ship object already exists, If so display elements to update ship's information
	void searchShip(MouseEvent event)
	{
		String name = searchShip.getText();
		for (Ship x: ships) // Conditional Check for a Duplicate Ship
    	{
    		if (name.equalsIgnoreCase(x.getShipName())) // If Ship Exists allow user tools to update that ship's information
    		{	
    			successBox.setVisible(true);
    			label1.setVisible(true);
    			label2.setVisible(true);
    			availLabel.setVisible(true);
    			editAvailabiltyBox.setVisible(true);
    			editShipNameBox.setVisible(true);
    			errorBox.setVisible(false);
    			updateButton.setVisible(true);
    			errorBox2.setVisible(false);
    			successBox2.setVisible(false);
    			return;
    		}
    	}
    	// Reach Here - The search went through the entire ArrayList and did not find a match (Ship Does not Exist)
    	successBox.setVisible(false);
		label1.setVisible(false);
		label2.setVisible(false);
		availLabel.setVisible(false);
		editAvailabiltyBox.setVisible(false);
		editShipNameBox.setVisible(false);
		errorBox.setVisible(true);
		updateButton.setVisible(false);
		errorBox2.setVisible(false);
		successBox2.setVisible(false);
		return;
	}

	@FXML	// This Method processes all the new Ship information with conditional checks
	void updateShipInfo(MouseEvent event)
	{
     	String availability = editAvailabiltyBox.getText();
     	String editName = editShipNameBox.getText();
     	String name = searchShip.getText();
     	
     	for (Ship s: ships) // Conditional Check for a Duplicate Ship
    	{
    		if (name.equalsIgnoreCase(s.getShipName()))	// If Duplicate Ship exists
    		{
    			if (!editShipNameBox.getText().isEmpty()) // If there is a Value in the update Ship Name Box
    			{
    				s.setName(editName);	// Set Name to New Value
    			}
    			else
    			{
    				s.setName(name);	// otherwise keep it the same
    			}
    		
    			if (!editAvailabiltyBox.getText().isEmpty());// If new Value Exists in the update Availability Box
    	    	{
    	    		if(availability.equalsIgnoreCase("yes"))	// If yes
    	    		{
    	    			s.setAvailability(true);	// Set Ship Availability to True
    	    			successBox2.setVisible(true);
    	    			errorBox2.setVisible(false);
        	    		return;
    	    		}
    	    		if(availability.equalsIgnoreCase("no"))		// If no
    	    		{
    	    			s.setAvailability(false);	// Set Ship Availability to True
    	    			successBox2.setVisible(true);
    	    			errorBox2.setVisible(false);
        	    		return;
    	    		}
    	    		// If we reach here yes or no were incorrectly typed
    	    		s.setName(name);				// Do not update the name 
        	    	successBox2.setVisible(false); 	// Prompt User of incorrect Input
    	    		errorBox2.setVisible(true);
    	    		return;
    	    	}
    		}
    	}
	}
	
	@FXML // Returns User to the Menu Screen and Stores Updated ArrayLists
	void backToMenu(MouseEvent event) throws IOException
	{
		// Code to Properly load and utilize Menu's ArrayLists
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Menu.fxml"));
		Parent root = loader.load();
		Scene MainScene = new Scene(root);
		MenuController controller = loader.getController();
		// Passes the ArrayLists storing new Information to the ArrayList utilized in the Menu
		controller.initData(passengers);
		controller.initCruises(cruises);
		controller.initShips(ships);
		 
		// Switch to Menu Scene
		Stage stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
		stage.setScene(MainScene);
		stage.show();
	}		
}