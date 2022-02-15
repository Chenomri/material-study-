import javax.naming.AuthenticationException;

public class Course {

	private int courseId;
	private String courseNum;
	private Teacher teacher;
	private Grade grade ;
	int dayInWeek;
	int dayInHour;
	
	public Course (int courseId,String courseName,Teacher teacher,Grade grade,int dayInWeek,int dayInHour) {
	setCourseId(courseId);	
	setCourseName(courseName);
	setTeacher(teacher);
	setGrade(grade);
	setDayInWeek(dayInWeek);
	setDayInHour(dayInHour);
	}
	
	public Course() {
		
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

	public int getDayInWeek() {
		return dayInWeek;
	}

	public void setDayInWeek(int dayInWeek) {
		this.dayInWeek = dayInWeek;
	}

	public int getDayInHour() {
		return dayInHour;
	}

	public void setDayInHour(int dayInHour) {
		this.dayInHour = dayInHour;
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
				"At "+dayInHour+"o'clock";
	}
	
	
	
}
