package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Beans.user;

public class SelectAllUsers 

{

	public List<user> selectAll() throws SQLException {
		
    List<user> users = new ArrayList<>();
		
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");		
				
				
				PreparedStatement ps= con.prepareStatement("select * from user");
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					user currentUser = new user();
					 currentUser.setId(rs.getInt(1));
		             currentUser.setName(rs.getString(2));
		             currentUser.setEmail(rs.getString(3));
		             currentUser.setCountry(rs.getString(4));
		             currentUser.setPassword(rs.getString(5));
		             
		             users.add(currentUser);
			    }
				
			}
				
				catch (ClassNotFoundException e)
				
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }
		
		  return users;
	}
}
	
	   

