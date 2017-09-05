package org.lifestyle.objects;

public class Food extends Category{
	private String type; // american, mexican, italian, what more could you want?
	
	
	public Food(String name, String type, String price)
	{
		super(name, price);
		this.type = type;
	}
	
	public void setType(String in)
	{
		type = in;
	}
	
	// american, mexican, WHAT MORE COULD YOU POSSIBLY WANT OMG
	public String getType()
	{
		return type;
	}
	
	
} // end class
