/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 3.Patterns
 * 		Tasca S3.01.Patterns 1
 * 		Nivell 3
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package n3command;

import java.util.List;

//client
public class Main {

	public static void main(String[] args) {
	
		Parking parking = new Parking();
		omplirParking(parking.getList());
		
		Pilot pilot = new Pilot();
		
		//command individual
		ICommand arrencarCommand = new ArrencarCommand(parking.getList().get(0));
		pilot.execute(arrencarCommand);
		
		System.out.println("--------------------------------------------------");
		
		//command a tots els vehicles del parking
		for(Vehicle vehicle : parking.getList()) {
			arrencarCommand = new ArrencarCommand(vehicle);
			pilot.execute(arrencarCommand);
		}
		
		System.out.println("--------------------------------------------------");

		//resta de commands a tots els vehicles
		for(Vehicle vehicle : parking.getList()) {
			ICommand accelerarCommand = new AccelerarCommand(vehicle);
			pilot.execute(accelerarCommand);
		}
		
		System.out.println("--------------------------------------------------");
		
		for(Vehicle vehicle : parking.getList()) {
			ICommand frenarCommand = new FrenarCommand(vehicle);
			pilot.execute(frenarCommand);
		}
		
	}


	public static void omplirParking(List<Vehicle> parking) {
		Avio avio = new Avio();
		Bicicleta bicicleta = new Bicicleta();
		Cotxe cotxe = new Cotxe();
		Vaixell vaixell = new Vaixell();
		
		parking.add(avio);
		parking.add(bicicleta);
		parking.add(cotxe);
		parking.add(vaixell);
	}
	
}
