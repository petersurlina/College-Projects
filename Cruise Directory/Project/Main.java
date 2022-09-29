/* Name: Peter Surlina
 * Date: 12-06-2021
 * Assignment: Final Project
 * Description: Our mission at Luxury Vacation Cruise is to provide the accurate and efficient ability to coordinate cruise bookings
 * for our growing list of affiliate luxury cruise ship owners and cruise lines. We require a simple menu-based system to perform
 * core functions that are essential to our daily operations. The envisioned system will include three primary components: ships, cruises, and
 * passengers. The Luxury Vacation Cruise company does not own ships; instead, it creates cruises using available ships. Once a ship is placed
 *  “in service,” it is available for cruises. Passengers can be added to cruises. Here are the relationships of these components:
 *  
 * • Ships have unique names.
 * • Cruises have unique names and are assigned to ships.
 * • Ships can have multiple cruises.
 * • Each ship has a finite number of passenger cabins (Balcony, Ocean View,Suite, and Interior). Overbooking is not permitted.
 * • Passengers are assigned to cruises.
 */

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
// Launch The Menu Screen
public class Main extends Application 
{	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		primaryStage.setTitle("Selection Menu");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
