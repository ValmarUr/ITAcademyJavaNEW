/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 1.Java Bàsics
 * 		Tasca S1.01.Herència i Polimorfisme
 * 		Nivell 3 Exercici 1
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package n3Ex1;

public class App {

	public static void main(String[] args) {
		
		ClassePare cp = new ClassePare();
		ClasseFill cf = new ClasseFill();
		
		ClassePare castcf= (ClassePare)cf;
		
		// prova amb un objecte de la classe pare
		System.out.println("PROVA AMB L'INSTÀNCIA D'UN OBJECTE DE LA CLASSE PARE");
		cp.primerMetode();
		cp.segonMetode();
		
		System.out.println();

		
		System.out.println("QUAN INVOQUEM EL SEGON MÈTODE, EXECUTA LA VERSIÓ DE LA CLASSE FILL (OVERRIDE)");
		castcf.primerMetode();
		castcf.segonMetode();
		
	}

}
