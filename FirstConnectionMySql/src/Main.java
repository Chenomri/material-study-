
import java.sql.*;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = null;

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			

			String dbUrl = "jdbc:mysql://localhost:3306/School";//<---------

			conn = DriverManager.getConnection(dbUrl, "omriyosef", "o1m2r3i4O1M2R3I4");//<---
			

	        Statement stmt = conn.createStatement();
	        
	        int paswword ;
	        String name = "1=1";
				 
	        ResultSet rs = stmt.executeQuery("SELECT actor_id , first_name FROM omri4");
	        
		

	       while (rs.next()) {
	          System.out.println(rs.getInt("actor_id") + "- " + rs.getString("first_name"));
	        }

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		



	}

}
