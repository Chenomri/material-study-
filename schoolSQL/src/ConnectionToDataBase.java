import java.sql.*;

public class ConnectionToDataBase {
	private Connection conn ;
	private String dbUrl;
	private Statement stmt;

	public ConnectionToDataBase(Connection conn, String dbUrl) throws ClassNotFoundException, SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dbUrl=dbUrl;
		this.conn=conn;
		stmt = conn.createStatement();

	}
	
	public boolean addPerson(School s ,Person p)throws SQLException {
		if(!s.checkIfPersonExist(p.getId()))
		{
			String str = "INSERT INTO Person VALUES\n"
					+ "("+p.getId()+",'"+p.getFirstName()+"','"+p.getLastName()+
					"',"+p.getYearOfBirth()+",'"+p.getCity()+"');";
			int rs = stmt.executeUpdate(str);
			if(rs == 1)
				return true;
		}
		return false;
		
	}
	
	public boolean deletePerson(School s ,Person p)throws SQLException {
		if(s.checkIfPersonExist(p.getId()))
		{
			String str = "DELETE FROM Person\n"
					 +"WHERE ID = "+p.getId()+" ;"; 
			int rs = stmt.executeUpdate(str);
			if(rs == 1)
				return true;
		}
		return false;
	}

	public ResultSet getStudentFromData() throws SQLException {
		ResultSet rs = stmt.executeQuery(
						"SELECT student.SID , student.average, person.FirstName, person.LastName , person.YearOfBirth , person.City\n"
						+ "FROM student join person\n" + "where student.SID = person.ID;");
			return rs;
	}
	
	public void addStudentToData(School school ,Student s) throws SQLException {
		if(!school.checkIfStudentExist(s.id))
		{
			if(addPerson(school, s))
			{
				school.addStudent(s);
				String str = "INSERT INTO Student VALUES\n"
						+ "("+s.getId()+","+s.getAverage()+");";
				int rs = stmt.executeUpdate(str);
			}
		}
		else
			System.out.println("Student exist");
	}
	
	public void deleteStudentFromData(School school , int sid)throws SQLException {
		if(school.checkIfStudentExist(sid))
		{
			
			String str = "DELETE From Student\n"
					+ "WHERE SID = "+sid+";";
			int rs = stmt.executeUpdate(str);
			String str2 = "DELETE FROM CoursesStudent\n"
					+"WHERE StudentID = "+sid+";";
			rs = stmt.executeUpdate(str2);
			deletePerson(school, school.getStudentBySID(sid));
			school.deleteStudent(school.getStudentBySID(sid));
		}
		else {
			System.out.println("Student not exist");
		}
	}
	
	public ResultSet getGeneralEmployeeFromData() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT generalEmployee.EID , generalEmployee.workingType, generalEmployee.wage ,person.FirstName, person.LastName , person.YearOfBirth , person.City\n"
				+ "FROM generalEmployee join person\n"
				+ "where generalEmployee.EID = person.ID;");
		return rs;
	}
	
	public void addEmployeeToData(School school ,GeneralEmployee e) throws SQLException {
		if(school.checkIfEmployeeExist(e.getId()))
		{
			if(addPerson(school, e))
			{
				String str = "INSERT INTO generalEmployee VALUES\n"
						+ "("+e.getId()+","+e.getJobType()+","+e.getSalary()+");";
				school.addEmployee(e);
				int rs = stmt.executeUpdate(str);
			}		
		}
		else
			System.out.println("employee exist");
	}
	
	public void deleteEmployeeFromData(School school , int eid)throws SQLException {
		if(school.checkIfEmployeeExist(eid))
		{
			String str = "DELETE FROM generalEmployee\n"
					+"WHERE EID = "+eid+";";
			int rs = stmt.executeUpdate(str);
			 deletePerson(school, school.getEmployeeByID(eid));
			 school.deleteEmployee(school.getEmployeeByID(eid));
		}
		System.out.println("Employee not exist");
	}
	
	public ResultSet getTeacherFromData() throws SQLException {
		ResultSet rs = stmt.executeQuery(
				"SELECT Teacher.TID , Teacher.degree, Teacher.wage ,person.FirstName, person.LastName , person.YearOfBirth , person.City\n"
				+ "FROM Teacher join person\n"
				+ "where Teacher.TID = person.ID;");
		return rs;
	}
	
	public void addTeacherToData(School school , Teacher t) throws SQLException {
		if(!school.checkIfTeacherExistByID(t.getId()))
		{
			if(addPerson(school, t))
			{
				school.addTeacher(t);
				String str = "INSERT INTO Teacher VALUES\n"
						+ "("+t.getId()+","+t.getDegree()+","+t.getSalary()+");";
				int rs = stmt.executeUpdate(str);
			}
		}
		else
			System.out.println("Teacher exist");
	}

	public void deleteTeacherFromData(School school , int tid)throws SQLException{
		if(school.checkIfTeacherExistByID(tid))
		{
			String str = "DELETE FROM Teacher\n"
					+ "WHERE TID = "+tid+";";
			int rs = stmt.executeUpdate(str);
			 deletePerson(school, school.getTeacherByID(tid));
			 school.deleteTeacher(school.getTeacherByID(tid));
		}
		System.out.println("Teacher not exist");
	}
	
	public ResultSet getClassFromData() throws SQLException {
		ResultSet rs = stmt.executeQuery(
				"SELECT *\n"
				+ "FROM class;");
		return rs;
	}
	
	public void addClassToData(School school , Grade g) throws SQLException {
		if(!school.checkIfClassExistByGradeId(g.getClassNume()))
		{
			school.addGrade(g);
			ResultSet rs = stmt.executeQuery(
					"INSERT INTO Class VALUES\n"
					+ "("+g.getClassNume()+","+g.getCapacity()+");");
		}
		else
			System.out.println("Class exist");
	}
	
	public void deleteClassFromData(School school , int gid)throws SQLException{
		if(!school.checkIfClassExistByGradeId(gid))
		{
			
			ResultSet rs = stmt.executeQuery(
					"DELETE FROM Class\n"
					+ "WHERE ClassID = "+gid+";");
			school.deleteGrade(gid);
		}
		System.out.println("Class not exist");
	}
	
	public ResultSet getCoursesFromData() throws SQLException {
		ResultSet rs = stmt.executeQuery(
				"SELECT *\n"
				+ "FROM Courses;");
		return rs;
	}
	
	public void addCourseToData(School school , Course course) throws SQLException {
		if(!school.checkIfCourseExist(course.getCourseId()))
		{
			school.addCourse(course);
			ResultSet rs = stmt.executeQuery(
					"INSERT INTO Courses VALUES\n"
					+ "("+course.getCourseId()+","+course.getCourseName()+","
							+course.getTeacher().getId()+","+course.getGrade().getClassNume()+","+
					course.dayInWeek+","+course.getHour()+");");
		}
		else
			System.out.println("Course exist");
	}
	
	public void deleteCourseFromData (School school , int cid) throws SQLException {
		if(!school.checkIfCourseExist(cid))
		{
			school.deleteCourse(cid);
			ResultSet rs = stmt.executeQuery(
					"DELETE FROM Courses\n"
					+ "WHERE CourseID = "+cid+";");
			rs = stmt.executeQuery(
					"DELETE FROM CoursesStudent\n"
					+ "WHERE CourseID = "+cid+";");
		}
		else
			System.out.println("Course not exist");
	}

	public void addStudentToCourse (School school , int CID , int SID) throws SQLException{
		if(school.checkIfCourseExist(CID) && school.checkIfStudentExist(SID))
		{
			school.addStudentToCourse(CID , SID);
			ResultSet rs = stmt.executeQuery(
					"INSERT INTO CoursesStudent VALUES\n"
					+ "("+CID+","+SID+");");
		}
	}

	public void removeStudentFromCourse (School school , int CID , int SID) throws SQLException{
		if(school.checkIfCourseExist(CID) && school.checkIfStudentExist(SID))
		{
			school.removeStudentToCourse(CID , SID);
			ResultSet rs = stmt.executeQuery(
					"DELETE FROM CoursesStudent\n"
					+ "WHERE CourseID = "+CID + " AND StudentID = "+SID+";");
		}
		
	}
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

}
