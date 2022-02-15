
public class Teacher extends Person {

	private double salary;
	private String degree;

	public Teacher() {
		super();
	}

	public Teacher(int id, String firstName, String lastName, int yearOfBirth, String city, double salary,
			String degree) {
		super(id, firstName, lastName, yearOfBirth, city);
		setSalary(salary);
		setDegree(degree);

	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\n your name Degree is: " + degree + "\n your salary is: " + salary + "\n";
	}
}