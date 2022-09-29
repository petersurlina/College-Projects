package application;

// General Imports for FXML Usages
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

public class addPassengerController 
{	
    @FXML	// Instantiation of elements utilized in addPassenger Scene
    private TextField nameBox;
    @FXML
    private TextField cruiseBox;
    @FXML
    private TextField roomBox;
    @FXML
    private Button addButton;
    @FXML
    private Button menuButton;
    @FXML
    private Label unsuccessBox;
    @FXML
    private Label successBox;
    
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
 	
    @FXML	// This Method Adds Passenger Information with conditional checking
    void addPassInfo(MouseEvent event) throws IOException
    {	
    	String name = nameBox.getText();
    	String cruise = cruiseBox.getText();
    	String room =  roomBox.getText();
    	int balCounter = 0;
    	int suiteCounter = 0;
    	int oceanCounter = 0;
    	int intCounter = 0;
    	
    	
    	if (cruises.isEmpty())	// Conditional to Check that there are cruises
    	{
    		unsuccessBox.setVisible(true); // If not prompt user
			unsuccessBox.setText("No Cruises Available");
			successBox.setVisible(false);
			return;
    	}
    	
    	for (Passenger x: passengers) // Conditional Check for a Duplicate Passenger
    	{
    		if (name.equalsIgnoreCase(x.getName())) // If Duplicate exists
    		{
    			unsuccessBox.setVisible(true);	// Prompt User
    			unsuccessBox.setText("Unsuccessful Addition: This Passenger Exists");
    			successBox.setVisible(false);
    			return;
    		}
    	}
    	
    	for (Cruise c: cruises)	// Conditional Check for a specific Cruise
    	{
    		if(!cruise.equalsIgnoreCase(c.getCruiseName()))	// Cruise does not exist
    		{
    			unsuccessBox.setVisible(true); // Prompt User
    			unsuccessBox.setText("This Cruise does not exist yet");
    			successBox.setVisible(false);
    			return;
    		}
    	}
    	
    	for (Passenger p: passengers)	// Loop to count number of Room Types taken
    	{
    		if (p.getcabinType().equalsIgnoreCase("balcony"))
    		{
    			balCounter++;
    		}
    		if (p.getcabinType().equalsIgnoreCase("ocean view"))
    		{
    			oceanCounter++;
    		}
    		if (p.getcabinType().equalsIgnoreCase("suite"))
    		{
    			suiteCounter++;
    		}
    		if (p.getcabinType().equalsIgnoreCase("interior"))
    		{
    			intCounter++;
    		}
    	}
    	
    	for (Ship s: ships)	// Conditional to avoid over-booking of Rooms
    	{
    		if (balCounter >= s.getBalcony()  || oceanCounter >= s.getOceanView() || intCounter >= s.getInterior() || suiteCounter >= s.getSuite())
    		{
  
    			unsuccessBox.setVisible(true);	// Prompt User
    			unsuccessBox.setText("This Addition will cause overbooking issues. Try a different Room");
    			successBox.setVisible(false);
    			return;
    		}
    	}
    	
    	// Conditional Check for a Proper Room Input
    	if (room.equalsIgnoreCase("balcony") || room.equalsIgnoreCase("ocean view") || room.equalsIgnoreCase("suite") || room.equalsIgnoreCase("interior"))
    	{
    		// Reach Here - All Conditionals passed
    		Passenger tempPassenger = new Passenger(name, cruise, room);
    		passengers.add(tempPassenger);
    		successBox.setVisible(true);
    		unsuccessBox.setVisible(false);
    		return;
    	}
    	else // Improper Input
    	{
    		successBox.setVisible(false);
    		unsuccessBox.setVisible(true);
    		unsuccessBox.setText("Unsuccessful Addition: Improper Room Type");
    		return;
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
    