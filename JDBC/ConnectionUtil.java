package com.metacube.jdbc.session1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/library_management_system";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "mysql";


	
	public static Connection getConnection() 
	{
		/* register driver */
		Connection connection = null;	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Class not found Exception");
			System.exit(1);
		}
		
		/* open connection */
		try 
		{
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
		}
		catch (SQLException e) 
		{
			System.out.println("SQL exception Occured ");
			System.exit(1);
		}
		
		return connection;
	}
	
}
