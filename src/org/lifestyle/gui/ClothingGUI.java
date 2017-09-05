package org.lifestyle.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.lifestyle.objects.Clothing;
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


public class ClothingGUI {

	private JFrame frame;
	
	private Clothing cloth;
	private User user;
	
	private JButton btnAddAsLiked;

	/**
	 * Create the application.
	 */
	public ClothingGUI(Clothing enter, User user) {
		this.cloth = enter;
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
		frame.setBounds(100, 100, 550, 400);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{146, -87, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_label.fill = GridBagConstraints.HORIZONTAL;
		gbc_label.gridheight = 10;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		frame.getContentPane().add(label, gbc_label);
		
		JLabel title_label = new JLabel("Title:");
		title_label.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		GridBagConstraints gbc_title_label = new GridBagConstraints();
		gbc_title_label.gridwidth = 3;
		gbc_title_label.anchor = GridBagConstraints.WEST;
		gbc_title_label.insets = new Insets(0, 0, 5, 5);
		gbc_title_label.gridx = 1;
		gbc_title_label.gridy = 1;
		frame.getContentPane().add(title_label, gbc_title_label);
		
		JLabel titlereturn = new JLabel(cloth.getName());
		titlereturn.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		GridBagConstraints gbc_titlereturn = new GridBagConstraints();
		gbc_titlereturn.anchor = GridBagConstraints.WEST;
		gbc_titlereturn.gridwidth = 3;
		gbc_titlereturn.insets = new Insets(0, 0, 5, 5);
		gbc_titlereturn.gridx = 1;
		gbc_titlereturn.gridy = 2;
		frame.getContentPane().add(titlereturn, gbc_titlereturn);
		
		JLabel Body = new JLabel("Body:");
		Body.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		GridBagConstraints gbc_Body = new GridBagConstraints();
		gbc_Body.gridwidth = 3;
		gbc_Body.anchor = GridBagConstraints.WEST;
		gbc_Body.insets = new Insets(0, 0, 5, 5);
		gbc_Body.gridx = 1;
		gbc_Body.gridy = 3;
		frame.getContentPane().add(Body, gbc_Body);
		
		JLabel bodytitle = new JLabel(cloth.getBodySect());
		GridBagConstraints gbc_bodytitle = new GridBagConstraints();
		gbc_bodytitle.gridwidth = 3;
		gbc_bodytitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_bodytitle.insets = new Insets(0, 0, 5, 5);
		gbc_bodytitle.gridx = 1;
		gbc_bodytitle.gridy = 4;
		frame.getContentPane().add(bodytitle, gbc_bodytitle);
		
		JLabel type = new JLabel("Type:");
		type.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		GridBagConstraints gbc_type = new GridBagConstraints();
		gbc_type.gridwidth = 3;
		gbc_type.anchor = GridBagConstraints.WEST;
		gbc_type.insets = new Insets(0, 0, 5, 5);
		gbc_type.gridx = 1;
		gbc_type.gridy = 5;
		frame.getContentPane().add(type, gbc_type);
		
		JLabel typetitle = new JLabel(cloth.getWhatItIs());
		GridBagConstraints gbc_typetitle = new GridBagConstraints();
		gbc_typetitle.fill = GridBagConstraints.BOTH;
		gbc_typetitle.insets = new Insets(0, 0, 5, 5);
		gbc_typetitle.gridwidth = 3;
		gbc_typetitle.gridx = 1;
		gbc_typetitle.gridy = 6;
		frame.getContentPane().add(typetitle, gbc_typetitle);
		
		JLabel lblStyle = new JLabel("Style:");
		lblStyle.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		GridBagConstraints gbc_lblStyle = new GridBagConstraints();
		gbc_lblStyle.anchor = GridBagConstraints.WEST;
		gbc_lblStyle.gridwidth = 3;
		gbc_lblStyle.insets = new Insets(0, 0, 5, 5);
		gbc_lblStyle.gridx = 1;
		gbc_lblStyle.gridy = 7;
		frame.getContentPane().add(lblStyle, gbc_lblStyle);
		
		JLabel lblStylereturn = new JLabel(cloth.getStyle());
		GridBagConstraints gbc_lblStylereturn = new GridBagConstraints();
		gbc_lblStylereturn.insets = new Insets(0, 0, 5, 5);
		gbc_lblStylereturn.gridx = 1;
		gbc_lblStylereturn.gridy = 8;
		frame.getContentPane().add(lblStylereturn, gbc_lblStylereturn);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.WEST;
		gbc_lblColor.gridwidth = 3;
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 1;
		gbc_lblColor.gridy = 9;
		frame.getContentPane().add(lblColor, gbc_lblColor);
		
		JLabel lblColorreturn = new JLabel(cloth.getColor());
		GridBagConstraints gbc_lblColorreturn = new GridBagConstraints();
		gbc_lblColorreturn.insets = new Insets(0, 0, 5, 5);
		gbc_lblColorreturn.gridx = 1;
		gbc_lblColorreturn.gridy = 10;
		frame.getContentPane().add(lblColorreturn, gbc_lblColorreturn);
		
		btnAddAsLiked = new JButton("Add to \"Likes\"");
		GridBagConstraints gbc_btnAddAsLiked = new GridBagConstraints();
		gbc_btnAddAsLiked.gridwidth = 3;
		gbc_btnAddAsLiked.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddAsLiked.gridx = 1;
		gbc_btnAddAsLiked.gridy = 14;
		frame.getContentPane().add(btnAddAsLiked, gbc_btnAddAsLiked);
		btnAddAsLiked.addActionListener(new MenuListener());
	}

	private class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			
			if (source.equals(btnAddAsLiked))
			{
				if (!user.getClothing().contains(cloth))
					user.addClothing(cloth);

				frame.dispose();	// closes the window aftering adding the food
			}
		} // end actionPerformed
		
		
		
	} // end MenuListener
	

} // end FoodGUI
