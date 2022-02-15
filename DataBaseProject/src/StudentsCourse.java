
public class StudentsCourse {
	
	private Student student;
	private Course course;
	
	
	public StudentsCourse () {
		
	}
	public StudentsCourse (Student student,Course course) {
		setStudent(student);
		setCourse(course);
		
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		
		return student.toString() +"\n"+course.toString() ;
	}
	
	

}
