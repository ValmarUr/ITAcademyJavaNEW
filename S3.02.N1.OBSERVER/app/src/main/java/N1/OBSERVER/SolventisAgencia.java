package N1.OBSERVER;

public class SolventisAgencia extends Observer {
	
	public SolventisAgencia(Subject subject) {
		this.subject = subject;
		subject.attach(this);
	}
	
	@Override
	void update() {
		System.out.println("Solventis: " + subject.getState());
	}

}
