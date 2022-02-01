package n2abstractfactory;

public class PhoneAus extends PhoneEntry {

	public PhoneAus() {
		
		super.setPhonePrefix("+61");
		super.setCountry("Australia");
	}
	
	public PhoneAus(String name, String lastName, String phoneNumber) {
		
		super(name, lastName, phoneNumber);
		super.setPhonePrefix("+61");
		super.setCountry("Australia");
	}
	
	
	public void countryFormat() {
		
		System.out.println(
				"\nAustralia Phone Format" +
				"\nNom: " + super.getName() + " " + super.getLastName() +
				"\nTelf: " + super.getPhonePrefix() + " " + super.getPhoneNumber() + "\t\t" + super.getCountry());
	}
	
}
