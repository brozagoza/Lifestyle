package org.lifestyle.objects;

import java.util.ArrayList;

import org.lifestyle.user.User;

public class Fashion{
	
	private ArrayList<Clothing> clothing; 
	private ArrayList<Shop> shops; 
	
	protected String[] bodySection = {"Top","Bottom","Shoes","Accesory"}; // index #1####
	protected String[] tops = {"T-Shirt","Shirt","Sweater","Jacket"};	// index ##1###
	protected String[] bottoms = {"Shorts","Pants","Underwear", "Socks"};		// index ##1##
	protected String[] shoes = {"Hi-Tops","Dressy", "Heels", "Sneaker"}; // index ##1###
	protected String[] accesories = {"Ring","Necklace","Hat","Belt"};	// index ##1###
	protected String[] colors = {"Blue","Red","Black","White","Pink"};		// index ###1##
	protected String[] styles = {"Casual","Business","Formal","Sleepwear"};		// index ####1#
	
	
	
	public String[] getBodySection() {
		return bodySection;
	}
	
	public String[] getWhat()
	{
		int i = 0;
		String [] tmp = new String[tops.length+bottoms.length+shoes.length+accesories.length];
		
		for (; i < tops.length; i++)
			tmp[i] = tops[i];
		
		for (int j = 0; j < bottoms.length; j++, i++)
			tmp[i] = bottoms[j];
		
		for (int j = 0; j < shoes.length; i++, j++)
			tmp[i] = shoes[j];
		
		for (int j = 0; j < accesories.length; i++, j++)
			tmp[i] = accesories[j];
		
		return tmp;
	}

	public String[] getTops() { //////
		return tops;
	}

	public String[] getBottoms() {
		return bottoms;
	}

	public String[] getShoes() {
		return shoes;
	}

	public String[] getAccesories() { ///////
		return accesories;
	}

	public String[] getColors() {
		return colors;
	}

	public String[] getStyles() {
		return styles;
	}

	public Clothing getClothing(String inp)
	{	
		
		//System.out.println(clothing.size());
		
		
		
		for (int i = 0; i < clothing.size(); i++)
		{
			//System.out.println(clothing.get(i).getName());
			//clothing.get(i).getName().equals(anObject)
			
			if (clothing.get(i).getName().equals(inp))
				return clothing.get(i);
		}
		
		//System.out.println("fdsafdsa");
		return null;
			
	}


	
	

	public Fashion() {
		clothing = new ArrayList<Clothing>();
		shops = new ArrayList<Shop>();
	}
	
	public void addObject(String name, String price, int index)
	{
		if(index/100000 == 1)
		{
			Clothing temp = new Clothing(name, price, index);
			clothing.add(temp);
		}
		else if(index/100000 == 2)
		{
			Shop temp = new Shop(name, price, index);
			shops.add(temp);
		}
	}
	
	public ArrayList<Clothing> getClothesSuggestArray(User user)
	{
		ArrayList<Clothing> temp = new ArrayList<Clothing>();
		for(int i = 0; i < clothing.size(); i++)
		{
			int matches = 0;
			if(user.getFashionBody().contains(clothing.get(i).getBodySect()))
				matches++;
			if(user.getFashionWhat().contains(clothing.get(i).getWhatItIs()))
				matches++;
			if(user.getFashionStyle().contains(clothing.get(i).getStyle()))
				matches++;
			if(user.getFashionColor().contains(clothing.get(i).getColor()))
				matches++;
			
			if(matches >= 2)
				temp.add(clothing.get(i));
			
			if (user.getClothing().contains(clothing.get(i)))
				temp.remove(clothing.get(i));
			
		}
		
		return temp;
		
	}
	
	
	
	public void printClothes()
	{
		for(int i = 0; i < clothing.size();i++)
		{
			clothing.get(i).printArticle();
		}
	}

	
	
}