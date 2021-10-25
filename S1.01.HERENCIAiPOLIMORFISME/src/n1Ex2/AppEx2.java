/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 1.Java Bàsics
 * 		Tasca S1.01.Herència i Polimorfisme
 * 		Nivell 1 Exercici 2
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */


package n1Ex2;

public class AppEx2 {

	public static void main(String[] args) {
		
		AppEx2.metodeStatic();
		// AppEx2.metodeNoStatic();
		
		AppEx2 app = new AppEx2();
		app.metodeNoStatic();
		
	}
	
	public static void metodeStatic() {
		
		System.out.println("Executant metodeStatic... \nPuc ésser invocat sense fer cap instància de la classe.\n");
	}
	
	
	public void metodeNoStatic() {
		
		System.out.println("Executant metodeNoStatic... \nPer invocar-me ha estat necessari fer una instància de la classe previament.\n");
	}

}
