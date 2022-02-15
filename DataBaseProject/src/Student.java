
public class Student extends Person {
	private int average;
	public Student() {
		super();
		
	}

	public Student(int id, String firstName, String lastName,int yearOfBirth, String city,  int average) {
		super(id, firstName, lastName, yearOfBirth, city);
		setAverage(average);

	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this. average =  average;
	}

	@Override
	public String toString() {
		return super.toString() + "\n You are in grade number: " +  average+"\n";
	}

}
