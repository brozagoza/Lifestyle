package org.lifestyle.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.lifestyle.objects.Entertainment;
import org.lifestyle.objects.Food;
import org.lifestyle.user.User;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Canvas;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;


public class EntertainmentGUI {

	private JFrame frame;
	
	private Entertainment enter;
	private User user;
	
	private JButton btnAddAsLiked;

	/**
	 * Create the application.
	 */
	public EntertainmentGUI(Entertainment enter, User user) {
		this.enter = enter;
		this.user = user;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{146, -87, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel label = new JLabel("");
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("./tv_movie_photo.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		ImageIcon i = new ImageIcon(img.getScaledInstance(150, 150,
		        Image.SCALE_SMOOTH));
		label.setIcon(i);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridheight = 6;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		frame.getContentPane().add(label, gbc_label);
		
		JLabel lblResturant = new JLabel("Title:");
		lblResturant.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		GridBagConstraints gbc_lblResturant = new GridBagConstraints();
		gbc_lblResturant.gridwidth = 2;
		gbc_lblResturant.anchor = GridBagConstraints.WEST;
		gbc_lblResturant.insets = new Insets(0, 0, 5, 5);
		gbc_lblResturant.gridx = 1;
		gbc_lblResturant.gridy = 1;
		frame.getContentPane().add(lblResturant, gbc_lblResturant);
		
		JLabel lblResturantreturned = new JLabel(enter.getName());
		lblResturantreturned.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		GridBagConstraints gbc_lblResturantreturned = new GridBagConstraints();
		gbc_lblResturantreturned.anchor = GridBagConstraints.WEST;
		gbc_lblResturantreturned.gridwidth = 2;
		gbc_lblResturantreturned.insets = new Insets(0, 0, 5, 5);
		gbc_lblResturantreturned.gridx = 1;
		gbc_lblResturantreturned.gridy = 2;
		frame.getContentPane().add(lblResturantreturned, gbc_lblResturantreturned);
		
		JLabel lblType = new JLabel("Platform:");
		lblType.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.gridwidth = 2;
		gbc_lblType.anchor = GridBagConstraints.WEST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 1;
		gbc_lblType.gridy = 3;
		frame.getContentPane().add(lblType, gbc_lblType);
		
		JLabel lblTypereturned = new JLabel(enter.getType());
		GridBagConstraints gbc_lblTypereturned = new GridBagConstraints();
		gbc_lblTypereturned.gridwidth = 2;
		gbc_lblTypereturned.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTypereturned.insets = new Insets(0, 0, 5, 5);
		gbc_lblTypereturned.gridx = 1;
		gbc_lblTypereturned.gridy = 4;
		frame.getContentPane().add(lblTypereturned, gbc_lblTypereturned);
		
		JLabel lblPrice = new JLabel("Genre:");
		lblPrice.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.gridwidth = 2;
		gbc_lblPrice.anchor = GridBagConstraints.WEST;
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 1;
		gbc_lblPrice.gridy = 5;
		frame.getContentPane().add(lblPrice, gbc_lblPrice);
		
		JLabel lblPricereturned = new JLabel(enter.getGenre());
		GridBagConstraints gbc_lblPricereturned = new GridBagConstraints();
		gbc_lblPricereturned.fill = GridBagConstraints.BOTH;
		gbc_lblPricereturned.insets = new Insets(0, 0, 5, 5);
		gbc_lblPricereturned.gridwidth = 2;
		gbc_lblPricereturned.gridx = 1;
		gbc_lblPricereturned.gridy = 6;
		frame.getContentPane().add(lblPricereturned, gbc_lblPricereturned);
		
		btnAddAsLiked = new JButton("Add to \"Likes\"");
		GridBagConstraints gbc_btnAddAsLiked = new GridBagConstraints();
		gbc_btnAddAsLiked.gridwidth = 2;
		gbc_btnAddAsLiked.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddAsLiked.gridx = 1;
		gbc_btnAddAsLiked.gridy = 7;
		frame.getContentPane().add(btnAddAsLiked, gbc_btnAddAsLiked);
		btnAddAsLiked.addActionListener(new MenuListener());
	}

	private class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			
			if (source.equals(btnAddAsLiked))
			{
				if (!user.getEntertainment().contains(enter))
					user.addEntertainment(enter);
				frame.dispose();	// closes the window aftering adding the food
			}
		} // end actionPerformed
		
		
		
	} // end MenuListener
	

} // end FoodGUI
