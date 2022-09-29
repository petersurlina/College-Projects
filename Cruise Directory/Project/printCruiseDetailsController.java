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
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class printCruiseDetailsController 
{
	@FXML
	private Button backToMenuButton;
	@FXML
	private TextArea detailsArea;
	
	// New ArrayLists to be overwritten
	public ArrayList<Cruise> cruises = new ArrayList<>(); 
	public ArrayList<Passenger> passengers = new ArrayList<>();
	public ArrayList<Ship> ships = new ArrayList<>();
	
	public void initData(ArrayList<Passenger> p) // This Method accepts an updated Version of the Passengers ArrayList 
 	{
 		passengers = p; 
 	}
	
	public void initCruises(ArrayList<Cruise> c) // This Method accepts an updated Version of the Cruise ArrayList 
 	{
		cruises = c; 
		for (Cruise x: cruises)		// Loop To Print Cruise and their Respective Passengers
 		{
			detailsArea.appendText("-----------Cruise Info----------" + "\n" + x.toString() + "\n" + "-----------Passengers On Cruise----------" + "\n");
 			for (Passenger p: passengers)
 			{
 				if (p.getCruise().equalsIgnoreCase(x.getCruiseName()))
 				{
 					detailsArea.appendText(p.toString());
 				}
 			}
 		}
 	}
	public void initShips(ArrayList<Ship> s) // This Method accepts an updated Version of the Ship ArrayList 
 	{
		ships = s; 
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
		 // Passes the ArrayList storing new Passengers' Information to the ArrayList utilized in the Menu
		 controller.initData(passengers);
		 controller.initCruises(cruises);
		 controller.initShips(ships);

		 // Switch to Menu Scene
		 Stage stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
		 stage.setScene(MainScene);
		 stage.show();
	}
}
