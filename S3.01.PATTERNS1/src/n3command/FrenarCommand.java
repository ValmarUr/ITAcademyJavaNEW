package n3command;

//cocrete command
public class FrenarCommand implements ICommand {

	private Vehicle vehicle;
	
	public FrenarCommand(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
	@Override
	public void execute() {
		vehicle.frenar();
	}

}
