package n1Ex7;

public class Frog extends Amphibian{

	@Override
	public void moviment() {
		System.out.println("Boing!");
	}
	
	@Override
	public void respirar() {
		System.out.println("*Ribbit*");
	}
	
	@Override
	public void bucejar() {
		System.out.println("CHOF!!!");
	}
	
	
}
