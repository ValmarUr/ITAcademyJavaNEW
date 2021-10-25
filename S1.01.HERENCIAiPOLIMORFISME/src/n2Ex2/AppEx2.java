/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 1.Java Bàsics
 * 		Tasca S1.01.Herència i Polimorfisme
 * 		Nivell 2 Exercici 2
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package n2Ex2;

public class AppEx2 {

	public static void main(String[] args) {
		
		Raton rat = new Raton();
		Jerbo jer = new Jerbo();
		Hamster ham = new Hamster();
		
		
		Roedor[] rodent = {rat, jer, ham}; 
		
		for(int i = 0; i < rodent.length; i++) {
			rodent[i].cridar();
			rodent[i].escalar();
			rodent[i].rosegar();
			System.out.println();
		}
		
	}

}
