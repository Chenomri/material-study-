import java.util.Vector;

import javax.naming.AuthenticationException;

public class Course {

	private int courseId;
	private String courseNum;
	private Teacher teacher;
	private Grade grade ;
	String dayInWeek;
	int Hour;
	private Vector< Student >students;
	
	public Course (int courseId,String courseName,Teacher teacher,Grade grade,String day,int dayInHour) {
	setCourseId(courseId);	
	setCourseName(courseName);
	setTeacher(teacher);
	setGrade(grade);
	setDayInWeek(day);
	setDayInHour(dayInHour);
	this.students = new Vector<Student>();
	}
	
	public Course() {
		
	}
	
	

	public Vector<Student> getStudents() {
		return students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getWeek() {
		return dayInWeek;
	}

	public void setDayInWeek(String dayInWeek) {
		this.dayInWeek = dayInWeek;
	}

	public int getHour() {
		return Hour;
	}

	public void setDayInHour(int dayInHour) {
		this.Hour = dayInHour;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseNum;
	}

	public void setCourseName(String courseName) {
		this.courseNum = courseName;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Course)) {
			return false;
		}

		Course tempCourse = (Course) obj;
		if (tempCourse.getCourseId() == courseId) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {

		return "The course ID is: " + courseId + "\n The name course is: " + courseNum + "\n" + "The teacher cours is: " +teacher.getFirstName()+" "+teacher.getLastName()+
		"\n"+"The course in calss Number: "+grade.getClassNume() +"\n"+ " day In Week: "+"dayInWeek"+"\n"+
				"At "+Hour+"o'clock";
	}
	
	public void addStudent (Student s) {
		this.students.add(s);
	}

	public void removeStudent(Student student) {
		this.students.remove(student);
	}
	
	
}
