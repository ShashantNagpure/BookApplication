package com.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static Connection con;
	public static Connection openConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver Loaded Successfully");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CITI", "sa", "sa123");
			System.out.println("Connection Successful");
			//con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static Connection closeConnection() throws SQLException
	{
		con.close();
		return con;
	}
	
}
