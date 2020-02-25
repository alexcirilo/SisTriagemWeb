package br.com.sistriagem.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String user = "root";
	private static final String password = "qwe123";
	private static final String url = "jdbc:mysql://localhost:4306/sistriagem";
	
	public static Connection connect() throws SQLException{
		
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection(url,user,password);
		return con;
	}
	
	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			Connection con = ConnectionFactory.connect();
			
			System.out.println("Connected!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("YOU SHALL NOT PASS!!!");
			e.printStackTrace();
		}
		
	}
}
