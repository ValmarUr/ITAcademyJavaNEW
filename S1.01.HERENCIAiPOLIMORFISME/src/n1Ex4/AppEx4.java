/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 1.Java Bàsics
 * 		Tasca S1.01.Herència i Polimorfisme
 * 		Nivell 1 Exercici 4
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package n1Ex4;

class Prova{
	
	//1. "final" ens permet declarar sense inicialitzar
	final int num;
	
	//2. "final static" ens obliga a inicialitzar amb un valor la variable
	//static final int M;		
	static final int N = 5;

	
	public Prova() {
		
		//1. Amb "final" podem inicialitzar el valor al constructor
		num = 0;
		
		//3. Podem crear una variable final no estàtica al constructor (tot i que en aquest cas no té gaire sentit)
		final int number = 10;
		
		//3. En canvi no podrem fer-ho si la declarem com "final static".
		//static final int NUM = 5;
		
	}
	
}

public class AppEx4 {
	
	final int number = 10;
	static final int NUM = 5;

	public static void main(String[] args) {
		
		Prova p = new Prova();
		System.out.println(p.num);
		System.out.println(Prova.N);
		
	}

}
