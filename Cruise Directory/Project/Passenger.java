package application;

public class Passenger 
{
	private String Name;
	private String Cruise;
	private String cabinType;
	
	// Default Constructor
	Passenger(){}
	
	// Constructor w/ Implemented Details
	Passenger (String passengerName, String cruiseType, String room)
	{
		Name = passengerName;
		Cruise = cruiseType;
		cabinType = room;
	}
	
	// Getter Methods
	public String getName()
	{
		return Name;
	}
	public String getCruise()
	{
		return Cruise;
	}
	public String getcabinType()
	{
		return cabinType;
	}
	// Setter Methods
	public void setName(String newName)
	{
		Name = newName;
	}
	public void setCruise(String newCruise)
	{
		Cruise = newCruise;
	}
	public void setCabinType(String newCabin)
	{
		cabinType = newCabin;
	}
	
	@Override
	public String toString()	// Returns Passenger Information
	{
		return ("Name: " + Name + "\n" +
				"Cruise: " + Cruise + "\n" +
				"Room Type: " + cabinType  + "\n" + "\n");
	}
	
}
