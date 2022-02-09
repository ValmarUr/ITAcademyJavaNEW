package N1.OBSERVER;

public class AbanteAgencia extends Observer {
	
	public AbanteAgencia(Subject subject) {
		this.subject = subject;
		subject.attach(this);
	}
	
	@Override
	void update() {
		System.out.println("Abante: " + subject.getState());
	}

}
