package com.cg;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoJDBCDelete {

	
	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
		//Load Appropaiayte Drive
		Class.forName("com.mysql.jdbc.Driver");
		//Establish connections
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "root");
		//Prepare Statements
		String sql="delete from actor where actor_id=?";
		PreparedStatement strmt=conn.prepareStatement(sql);
		strmt.setInt(1, 1005);
		int no=strmt.executeUpdate();
		System.out.println("No Of Record Updated is "+no);
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
