package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Kurs;

public class MetodeJdbc {
	
	
	private static Connection uspostaviKonekciju(String imeBaze) throws SQLException {
		
		final String url = "jdbc:mysql://localhost:3306/" + imeBaze;
		final String pass = "root";
		final String user = "root";
		
		return  DriverManager.getConnection(url, user, pass);
			
	}

	
	public boolean ubaciUtabeluKursevi(String imeKursa, String cena) {
		
		
		Connection konekcija = null;
		PreparedStatement statement = null;
		
		int cenaZaUpis = Integer.parseInt(cena);
		
		try {
			konekcija = uspostaviKonekciju("kursevi");
			System.out.println("Konekcija uspostavljena!");
			
			String query = "INSERT INTO courses VALUES(null,?,?)";
			statement = konekcija.prepareStatement(query);
				statement.setString(1, imeKursa);
				statement.setInt(2, cenaZaUpis);
			statement.execute();
			System.out.println("Uspesno ubacen kurs!");
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				konekcija.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}			
	}
	
	
	public boolean izmeniCenuKursa(String imeKursa, int cena) {
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		
		try {
			konekcija = uspostaviKonekciju("kursevi");
			System.out.println("Konekcija uspostavljena");
			
			String query = "UPDATE courses SET cena = ? WHERE ime_kursa = ?";
			pst = konekcija.prepareStatement(query);
				pst.setInt(1, cena);
				pst.setString(2, imeKursa);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				konekcija.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void prikaziSveKurseve() {
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		
		
		try {
			konekcija = uspostaviKonekciju("kursevi");
			System.out.println("Konekcija uspostavljena");
			
			String query = "SELECT * FROM courses";		
			pst = konekcija.prepareStatement(query);
			
			res = pst.executeQuery();
			
			System.out.println("id   ime   cena");
			System.out.println("_________________________");
			
			while(res.next()) {
				
				int id = res.getInt("id_courses");
				String ime = res.getString("ime_kursa");
				double cena = res.getDouble("cena");
				
				System.out.println(id + "   " + ime + "   " + cena);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				konekcija.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}	
	}
	
	
	
	public Kurs vratiKursPoId(int id) {
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		
		Kurs kurs = new Kurs();
		
		try {
			konekcija = uspostaviKonekciju("kursevi");
			System.out.println("Konekcija uspostavljena");
			
			String query = "SELECT * FROM courses WHERE id_courses = ?";		
			pst = konekcija.prepareStatement(query);
				pst.setInt(1, id);
			
			res = pst.executeQuery();
			
			while(res.next()) {
				
				kurs.setIdKursa( res.getInt("id_courses") ); 	
				kurs.setImeKursa( res.getString("ime_kursa") );
				kurs.setCena( res.getDouble("cena") ); 
					
			}
			
			return kurs;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				konekcija.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
