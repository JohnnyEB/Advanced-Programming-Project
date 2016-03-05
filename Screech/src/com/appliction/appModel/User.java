package com.appliction.appModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import factories.DBConnectorFactory;
import com.appliction.appController.*;
import com.appliction.appView.*;
public class User {
	private java.sql.Connection cn;	
	public User() {
		cn = DBConnectorFactory.getDatabaseConnection();
	}
	

	public void createUser(String accountName, String firstName,String lastName, String password, String email, String country) {
		try {
			Statement smt = cn.createStatement();
			String query = "INSERT INTO users " +"VALUES('"+accountName+"','"+firstName+"',"
					+ "'"+lastName+"','"+password+"', '"+email+"', '"+country+"')"; 
			smt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error in create"+ e);
		}
		
	}
	
	public void readAllUsers() {
		ResultSet res = null;
		try {
			Statement smt = cn.createStatement();
			String query = "SELECT* FROM users"; 
			
			res = smt.executeQuery(query);
			while(res.next()) {
				res.getString("userAccount");
				res.getString("firstName");
				res.getString("lastName");
			}
			
			
		} catch (Exception e) {
			System.out.println("Error in readAll"+ e);
		}
	}
	/*
	public void update(String accountName, String firstName,String lastName, String password, String email, String country) {
		int in;
		try {
			Statement smt = cn.createStatement();
			String query = "UPDATE assignment SET student_name= '" +studeName+ "' WHERE accountName='" +accountName+"'";
			String query2 = "UPDATE assignment SET assignment_grade= '" +assignGrade+ "' WHERE student_id='" +studId+"'";
			smt.executeUpdate(query);
			smt.executeUpdate(query2);
		} catch (Exception e) {
			System.out.println("Error in Update"+ e);
			
		}
	
	}
	*/
	public void deleteUser(String userName) {
		try {
			Statement smt = cn.createStatement();
			String query = "DELETE FROM users WHERE userName ="+"'"+userName+"'";
			smt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Error in Delete"+ e);			
		}
	}

}
