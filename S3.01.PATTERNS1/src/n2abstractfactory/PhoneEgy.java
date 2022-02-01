package n2abstractfactory;

public class PhoneEgy extends PhoneEntry {

	public PhoneEgy() {
		
		super.setPhonePrefix("+20");
		super.setCountry("Egipte");
	}
	
	public PhoneEgy(String name, String lastName, String phoneNumber) {
		
		super(name, lastName, phoneNumber);
		super.setPhonePrefix("+20");
		super.setCountry("Egipte");
	}
	
	
	public void countryFormat() {
		
		System.out.println(
				"\nEgypt Phone Format" +
				"\nNom: " + super.getName() + " " + super.getLastName() +
				"\nTelf: " + super.getPhonePrefix() + " " + super.getPhoneNumber() + "\t\t" + super.getCountry());
	}
	
}
