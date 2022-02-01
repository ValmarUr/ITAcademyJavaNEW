package n2abstractfactory;

import java.util.InputMismatchException;
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
	 
	 public static int leerInt(String text) {
	     int numero = 0;
	     boolean correcto = false;

	     do {
	         System.out.print(text);
	         try {
	             numero = s.nextInt();
	             correcto = true;
	         } catch (InputMismatchException ex) {
	             System.out.println("Format error.");
	         }
	         s.nextLine();
	     } while (!correcto);
      return numero;
    }
	
}
