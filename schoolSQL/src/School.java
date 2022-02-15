import java.util.Vector;

public class School {
	private Vector<Person> persons;
	private Vector<Student> students;
	private Vector<GeneralEmployee> employees;
	private Vector<Teacher> teachers;
	private Vector<Grade> grades; ///class
	private Vector<Course> courses;

	public School() {
		this.persons = new Vector<Person>();
		this.students = new Vector<Student>();
		this.employees = new  Vector<GeneralEmployee>();
		this.teachers =  new Vector<Teacher> ();
		this.grades = new Vector<Grade>();
		this.courses =  new Vector<Course> ();
	}
	
	

	public Vector<Grade> getGrades() {
		return grades;
	}



	public Vector<Teacher> getTeachers() {
		return teachers;
	}



	public boolean checkIfPersonExist(int PID) {
		for (Person p : this.persons) {
			if(p.getId() == PID)
				return true;
		}
		return false;
	}

	public boolean checkIfStudentExist(int SID) {
		for (Student s : this.students) {
			if(SID == s.getId())
				return true;
		}
		return false;
	}

	public void addStudent(Student s) {
		this.students.add(s);
		this.persons.add(s);
	}

	public void deleteStudent(Student s) {
		for (Course course : courses) {
			if(course.getStudents().contains(s))
				course.getStudents().remove(s);
		}
		this.students.remove(s);
		this.persons.remove(s);
	}

	public Student getStudentBySID(int SID) {
		for (Student s : this.students) {
			if(SID == s.getId())
				return s;
		}
		return null;
	}

	public boolean checkIfEmployeeExist(int EID) {
		for (GeneralEmployee e : this.employees) {
			if(EID == e.getId())
				return true;
		}
		return false;
	}

	public void addEmployee(GeneralEmployee e) {
		this.employees.add(e);
		this.persons.add(e);
	}

	public GeneralEmployee getEmployeeByID(int EID) {
		for (GeneralEmployee e : this.employees) {
			if(EID == e.getId())
				return e;
		}
		return null;
	}

	public void deleteEmployee(GeneralEmployee e) {
		this.employees.remove(e);
		this.persons.remove(e);
	}


	public boolean checkIfTeacherExistByID(int TID) {
		for (Teacher t : this.teachers) {
			if(t.getId() == TID)
				return true;
		}
		return false;
	}


	public void addTeacher(Teacher t) {
		this.teachers.add(t);
		this.persons.add(t);
	}


	public Teacher getTeacherByID(int TID) {
		for (Teacher t : this.teachers) {
			if(t.getId() == TID)
				return t;
		}
		return null;
	}

	public void deleteTeacher(Teacher t) {
		this.teachers.remove(t);
		this.persons.remove(t);
	}

	public boolean checkIfClassExistByGradeId(int classNume) {
		for (Grade g : this.grades) {
			if(g.getClassNume() == classNume)
				return true;
		}
		return false;
	}

	public void addGrade(Grade g) {
		this.grades.add(g);
	}

	public void deleteGrade(int gid) {
		for (Grade g : this.grades) {
			if(g.getClassNume() == gid)
			{
				this.grades.remove(g);
				return;
			}
		}
	}

	public boolean checkIfCourseExist(int CID) {
		for (Course c : courses) {
			if(c.getCourseId() == CID)
				return true;
		}
		return false;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public void deleteCourse(int cid) {
		for (Course course : courses) {
			if(course.getCourseId() == cid)
			{
				this.courses.remove(course);
				return;
			}
		}
		
	}

	
	public void addStudentToCourse(int cID, int sID) {
		getCourseBYID(cID).addStudent(getStudentBySID(sID));
	}
	public Course getCourseBYID(int CID) {
		for (Course course : courses) {
			if(course.getCourseId() == CID)
				return course;
		}
		return null;
	}

	public void removeStudentToCourse(int cID, int sID) {
		getCourseBYID(cID).removeStudent(getStudentBySID(sID));
		
	}

	public Grade getGradeByID(int classID) {
		for (Grade g : this.grades) {
			if(g.getClassNume() == classID)
				return g;
		}
		return null;
	}
	
	

	
	
	

}
