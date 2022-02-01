package n2abstractfactory;

public class PhoneSpa extends PhoneEntry {
	
	public PhoneSpa() {
		
		super.setPhonePrefix("+34");
		super.setCountry("Espanya");
	}
	
	public PhoneSpa(String name, String lastName, String phoneNumber) {
		
		super(name, lastName, phoneNumber);
		super.setPhonePrefix("+34");
		super.setCountry("Espanya");
	}
	
	
	public void countryFormat() {
		
		System.out.println(
				"\nSpain Phone Format" +
				"\nNom: " + super.getName() + " " + super.getLastName() +
				"\nTelf: " + super.getPhonePrefix() + " " + super.getPhoneNumber() + "\t\t" + super.getCountry());
	}
	
}
