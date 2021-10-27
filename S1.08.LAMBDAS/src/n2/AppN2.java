/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 1.Java Bàsics
 * 		Tasca S1.08.Lambdes
 * 		Nivell 2
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package n2;

import java.util.Comparator;
import java.util.List;

public class AppN2 {

	public static void main(String[] args) {
		
		LlistesN2 llistes = new LlistesN2();
		AppN2 app = new AppN2();
		
		
		app.Ex1(llistes.llista);
//		app.Ex2(llistes.llista);
//		app.Ex3(llistes.llista);
//		app.Ex4(llistes.llista);
//		app.Ex5(llistes.llista);
//		app.Ex6(llistes.llista);
		
		
		
		System.out.println("\n\n=============================================\n\n");
		
		
		I02_FunctionalInterface i02Suma = (x, y) -> (float)x + y; 
		I02_FunctionalInterface i02Resta = (x, y) -> (float)x - y; 
		I02_FunctionalInterface i02Multiplicacio = (x, y) -> (float)x * y; 
		I02_FunctionalInterface i02Divisio = 
				(x, y) -> {
					
					if(y == 0) {
						System.out.println("Error: No es pot dividir entre 0");
						return 0;
					}else {
						return (float)x / y;
					}

				};
		
		System.out.println(i02Suma.operacio(10, 6));
		System.out.println(i02Resta.operacio(10, 6));
		System.out.println(i02Multiplicacio.operacio(10, 6));
		System.out.println(i02Divisio.operacio(10, 6));
		System.out.println(i02Divisio.operacio(10, 0));
		
	}
	
	private void Ex1(List<String> llista) {
		
		llista.stream().sorted(Comparator.comparing(s -> s.length())).forEach(System.out::println);
		
	}
	
	private void Ex2(List<String> llista) {
		
		llista.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
		
	}
	
	private void Ex3(List<String> llista) {
		
		llista.stream().sorted(Comparator.comparing(s -> s.charAt(0))).forEach(System.out::println);
		
	}

	private void Ex4(List<String> llista) {
		
		llista.stream().sorted(Comparator.comparing((String s) -> s.toLowerCase().contains("e")).reversed()).forEach(System.out::println);
		
	}
	
	private void Ex5(List<String> llista) {
		
		llista.stream().map(s -> s.replace('a', '4')).forEach(System.out::println);
		
	}
	
	private void Ex6(List<String> llista) {
		
		String exprNumeros = "\\d+";
		llista.stream().filter(s -> s.matches(exprNumeros)).forEach(System.out::println);
	}
	
}
