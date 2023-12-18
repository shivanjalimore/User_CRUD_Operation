package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Beans.user;

public class InsertUser {

	public void insertuser(user newuser) throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");		
			
			
			PreparedStatement ps= con.prepareStatement("insert into user(name,email,country,password)values(?,?,?,?)");
			ps.setString(1,newuser.getName());
			ps.setString(2, newuser.getEmail());
			ps.setString(3,newuser.getCountry());
			ps.setString(4, newuser.getPassword());
			
			int result=ps.executeUpdate();
			
			if(result>0) {
		    	System.out.println("Registration successfully!!...");
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
