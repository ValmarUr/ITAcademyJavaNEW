package n2abstractfactory;

public class PhoneUSA extends PhoneEntry {

	public PhoneUSA() {
		
		super.setPhonePrefix("+1");
		super.setCountry("USA");
	}
	
	public PhoneUSA(String name, String lastName, String phoneNumber) {
		
		super(name, lastName, phoneNumber);
		super.setPhonePrefix("+1");
		super.setCountry("USA");
	}
	
	
	public void countryFormat() {
		
		System.out.println(
				"\nUSA Phone Format" +
				"\nNom: " + super.getName() + " " + super.getLastName() +
				"\nTelf: " + super.getPhonePrefix() + " " + super.getPhoneNumber() + "\t\t" + super.getCountry());
	}
	
}
