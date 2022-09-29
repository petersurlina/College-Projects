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

public class editCruiseController 
{
	
	
	@FXML// Instantiation of elements utilized in editCruise Scene
	private TextField currentNameBox;
	@FXML
	private Label label1;
	@FXML
	private Label label2;
	@FXML
	private TextField editShipBox;
	@FXML
	private TextField editLocationBox;
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
	@FXML
	private Label label3;
	@FXML
	private TextField editNameBox;
	
	// New ArrayLists to be overwritten
	public ArrayList<Cruise> cruises = new ArrayList<>();
	public ArrayList<Passenger> passengers = new ArrayList<>();
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
	
	@FXML	// This Method searches for an existing Cruise
	void searchCruise(MouseEvent event) 
	{
		String name = currentNameBox.getText();
		
    	for (Cruise x: cruises) // Conditional Check for a Duplicate Passenger
    	{
    		if (name.equalsIgnoreCase(x.getCruiseName())) // If cruise exists load elements for user to change cruise information 
    		{
    			successBox.setVisible(true);
    			label1.setVisible(true);
    			label2.setVisible(true);
    			label3.setVisible(true);
    			editNameBox.setVisible(true);
    			editShipBox.setVisible(true);
    			editLocationBox.setVisible(true);
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
		editShipBox.setVisible(false);
		editLocationBox.setVisible(false);
		errorBox.setVisible(true);
		updateButton.setVisible(false);
		return;
	}

	@FXML	// This Method updates information of an existing Cruise with conditional checks
	void updateCruiseInfo(MouseEvent event) 
	{
		String name = currentNameBox.getText();
     	String editName = editNameBox.getText();
  		String shipName = editShipBox.getText();
    	String location =  editLocationBox.getText();
    	
    	for (Cruise x: cruises) // Conditional Check for a Duplicate Cruise
    	{
    		if (name.equalsIgnoreCase(x.getCruiseName())) // If Cruise Exists
    		{
    			if (!editLocationBox.getText().isEmpty()) // If there is a Value in the update Location Box
    			{
    				for (Ship s: ships)
    				{
    					if (!shipName.equalsIgnoreCase(s.getShipName())) // Conditional Check to see if the ship exists or not
    					{
    						errorBox.setVisible(true); // Prompt user ship does not exist
    						errorBox.setText("The Ship does not Exist.");
    						successBox.setVisible(false);
    						return;
    					}
    					// Conditional to make sure the ship is available
    					if (shipName.equalsIgnoreCase(s.getShipName()) & s.getAvailability() == false) 
    					{
    						errorBox.setVisible(true); // Prompt user ship is not available
    						errorBox.setText("The Ship is not Available.");
    						successBox.setVisible(false);
    						return;
    					}
    				}
    				x.setLocation(location);	// Set Location to New Value
    			}    			
    			if (!editNameBox.getText().isEmpty()) // If there is a Value in the update Name Box
    			{
    				x.setCruiseName(editName);	// Set Name to New Value
    			}
    			else
    			{
    				x.setCruiseName(name);	// otherwise keep it the same
    			}
    			
    			if (!editShipBox.getText().isEmpty())	// If there is a new Value in the update Ship Box
    	    	{
    	    		x.setShipName(shipName);	// Set Ship Name to New Value
    	    	}
    		}
    	}
    	// Reach Here - All conditions Passed
		errorBox.setVisible(false);
		successBox.setVisible(true);
		successBox.setText("Update completed");
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
