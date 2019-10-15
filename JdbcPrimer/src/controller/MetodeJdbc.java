package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetodeJdbc {
	
	
	
	public static Connection uspostaviKonekciju(String imeBaze) throws SQLException {
		
		final String url = "jdbc:mysql://localhost:3306/" + imeBaze;
		final String pass = "root";
		final String user = "root";
		
		return  DriverManager.getConnection(url, user, pass);
			
	}

	
	
}
