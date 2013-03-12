package com.opentrafficsimulation.utility.data;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	
	public Connection con= null;
	
	public Connection connector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost/vehicles", "root","");
			
			if (con== null) {
				System.out.println("Connection counld not be esstablished");
			}
			return con;
		} 
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error" + e);
		}
		return null;
	}

	
//	private static DBConnector connector = new DBConnector();
//	
//	public static DBConnector getInstance() {
//		return connector;
//		
//	}
}
