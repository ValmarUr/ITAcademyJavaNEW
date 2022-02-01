package n3command;

public class Avio extends Vehicle {

	@Override
	public void arrencar() {
		
		if(!getEstaArrencat()) {
			System.out.println("L'avió arrenca el motor.");
			setEstaArrencat(true);
		}else {
			System.out.println("L'avió ja està en marxa.");
		}
	}

	@Override
	public void accelerar() {
		System.out.println("L'avió accelera.");
	}

	@Override
	public void frenar() {
		System.out.println("L'avió frena.");
	}

}
