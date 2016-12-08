package com.web.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;


public class CommonDB {

	private static String dbUrl = "jdbc:mysql://localhost:3306/lastcart";
	private static String dbUsername = "Shefali";
	private static String dbPassword = "shefali123";

	public Connection getConnection()   {
		//Connection con = null;
		Connection connection = null;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			System.out.println("Connecting to the MySQL database");	

		}
	catch(ClassNotFoundException e)
		{
		System.out.println("Connecting to the MySQL database");	
		throw new RuntimeException(e);
		}
		catch(SQLException e)
		{
		System.out.println("Connecting to the MySQL database");	
		throw new RuntimeException(e);
		}
		return connection;
	}
	public void closeConnection(Connection connection){ 
		System.out.println("Closing..byeee.");
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ignore) {
			}
		}
	}
}
