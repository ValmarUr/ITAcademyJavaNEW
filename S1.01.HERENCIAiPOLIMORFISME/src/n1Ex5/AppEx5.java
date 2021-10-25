/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 1.Java Bàsics
 * 		Tasca S1.01.Herència i Polimorfisme
 * 		Nivell 1 Exercici 5
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package n1Ex5;

public class AppEx5  {

	public static void main(String[] args) {
		
		Estudiante student = new Estudiante();
		student.saludar();
		student.saludar("David");
		student.saludar("Pedro", 5);
		student.saludar("Juan", "profesor");
		
	}

}
