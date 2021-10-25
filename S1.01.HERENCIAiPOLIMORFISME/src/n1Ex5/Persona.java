package n1Ex5;

public class Persona {

	public void saludar() {
		System.out.println("Hola!");
	}
	
	public void saludar(String nombre) {
		System.out.println("Hola, " + nombre + "!");
	}
	
	public void saludar(String nombre, int repeticiones) {
		
		System.out.print("Ho");
		
		for(int i = 0; i < repeticiones; i++) {
			System.out.print("o");
		}
		System.out.println("la, " + nombre + "!");
	}
	
	
}
