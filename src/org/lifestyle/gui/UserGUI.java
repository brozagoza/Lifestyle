package org.lifestyle.gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.lifestyle.objects.Clothing;
import org.lifestyle.objects.Entertainment;
import org.lifestyle.objects.Fashion;
import org.lifestyle.objects.Food;
import org.lifestyle.user.Database;
import org.lifestyle.user.User;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;

public class UserGUI {

	private JFrame frame;
	private JButton btnGo;
	private User user;
	private Database database;
	private Fashion fashion;
	
	private JLabel lblEntertainmentSuggestions;
	private JLabel lblFashionSuggestions;
	
	private JMenuBar menuBar;
	private JMenu likes_tab;
	private JMenuItem food_likes;
	private JMenuItem enter_likes;
	private JMenuItem fash_likes;
	private JTable table;
	
	private Object [][] food_matches;
	private Object [][] food_matches_2;
	private Object [][] enter_matches;
	private Object [][] enter_matches_2;
	private Object [][] fash_matches;
	private JMenuItem mntmEntertainment;
	private JMenuItem mntmFashion;
	private JLabel lblUser;
	private JLabel lblByType;
	private JLabel lblByPrice;
	private JTable table_1;
	private JButton btnGo_1;
	private JButton btnFoodCatalog;
	private JTable table_2;
	private JLabel lblByGenre;
	private JButton btnGo_2;
	private JButton btnEnterbotgo;
	private JButton btnEntertainmentCatalog;
	private JTable enter_bot_table;
	private JLabel lblYourMovieFavorites;
	private JButton btnUpdatePane;
	private JTable fash_suggest;
	private JButton fash_go;
	private JButton btnFashionCatalog;

	/**
	 * Create the application.
	 */
	public UserGUI(User user, Database database, Fashion fashion) {
		this.user = user;
		this.database = database;
		this.fashion = fashion;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// The top tabs
		menuBar = new JMenuBar();
		
		likes_tab = new JMenu("My Likes");
		
		food_likes = new JMenuItem("Food"); 
		food_likes.addActionListener(new MenuListener());
		likes_tab.add(food_likes);
		
		mntmEntertainment = new JMenuItem("Entertainment");
		mntmEntertainment.addActionListener(new MenuListener());
		likes_tab.add(mntmEntertainment);
		
		mntmFashion = new JMenuItem("Fashion");
		mntmFashion.addActionListener(new MenuListener());
		likes_tab.add(mntmFashion);
		
		menuBar.add(likes_tab);
		
		//Food
		if (user.getFoodLikes().size() == 0)
			initializeFood();
		
		//Entertainment
		if (user.getEnterLikes().size() == 0)
			initializeEntertainment();
		
		
		//Clothing
		if (user.getFashionBody().size() == 0)
			initializeFashionBody(); 
		
		if (user.getFashionWhat().size() == 0)
			initializeFashionWhat();
		
		if (user.getFashionStyle().size() == 0)
			initializeFashionStyle();
		
		if (user.getFashionColor().size() == 0)
			initializeFashionColor();
		
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		frame.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		GridBagLayout gridBagLayout = new GridBagLayout();
		frame.setBounds(100, 100, 800, 600);
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		/// food matches being displayed
		food_matches = new Object[database.foodMatches(user).size()][];
		
		for (int i = 0; i < food_matches.length; i++)
		{
			Food tmpf = database.getFood(database.foodMatches(user).get(i));
			Object [] tmpo = {tmpf.getName(), tmpf.getType(), tmpf.getPrice()};
			food_matches[i] = tmpo;
		} // end for loop
		
		Object [] title = {"Resturant", "Type", "Price"};
		
		lblUser = new JLabel("USER: "+user.getName());
		lblUser.setFont(new Font("Bookman Old Style", Font.BOLD, 23));
		lblUser.setForeground(Color.YELLOW);
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 2;
		gbc_lblUser.gridy = 0;
		frame.getContentPane().add(lblUser, gbc_lblUser);
		
		btnUpdatePane = new JButton("UPDATE PANE");
		GridBagConstraints gbc_btnUpdatePane = new GridBagConstraints();
		gbc_btnUpdatePane.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdatePane.gridx = 4;
		gbc_btnUpdatePane.gridy = 0;
		btnUpdatePane.addActionListener(new MenuListener());
		frame.getContentPane().add(btnUpdatePane, gbc_btnUpdatePane);
		
		JLabel lblFoodSuggestions = new JLabel("Food Suggestions");
		lblFoodSuggestions.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		lblFoodSuggestions.setForeground(UIManager.getColor("InternalFrame.borderShadow"));
		GridBagConstraints gbc_lblFoodSuggestions = new GridBagConstraints();
		gbc_lblFoodSuggestions.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoodSuggestions.gridx = 0;
		gbc_lblFoodSuggestions.gridy = 1;
		frame.getContentPane().add(lblFoodSuggestions, gbc_lblFoodSuggestions);
		
		lblEntertainmentSuggestions = new JLabel("Entertainment Suggestions");
		lblEntertainmentSuggestions.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		lblEntertainmentSuggestions.setForeground(Color.RED);
		GridBagConstraints gbc_lblEntertainmentSuggestions = new GridBagConstraints();
		gbc_lblEntertainmentSuggestions.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntertainmentSuggestions.gridx = 2;
		gbc_lblEntertainmentSuggestions.gridy = 1;
		frame.getContentPane().add(lblEntertainmentSuggestions, gbc_lblEntertainmentSuggestions);
		
		lblFashionSuggestions = new JLabel("Fashion Suggestions");
		lblFashionSuggestions.setForeground(Color.RED);
		lblFashionSuggestions.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		GridBagConstraints gbc_lblFashionSuggestions = new GridBagConstraints();
		gbc_lblFashionSuggestions.insets = new Insets(0, 0, 5, 5);
		gbc_lblFashionSuggestions.gridx = 4;
		gbc_lblFashionSuggestions.gridy = 1;
		frame.getContentPane().add(lblFashionSuggestions, gbc_lblFashionSuggestions);
		
		lblByType = new JLabel("By Type:");
		lblByType.setForeground(Color.BLACK);
		lblByType.setFont(new Font("Bookman Old Style", Font.ITALIC, 13));
		GridBagConstraints gbc_lblByType = new GridBagConstraints();
		gbc_lblByType.anchor = GridBagConstraints.WEST;
		gbc_lblByType.insets = new Insets(0, 0, 5, 5);
		gbc_lblByType.gridx = 0;
		gbc_lblByType.gridy = 2;
		frame.getContentPane().add(lblByType, gbc_lblByType);
		
		lblByGenre = new JLabel("By Genre:");
		lblByGenre.setFont(new Font("Bookman Old Style", Font.ITALIC, 13));
		GridBagConstraints gbc_lblByGenre = new GridBagConstraints();
		gbc_lblByGenre.anchor = GridBagConstraints.WEST;
		gbc_lblByGenre.insets = new Insets(0, 0, 5, 5);
		gbc_lblByGenre.gridx = 2;
		gbc_lblByGenre.gridy = 2;
		frame.getContentPane().add(lblByGenre, gbc_lblByGenre);
		
		table = new JTable(food_matches, title);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 3;
		frame.getContentPane().add(table, gbc_table);
		
		/// food matches being displayed
		enter_matches = new Object[database.enterMatches(user).size()][];
		
		for (int i = 0; i < enter_matches.length; i++)
		{
			Entertainment tmpf = database.getEntertainment(database.enterMatches(user).get(i));
			Object [] tmpo = {tmpf.getName(), tmpf.getType(), tmpf.getGenre()};
			enter_matches[i] = tmpo;
		} // end for loop
		
		table_2 = new JTable(enter_matches, title);
		GridBagConstraints gbc_table_2 = new GridBagConstraints();
		gbc_table_2.gridwidth = 2;
		gbc_table_2.insets = new Insets(0, 0, 5, 5);
		gbc_table_2.fill = GridBagConstraints.BOTH;
		gbc_table_2.gridx = 2;
		gbc_table_2.gridy = 3;
		frame.getContentPane().add(table_2, gbc_table_2);
		
		fash_matches = new Object[fashion.getClothesSuggestArray(user).size()][];
		
		for (int i = 0; i < fash_matches.length; i++)
		{
			Clothing tmpc = fashion.getClothesSuggestArray(user).get(i);
			Object [] tmpo = {tmpc.getName(), tmpc.getBodySect(), tmpc.getWhatItIs(), tmpc.getStyle(), tmpc.getColor()};
			fash_matches[i] = tmpo;
		}
		Object[] t = {"Name", "Body", "What", "Style", "Color"};
		
		fash_suggest = new JTable(fash_matches, t);
		GridBagConstraints gbc_fash_suggest = new GridBagConstraints();
		gbc_fash_suggest.gridheight = 4;
		gbc_fash_suggest.gridwidth = 2;
		gbc_fash_suggest.insets = new Insets(0, 0, 5, 5);
		gbc_fash_suggest.fill = GridBagConstraints.BOTH;
		gbc_fash_suggest.gridx = 4;
		gbc_fash_suggest.gridy = 3;
		frame.getContentPane().add(fash_suggest, gbc_fash_suggest);
		
		btnGo = new JButton("Go");
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.insets = new Insets(0, 0, 5, 5);
		gbc_btnGo.gridx = 0;
		gbc_btnGo.gridy = 4;
		frame.getContentPane().add(btnGo, gbc_btnGo);
		btnGo.addActionListener(new MenuListener());
		
		/// food matches being displayed
		food_matches_2 = new Object[database.foodPriceMatches(user).size()][];

		for (int i = 0; i < food_matches_2.length; i++)
		{
			Food tmpf = database.getFood(database.foodPriceMatches(user).get(i));
			Object [] tmpo = {tmpf.getName(), tmpf.getType(), tmpf.getPrice()};
			food_matches_2[i] = tmpo;
		} // end for loop
		
		String price_text =" ";
		if (food_matches_2.length != 0)
			if (food_matches_2[0][2].equals("$")) price_text += "Cheap Eats!";
			else if (food_matches_2[0][2].equals("$$")) price_text += "Delicious Meals!";
			else if (food_matches_2[0][2].equals("$$$")) price_text += "Fancy Dining!";
		
		btnGo_2 = new JButton("Go"); // entertainment go
		GridBagConstraints gbc_btnGo_2 = new GridBagConstraints();
		gbc_btnGo_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnGo_2.gridx = 2;
		gbc_btnGo_2.gridy = 4;
		btnGo_2.addActionListener(new MenuListener());
		frame.getContentPane().add(btnGo_2, gbc_btnGo_2);
		
		lblByPrice = new JLabel("Your Favorites By Price:"+price_text);
		lblByPrice.setFont(new Font("Bookman Old Style", Font.ITALIC, 13));
		GridBagConstraints gbc_lblByPrice = new GridBagConstraints();
		gbc_lblByPrice.anchor = GridBagConstraints.WEST;
		gbc_lblByPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblByPrice.gridx = 0;
		gbc_lblByPrice.gridy = 5;
		frame.getContentPane().add(lblByPrice, gbc_lblByPrice);
		
		/// food matches being displayed
		enter_matches_2 = new Object[database.enterTypeMatches(user).size()][];

		for (int i = 0; i < enter_matches_2.length; i++)
		{
			Entertainment tmpf = database.getEntertainment(database.enterTypeMatches(user).get(i));
			Object [] tmpo = {tmpf.getName(), tmpf.getType(), tmpf.getGenre()};
			enter_matches_2[i] = tmpo;
		} // end for loop
		
		String ent_text =" ";
		if (enter_matches_2.length != 0)
			if (enter_matches_2[0][1].equals("TV")) ent_text += "TV time!"; 
			else if (enter_matches_2[0][1].equals("Movie")) ent_text += "Movie night!";
		
		lblYourMovieFavorites = new JLabel(ent_text+" Favorites:");
		lblYourMovieFavorites.setFont(new Font("Bookman Old Style", Font.ITALIC, 13));
		GridBagConstraints gbc_lblYourMovieFavorites = new GridBagConstraints();
		gbc_lblYourMovieFavorites.anchor = GridBagConstraints.WEST;
		gbc_lblYourMovieFavorites.insets = new Insets(0, 0, 5, 5);
		gbc_lblYourMovieFavorites.gridx = 2;
		gbc_lblYourMovieFavorites.gridy = 5;
		frame.getContentPane().add(lblYourMovieFavorites, gbc_lblYourMovieFavorites);
		
		
		table_1 = new JTable(food_matches_2, title);
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.gridwidth = 2;
		gbc_table_1.insets = new Insets(0, 0, 5, 5);
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 0;
		gbc_table_1.gridy = 6;
		frame.getContentPane().add(table_1, gbc_table_1);
		
		btnGo_1 = new JButton("Go");
		GridBagConstraints gbc_btnGo_1 = new GridBagConstraints();
		gbc_btnGo_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnGo_1.gridx = 0;
		gbc_btnGo_1.gridy = 7;
		btnGo_1.addActionListener(new MenuListener());
		
		enter_bot_table = new JTable(enter_matches_2, title);
		GridBagConstraints gbc_enter_bot_table = new GridBagConstraints();
		gbc_enter_bot_table.gridwidth = 2;
		gbc_enter_bot_table.insets = new Insets(0, 0, 5, 5);
		gbc_enter_bot_table.fill = GridBagConstraints.BOTH;
		gbc_enter_bot_table.gridx = 2;
		gbc_enter_bot_table.gridy = 6;
		frame.getContentPane().add(enter_bot_table, gbc_enter_bot_table);
		frame.getContentPane().add(btnGo_1, gbc_btnGo_1);
		
		btnFoodCatalog = new JButton("Food Catalog");
		GridBagConstraints gbc_btnFoodCatalog = new GridBagConstraints();
		gbc_btnFoodCatalog.insets = new Insets(0, 0, 0, 5);
		gbc_btnFoodCatalog.gridx = 0;
		gbc_btnFoodCatalog.gridy = 8;
		btnFoodCatalog.addActionListener(new MenuListener());
		
		btnEnterbotgo = new JButton("Go");
		GridBagConstraints gbc_btnEnterbotgo = new GridBagConstraints();
		gbc_btnEnterbotgo.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnterbotgo.gridx = 2;
		gbc_btnEnterbotgo.gridy = 7;
		btnEnterbotgo.addActionListener(new MenuListener());
		frame.getContentPane().add(btnEnterbotgo, gbc_btnEnterbotgo);
		
		fash_go = new JButton("Go");
		GridBagConstraints gbc_fash_go = new GridBagConstraints();
		gbc_fash_go.insets = new Insets(0, 0, 5, 5);
		gbc_fash_go.gridx = 4;
		gbc_fash_go.gridy = 7;
		fash_go.addActionListener(new MenuListener());
		frame.getContentPane().add(fash_go, gbc_fash_go);
		frame.getContentPane().add(btnFoodCatalog, gbc_btnFoodCatalog);
		
		btnEntertainmentCatalog = new JButton("Entertainment Catalog");
		GridBagConstraints gbc_btnEntertainmentCatalog = new GridBagConstraints();
		gbc_btnEntertainmentCatalog.insets = new Insets(0, 0, 0, 5);
		gbc_btnEntertainmentCatalog.gridx = 2;
		gbc_btnEntertainmentCatalog.gridy = 8;
		btnEntertainmentCatalog.addActionListener(new MenuListener());
		frame.getContentPane().add(btnEntertainmentCatalog, gbc_btnEntertainmentCatalog);
		
		btnFashionCatalog = new JButton("Fashion Catalog");
		GridBagConstraints gbc_btnFashionCatalog = new GridBagConstraints();
		gbc_btnFashionCatalog.insets = new Insets(0, 0, 0, 5);
		gbc_btnFashionCatalog.gridx = 4;
		gbc_btnFashionCatalog.gridy = 8;
		btnFashionCatalog.addActionListener(new MenuListener());
		frame.getContentPane().add(btnFashionCatalog, gbc_btnFashionCatalog);
		
		
		frame.setJMenuBar(menuBar); 	// menu bar
		// continue doing new stuff
	} // end  initialize
	
	public Database updateDatabase()
	{
		return database;
	}
	
	// Used to initialize food for the first time
	public void initializeFood()
	{
		JOptionPane.showMessageDialog(null,
				"You don't have any \"likes\" yet!\n"+
						"Lets change that buster!",
				"New User",
				JOptionPane.PLAIN_MESSAGE);
		
		JCheckBox[] check_boxes = new JCheckBox[database.getFoodTypes().size()];
		
		for (int i = 0; i < database.getFoodTypes().size(); i++)
			check_boxes[i] = new JCheckBox(database.getFoodTypes().get(i));

		
		JOptionPane.showConfirmDialog (null, check_boxes, "Food Types", JOptionPane.PLAIN_MESSAGE);
		
		ArrayList<String> food_type_likes = new ArrayList<String>();
		
		for (int i = 0; i < check_boxes.length; i++)	// checks if the radio buttons were selected
			if (check_boxes[i].isSelected())
				food_type_likes.add(database.getFoodTypes().get(i));
		
		user.setFoodLikes(food_type_likes);
		
		
	} // INITIALIE FOOD
	
	public void initializeEntertainment()
	{
		JCheckBox[] check_boxes = new JCheckBox[database.getEnterGenres().size()];
		
		for (int i = 0; i < database.getEnterGenres().size(); i++)
			check_boxes[i] = new JCheckBox(database.getEnterGenres().get(i));

		
		JOptionPane.showConfirmDialog (null, check_boxes, "Entertainment Genres", JOptionPane.PLAIN_MESSAGE);
		
		ArrayList<String> enter_genre_likes = new ArrayList<String>();
		
		for (int i = 0; i < check_boxes.length; i++)	// checks if the radio buttons were selected
			if (check_boxes[i].isSelected())
				enter_genre_likes.add(database.getEnterGenres().get(i));
		
		user.setEnterGenres(enter_genre_likes);
	}
	
	//
	public void initializeFashionBody()
	{
		JCheckBox[] check_boxes = new JCheckBox[fashion.getBodySection().length];
		
		for (int i = 0; i < fashion.getBodySection().length; i++)
			check_boxes[i] = new JCheckBox(fashion.getBodySection()[i]);

		
		JOptionPane.showConfirmDialog (null, check_boxes, "Fashion Body Likes", JOptionPane.PLAIN_MESSAGE);
		
		ArrayList<String> fash_body_likes = new ArrayList<String>();
		
		for (int i = 0; i < check_boxes.length; i++)	// checks if the radio buttons were selected
			if (check_boxes[i].isSelected())
				fash_body_likes.add(fashion.getBodySection()[i]);
		
		user.setFashionBody(fash_body_likes);
	} // initializeFashionBody
	
	///// 
	public void initializeFashionWhat()
	{	
		
		JCheckBox[] check_boxes = new JCheckBox[fashion.getWhat().length];
		
		for (int i = 0; i < fashion.getWhat().length; i++)
			check_boxes[i] = new JCheckBox(fashion.getWhat()[i]);

		
		JOptionPane.showConfirmDialog (null, check_boxes, "Fashion Likes", JOptionPane.PLAIN_MESSAGE);
		
		ArrayList<String> fash_body_likes = new ArrayList<String>();
		
		for (int i = 0; i < check_boxes.length; i++)	// checks if the radio buttons were selected
			if (check_boxes[i].isSelected())
				fash_body_likes.add(fashion.getWhat()[i]);
		
		user.setFashionWhat(fash_body_likes);
	}
	
	
	public void initializeFashionStyle()
	{
		JCheckBox[] check_boxes = new JCheckBox[fashion.getStyles().length];
		
		for (int i = 0; i < fashion.getStyles().length; i++)
			check_boxes[i] = new JCheckBox(fashion.getStyles()[i]);
		
		JOptionPane.showConfirmDialog (null, check_boxes, "Fashion Style", JOptionPane.PLAIN_MESSAGE);
		
		ArrayList<String> fash_likes = new ArrayList<String>();
		
		for (int i = 0; i < check_boxes.length; i++)
			if (check_boxes[i].isSelected())
				fash_likes.add(fashion.getStyles()[i]);
		
		user.setFashionStyle(fash_likes);
	}
	
	public void initializeFashionColor()
	{
	
		JCheckBox[] check_boxes = new JCheckBox[fashion.getColors().length];
		
		for (int i = 0; i < fashion.getColors().length; i++)
			check_boxes[i] = new JCheckBox(fashion.getColors()[i]);
		
		JOptionPane.showConfirmDialog (null, check_boxes, "Fashion Color Likes", JOptionPane.PLAIN_MESSAGE);
		
		ArrayList<String> fash_likes = new ArrayList<String>();
		
		for (int i = 0; i < check_boxes.length; i++)
			if (check_boxes[i].isSelected())
				fash_likes.add(fashion.getColors()[i]);
		
		user.setFashionColor(fash_likes);
	}
	
	
	
	
	
	private class MenuListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			ArrayList<Food> food_bank = database.getFoodBank();
			
			if (source.equals(food_likes))
			{
				FoodLikesGUI gooey = new FoodLikesGUI(database, user);
			} // end else if
			else if (source.equals(mntmEntertainment))
			{
				EntertainmentLikesGUI googoo = new EntertainmentLikesGUI(database, user);
			}
			else if (source.equals(mntmFashion))
			{
				ClothingLikesGUI cloth = new ClothingLikesGUI(database, user, fashion);
			}
			else if (source.equals(btnGo)) 
			{
				FoodGUI foodGUI = new FoodGUI(database.getFood((String)food_matches[table.getSelectedRow()][0]), user);
			} // end if
			else if (source.equals(btnFoodCatalog))
			{
				FoodCatalogGUI fcGUI = new FoodCatalogGUI(user, database);
			} // end btnFoodCatalog
			
			else if (source.equals(btnGo_1))
			{
				FoodGUI foodGUI = new FoodGUI(database.getFood((String)food_matches_2[table_1.getSelectedRow()][0]), user);
			}
			else if (source.equals(btnGo_2))
			{
				EntertainmentGUI enterGUI = new EntertainmentGUI(
						database.getEntertainment((String)enter_matches[table_2.getSelectedRow()][0]), user);
			}
			else if (source.equals(btnEntertainmentCatalog))
			{
				EntertainmentCatalogGUI ecGUI = new EntertainmentCatalogGUI(user, database);
			}
			else if (source.equals(btnEnterbotgo))
			{
				EntertainmentGUI enterGUI = new EntertainmentGUI(
						database.getEntertainment((String)enter_matches_2[enter_bot_table.getSelectedRow()][0]), user);
			}
			else if (source.equals(btnUpdatePane))
			{
				UserGUI userGUI = new UserGUI(user, database, fashion);
				frame.dispose();
			}
			else if (source.equals(fash_go))
			{
				ClothingGUI clothgui = new ClothingGUI( 
						fashion.getClothing((String)fash_matches[fash_suggest.getSelectedRow()][0]), user);
			}
			else if (source.equals(btnFashionCatalog))
			{
				
			}

			
			
		}
	} // end Menulistener

}
