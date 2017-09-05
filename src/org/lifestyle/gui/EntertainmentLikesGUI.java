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

public class EntertainmentLikesGUI {

	private JFrame frame;
	private Object[][] enter_matches;
	private User user;
	private JTable table;
	private JLabel lblFoodLikes;
	private JButton btnMoreInfo;
	private Database database;
	
	/**
	 * Create the application.
	 */
	public EntertainmentLikesGUI(Database database, User user) {
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
		enter_matches = new Object[user.getEntertainment().size()][];
		for (int i = 0; i < enter_matches.length; i++)
		{
			Object [] tmpo = {user.getEntertainment().get(i).getName(), 
					user.getEntertainment().get(i).getType(), user.getEntertainment().get(i).getGenre()};
			enter_matches[i] = tmpo;
		} // end for loop
		
		Object [] title = {"Resturant", "Type", "Price"};
		
		lblFoodLikes = new JLabel("Entertainment Likes");
		lblFoodLikes.setForeground(Color.RED);
		lblFoodLikes.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		GridBagConstraints gbc_lblFoodLikes = new GridBagConstraints();
		gbc_lblFoodLikes.gridwidth = 9;
		gbc_lblFoodLikes.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoodLikes.gridx = 1;
		gbc_lblFoodLikes.gridy = 0;
		frame.getContentPane().add(lblFoodLikes, gbc_lblFoodLikes);
		
		table = new JTable(enter_matches, title);
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
				EntertainmentGUI foodGUI = new EntertainmentGUI
						(database.getEntertainment((String)enter_matches[table.getSelectedRow()][0]), user);
				
			} // end if
		} // end actionPerformed
		
		
		

	}
}
