package n3command;

//invoker
public class Pilot {
	
	public void execute(ICommand command) {
		command.execute();
	}
	
}
