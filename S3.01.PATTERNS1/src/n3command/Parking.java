package n3command;

import java.util.ArrayList;
import java.util.List;

public class Parking {
	
	private List<Vehicle> parking;  
	
	public Parking() {
		parking = new ArrayList<>();
	}
	
	public List<Vehicle> getList() {
		return this.parking;
	}

}
