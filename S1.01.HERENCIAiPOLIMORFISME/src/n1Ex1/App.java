/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 1.Java Bàsics
 * 		Tasca S1.01.Herència i Polimorfisme
 * 		Nivell 1 Exercici 1
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package n1Ex1;

public class App {
	
	public App() {
		
		System.out.println("2.Quan fem una nova instància d'una classe, s'executa el constructor");
	}

	public static void main(String[] args) {
		
		
		System.out.println("1.Quan executem un programa, ho fa desde el mètode main");
		App app = new App();
		app.saluda();
		
	}
	
	public void saluda() {
		System.out.println("3.Un cop tenim la instància, podem fer servir els mètodes no estàtics associats a aquesta classe");
	}

}
