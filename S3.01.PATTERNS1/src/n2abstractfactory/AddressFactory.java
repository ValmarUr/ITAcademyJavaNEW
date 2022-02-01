package n2abstractfactory;

public class AddressFactory extends FabricaAbstracta {

	public AgendaEntry getEntry(Country country) {
		
		switch (country) {
			case SPAIN:
				return new AddressSpa();
			case USA:
				return new AddressUSA();
			case JAPAN:
				return new AddressJap();
			case AUSTRALIA:
				return new AddressAus();
			case EGYPT:
				return new AddressEgy();
		}
		
		return null;
	}

}
