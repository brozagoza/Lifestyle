package org.lifestyle.objects;

public abstract class Category {
	protected String name;		// name
	protected String price;		// price represented as dollar signs
	
	
	
	public Category(String name, String price)
	{
		this.name = name;
		this.price = price;
	} // end constructor
	
	
	
	//////// GETTERS AND SETTERS ///////
	public void setName(String name)
	{
		this.name = name;
	} // end setName
	
	public void setPrice(String price)
	{
		this.price = price;
	} // end setPrice
	
	public String getName()
	{
		return name;
	} // end getName
	
	public String getPrice()
	{
		return price;
	} // end 
	///////////////////////////////////
	
	
} // end class