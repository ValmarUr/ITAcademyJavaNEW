package n2Ex1;

public class Cycle {

	public int rodes;
	
	
	public void ride() {
		System.out.println("Broom!! El vehicle és de " + wheels() + (wheels()>1?" rodes":" roda") );
	}
	
	public int wheels() {
		return rodes;
	}
	
}
