package n3command;

public class Cotxe extends Vehicle {

	@Override
	public void arrencar() {
		
		if(!getEstaArrencat()) {
			System.out.println("El cotxe arrenca el motor.");
			setEstaArrencat(true);
		}else {
			System.out.println("El cotxe ja està en marxa.");
		}
	}

	@Override
	public void accelerar() {
		System.out.println("El cotxe accelera.");
	}

	@Override
	public void frenar() {
		System.out.println("El cotxe frena.");
	}

}
