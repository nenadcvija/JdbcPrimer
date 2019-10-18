package jdbc;

import java.util.Scanner;
import controller.MetodeJdbc;

public class JdbcProject {

	public static void main(String[] args) {
		

		MetodeJdbc metode = new MetodeJdbc();
		
		Scanner scanner = new Scanner(System.in);	
		
			System.out.println("Unesite ime kursa: ");
			String imeKursa = scanner.nextLine();
			
			System.out.println("Unesite cenu: ");
			int cena = Integer.parseInt(scanner.nextLine());
			
		scanner.close();
		
		metode.izmeniCenuKursa(imeKursa, cena);
		
		
		
		
		
		
		

	}

}
