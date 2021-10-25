/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 1.Java Bàsics
 * 		Tasca S1.01.Herència i Polimorfisme
 * 		Nivell 1 Exercici 6
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package n1Ex6;

public class AppEx6 {

	public static void main(String[] args) {
		
		Amphibian granota = new Frog();
		Frog gr1 = new Frog();
		Amphibian gr2 = (Amphibian)gr1;
		
		granota.bucejar();
		granota.reptar();
		granota.respirar();
		System.out.println();
		
		gr1.bucejar();
		gr1.reptar();
		gr1.respirar();
		gr1.so();
		gr1.saltar();
		System.out.println();

		gr2.bucejar();
		gr2.reptar();
		gr2.respirar();
		
	}

}
