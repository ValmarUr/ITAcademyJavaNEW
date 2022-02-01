package n2abstractfactory;

public class AddressJap extends AddressEntry {

	public AddressJap() {
		
		super.setCountry("Japó");
	}
	
	public AddressJap(String name, String lastName, String streetType, String street, String doorNum, String city,
			String region, String zipCode) {
		super(name, lastName, streetType, street, doorNum, city, region, zipCode);
		super.setCountry("Japó");
	}
	
	
	public void countryFormat() {
		
		System.out.println(
				"\nJapan Address Format" +
				"\nNom: " + super.getName() + " " + super.getLastName() +
				"\nAdreça: " + super.getStreetType() + " " + super.getStreet() + " nº" + super.getDoorNum() +  
				"\n" + super.getCity() + "(" + super.getRegion() + ")" + 
				"\n" + super.getZipCode() + "\t" + super.getCountry());
	}
	
}
