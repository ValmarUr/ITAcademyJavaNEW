package n1singleton;

import java.util.Scanner;

public class Lector {

	 private static Scanner s = new Scanner(System.in);
	 
	 public static String leer() {
		 
		 return s.nextLine();
	 }
	
	 public static String leer(String text) {
		 
		 System.out.print(text);
		 return s.nextLine();
	 }
	 
}
