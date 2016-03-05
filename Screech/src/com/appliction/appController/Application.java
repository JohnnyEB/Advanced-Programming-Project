package com.appliction.appController;

import javax.swing.SwingUtilities;

import com.appliction.appView.SignUpUserInterface;
import com.appliction.appModel.*;
import com.appliction.appView.*;

public class Application {
	
	User user;
	SignUpUserInterface signUp;
	
	public Application() {
		user = new User();
		signUp = new SignUpUserInterface(this);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				 new Application();
			}
		});
	}
}
