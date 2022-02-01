package n2abstractfactory;

public class AddressAus extends AddressEntry {

	public AddressAus() {
		
		super.setCountry("Australia");
	}
	
	public AddressAus(String name, String lastName, String streetType, String street, String doorNum, String city,
			String region, String zipCode) {
		super(name, lastName, streetType, street, doorNum, city, region, zipCode);
		super.setCountry("Australia");
	}
	
	
	public void countryFormat() {
		
		System.out.println(
				"\nAustralia Address Format" +
				"\nNom: " + super.getName() + " " + super.getLastName() +
				"\nAdreça: " + super.getStreetType() + " " + super.getStreet() + " nº" + super.getDoorNum() +  
				"\n" + super.getCity() + "(" + super.getRegion() + ")" + 
				"\n" + super.getZipCode() + "\t\t" + super.getCountry());
	}
	
}
