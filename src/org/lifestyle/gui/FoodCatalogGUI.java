package org.lifestyle.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import javax.swing.JTable;

import org.lifestyle.objects.Food;
import org.lifestyle.user.Database;
import org.lifestyle.user.User;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class FoodCatalogGUI {

	private JFrame frame;
	private Object[][] food_matches;
	private User user;
	private JTable table;
	private JLabel lblFoodLikes;
	private JButton btnMoreInfo;
	private Database database;
	
	/**
	 * Create the application.
	 */
	public FoodCatalogGUI(User user, Database database) {
		this.user = user;
		this.database = database;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 550, 350);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		/// food matches being displayed
		food_matches = new Object[database.getFoodBank().size()][];
		
		for (int i = 0; i < food_matches.length; i++)
		{
			Object [] tmpo = {database.getFoodBank().get(i).getName(), database.getFoodBank().get(i).getType(), 
					database.getFoodBank().get(i).getPrice()};
			food_matches[i] = tmpo;
		} // end for loop
		
		Object [] title = {"Resturant", "Type", "Price"};
		
		lblFoodLikes = new JLabel("Food Catalog");
		lblFoodLikes.setForeground(Color.RED);
		lblFoodLikes.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		GridBagConstraints gbc_lblFoodLikes = new GridBagConstraints();
		gbc_lblFoodLikes.gridwidth = 9;
		gbc_lblFoodLikes.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoodLikes.gridx = 1;
		gbc_lblFoodLikes.gridy = 0;
		frame.getContentPane().add(lblFoodLikes, gbc_lblFoodLikes);
		
		table = new JTable(food_matches, title);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 7;
		gbc_table.gridwidth = 8;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		frame.getContentPane().add(table, gbc_table);
		
		btnMoreInfo = new JButton("More Info");
		GridBagConstraints gbc_btnMoreInfo = new GridBagConstraints();
		gbc_btnMoreInfo.insets = new Insets(0, 0, 0, 5);
		gbc_btnMoreInfo.gridx = 3;
		gbc_btnMoreInfo.gridy = 9;
		btnMoreInfo.addActionListener(new MenuListener());
		frame.getContentPane().add(btnMoreInfo, gbc_btnMoreInfo);
		

		
	} // end initialize
	
	private class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			Object source = (e.getSource());
			
			if (source.equals(btnMoreInfo)) 
			{
				FoodGUI foodGUI = new FoodGUI(database.getFood((String)food_matches[table.getSelectedRow()][0]), user);
				
				for (int i = 0; i < user.getFood().size(); i++)
					System.out.println(user.getFood().get(i).getName());
			} // end if
		} // end actionPerformed
		
		
		

	}
}
