package n2abstractfactory;

public class AddressUSA extends AddressEntry {

	public AddressUSA() {
		
		super.setCountry("USA");
	}
	
	public AddressUSA(String name, String lastName, String streetType, String street, String doorNum, String city,
			String region, String zipCode) {
		super(name, lastName, streetType, street, doorNum, city, region, zipCode);
		super.setCountry("USA");
	}
	
	
	public void countryFormat() {
		
		System.out.println(
				"\nUSA Address Format" +
				"\nNom: " + super.getName() + " " + super.getLastName() +
				"\nAdreça: " + super.getStreetType() + " " + super.getStreet() + " nº" + super.getDoorNum() +  
				"\n" + super.getCity() + "(" + super.getRegion() + ")" + 
				"\n" + super.getZipCode() + "\t\t" + super.getCountry());
	}
	
}
