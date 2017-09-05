package org.lifestyle.user;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.lifestyle.objects.*;

public class Database implements Serializable{

	private ArrayList<User> userBank; // userBank
	
	// Food
	private ArrayList<Food> foodBank;
	private ArrayList<String> foodTypes;
	
	// Entertainment
	private ArrayList<Entertainment> enterBank;
	private ArrayList<String> enterGenres;
	
	// Fashion
	private ArrayList<Fashion> fashBank;
	
	/*
	 * Database constructor
	 */
	public Database()
	{
		userBank = new ArrayList<User>();
		
		// food
		foodBank = new ArrayList<Food>();
		foodTypes = new ArrayList<String>();
		
		// entertainment
		enterBank = new ArrayList<Entertainment>();
		enterGenres = new ArrayList<String>();
		
		// fashion
		fashBank = new ArrayList<Fashion>();
		
		readFoodFile("food_data.csv");
		readEntertainmentFile("entertainment_data.csv");
	} // end Database
	
	/*============================  USERS   ==========================================================*/
	/*================================================================================================*/
	public void createUser(String name, String password)
	{
		userBank.add(new User(name, password)); // end userBank
	} // end createUser
	
	public boolean deleteUser(String name)
	{
		if (userBank.remove(getUser(name)) == false)
			return false;
		else
			return true;
	} // end delete User
	
	public ArrayList<User> getUsers()
	{
		return userBank;
	} // end getUsers
	
	public User getUser(String inp)
	{
		for (int i = 0; i < userBank.size(); i++)
			if (userBank.get(i).getName().equals(inp))
				return userBank.get(i);
		
		return null;
	} // end get user
	/*================================================================================================*/
	/*================================================================================================*/
	
	
	/*================================================================================================
	 *	
	 * 
	 * 
	 *================================================================================================*/
	public ArrayList<Food> getFoodBank()
	{
		return foodBank;
	} // end getFoodBank
	
	public ArrayList<String> getFoodTypes()
	{
		return foodTypes;
	} // getFoodTypes from foodBank
	
	public ArrayList<String> getEnterGenres()
	{
		return enterGenres;
	}
	
	// Returns the food object that you require
	public Food getFood(String inp)
	{
		for (int i = 0; i < foodBank.size(); i++)
			if (inp.equals(foodBank.get(i).getName()))
					return foodBank.get(i);
		
		return null;
	} // end getFood
	
	public Entertainment getEntertainment(String inp)
	{
		for (int i = 0; i < enterBank.size(); i++)
			if (inp.equals(enterBank.get(i).getName()))
				return enterBank.get(i);
		
		return null;
	}
	
	public ArrayList<Entertainment> getEnterBank()
	{
		return enterBank;
	}
	
	public ArrayList<String> foodMatches(User user)
	{
		ArrayList<String> tmp = new ArrayList<String>();

		// matches initial likes from user and foodbank
		for (int i = 0; i < foodBank.size(); i++)
			for (int j = 0; j < user.getFoodLikes().size(); j++)
				if (user.getFoodLikes().get(j).equals(foodBank.get(i).getType()) 
						&& !user.getFood().contains(foodBank.get(i)))
					tmp.add(foodBank.get(i).getName());
		
		
		// matches properties of the user's food bank and the database's food bank
		
		
		return tmp;
	} // end foodMatches
	
	public ArrayList<String> enterMatches(User user)
	{
		ArrayList<String> tmp = new ArrayList<String>();
		
		for (int i = 0; i < enterBank.size(); i++)
			for (int j = 0; j < user.getEnterLikes().size(); j++)
				if (user.getEnterLikes().get(j).equals(enterBank.get(i).getGenre())
					&& !user.getEntertainment().contains(enterBank.get(i)))
					tmp.add(enterBank.get(i).getName());
		
		return tmp;
	}
	
	////// price stuff
	public ArrayList<String> foodPriceMatches(User user)
	{
		ArrayList<String> tmp = new ArrayList<String>();
		String str = "";
		
		int one_count = 0, two_count = 0, three_count = 0;
		
		for (int i = 0; i < user.getFood().size(); i++)
			if (user.getFood().get(i).getPrice().equals("$"))
				one_count++;
			else if (user.getFood().get(i).getPrice().equals("$$"))
				two_count++;
			else if (user.getFood().get(i).getPrice().equals("$$$"))
				three_count++;
		
		if (three_count > two_count && three_count > one_count) 
			str = "$$$";
		else if (two_count > three_count && two_count > one_count)
			str = "$$";
		else
			str = "$";
		
		for (int i = 0; i < user.getFood().size(); i++)
			if (user.getFood().get(i).getPrice().equals(str))
				tmp.add(user.getFood().get(i).getName());
		
		return tmp;
	} // end foodPriceMatches
	
	public ArrayList<String> enterTypeMatches(User user)
	{
		ArrayList<String> tmp = new ArrayList<String>();
		String str = "";
		
		int tv = 0, mov = 0;
		
		for (int i = 0; i < user.getEntertainment().size(); i++)
			if (user.getEntertainment().get(i).getType().equals("TV"))
				tv++;
			else
				mov++;
		
		if (mov < tv)
			str = "TV";
		else
			str = "Movie";
		
		for (int i = 0; i < user.getEntertainment().size(); i++)
			if (user.getEntertainment().get(i).getType().equals(str))
				tmp.add(user.getEntertainment().get(i).getName());
		
		return tmp;
	} // end 
	
	
	/*================================================================================================
	 *	Reads in the food excel file
	 * 
	 * 
	 *================================================================================================*/
	public void readFoodFile(String filename)
	{
		try
		  {
		    BufferedReader reader = new BufferedReader(new FileReader(filename));
		    String line;
		    while ((line = reader.readLine()) != null)
		    {
		    	String foodName = line.substring(0, line.indexOf(','));
		    	String foodType = line.substring(line.indexOf(',', line.indexOf(','))+1, line.lastIndexOf(','));
		    	String foodPrice = line.substring( line.lastIndexOf(',')+1, line.length());
		    	
		    	
		    	Food newFood = new Food(foodName, foodType, foodPrice);
		    	foodBank.add(newFood);	// add the new food object :P
		    	
		    	if (!foodTypes.contains(foodType))
		    		foodTypes.add(foodType);
		    }
		    reader.close();
		  }
		catch (Exception e)
		  {
		    System.err.format("Exception occurred trying to read '%s'.", filename);
		    e.printStackTrace();
		  }
	} // end readFile
	
	
	public void readEntertainmentFile(String filename)
	{
		try
		  {
		    BufferedReader reader = new BufferedReader(new FileReader(filename));
		    String line;
		    while ((line = reader.readLine()) != null)
		    {
		    	String name = line.substring(0, line.indexOf(','));
		    	String type = line.substring(line.indexOf(',', line.indexOf(','))+1, line.lastIndexOf(','));
		    	String genre = line.substring( line.lastIndexOf(',')+1, line.length());
		    	
		    	Entertainment newEnter = new Entertainment(name, type, genre);
		    	enterBank.add(newEnter);	// add the new food object :P
		    	
		    	if (!enterGenres.contains(genre))
		    		enterGenres.add(genre);
		    }
		    reader.close();
		  } // end try
		catch (Exception e)
		  {
		    System.err.format("Exception occurred trying to read '%s'.", filename);
		    e.printStackTrace();
		  }
	} // end readFile
	
	
	
	
	
	
	
	
	
	
	
	
	/*================================================================================================*/
	public static void saveData(Database datab) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut= null;

		try 
		{
			fileOut = new FileOutputStream("database.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(datab);
			objOut.close();
			fileOut.close();
	     }	
		
		catch(IOException i)
	    {
			i.printStackTrace();
	    }
	
	} // end saveData
	
	
	/*
	 * Pretty sure we're not using this dawgie
	 */
	public static Database loadData(){
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		Database datab=null;
			
		try
		{
			fileIn = new FileInputStream("database.ser");
			objIn = new ObjectInputStream(fileIn);
			datab = (Database) objIn.readObject();
			objIn.close();
			fileIn.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}  
		return datab;
	} // end loadData
	
	
} // end class