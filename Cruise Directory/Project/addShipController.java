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

public class addShipController 
{
	@FXML	// Instantiation of elements utilized in addShip Scene
	private TextField shipNameBox;
	@FXML
	private Button addButton;
	@FXML
	private Button menuButton;
	@FXML
    private TextField booleanBox;
    @FXML
    private Label successBox;
    @FXML
    private Label errorBox;
    
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
		
	@FXML	// This method Adds a new Ship Object with a conditional check
	void addShipInfo(MouseEvent event) 
	{
		String name = shipNameBox.getText();
    	String available = booleanBox.getText();
    	boolean k;
    	
    	for (Ship x: ships) // Conditional Check for a Duplicate Passenger
    	{
    		if (name.equalsIgnoreCase(x.getShipName()))	//If Duplicate Exists
    		{
    			errorBox.setVisible(true);	// Prompt User of incorrect usage
    			errorBox.setText("Unsuccessful Addition: This Ship Already Exists");
    			successBox.setVisible(false);
    			return;
    		}
    	}
    	if (available.equalsIgnoreCase("Yes"))	// Conditional Checks for Proper Service Input
    	{
    		k = true; // Create Available Ship Object
    		Ship tempShip = new Ship(name, k);
    		ships.add(tempShip);
    		successBox.setVisible(true);
    		errorBox.setVisible(false);
    		return;
    	}
    	if (available.equalsIgnoreCase("No"))
    	{
    		k = false;	// Create Unavailable Ship Object
    		Ship tempShip = new Ship(name, k);
    		ships.add(tempShip);
    		successBox.setVisible(true);
    		errorBox.setVisible(false);
    		return;
    	}
    	else // Otherwise improper Input
    	{
    		successBox.setVisible(false);	// Prompt User of Improper Usage
    		errorBox.setVisible(true);
    		errorBox.setText("Unsuccessful Addition: Improper Service Input");
    		return;
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
