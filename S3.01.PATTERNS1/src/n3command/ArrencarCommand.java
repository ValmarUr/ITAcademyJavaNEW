package n3command;

//cocrete command
public class ArrencarCommand implements ICommand {

	private Vehicle vehicle;
	
	public ArrencarCommand(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
	@Override
	public void execute() {
		vehicle.arrencar();
	}

}
