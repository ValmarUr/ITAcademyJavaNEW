package n2abstractfactory;

public abstract class PhoneEntry extends AgendaEntry {

	private String phoneNumber;
	private String phonePrefix;
	private String country;
	
	public PhoneEntry() {}
	
	public PhoneEntry(String name, String lastName, String phoneNumber) {
		super(name,lastName);
		this.phoneNumber = phoneNumber;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhonePrefix() {
		return phonePrefix;
	}
	public void setPhonePrefix(String phonePrefix) {
		this.phonePrefix = phonePrefix;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public abstract void countryFormat();
}
