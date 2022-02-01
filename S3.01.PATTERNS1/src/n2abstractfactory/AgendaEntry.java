package n2abstractfactory;

public abstract class AgendaEntry {

	private String name;
	private String lastName;
	
	public AgendaEntry() {}
	
	public AgendaEntry(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public abstract void countryFormat();
}