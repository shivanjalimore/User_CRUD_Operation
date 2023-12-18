package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Beans.user;

public class DeleteUser {

	public void deleteuser(user newuser) throws SQLException 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");		
			PreparedStatement ps = con.prepareStatement("DELETE FROM user WHERE id=?;");
			ps.setInt(1,newuser.getId());
			
			 int x=ps.executeUpdate();
		        
		    	if(x!=0)
					System.out.println(" DELETED SUCCESSFULLY !");
				else
					System.out.println(" NOT FOUND !");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
