package org.lifestyle.user;

import java.util.ArrayList;

import org.lifestyle.objects.Clothing;
import org.lifestyle.objects.Entertainment;
import org.lifestyle.objects.Fashion;
import org.lifestyle.objects.Food;

public class User {
	private String name; // username
	private String password; // password
	
	private ArrayList<Food> food;
	private ArrayList<String> food_type_likes;
	
	private ArrayList<Entertainment> entertainment;
	private ArrayList<String> enter_genre_likes;
	
	private ArrayList<Clothing> clothing;
	
	private ArrayList<String> fashionBody; //NEW
	private ArrayList<String> fashionWhat;	//NEW
	private ArrayList<String> fashionStyle;	//NEW
	private ArrayList<String> fashionColor; //NEW
	
	public User(String name, String password)
	{
		this.name = name;
		this.password = password;
		
		food = new ArrayList<Food>();
		food_type_likes = new ArrayList<String>();
		
		entertainment = new ArrayList<Entertainment>();
		enter_genre_likes = new ArrayList<String>();
		
		clothing = new ArrayList<Clothing>();
		
		fashionBody = new ArrayList<String>();
		fashionWhat = new ArrayList<String>();
		fashionStyle = new ArrayList<String>();
		fashionColor = new ArrayList<String>();
	} // end User
	
	
	public String getName()
	{
		return name;
	} // getName
	
	public String getPassword()
	{
		return password;
	}
	
	// adders of arraylist
	public void addFood(Food inp)
	{
		if (!food_type_likes.contains(inp.getType()))
			food_type_likes.add(inp.getType());
		food.add(inp);
	} // end addFood
	
	public void addEntertainment(Entertainment inp)
	{
		entertainment.add(inp);
	} // end addEntertainment
	
	public void addClothing(Clothing inp)
	{
		if (clothing.contains(inp))
			return;
		
		clothing.add(inp);
	} // end addFashion
	
	// getters of arraylists
	public ArrayList<Food> getFood()
	{
		return food;
	}
	
	public ArrayList<Entertainment> getEntertainment()
	{
		return entertainment;
	}
	
	public ArrayList<Clothing> getClothing()
	{
		return clothing;
	}
	
	public ArrayList<String> getFoodLikes()
	{
		return food_type_likes;
	}
	
	public ArrayList<String> getEnterLikes()
	{
		return enter_genre_likes;
	}
	
	public void setFoodLikes(ArrayList<String> inp)
	{
		food_type_likes = inp;
	}
	
	public void setEnterGenres(ArrayList<String> inp)
	{
		enter_genre_likes = inp;
	}
	
	public ArrayList<String> getFashionBody() { 	// add me
		return fashionBody;
	}


	public void setFashionBody(ArrayList<String> fashionBody) { // add me
		this.fashionBody = fashionBody;
	}


	public ArrayList<String> getFashionWhat() { // add me
		return fashionWhat;
	}


	public void setFashionWhat(ArrayList<String> fashionWhat) { // add me
		this.fashionWhat = fashionWhat;
	}


	public ArrayList<String> getFashionStyle() { // add me
		return fashionStyle;
	}


	public void setFashionStyle(ArrayList<String> fashionStyle) {
		this.fashionStyle = fashionStyle;
	}


	public ArrayList<String> getFashionColor() {
		return fashionColor;
	}


	public void setFashionColor(ArrayList<String> fashionColor) {
		this.fashionColor = fashionColor;
	}
	
	
	
} // end class
