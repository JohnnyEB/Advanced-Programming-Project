package com.appliction.appView;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

import javafx.scene.layout.Background;

import com.mysql.jdbc.log.Log;
import com.appliction.appController.Application;
import com.appliction.appModel.*;

public class LogInUserInterface extends JFrame implements ActionListener{

	JPanel loginCanvas;
	JLabel appTitle, username, password;
	JTextField userNameBox;
	JPasswordField passwordBox;
	JButton logIn, createAccount;
	

	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private GridLayout gl;
	Border emptyBorder; 
	
	Background emptyBackground;
	
	SignUpUserInterface signUp;
	Application app;
	private void initializeComponents() {

		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,0,0);
		
		emptyBorder = BorderFactory.createEmptyBorder();
		emptyBackground = Background.EMPTY;
		
		username = new JLabel("Account Name:");
		gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridx = 1;
        gbc.gridy = 0; 
        gbl.setConstraints(username,gbc);
        username.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));   
        username.setForeground(Color.WHITE);
        
        
		password = new JLabel("        Password:");
		gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridx = 1;
        gbc.gridy = 1; 
        gbl.setConstraints(password,gbc);
        password.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15)); 
        password.setForeground(Color.WHITE);
		
		userNameBox = new JTextField(20);
		gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridx = 2;
        gbc.gridy = 0; 
        gbl.setConstraints(userNameBox,gbc);
        userNameBox.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));  
		
		
		passwordBox = new JPasswordField(20);
		gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridx = 2;
        gbc.gridy = 1; 
        gbl.setConstraints(passwordBox,gbc);
        passwordBox.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));  
        
		logIn = new JButton("Log In");
		gbc.ipadx = 5;
        gbc.ipady = 5;
        gbc.gridx = 2;
        gbc.gridy = 2; 
        gbl.setConstraints(logIn,gbc);
        logIn.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));  
        logIn.setBackground(Color.GREEN);
        logIn.setForeground(Color.BLACK);
        
		createAccount = new JButton("Create a new account");	
		gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridx = 2;
        gbc.gridy = 7; 
        gbl.setConstraints(createAccount,gbc);
        createAccount.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));  
        createAccount.setBackground(Color.CYAN);
        
	}
	
	
	private void addComponentsToPanels() {
		
		loginCanvas = new JPanel();
		this.add(username);
		this.add(userNameBox);
		this.add(password);
		this.add(passwordBox);
		this.add(logIn);
		this.add(createAccount);
		
	}

	private void addPanelsToWindow() {		
		this.add(loginCanvas);
	
	}

	private void registerListeners() {
		logIn.addActionListener(this);
		createAccount.addActionListener(this);	
	}

	private void setWindowProperties() {
		setLayout(gbl);
		this.setSize(700,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);	
	
	}
	
	public LogInUserInterface() {
		super("App");
		setDesign();
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("../Screech/src/newWall1.jpg")))));
		} catch (IOException e) {
			System.out.println("Image does not exist");
		}
		initializeComponents();
		addComponentsToPanels();
		addPanelsToWindow();
		registerListeners();
		setWindowProperties();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(createAccount)){
			try {
				signUp = new SignUpUserInterface(app);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource().equals(logIn)){
		
		}
		
		
	}
	

	public final static void setDesign() {
        try{
        	UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e){   
        }
    }
}

