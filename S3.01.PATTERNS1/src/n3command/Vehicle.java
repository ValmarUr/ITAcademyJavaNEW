package n3command;

//receiver
public abstract class Vehicle {
	
	private boolean estaArrencat = false;
	
	public boolean getEstaArrencat() {
		return this.estaArrencat;
	}
	
	public void setEstaArrencat(Boolean bool) {
		this.estaArrencat = bool;
	}

	public abstract void arrencar();
	
	public abstract void accelerar();
	
	public abstract void frenar();
	
}
