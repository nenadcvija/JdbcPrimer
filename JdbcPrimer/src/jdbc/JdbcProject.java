package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import controller.MetodeJdbc;

public class JdbcProject {

	public static void main(String[] args) {
		
		//MetodeJdbc metodeJdbc = new MetodeJdbc();
		
			Connection konekcija = null;
			Statement statement = null;
			
			try {
				konekcija = MetodeJdbc.uspostaviKonekciju("kursevi");
				System.out.println("Usposatvio konekciju");
				
				String query = "INSERT INTO courses VALUES(null,'css',7800)";
				statement = konekcija.createStatement();
				statement.execute(query);
				
				System.out.println("Uspesan unos!");
				
			} catch (SQLException e) {
				System.out.println("Nema konekcije!");
			}
		
		
		
		

	}

}
