package jdbc;

import java.util.Scanner;
import controller.MetodeJdbc;
import model.Kurs;

public class JdbcProject {

	public static void main(String[] args) {
		

		MetodeJdbc metode = new MetodeJdbc();
		
		
		Kurs k = metode.vratiKursPoId(3);
		
		System.out.println("Id: " + k.getIdKursa());
		System.out.println("Ime: " + k.getImeKursa());
		System.out.println("Cena: " + k.getCena());
		
		
		
		
		

	}

}
