package org.lifestyle.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

import org.lifestyle.objects.Fashion;
import org.lifestyle.user.Database;
import org.lifestyle.user.User;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.TextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class GUI {

	private JFrame frame;
	private Database database;
	private Fashion fashion;
	
	private JButton btnNewUser;
	private JButton btnLoadUser;
	private JButton btnClose;
	
	private JLabel lblNewLabel;
	private JTextPane txtpnYoungThug;
	private JTextField txtUsername; 		// temporally holds the username field
	private JPasswordField pwdPassword; 	// temporally holds the password field
	private JTextPane txtpnUsername;
	private JTextPane txtpnPassword;

	/**
	 * Create the application.
	 */
	public GUI(Database database, Fashion fashion) {
		this.database = database;
		this.fashion = fashion;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		lblNewLabel = new JLabel("LifeStyle");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 71));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.gridwidth = 7;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtpnYoungThug = new JTextPane();
		txtpnYoungThug.setEditable(false);
		txtpnYoungThug.setForeground(UIManager.getColor("InternalFrame.borderLight"));
		txtpnYoungThug.setFont(new Font("Helvetica", Font.ITALIC, 11));
		txtpnYoungThug.setText("© Young Thug Industries");
		txtpnYoungThug.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		GridBagConstraints gbc_txtpnYoungThug = new GridBagConstraints();
		gbc_txtpnYoungThug.gridheight = 2;
		gbc_txtpnYoungThug.gridwidth = 6;
		gbc_txtpnYoungThug.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnYoungThug.fill = GridBagConstraints.VERTICAL;
		gbc_txtpnYoungThug.gridx = 0;
		gbc_txtpnYoungThug.gridy = 3;
		frame.getContentPane().add(txtpnYoungThug, gbc_txtpnYoungThug);
		
		btnLoadUser = new JButton("Load User");	// Load User button
		GridBagConstraints gbc_btnLoadUser = new GridBagConstraints();
		gbc_btnLoadUser.insets = new Insets(0, 0, 5, 5);
		gbc_btnLoadUser.gridx = 2;
		gbc_btnLoadUser.gridy = 7;
		btnLoadUser.addActionListener(new MenuListener());
		
		txtpnUsername = new JTextPane();	// Takes username
		txtpnUsername.setEditable(false);
		txtpnUsername.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		txtpnUsername.setText(" Username:");
		GridBagConstraints gbc_txtpnUsername = new GridBagConstraints();
		gbc_txtpnUsername.gridwidth = 2;
		gbc_txtpnUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpnUsername.gridx = 0;
		gbc_txtpnUsername.gridy = 5;
		frame.getContentPane().add(txtpnUsername, gbc_txtpnUsername);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.gridwidth = 2;
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername.gridx = 2;
		gbc_txtUsername.gridy = 5;
		frame.getContentPane().add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		
		txtpnPassword = new JTextPane();
		txtpnPassword.setEditable(false);
		txtpnPassword.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		txtpnPassword.setText(" Password:");
		GridBagConstraints gbc_txtpnPassword = new GridBagConstraints();
		gbc_txtpnPassword.gridwidth = 2;
		gbc_txtpnPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpnPassword.gridx = 0;
		gbc_txtpnPassword.gridy = 6;
		frame.getContentPane().add(txtpnPassword, gbc_txtpnPassword);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("Password");
		GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
		gbc_pwdPassword.gridwidth = 2;
		gbc_pwdPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdPassword.insets = new Insets(0, 0, 5, 5);
		gbc_pwdPassword.gridx = 2;
		gbc_pwdPassword.gridy = 6;
		frame.getContentPane().add(pwdPassword, gbc_pwdPassword);
		frame.getContentPane().add(btnLoadUser, gbc_btnLoadUser);
		
		btnNewUser = new JButton("Create New User\n");
		GridBagConstraints gbc_btnNewUser = new GridBagConstraints();
		gbc_btnNewUser.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewUser.gridx = 2;
		gbc_btnNewUser.gridy = 8;
		btnNewUser.addActionListener(new MenuListener());
		frame.getContentPane().add(btnNewUser, gbc_btnNewUser);
		
		btnClose = new JButton("Close");
		btnClose.setBackground(new Color(51, 102, 102));
		GridBagConstraints gbc_btnClose = new GridBagConstraints();
		gbc_btnClose.insets = new Insets(0, 0, 0, 5);
		gbc_btnClose.gridx = 4;
		gbc_btnClose.gridy = 8;
		btnClose.addActionListener(new MenuListener());
		frame.getContentPane().add(btnClose, gbc_btnClose);
		
		
	}
	
	private class MenuListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			
			if (source.equals(btnNewUser))
				newUser();
			
			else if (source.equals(btnLoadUser))
				loadUser(txtUsername.getText(), new String(pwdPassword.getPassword()));
				
			else if (source.equals(btnClose))
				System.exit(0);
				
			
			
		} // end actionPerformed
		
		// begin newUser
		private void newUser()
		{
			String value1="", value2="";
			
			JTextField field1 = new JTextField();
			JTextField field2 = new JTextField();

			Object[] message = {
			    "Enter Username:", field1,
			    "Enter Password:", field2
			};
			
			int option = JOptionPane.showConfirmDialog(null, message, "Add User", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION)
			{
			    value1 = field1.getText();
			    value2 = field2.getText();
			    
			}
			if (value1.equals(""))
				return; 	// exit from creating the user
			
			
			if (value1 != null)
			{
				User t = database.getUser(value1);
				if(t != null)
				{
					JOptionPane.showMessageDialog(null, 
												"That user already exists!",
												"ERROR",
												JOptionPane.PLAIN_MESSAGE);
					return;
				}

			} // end value1
			
			if (value2 != null)
			{
				if (value2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter an actual password!",
							"ERROR",
							JOptionPane.PLAIN_MESSAGE);
					return;
				}
				
				
			} // end value2
			
			database.createUser(value1, value2);	// user has been created
			
			JOptionPane.showMessageDialog(null,
										"User "+value1+" created.",
										"YAY SUCCESS",
										JOptionPane.PLAIN_MESSAGE);
			
		} // end newUser
		
		/*
		 * 
		 */
		private void loadUser(String username, String password)
		{
			User tmp = database.getUser(username);
			
			if (tmp == null)
			{
				JOptionPane.showMessageDialog(null,
						"That user doesn't exist",
						"Error",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			if (!tmp.getPassword().equals(password))
			{
				JOptionPane.showMessageDialog(null,
						"Password doesn't match.",
						"Error",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			UserGUI userGUI = new UserGUI(tmp, database, fashion);
			database = userGUI.updateDatabase();
			
			
		} // end loadUser

	} // end MenuListener

} // end class GUI
