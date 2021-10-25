/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 1.Java Bàsics
 * 		Tasca S1.01.Herència i Polimorfisme
 * 		Nivell 1 Exercici 3
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package n1Ex3;

class Gat {
	
	{
		System.out.println("bloc inicialització Gat");
	}
	
	public int potes = 4;
	
	static {
		System.out.println("Inicialització membre estàtic Gat");
	}
	
}

class Gos {
	
	{
		System.out.println("bloc inicialització Gos");
	}
	
	public static int potes = 4;
	
	static {
		System.out.println("Inicialització membre estàtic Gos");
	}
	
}

public class AppEx3 {
	
//	public int number = 0;
//	{
//		System.out.println("bloc inicialització AppEx3");
//	}
//	
//	public AppEx3() {
//		number = 10;
//		System.out.println("constructor AppEx3");
//	}
//	
//	static{
//		System.out.println("inicialització membre estàtic AppEx3");
//	}

	public static void main(String[] args) {
		
		 System.out.println("CÀRREGA PROVOCADA PER L'ACCÉS A UN MEMBRE ESTÀTIC DE LA CLASSE ");
		 System.out.println(Gos.potes);
		 
		 System.out.println("\nLA SEGONA VEGADA QUE S'ACCEDEIX NO ES TORNA A CARREGAR EL BLOC ESTÀTIC");
		 System.out.println(Gos.potes);
		 
		 
		 System.out.println("\n-----------------------------------------------------------------------------------\n");
		 
		 
		 System.out.println("CÀRREGA PROVOCADA PER CREACIÓ DE LA PRIMERA INSTANCIA");
		 Gat gat1 = new Gat();
		 System.out.println(gat1.potes);
		 
		 System.out.println("LA SEGONA VEGADA QUE S'INSTANCIA LA CLASSE NO ES TORNA A CARREGAR EL BLOC ESTÀTIC");
		 Gat gat2 = new Gat();
		 System.out.println(gat2.potes);

	}

}
