import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Student> students= new ArrayList<Student>();
		 ResultSet rs;
		 
		 try {
			
				 String dbUrl = "jdbc:mysql://localhost:3306/School";
				 Connection conn =  DriverManager.getConnection(dbUrl, "root", "o1m2r3i4O1M2R3I4");;
				 ConnectionToDataBase c = new ConnectionToDataBase(conn,dbUrl);
				 rs=c.getStudentFromData();
				 
				 
			     while (rs.next()) {
			          System.out.print(rs.getString("FirstName") +" ");
			          
			          System.out.println(rs.getString("LastName"));
			        }
			
		 }
		 catch (Exception e) {
			 
			 System.out.println(e.getMessage());
			
		}
		 
		

	}

}
