package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Beans.user;

public class UpdateUser {

	public void update(user newuser) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
//			System.out.println("Update ...");
			
			PreparedStatement ps = con.prepareStatement("update user set name=?,email=?,country=?,password=? where id=?; ");
			ps.setString(1,newuser.getName());
			ps.setString(2,newuser.getEmail());
			ps.setString(3,newuser.getCountry());
			ps.setString(4,newuser.getPassword());
			ps.setInt(5, newuser.getId());
			
	//System.out.println(" ID : "+newuser.getId());
			System.out.println("-----------------------------");
			int result=ps.executeUpdate();
			System.out.println("result :"+result);
			if(result>0) {
		    	System.out.println("Updated Successfully!!...");
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
