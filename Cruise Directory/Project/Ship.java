package application;

public class Ship 
{	// Variables to store Ship Information
	private String sName;
	private int cabinBalcony = 20;
	private int cabinSuite = 10;
	private int cabinOceanview = 1;
	private int cabinInterior = 20;
	private boolean available;

	// Default Constructor
	Ship(){}
	
	// Constructor w/ Implemented Details
	Ship(String name, boolean open)
	{
		sName = name;			// Stores Ship's Name
		available = open;			// Stores the availability of the ship
	}

	// Getter Methods
	public String getShipName()
	{
		return sName;
	}
	
	public boolean getAvailability() 
	{
		return available;
	}
	
	public int getBalcony()
	{
		return cabinBalcony;
	}
	public int getSuite()
	{
		return cabinSuite;
	}
	public int getOceanView()
	{
		return cabinOceanview;
	}
	public int getInterior()
	{
		return cabinInterior;
	}
	
	// Setter Methods
	public void setName(String newName)
	{
		sName = newName;
	}
	public void setSuite(int newSuite)
	{
		cabinSuite = newSuite;
	}
	public void setOceanView(int newOceanView)
	{
		cabinOceanview = newOceanView;
	}
	public void setInterior(int newInterior)
	{
		cabinInterior = newInterior;
	}
	public void setBalcony(int newBalcony)
	{
		cabinBalcony = newBalcony;
	}
	public void setAvailability(boolean x) 
	{
		available = x;
	}
	
	@Override
	public String toString()	// Returns Ship Information
	{
		return ("Ship Name: " + sName + "\n" +
				"Total Balcony Rooms: " + cabinBalcony + "\n" +
				"Total Suite Rooms: " + cabinSuite + "\n" +
				"Total Oceanview Rooms: " + cabinOceanview + "\n" +
				"Total Interior Rooms: " + cabinInterior + "\n" +
				"Availability: " + available + "\n");
	}
}