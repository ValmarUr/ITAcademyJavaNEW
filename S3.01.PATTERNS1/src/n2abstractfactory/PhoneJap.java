package n2abstractfactory;

public class PhoneJap extends PhoneEntry {

	public PhoneJap() {
		
		super.setPhonePrefix("+81");
		super.setCountry("Japó");
	}
	
	public PhoneJap(String name, String lastName, String phoneNumber) {
		
		super(name, lastName, phoneNumber);
		super.setPhonePrefix("+81");
		super.setCountry("Japó");
	}
	
	
	public void countryFormat() {
		
		System.out.println(
				"\nJapan Phone Format" +
				"\nNom: " + super.getName() + " " + super.getLastName() +
				"\nTelf: " + super.getPhonePrefix() + " " + super.getPhoneNumber() + "\t\t" + super.getCountry());
	}
	
}
