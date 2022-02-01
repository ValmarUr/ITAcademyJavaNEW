package n2abstractfactory;

public abstract class AddressEntry extends AgendaEntry {

	private String streetType;
	private String street;
	private String doorNum;
	private String city;
	private String region;
	private String zipCode;
	private String country;
	
	public AddressEntry() {}
	
	public AddressEntry(String name, String lastName, String streetType, String street, String doorNum, String city,
			String region, String zipCode) {
		super(name, lastName);
		this.streetType = streetType;
		this.street = street;
		this.doorNum = doorNum;
		this.city = city;
		this.region = region;
		this.zipCode = zipCode;
	}

	
	public String getStreetType() {
		return streetType;
	}
	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	public String getDoorNum() {
		return doorNum;
	}
	public void setDoorNum(String doorNum) {
		this.doorNum = doorNum;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
