package application;

//General Imports for FXML Usages
import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;	// Instantiation of elements utilized in editPassenger Scene
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class editPassengerController 
{
	@FXML	// Instantiation of elements utilized in addShip Scene
    private TextField currentNameBox;
    @FXML
    private TextField editNameBox;
    @FXML
    private TextField editCruiseBox;
    @FXML
    private TextField editRoomBox;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label errorBox;
    @FXML
    private Label successBox;
    @FXML
    private Button backToMenuButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button updateButton;
    
    // New ArrayList to be overwritten
 	public ArrayList<Passenger> passengers = new ArrayList<>();
 	public ArrayList<Cruise> cruises = new ArrayList<>();
 	public ArrayList<Ship> ships = new ArrayList<>();
    
    public void initCruises(ArrayList<Cruise> c) // This Method accepts an updated Version of the Cruise ArrayList 
 	{
    	cruises = c; 
 	}
    public void initData(ArrayList<Passenger> p) // This Method accepts an updated Version of the Passenger ArrayList
 	{
 		passengers = p;
 	}
 	public void initShips(ArrayList<Ship> s) // This Method accepts an updated Version of the Ship ArrayList 
 	{
 		ships = s; 
 	}
	
  	@FXML	// This Method searches for an existing Passenger
    public void searchPassenger(MouseEvent event) throws IOException
    {	
    	String name = currentNameBox.getText();
    	
    	for (Passenger x: passengers) // Conditional Check for a Duplicate Passenger
    	{
    		if (name.equalsIgnoreCase(x.getName())) // If Passenger Exists
    		{	// Prompt User
    			successBox.setVisible(true);
    			label1.setVisible(true);
    			label2.setVisible(true);
    			label3.setVisible(true);
    			editCruiseBox.setVisible(true);
    			editRoomBox.setVisible(true);
    			editNameBox.setVisible(true);
    			errorBox.setVisible(false);
    			updateButton.setVisible(true);
    			return;
    		}
    	}
    	// Reach Here - The search went through the entire ArrayList and did not find a match
    	successBox.setVisible(false);
		label1.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(false);
		editNameBox.setVisible(false);
		editCruiseBox.setVisible(false);
		editRoomBox.setVisible(false);
		errorBox.setVisible(true);
		updateButton.setVisible(false);
		return;	
    }
  	
  	 @FXML	// This Method processes all the new Passenger information with conditional checks
     void updatePassInfo(MouseEvent event) 
  	 {
  		String name = currentNameBox.getText();
     	String editName = editNameBox.getText();
  		String cruise = editCruiseBox.getText();
    	String room =  editRoomBox.getText();
    	
    	for (Passenger x: passengers) // Conditional Check for a Duplicate Passenger
    	{
    		if (name.equalsIgnoreCase(x.getName()))	// If Duplicate exists
    		{
    			if (!editCruiseBox.getText().isEmpty()) // If there is a Value in the update Name Box
    			{
    				for (Cruise c: cruises)	// Conditional Check for a specific Cruise
    		    	{
    		    		if(!cruise.equalsIgnoreCase(c.getCruiseName()))	// Cruise does not exist
    		    		{
    		    			errorBox.setVisible(true); // Prompt User
    		    			errorBox.setText("This Cruise does not exist yet");
    		    			successBox.setVisible(false);
    		    			return;
    		    		}
    		    	}
    				x.setCruise(cruise);	// Set Name to New Value
    			}    	
    			if (!editNameBox.getText().isEmpty()) // If there is a Value in the update Name Box
    			{
    				x.setName(editName);	// Set Name to New Value
    			}
    			else
    			{
    				x.setName(name);	// Otherwise keep is the same
    			}
    			
    			if (room.equalsIgnoreCase("balcony") || room.equalsIgnoreCase("ocean view") || room.equalsIgnoreCase("suite") || room.equalsIgnoreCase("interior"))
    	    	{
    	    		x.setCabinType(room);	// Set Room Type to New Value
    	    	}
    					
    		}
    	}
     }
  	
  	@FXML // Returns User to the Menu Screen and Stores Updated ArrayLists
    void backToMenu(MouseEvent event) throws IOException
    {
    	// Code to Properly load and utilize Menu's ArrayList
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("Menu.fxml"));
    	Parent root = loader.load();
    	Scene MainScene = new Scene(root);
    	MenuController controller = loader.getController();
    	// Passes the ArrayLists storing new Information to the ArrayLists utilized in the Menu
    	controller.initData(passengers);
    	controller.initCruises(cruises);
    	controller.initShips(ships);
    	
    	// Switch to Menu Scene
    	Stage stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
    	stage.setScene(MainScene);
    	stage.show();
    }
}