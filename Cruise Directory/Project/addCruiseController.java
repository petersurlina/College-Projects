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

public class addCruiseController 
{
	@FXML	// Instantiation of elements utilized in addCruise Scene
	private TextField cruiseNameBox;
	@FXML
	private TextField shipNameBox;
	@FXML
	private TextField locationBox;
	@FXML
	private Button addButton;
	@FXML
	private Button menuButton;
	@FXML
	private Label errorLabel;
	@FXML
	private Label successLabel;
	
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
	
	@FXML	// This Method adds a New Cruise Object with Conditional checks
	void addCruiseInfo(MouseEvent event) 
	{
		String cruise = cruiseNameBox.getText();
    	String ship = shipNameBox.getText();
    	String location =  locationBox.getText();

    	
    	if (ships.isEmpty())	// Conditional to Check that there are Ships
    	{
			errorLabel.setVisible(true); // If not prompt user
			errorLabel.setText("No Ships Available");
			successLabel.setVisible(false);
			return;
    	}
    	
		for (Ship s: ships)
		{
			if (!ship.equalsIgnoreCase(s.getShipName())) // Conditional Check to see if the ship exists or not
			{
				errorLabel.setVisible(true); // Prompt user ship does not exist
				errorLabel.setText("The Ship does not Exist.");
				successLabel.setVisible(false);
				return;
			}
			// Conditional to make sure the ship is available
			if (ship.equalsIgnoreCase(s.getShipName()) & s.getAvailability() == false) 
			{
				errorLabel.setVisible(true); // Prompt user ship is not available
				errorLabel.setText("The Ship is not Available.");
				successLabel.setVisible(false);
				return;
			}
		}
    	
		for (Cruise c: cruises) // Conditional Check for a Duplicate Cruise
    	{
    		if (cruise.equalsIgnoreCase(c.getCruiseName())) // If Duplicate Exists
    		{
    			errorLabel.setVisible(true); // Prompt user of Duplicate Cruise
    			successLabel.setVisible(false);
    			return;
    		}
    	}
		// Reach Here - All Conditions passed and add New Cruise
		Cruise tempCruise = new Cruise(cruise, ship, location);
    	cruises.add(tempCruise);
		successLabel.setVisible(true);
		errorLabel.setVisible(false);
		return;
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