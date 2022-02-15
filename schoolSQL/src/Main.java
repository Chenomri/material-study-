import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet.ColorAttribute;

import com.mysql.cj.protocol.Warning;
import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

public class Main {
	private static School school;
	public static ConnectionToDataBase connection;
	
	public static void readStudents(ResultSet rs) throws SQLException {
		while (rs.next()) {
			 int SID = rs.getInt("SID");
			 int ave = rs.getInt("average");
			 String firstName = rs.getString("FirstName");
			 String lastName = rs.getString("LastName");
			 int year = rs.getInt("YearOfBirth");
			 String city = rs.getString("City");
			 Student s =  new Student(SID , firstName ,lastName , year , city ,ave);
			 school.addStudent(s);
		 }
	}
	
	public static void readEmployees(ResultSet rs)throws SQLException{
		while (rs.next()) {
			 int EID = rs.getInt("EID");
			 String workingType = rs.getString("workingType");
			 int wage = rs.getInt("wage");
			 String firstName = rs.getString("FirstName");
			 String lastName = rs.getString("LastName");
			 int year = rs.getInt("YearOfBirth");
			 String city = rs.getString("City");
			 GeneralEmployee e = new GeneralEmployee(EID , firstName , lastName , year ,city ,workingType ,wage);
			 school.addEmployee(e);
		 }
	}
	
	public static void readTeacher (ResultSet rs) throws SQLException{
		while (rs.next()) {
			 int TID = rs.getInt("TID");
			 String degree = rs.getString("degree");
			 int wage = rs.getInt("wage");
			 String firstName = rs.getString("FirstName");
			 String lastName = rs.getString("LastName");
			 int year = rs.getInt("YearOfBirth");
			 String city = rs.getString("City");
			 GeneralEmployee t = new GeneralEmployee(TID , firstName , lastName , year ,city ,degree ,wage);
			 school.addEmployee(t);
		 }
	}
	
	public static void readGrade (ResultSet rs) throws SQLException{
		while (rs.next()) {
			 int ClassID = rs.getInt("ClassID");
			 int Capacity = rs.getInt("Capacity");
			 Grade g = new Grade(ClassID , Capacity);
			 school.addGrade(g);
		 }
	}
	
	public static void readCourses (ResultSet rs) throws SQLException{
		while (rs.next()) {
			 int CoursesID = rs.getInt("CourseID");
			 String CourseName = rs.getString("CourseName");
			 int TID = rs.getInt("TID");
			 int ClassID = rs.getInt("ClassID");
			 String day = rs.getString("DayINWeek");
			 int hour = rs.getInt("HourINDay");
			 Course c = new Course(CoursesID, CourseName , school.getTeacherByID(TID) 
					 , school.getGradeByID(ClassID) , day ,hour );
			 school.addCourse(c);
		 }
	}
	
	public static String getMessegjOP(String s) {
		return JOptionPane.showInputDialog(null ,s,"DataBase",JOptionPane.QUESTION_MESSAGE);
	//	f,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE
	
	}
	
	public static void showMesseg(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
	
	private static String getDay(int day) {
		if(day == 1)
			return "Sunday";
		else if (day == 2)
			return "Monday";
		else if (day == 3)
			return "Tuesday";
		else if (day == 4)
			return "Wednesday";
		else if(day == 5)
			return "Thursday";
		else if (day == 6)
			return "Friday";
		else
			return "Saturday";
	}
	
	public static Person getPerson() {
		int id = Integer.parseInt(getMessegjOP("Enter ID"));
		String name = getMessegjOP("Enter first name");
		String last = getMessegjOP("Enter Last name");
		int year = Integer.parseInt(getMessegjOP("Enter year of birth"));
		String city = getMessegjOP("Enter city");
		Person p = new Person(id, name, last, year, city);
		return p;
	}
	
	public static void main(String[] args) {
		Connection conn = null;
		
		 try {
			 school = new School();
			 String dbUrl = "jdbc:mysql://localhost:3306/School";
			 conn =  DriverManager.getConnection(dbUrl, "root", "o1m2r3i4O1M2R3I4");;
			 connection = new ConnectionToDataBase(conn,dbUrl);
			
			 readStudents(connection.getStudentFromData());
			 readEmployees(connection.getGeneralEmployeeFromData());
			 readTeacher(connection.getTeacherFromData());
			 readGrade(connection.getClassFromData());
			 readCourses(connection.getCoursesFromData());
			 
			
		 }
		 catch (Exception e) {
			 
			 System.out.println(e.getMessage());
			
		 }
		 
		 String userResult;
			int userResultInt;
			boolean flag = true;
			boolean flag1 = true;

			while (flag1) {

				try {

					do {
						userResult = getMessegjOP("Please choice option: \n" + "1) add/remove Student \n"
								+ "2) add/remove General employee  \n" + "3) add/remove Teacher \n"
								+ "4) add/remove Coures \n" + "5) add/remove Class\n"
								+ "6) add/remove Student From Course \n"+"7) Exit \n");

						userResultInt = Integer.parseInt(userResult);
						if (userResultInt <= 7 || userResultInt < 0) {
							flag = false;

						}
						else {
							
							;}	
						
						
					}

					while (flag);
					{
						switch (userResultInt) {
						case 1: {
							int res = Integer.parseInt(getMessegjOP("1 - add student\nAnything - to remove"));
							if(res == 1) {
								Person p = getPerson();
								int ave = Integer.parseInt(getMessegjOP("Enter average"));
								Student s = new Student(p.getId(), p.getFirstName(), p.getLastName()
										, p.getYearOfBirth(), p.getCity(), ave);
								connection.addStudentToData(school , s);
								
							}
							else {
								int sid = Integer.parseInt(getMessegjOP("Enter SID to delete"));
								connection.deleteStudentFromData(school, sid);
							}
							break;
						}
						case 2: {
							int res = Integer.parseInt(getMessegjOP("1 - add Employee\nAnything - to remove"));
							if (res == 1) {
								Person p = getPerson();
								String job = getMessegjOP("Enter job type");
								int salary = Integer.parseInt(getMessegjOP("Enter wage"));
								GeneralEmployee e = new GeneralEmployee(p.getId(), p.getFirstName(),
										p.getLastName(), p.getYearOfBirth(), p.getCity(), job, salary);
								connection.addEmployeeToData(school, e);
							}
							else{
								int eid = Integer.parseInt(getMessegjOP("Enter EID to delete"));
								connection.deleteStudentFromData(school, eid);
							}
							break;
						}
						case 3: {
							int res = Integer.parseInt(getMessegjOP("1 - add Teacher\nAnything - to remove"));
							if (res == 1) {
								Person p = getPerson();
								int degree =  Integer.parseInt(getMessegjOP("Enter degree\n1-BA\n2-Master degre"));
								int salary = Integer.parseInt(getMessegjOP("Enter wage"));
								String deg;
								if(degree == 1){
									deg = "BA";
								}
								else{
									deg = "Master degre";
								}
								Teacher t = new Teacher(p.getId(), p.getFirstName(),
										p.getLastName(), p.getYearOfBirth(), p.getCity(), salary ,deg);
								connection.addTeacherToData(school, t);
							}
							else{
								int tid = Integer.parseInt(getMessegjOP("Enter TID to delete"));
								connection.deleteTeacherFromData(school, tid);
							}
							break;
						}
						case 4: {
							int res = Integer.parseInt(getMessegjOP("1 - add Course\nAnything - to remove"));
							if(res == 1) {
								int courseID = Integer.parseInt(getMessegjOP("Enter courseID"));
								String name = getMessegjOP("Enter course name");
								Teacher t = school.getTeacherByID(Integer.parseInt(getMessegjOP("Enter TID")));
								Grade g = school.getGradeByID(Integer.parseInt(getMessegjOP("Enter ClassID")));
								int day = Integer.parseInt(getMessegjOP("Enter num between 1-7"));
								String dayInWeek = getDay(day);
								int hour;
								do
								{
									hour = Integer.parseInt(getMessegjOP("Enter hour 1-24"));
								}while (hour < 0 | hour > 24);
								Course c = new Course(courseID , name , t , g ,dayInWeek , hour);
								connection.addCourseToData(school, c);
							}
							else {
								int CourseID = Integer.parseInt(getMessegjOP("Enter CourseID to delete"));
								connection.deleteTeacherFromData(school, CourseID);
							}
						}
						case 5: {
							int res = Integer.parseInt(getMessegjOP("1 - add Class\nAnything - to remove"));
							if(res == 1) {
								int classNum = Integer.parseInt(getMessegjOP("Enter Class Number"));
								int classCap = Integer.parseInt(getMessegjOP("Enter class capacity"));
								Grade g = new Grade(classNum, classCap);
								connection.addClassToData(school, g);
							}
							else {
								int cid = Integer.parseInt(getMessegjOP("Enter ClassID to delete"));
								connection.deleteClassFromData(school, cid);
							}
							break;
						}
						case 6: {
							int StudenId = Integer.parseInt(getMessegjOP("Enter student ID"));
							int CourseId = Integer.parseInt(getMessegjOP("Enter course ID"));
							int res = Integer.parseInt(getMessegjOP("1 - add student to course\nAnything - to remove"));
							if(res == 1) {
								connection.addStudentToCourse(school, CourseId, StudenId);
							}
							else
							{
								connection.removeStudentFromCourse(school, CourseId, StudenId);
							}
							break;
						}
						case 7: {
							showMesseg("bay bay :)");;
										flag1 = false;
										break;

						}

						
						}
						
					}
				} catch (Exception e) {
					showMesseg("something go worng , try select option between [1-7]");

				}
			}
		}

	
	}
		 
		 
		 
		 
		