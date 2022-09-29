package application;


public class Cruise 
{
	private String cruiseName;
	private String shipName;
	private String location;
	
	// Default Constructor
	Cruise(){}
		
	// Constructor w/ Implemented Details
	Cruise(String name, String ship, String destination)
	{
		cruiseName = name;			// Stores Ship's Name
		shipName = ship;	// Stores # of Balcony Cabins on the Ship
		location = destination;		// Stores # of Suite Cabins on the Ship
	}
	
	
	// Getter Methods
	public String getCruiseName()
	{
		return cruiseName;
	}
	
	public String getShipName()
	{
		return shipName;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	// Setter Methods
	public void setCruiseName(String newCruise)
	{
		cruiseName = newCruise;
	}
	public void setShipName(String newShip)
	{
		shipName = newShip;
	}
	public void setLocation(String newPlace)
	{
		location = newPlace;
	}

	@Override
	public String toString()	// Returns Cruise Information
	{
		return ("Cruise Name: " + cruiseName + "\n" +
				"Ship Name: " + shipName + "\n" +
				"Location: " + location + "\n");
	}
}
