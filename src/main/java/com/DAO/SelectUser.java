package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Beans.user;

public class SelectUser {

	public user SelectUser(int id) throws SQLException {
		user existingUser = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");		
			
			
			PreparedStatement ps= con.prepareStatement("select * from user where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				 existingUser = new user();
				 existingUser.setId(rs.getInt("id"));
	             existingUser.setName(rs.getString("name"));
	             existingUser.setEmail(rs.getString("email"));
	             existingUser.setCountry(rs.getString("country"));
	             existingUser.setPassword(rs.getString("password"));
	             System.out.println("User Retrieved: " + existingUser.getName());
			}
			
			
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return existingUser;
	
	}

}
