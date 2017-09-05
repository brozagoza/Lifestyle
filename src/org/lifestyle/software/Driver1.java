package org.lifestyle.software;

import java.awt.EventQueue;
import java.io.IOException;

import org.lifestyle.gui.GUI;
//import org.lifestyle.gui.GUI;
import org.lifestyle.objects.*;
import org.lifestyle.user.Database;
import org.lifestyle.user.*;

public class Driver1 {
	
	
	public static void main(String [] args) throws IOException
	{
		Database myData = new Database();
		Fashion daFash = new Fashion();
		GUI newGUI; // the gui homie
		
		myData.createUser("a", "a");
		System.out.println("Welcome to the lifestyle");
		
		daFash.addObject("Versace Shoes", "300", 132111);
		daFash.addObject("Nike Jacket", "60", 114311);
		daFash.addObject("Express Dress Socks", "30", 124332);
		daFash.addObject("Calvin Klein Belt", "60", 144322);
		daFash.addObject("Adidas Sneakers", "150", 131311);
		daFash.addObject("H&M Shirt", "20", 112413);
		
		newGUI = new GUI(myData, daFash);
       // newGUI = new GUI("LIFESTYLE", myData);

		
		
		
		
	} // end main
	
	
} // end Driver1
