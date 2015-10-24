package com.connutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
public class ConnectionUtil {

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/User_information";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "mysql";

	public static Connection getConnection(HttpServletResponse response) throws IOException {
		/* register driver */
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			response.sendRedirect("errorPage.jsp");
			
		}

		/* open connection */
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME,
					PASSWORD);
		} catch (SQLException e) {
			response.sendRedirect("errorPage.jsp");
			
		}

		return connection;
	}

}
