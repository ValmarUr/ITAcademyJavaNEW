package n2abstractfactory;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
	
	protected List<AddressEntry> addressList = new ArrayList<>();
	protected List<PhoneEntry> phoneList = new ArrayList<>();
	protected FabricaAbstracta addressFactory = FabricaAbstracta.getFactory(AgendaType.DIR);
	protected FabricaAbstracta phoneFactory = FabricaAbstracta.getFactory(AgendaType.TELF);
	
	//protected static 
	
	public void run() {
		
		int option = -1;
		
		do {
			introAgenda();
			String command = Lector.leer();
			
			try {
				option = Integer.parseInt(command);	
			}catch(Exception e) {
				System.out.println("Opció NO valida. Si us plau, introdueix el número corresponent. (0-5)");
				continue;
			}

			switch(option) {
				case 1: addAddress(countryMenu());
						break;
				case 2: addPhone(countryMenu());
						break;
				case 3: getAddressList().stream().forEach(AddressEntry::countryFormat);
						//getAddressList().stream().forEach(System.out::println);
						break;
				case 4: getPhoneList().stream().forEach(PhoneEntry::countryFormat);
						break;
				case 5: loadTrialList();
						break;
				case 0: System.out.println("\nGràcies per utilitzar el nostre gestor. Fins aviat!");
						break;
				default:
						System.out.println("Número fora de rang (0-5)");
						break;
			}
		}while(option!=0);
	}//end run
	
	public void introAgenda() {
		
		System.out.println(
				"\n////////// AGENDA INTERNACIONAL //////////" + 
				"\n                               gestorv0.1"+
				"\n MENU"+
				"\n  1.-Afegir adreça"+
				"\n  2.-Afegir telèfon"+
				"\n  3.-Veure llista adreces"+
				"\n  4.-Veure llista telèfons"+
				"\n  5.-Carregar llistes de mostra"+
				"\n  0.-Sortir");
	}
	
	public Country countryMenu() {
		
		System.out.println(
				"\nTria un pais entre els disponibles:"+
				"\n 1.-Espanya"+
				"\n 2.-USA"+
				"\n 3.-Japó"+
				"\n 4.-Australia"+
				"\n 5.-Egipte");
		
		int option = -1;
		
		while(true){
			String command = Lector.leer();
			
			try {
				option = Integer.parseInt(command);	
			}catch(Exception e) {
				System.out.println("Opció NO valida. Introdueix el número corresponent al país. (1-5)");
				continue;
			}
			
			switch(option) {
				case 1: return Country.SPAIN;
				case 2: return Country.USA;
				case 3: return Country.JAPAN;
				case 4: return Country.AUSTRALIA;
				case 5: return Country.EGYPT;
				default:
					System.out.println("Número fora del rang (1-5)");
			}
		}
	}
	
	public void addAddress(Country country) {
		String name = Lector.leer("Nom: ");
		String lastName = Lector.leer("Cognom: ");
		String streetType = Lector.leer("Tipus de via: ");
		String street = Lector.leer(streetType + ": ");
		String doorNum = Lector.leer("Número: ");
		String city = Lector.leer("Ciutat: ");
		String region = Lector.leer("Provincia: ");
		String zipCode = Lector.leer("Codi Postal: ");
		
		AddressEntry ae = (AddressEntry)addressFactory.getEntry(country);
		ae.setName(name);
		ae.setLastName(lastName);
		ae.setStreetType(streetType);
		ae.setStreet(street);
		ae.setDoorNum(doorNum);
		ae.setCity(city);
		ae.setRegion(region);
		ae.setZipCode(zipCode);
		addressList.add(ae);
		
		System.out.println("\nAdreça afegida correctament!\n");
	}
	
	public void addPhone(Country country) {
		String name = Lector.leer("Nom: ");
		String lastName = Lector.leer("Cognom: ");
		String phoneNumber = Lector.leer("Número de telèfon: ");
		
		PhoneEntry pe = (PhoneEntry)phoneFactory.getEntry(country);
		pe.setName(name);
		pe.setLastName(lastName);
		pe.setPhoneNumber(phoneNumber);
		phoneList.add(pe);
		
		System.out.println("\nTelèfon afegit correctament!\n");
	}
	
	public void loadTrialList() {
		addressList.add(new AddressSpa("Alberto","Rodríguez","Calle","Molino","13","Barcelona","Cataluña","08003"));
		addressList.add(new AddressJap("Kogoro","Mouri","Do","Azabudai","1-9-2","Tokyo-to","Minato-ku","106-0041"));
		addressList.add(new AddressUSA("Ken","Kenmasters","Way","Alpaca","4653","Anaheim","California","92801"));
		addressList.add(new AddressAus("Daven","Smith","Street","Shirley","98","PIMPAMA","QLD","4209"));
		addressList.add(new AddressEgy("Abanoub","Hassan","Street","Elsirgany","13","Abassia","Cairo","14311"));
		
		phoneList.add(new PhoneSpa("Juan Emilio","Fernández","666123456"));
		phoneList.add(new PhoneJap("Musashi","Miyamoto","969778341"));
		phoneList.add(new PhoneUSA("John","Smith","800571823"));
		phoneList.add(new PhoneAus("Dave","Porter","123456789"));
		phoneList.add(new PhoneEgy("Ramses","II","987654321"));
		
	}
	
	public List<AddressEntry> getAddressList(){
		return addressList;
	}
	
	public List<PhoneEntry> getPhoneList(){
		return phoneList;
	}
	
	
}
