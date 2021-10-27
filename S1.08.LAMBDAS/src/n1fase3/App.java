/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 1.Java Bàsics
 * 		Tasca S1.08.Lambdes
 * 		Nivell 1 Fase 3
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package n1fase3;

public class App {

	public static void main(String[] args) {
		
		I01_FunctionalInterface cadenaInreves = (s) -> new StringBuilder(s).reverse().toString();
		
		String resultat = cadenaInreves.reverse("tagamanen");
		
		System.out.println(resultat);
	}

}
