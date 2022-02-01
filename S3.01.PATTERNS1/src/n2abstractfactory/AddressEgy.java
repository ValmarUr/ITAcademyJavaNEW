package n2abstractfactory;

public class AddressEgy extends AddressEntry {

	public AddressEgy() {
		
		super.setCountry("Egipte");
	}
	
	public AddressEgy(String name, String lastName, String streetType, String street, String doorNum, String city,
			String region, String zipCode) {
		super(name, lastName, streetType, street, doorNum, city, region, zipCode);
		super.setCountry("Egipte");
	}
	
	
	public void countryFormat() {
		
		System.out.println(
				"\nEgypt Address Format" +
				"\nNom: " + super.getName() + " " + super.getLastName() +
				"\nAdreça: " + super.getStreetType() + " " + super.getStreet() + " nº" + super.getDoorNum() +  
				"\n" + super.getCity() + "(" + super.getRegion() + ")" + 
				"\n" + super.getZipCode() + "\t\t" + super.getCountry());
	}
	
}
