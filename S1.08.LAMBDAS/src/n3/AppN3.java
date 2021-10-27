/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 1.Java Bàsics
 * 		Tasca S1.08.Lambdes
 * 		Nivell 3 
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package n3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppN3 {

	public static void main(String[] args) {	
		
		List<Alumne> llista = new ArrayList<>();
		omplirLlista(llista);
		
		System.out.println("=== ex1 ===");
		llista.stream().forEach(s -> System.out.println(" Alumne: " + s.getNom() + "\n Edat: " + s.getEdat() + "\n") );
		
		System.out.println("=== ex2 ===");
		llista.stream().filter(s -> s.getNom().startsWith("A")).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("=== ex3 ===");
		llista.stream().filter(s -> s.getNota() >= 5).forEach(System.out::println);
		
		System.out.println("=== ex4 ===");
		llista.stream().filter(s -> s.getNota() >= 5 && s.getCurs() != "PHP").forEach(System.out::println);
		
		System.out.println("=== ex5 ===");
		llista.stream().filter(s -> s.getCurs() == "JAVA" && s.getEdat() >= 18).forEach(System.out::println);
	}
	
	public static void omplirLlista(List<Alumne> llista) {
		
		llista.add(new Alumne("Juan", 21, "PHP", 8));
		llista.add(new Alumne("Pedro", 23, "JAVA", 4));
		llista.add(new Alumne("Ariadna", 18, "ANGULAR", 9));
		llista.add(new Alumne("Julia", 33, "PYTHON", 8));
		llista.add(new Alumne("Ernesto", 27, "PHP", 7));
		llista.add(new Alumne("Victoria", 37, "JAVA", 10));
		llista.add(new Alumne("Eva", 25, "PHP", 5));
		llista.add(new Alumne("Alfonso", 47, "JAVA", 3));
		llista.add(new Alumne("Dafne", 41, "VUE", 6));
		llista.add(new Alumne("Berto", 17, "JAVA", 8));
		
	}

}
