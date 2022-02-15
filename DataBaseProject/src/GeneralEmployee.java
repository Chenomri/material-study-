
public class GeneralEmployee extends Person {
	private String jobType;
	private double salary;
	
	public GeneralEmployee() {
		super();
	}	
	public GeneralEmployee(int id, String firstName, String lastName, int yearOfBirth, String city ,String jobType,double salary) {
	super(id, firstName, lastName, yearOfBirth, city);
	setJobType(jobType);
	setSalary(salary);

}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() +"\n your job type is: " +jobType+"\n your salary is: "+salary+"\n" ;
	}
}