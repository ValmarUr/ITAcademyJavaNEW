/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 1.Java Bàsics
 * 		Tasca S1.01.Herència i Polimorfisme
 * 		Nivell 1 Exercici 7
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package n1Ex7;

public class AppEx7 {

	public static void main(String[] args) {
		
		Amphibian granota = new Frog();
		Amphibian am = new Amphibian();
		Frog gr1 = new Frog();
		Amphibian gr2 = (Amphibian)gr1;
		
		// variable Amphibian amb refèrencia a classe Amphibian
		am.bucejar();
		am.moviment();
		am.respirar();
		System.out.println("La classe pare crida als seus propis mètodes\n");
		
		// variable Amphibian amb referència a classe Frog
		granota.bucejar();
		granota.moviment();
		granota.respirar();
		System.out.println();
		
		// variable Frog amb referència a classe Frog
		gr1.bucejar();
		gr1.moviment();
		gr1.respirar();
		System.out.println();

		// variable Amphibian amb referència a classe Frog, castejada a Amphibian
		gr2.bucejar();
		gr2.moviment();
		gr2.respirar();
		System.out.println("En la resta de casos, els mètodes de la classe fill amb mateixa signatura que els de la classe pare queden sobreescrits.");
		
	}

}
