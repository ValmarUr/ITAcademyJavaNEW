package n3command;

public class Bicicleta extends Vehicle {

	@Override
	public void arrencar() {
		
		if(!getEstaArrencat()) {
			System.out.println("La bicicleta arrenca.");
			setEstaArrencat(true);
		}else {
			System.out.println("La bicicleta ja està en marxa.");
		}
	}

	@Override
	public void accelerar() {
		System.out.println("La bicicleta accelera.");
	}

	@Override
	public void frenar() {
		System.out.println("La bicicleta frena.");
	}

}
