package n2abstractfactory;

public class PhoneFactory extends FabricaAbstracta {

	public AgendaEntry getEntry(Country country) {
		
		switch (country) {
			case SPAIN:
				return new PhoneSpa();
			case USA:
				return new PhoneUSA();
			case JAPAN:
				return new PhoneJap();
			case AUSTRALIA:
				return new PhoneAus();
			case EGYPT:
				return new PhoneEgy();
		}
		
		return null;
	}
	
}
