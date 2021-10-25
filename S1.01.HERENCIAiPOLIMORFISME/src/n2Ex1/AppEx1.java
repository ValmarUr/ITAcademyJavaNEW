/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 1.Java Bàsics
 * 		Tasca S1.01.Herència i Polimorfisme
 * 		Nivell 2 Exercici 1
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package n2Ex1;

public class AppEx1 {

	public static void main(String[] args) {
		
		Unicycle unicycle = new Unicycle();
		Bicycle bicycle = new Bicycle();
		Tricycle tricycle = new Tricycle();
		
		unicycle.ride();
		bicycle.ride();
		tricycle.ride();
		
		Cycle[] garatge = {unicycle, bicycle, tricycle};
		
		
		for(int i = 0; i < garatge.length; i++) {
			//NO ENS PERMET INVOCAR EL MÈTODE PERQUÈ NO ESTÀ DEFINIT PEL TIPUS "Cycle"
			//garatge[i].balance();
		}
		
		// D'AQUESTA FORMA PODRÍEM INVOCAR ELS MÈTODES
		((Unicycle)garatge[0]).balance();
		((Bicycle)garatge[1]).balance();
		
		
		
	}

}
