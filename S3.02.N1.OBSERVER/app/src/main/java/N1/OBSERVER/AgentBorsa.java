package N1.OBSERVER;

public class AgentBorsa extends Subject {

	//dono valor inicial a la Borsa
	private int valorBorsa = 10;
	String estatBorsa;
	
	@Override
	void setState(int valorBorsa) {
		if(this.valorBorsa > valorBorsa) {
			estatBorsa = "La borsa baixa.";
		}else if(this.valorBorsa < valorBorsa) {
			estatBorsa = "La borsa puja.";
		}else if(this.valorBorsa == valorBorsa) {
			estatBorsa = "La borsa no varia.";
		}
		
		this.valorBorsa = valorBorsa;
		this.notifyObservers();
	}

	@Override
	String getState() {
		return estatBorsa;
	}

}
