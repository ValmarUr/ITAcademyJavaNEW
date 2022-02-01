package n3command;

//cocrete command
public class AccelerarCommand implements ICommand {

	private Vehicle vehicle;
	
	public AccelerarCommand(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	
	@Override
	public void execute() {
		vehicle.accelerar();
	}

}
