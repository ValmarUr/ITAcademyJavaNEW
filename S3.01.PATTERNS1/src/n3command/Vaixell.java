package n3command;

public class Vaixell extends Vehicle {

	@Override
	public void arrencar() {
		
		if(!getEstaArrencat()) {
			System.out.println("El vaixell arrenca el motor.");
			setEstaArrencat(true);
		}else {
			System.out.println("El vaixell ja està en marxa.");
		}
	}

	@Override
	public void accelerar() {
		System.out.println("El vaixell accelera.");		
	}

	@Override
	public void frenar() {
		System.out.println("El vaixell frena.");		
	}

}
