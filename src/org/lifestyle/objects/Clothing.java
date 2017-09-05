package org.lifestyle.objects;

public class Clothing{

	protected String[] bodySection = {"Top","Bottom","Shoes","Accesory"}; // index #1####
	protected String[] tops = {"T-Shirt","Shirt","Sweater","Jacket"};	// index ##1###
	protected String[] bottoms = {"Shorts","Pants","Underwear", "Socks"};		// index ##1##
	protected String[] shoes = {"Hi-Tops","Dressy", "Heels", "Sneaker"}; // index ##1###
	protected String[] accesories = {"Ring","Necklace","Hat","Belt"};	// index ##1###
	protected String[] colors = {"Blue","Red","Black","White","Pink"};		// index ###1##
	protected String[] styles = {"Casual","Business","Formal","Sleepwear"};		// index ####1#
	
	
	private String name;
	private String price;
	private int index;
	
	
	public Clothing(String name, String price, int index){
		this.name = name;
		this.price = price;
		this.index = index;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getStyle()
	{
		return styles[((index)/10)%10000%1000%100%10 - 1];
	}
	
	
	public String getColor()
	{
		return colors[((index)/100)%1000%100%10 - 1];
	}
	
	public String getWhatItIs()
	{
		if(((index)/10000)%10 == 1)
			return tops[((index)/1000)%100%10 - 1];
		if(((index)/10000)%10 == 2)
			return bottoms[((index)/1000)%100%10 - 1];
		if(((index)/10000)%10 == 3)
			return shoes[((index)/1000)%100%10 - 1];
		if(((index)/10000)%10 == 4)
			return accesories[((index)/1000)%100%10 - 1];
		else
			return "Not indexed";
	}
	
	public String getBodySect()
	{
		return bodySection[((index)/10000)%10 - 1];
	}
	
	public void printArticle()
	{
		System.out.println("" + name + " is: " + getBodySect() + " and "+ getWhatItIs() + " and " + getColor()+ " and " + getStyle()) ;
	}
	
	
	
	
} // end Fashion