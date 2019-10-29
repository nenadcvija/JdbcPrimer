package jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import controller.MetodeJdbc;
import model.Kurs;
import model.User;

public class JdbcProject {

	public static void main(String[] args) {
		

		MetodeJdbc metode = new MetodeJdbc();
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.println("Unesite id usera:"); int id =
		 * Integer.parseInt(scanner.nextLine()); scanner.close();
		 */
		/*
		 * Kurs k = metode.vratiKursPoId(3);
		 * 
		 * System.out.println("Id: " + k.getIdKursa()); System.out.println("Ime: " +
		 * k.getImeKursa()); System.out.println("Cena: " + k.getCena());
		 */
		
		/*
		 * User user = metode.vratiUseraPoId(id);
		 * 
		 * if(user.getIdUser() != 0) { System.out.println("ID: " + user.getIdUser());
		 * System.out.println("USER NAME: " + user.getUserName());
		 * System.out.println("PASSWORD: " + user.getPassword());
		 * System.out.println("MATBR: " + user.getMaticniBroj()); }else {
		 * System.out.println("Ne postoji taj user!"); }
		 */
		
		
		/*
		 * List<User> lstUsers = metode.vratiSveUsere();
		 * 
		 * for(User u: lstUsers) { System.out.println("ID: " +u.getIdUser());
		 * System.out.println("USER NAME: " + u.getUserName());
		 * System.out.println("PASSWORD: " + u.getPassword());
		 * System.out.println("MATBR: " + u.getMaticniBroj()); }
		 */
	
		
		  Scanner scanner = new Scanner(System.in);
		  System.out.println("Unesite username: ");
		  
		  String userName = scanner.nextLine();
		  
		  int id = metode.vratiIdPoUserneme(userName);
		  System.out.println(" Telefoni od : " + userName);
		  
		  List<String> listaBrojevaTelefona = new ArrayList<String>();
		  
		  if(id != 0) {
		  
		  listaBrojevaTelefona = metode.vratiBrojTelefona(id);
		  
		  for(String s : listaBrojevaTelefona) { 
			  
			  System.out.println(s); 
			  
		  }
		  
		  System.out.println(" kursevi koje pohadja: " + userName);
			
		  List<Integer> listaIdKurseva = new ArrayList<Integer>();
			
			listaIdKurseva = metode.vratiIdKursaPoIdUsera(id);
			
			for(int i: listaIdKurseva) {
				Kurs kurs = metode.vratiKursPoId(i);
				System.out.println(kurs.getImeKursa() + " " + kurs.getCena());
			}
		  
		  }else { System.out.println("Nepostojeci user!"); }
		 
			


		
		
		
		
		
		

	}

}
