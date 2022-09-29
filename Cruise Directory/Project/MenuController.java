package application;

//General Imports for FXML Usages
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

public class MenuController 
{
	private Stage stage;	// Variable for allowing of scene switching
	
	/* 	ArrayLists which are used to pass information from one scene's
	  	ArrayLists to another's*/
	public ArrayList<Passenger> passengersList = new ArrayList<>();	
	public ArrayList<Cruise> cruiseList = new ArrayList<>(); 
	public ArrayList<Ship> shipList = new ArrayList<>();
	
 	public void initData(ArrayList<Passenger> p) // This Method accepts an updated Version of the Passengers ArrayList 
 	{
 		passengersList = p; 
 	}
 	public void initCruises(ArrayList<Cruise> c) // This Method accepts an updated Version of the Cruise ArrayList 
 	{
 		cruiseList = c; 
 	}
 	public void initShips(ArrayList<Ship> s) // This Method accepts an updated Version of the Ship ArrayList 
 	{
 		shipList = s; 
 	}
 	
 	
    @FXML	// Instantiation of elements utilized in addPassenger Scene
    private Button addShipButton;
    @FXML
    private Button editShipButton;
    @FXML
    private Button addCruiseButton;
    @FXML
    private Button editCruiseButton;
    @FXML
    private Button addPassengerButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button editPassengerButton;
    @FXML
    private Button printShipInformationButton;
    @FXML
    private Button printCruiseListButton;
    @FXML
    private Button printCruiseDetailsButton;
    @FXML
    private Button printPassengersButton;
    
    
    
    
    
    
    @FXML	// This method will pass all ArrayLists and Switch to the Add Ship Info Scene
    void addShip(MouseEvent event) throws IOException
    {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("addShipScene.fxml"));
    	Parent root = loader.load();
    	Scene Scene1 = new Scene(root);
    	addShipController controller = loader.getController();
    	controller.initData(passengersList);
    	controller.initCruises(cruiseList);
    	controller.initShips(shipList);
    	
    	// Switch Scene to addCruiseScene
    	stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
    	stage.setScene(Scene1);
    	stage.show();
    }
    
    
    @FXML	// This method will pass all ArrayLists and Switch to the Edit Ship Info Scene
    void editShip(MouseEvent event) throws IOException 
    {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("editShipInfo.fxml"));
    	Parent root = loader.load();
    	Scene Scene2 = new Scene(root);
    	editShipController controller = loader.getController();
    	controller.initData(passengersList);
    	controller.initCruises(cruiseList);
    	controller.initShips(shipList);
    	
    	// Switch Scene to addCruiseScene
    	stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
    	stage.setScene(Scene2);
    	stage.show();
    }
    
    
    
    @FXML // This method will pass all ArrayLists and Switch to the Print Ship Info Scene
    void printShipInfo(MouseEvent event) throws IOException 
    {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("shipPrintInfo.fxml"));
    	Parent root = loader.load();
    	Scene Scene3 = new Scene(root);
    	shipPrintInfoController controller = loader.getController();
    	controller.initData(passengersList);
    	controller.initCruises(cruiseList);
    	controller.initShips(shipList);
    	
    	// Switch Scene to addCruiseScene
    	stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
    	stage.setScene(Scene3);
    	stage.show();
    }
    
    @FXML	// This method will pass all ArrayLists and Switch to the Add Cruise Scene
    void addCruises(MouseEvent event) throws IOException
    {	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("addCruiseScene.fxml"));
    	Parent root = loader.load();
    	Scene Scene3 = new Scene(root);
    	addCruiseController controller = loader.getController();
    	controller.initData(passengersList);
    	controller.initCruises(cruiseList);
    	controller.initShips(shipList);
    	
    	// Switch Scene to addCruiseScene
    	stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
    	stage.setScene(Scene3);
    	stage.show();
    }
    
   
    @FXML	// This method will pass all ArrayLists and Switch to the Edit Cruise Scene
    void editCruise(MouseEvent event) throws IOException 
    {	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("editCruiseScene.fxml"));
    	Parent root = loader.load();
    	Scene Scene4 = new Scene(root);
    	editCruiseController controller = loader.getController();
    	controller.initData(passengersList);
    	controller.initCruises(cruiseList);
    	controller.initShips(shipList);
    	
    	// Switch Scene to editCruiseScene
    	stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
    	stage.setScene(Scene4);
    	stage.show();
    }
    
    
    @FXML	// This method will pass all ArrayLists and Switch to the Print Cruise Scene
    void printCruises(MouseEvent event) throws IOException
    {	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("printCruiseList.fxml"));
    	Parent root = loader.load();
    	Scene SceneB = new Scene(root);
    	printCruiseController controller = loader.getController();
    	controller.initData(passengersList);
    	controller.initCruises(cruiseList);
    	controller.initShips(shipList);
    	
    	// Switch Scene to printCruiseList
    	stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
    	stage.setScene(SceneB);
    	stage.show();
    }
    
    @FXML // This method will pass all ArrayLists and Switch to the Print Cruise Details Scene
    void printCruiseDetails(MouseEvent event) throws IOException
    {	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("printCruiseDetails.fxml"));
    	Parent root = loader.load();
    	Scene SceneC = new Scene(root);
    	printCruiseDetailsController controller = loader.getController();
    	controller.initData(passengersList);
    	controller.initCruises(cruiseList);
    	controller.initShips(shipList);
    	
    	// Switch Scene to printCruiseDetails
    	stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
    	stage.setScene(SceneC);
    	stage.show();
    }
    
    @FXML	// This method will pass all ArrayLists and Switch to the Add Passenger Scene
    void addPassengers(MouseEvent event) throws IOException
    {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("addPassengersScene.fxml"));
    	Parent root = loader.load();
    	Scene Scene5 = new Scene(root);
    	addPassengerController controller = loader.getController();
    	controller.initData(passengersList);
    	controller.initCruises(cruiseList);
    	controller.initShips(shipList);
    	
    	// Switch Scene to addPassengerScene
    	stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
    	stage.setScene(Scene5);
    	stage.show();
    }
    
    @FXML	// This method will pass all ArrayLists and Switch to the Edit Passenger Scene
    void editPassenger(MouseEvent event)  throws IOException
    {	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("editPassengerScene.fxml"));
    	Parent root = loader.load();
    	Scene Scene6 = new Scene(root);
    	editPassengerController controller = loader.getController();
    	controller.initData(passengersList);
    	controller.initCruises(cruiseList);
    	controller.initShips(shipList);
    	
    	// Switch Scene to editPassengerScene
    	stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
    	stage.setScene(Scene6);
    	stage.show();
    }
  
    @FXML	// This method will pass all ArrayLists and Switch to the Passenger Listing Scene
    void printPassengers(MouseEvent event) throws IOException	
    {	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("passengerListing.fxml"));
    	Parent root = loader.load();
    	Scene SceneD = new Scene(root);
    	passengerListController controller = loader.getController();
    	controller.initData(passengersList);
    	controller.initCruises(cruiseList);
    	controller.initShips(shipList);
    	
    	// Switch Scene to passengerListing
    	stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
    	stage.setScene(SceneD);
    	stage.show();
    }
    
    @FXML	// Method to Close Program entirely
    void exitProgram(MouseEvent event) 
    {
    	System.exit(-1);
    }
}