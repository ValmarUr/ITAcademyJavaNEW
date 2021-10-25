/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 1.Java Bàsics
 * 		Tasca S1.08.Lambdes
 * 		Nivell 1 Fase 1
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package n1fase1;

public class App {
	
	Llistes ll = new Llistes();
	Lambdas l = new Lambdas();

	public static void main(String[] args) {
		
		App app = new App();
		
		app.ex1();
		app.ex2();
		app.ex3();
		app.ex4();
		app.ex5();
		app.ex6();
		
	}
	
	private void ex1() {
		
		System.out.println("---Ex1---");
		l.lambdaEx1(ll.llistaEx1).forEach(s -> System.out.println(s));
	}
	
	private void ex2() {
		
		System.out.println("---Ex2---");
		System.out.println(l.lambdaEx2(ll.llistaEx2));
	}

	private void ex3() {
		
		System.out.println("---Ex3---");
		l.lambdaEx3(ll.llistaEx3).forEach(s -> System.out.println(s));
	}
	
	private void ex4() {
		
		System.out.println("---Ex4---");
		l.lambdaEx4(ll.llistaEx3).forEach(s -> System.out.println(s));
	}
	
	private void ex5() {
		
		System.out.println("---Ex5---");
		l.lambdaEx5(ll.llistaEx5);
	}
	
	private void ex6() {
		
		System.out.println("---Ex6---");
		l.lambdaEx6(ll.llistaEx5);

	}
 }
