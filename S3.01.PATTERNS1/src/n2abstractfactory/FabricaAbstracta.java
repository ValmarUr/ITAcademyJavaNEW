package n2abstractfactory;


public abstract class FabricaAbstracta {
	
	public static FabricaAbstracta getFactory(AgendaType agendaType) {
		
		switch(agendaType) {
			case TELF : {
				return new PhoneFactory();
			}
			case DIR : {
				return new AddressFactory();
			}
			default : {
				return null;	
			}
		}
	}
	
	public abstract AgendaEntry getEntry(Country country);
}