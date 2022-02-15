import javax.naming.event.NamespaceChangeListener;

public class Person {
	protected int id;
	protected String FirstName;
	protected String LastName;
	protected int YearOfBirth;
	protected String city;

	public Person() {
	}

	
	public Person(int id, String firstName, String lastName, int yearOfBirth, String city) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setYearOfBirth(yearOfBirth);
		setCity(city);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getYearOfBirth() {
		return YearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		YearOfBirth = yearOfBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) {
			return false;
		}

		Person temPerson = (Person) obj;
		if (id == temPerson.getId()) {
			return true;
		}

		return false;
	}
	
	@Override
	public String toString() {
	return "Your ID is: "+id+"\n Your First name is: "+FirstName +"\n Your Last name is: "+LastName+
			"\n Your year Of birth is :"+YearOfBirth+"\n  You living in :" +city+"\n";
	}

}
