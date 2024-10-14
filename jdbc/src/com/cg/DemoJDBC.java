package com.cg;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoJDBC {

	
	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
		//Load Appropaiayte Drive
		Class.forName("com.mysql.jdbc.Driver");
		//Establish connections
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "root");
		//Prepare Statements
		//Statement stmt=conn.createStatement();
		PreparedStatement stmt=conn.prepareStatement("select * from actor where actor_id=?");
		//Obtain Resultset or Manipulate data
		System.out.println("Please enter actor id");
		int actId=sc.nextInt();
		stmt.setInt(1, actId);
		ResultSet rs=stmt.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("actor_id")+" "+rs.getString("first_name")+" "+rs.getString(3));
		}
		//Close Resultset and Statements
		rs.close();
		stmt.close();
		//Close Connections
		conn.close();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

	}

}
