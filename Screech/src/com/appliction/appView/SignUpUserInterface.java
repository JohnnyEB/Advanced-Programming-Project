package com.appliction.appView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.log.Log;
import com.appliction.appController.Application;
import com.appliction.appModel.*;

public class SignUpUserInterface extends JFrame implements ActionListener{
	
	private JPanel canvas1;	
	private JTextField firstNameBox,
					   lastNameBox,
					   userNameBox,
					   emailBox,
					   retypeEmailBox,
					   countryBox,
					   birthyear;	
	
	private JLabel firstName,
				   lastName,
				   userName,
				   password,
				   retypePassword,
				   email,
				   retypeEmail,
				   country,
				   dateOfBirth;	
	
	JComboBox birthday,birthmonth;
	
	JRadioButton female, male;
	
	JCheckBox agreementTick;
	
	private JButton signUp, logIn;	
	
	
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private GridLayout gl;
	
	private JPasswordField passwordBox;
	private JPasswordField retypePasswordBox;
	
	User user = new User();
	
	
/**/
	private void initializeComponents() {

		
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,0,0,0);
		setLayout(gbl);	
		
		firstName = new JLabel("First Name");
		gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridx = 1;
        gbc.gridy = 0; 
        gbl.setConstraints(firstName,gbc);
        firstName.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));        
        
        
        firstNameBox = new JTextField(20);
        gbc.ipadx = 8;
        gbc.ipady = 8;
        gbc.gridx = 1;
        gbc.gridy = 1;
        
        gbl.setConstraints(firstNameBox,gbc);
        firstNameBox.setBackground(Color.WHITE);
        firstNameBox.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
        
        
        //------------------------------------------------------------------------------------------------------------------
        
        lastName = new JLabel("Last Name");
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbl.setConstraints(lastName,gbc);
        lastName.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
        
        
        lastNameBox = new JTextField(20);
        gbc.ipadx = 8;
        gbc.ipady = 8;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbl.setConstraints(lastNameBox,gbc);
        lastNameBox.setBackground(Color.WHITE);
        lastNameBox.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
        
        
 //------------------------------------------------------------------------------------------------------------------
        
        email = new JLabel("Email Address");
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbl.setConstraints(email,gbc);
        email.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
        
        
        emailBox = new JTextField(20);
        gbc.ipadx = 8;
        gbc.ipady = 8;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbl.setConstraints(emailBox,gbc);
        emailBox.setBackground(Color.WHITE);
        emailBox.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
        
  //------------------------------------------------------------------------------------------------------------------
        
        retypeEmail = new JLabel(" Re-type Email Address");
		gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbl.setConstraints(retypeEmail,gbc);
        retypeEmail.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
        
        
        retypeEmailBox = new JTextField(20);
        gbc.ipadx = 8;
        gbc.ipady = 8;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbl.setConstraints(retypeEmailBox,gbc);
        retypeEmailBox.setBackground(Color.WHITE);
        retypeEmailBox.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
        
        
        
        //------------------------------------------------------------------------------------------------------------------
        
        userName = new JLabel("User Name");
		gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbl.setConstraints(userName,gbc);
        userName.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
        
        
        userNameBox = new JTextField(20);
        gbc.ipadx = 8;
        gbc.ipady = 8;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbl.setConstraints(userNameBox,gbc);
        userNameBox.setBackground(Color.WHITE);
        userNameBox.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
        
        
        //------------------------------------------------------------------------------------------------------------------
        
        password = new JLabel("Password");
		gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbl.setConstraints(password,gbc);
        password.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
       
        
        passwordBox = new JPasswordField(20);
        gbc.ipadx = 8;
        gbc.ipady = 8;
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbl.setConstraints(passwordBox,gbc);
        passwordBox.setBackground(Color.WHITE);
        passwordBox.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
        
        
      
  
        
        //------------------------------------------------------------------------------------------------------------------

        country = new JLabel("Country");
		gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbl.setConstraints(country,gbc);
        country.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
        
        
        countryBox = new JTextField(20);
        gbc.ipadx = 8;
        gbc.ipady = 8;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbl.setConstraints(countryBox,gbc);
        countryBox.setBackground(Color.WHITE);
        countryBox.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
        
      //------------------------------------------------------------------------------------------------------------------

        dateOfBirth = new JLabel("Date of Birth");
		gbc.ipadx = 8;
        gbc.ipady = 8;
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbl.setConstraints(dateOfBirth, gbc);
        dateOfBirth.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));  
        
        
        birthday = new JComboBox(new String[]{"day","1","2","3","4","5","6","7","8","9","10",
				"11","12","13","14","15","16","17","18","19","20",
				"21","22","23","24","25","26","29","30","31"});
        gbc.ipadx = 8;
        gbc.ipady = 8;
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbl.setConstraints(birthday,gbc);
        //birthday.setBackground(Color.WHITE);
        birthday.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
        
        //------------------------------------------------------------------------------------------------------------------
    
        
        birthmonth = new JComboBox(new String[]{"month","January","February","March","April","May","June",
				  "July","August","September","October","November","December"});
  
		gbc.ipadx = 8;
        gbc.ipady = 8;
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbl.setConstraints(birthmonth, gbc);
        birthmonth.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
        
        //------------
        
        birthyear = new JTextField("Year",5);
        gbc.ipadx = 8;
        gbc.ipady = 8;
        gbc.gridx = 3;
        gbc.gridy = 9;
        gbl.setConstraints(birthyear,gbc);
        birthyear.setBackground(getBackground());
        birthyear.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
        
        
        
      //------------------------------------------------------------------------------------------------------------------
        
        signUp = new JButton("SIGN UP");
		gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.gridx = 2;
        gbc.gridy = 12;
        gbl.setConstraints(signUp,gbc);
        signUp.setBackground(Color.GREEN);
        signUp.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
        
      //------------------------------------------------------------------------------------------------------------------
        /*
        logIn = new JButton("LOG IN");
		gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.gridx = 2;
        gbc.gridy = 12;
        gbl.setConstraints(logIn,gbc);
        logIn.setBackground(Color.WHITE);
        logIn.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
        */

	}

	/**/	
	private void addComponentsToPanel() {
		canvas1 = new JPanel();
		add(firstName);
		add(firstNameBox);
		add(lastName);
		add(lastNameBox);
		add(email);
		add(emailBox);
		add(retypeEmail);
		add(retypeEmailBox);		
		add(userName);
		add(userNameBox);
		add(password);
		add(passwordBox);
		add(country);
		add(countryBox);
		add(dateOfBirth);
		add(birthday);
		add(birthmonth);
		add(birthyear);
		add(signUp);

		//add(logIn);
	}
	
	/**/
	
	private void addPanelsToWindow() {
		this.add(canvas1);
		this.pack();
	}
	
	/**/
	
	private void registerListeners() {
		signUp.addActionListener(this);
		//logIn.addActionListener(this);
	}
	
	/**/
	
	private void setWindowProperties() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,700);
		this.setVisible(true);
		this.CenteredFrame(this);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	/*|	Constructor |*/
	public SignUpUserInterface(Application app) 
	{
		super("Instant Messenger");
		setDesign();
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("../Screech/src/image1.jpg")))));
		} catch (IOException e) {
			System.out.println("Image does not exist");
		}
		
		initializeComponents();
		addComponentsToPanel();
		addPanelsToWindow();
		registerListeners();
		setWindowProperties();	  
       
	}
	
	 public void CenteredFrame(JFrame objFrame) {
	        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
	        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
	        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
	        objFrame.setLocation(iCoordX, iCoordY); 
	    } 
	
	public final static void setDesign() {
        try{
        	UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e){   
        }
    }

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource().equals(signUp)) {
			user.createUser(userNameBox.getText().toString(), firstNameBox.getText().toString(), 
					lastNameBox.getText().toString(), passwordBox.getName(), 
					emailBox.getText().toString(), countryBox.getText().toString());
		}
		
	}
	
	public String getdate(){
	      DateFormat format = new SimpleDateFormat("MM/DD/YYYY"); //display your format.
	      Date date = new Date();//puts the date in variable.
	      return format.format(date); //returns the format to the date variable.
	}


}
