package org.lifestyle.objects;

public class Entertainment extends Category{

	private String type;
	private String genre;
	
	public Entertainment(String name, String price){
		super(name, price);
	}
	
	public Entertainment(String name, String type, String genre) {
		super(name, "");
		this.type = type;
		this.genre = genre;
	} // end constructor
	
	public String getType()
	{
		return type;
	}
	
	public String getGenre()
	{
		return genre;
	}

}
