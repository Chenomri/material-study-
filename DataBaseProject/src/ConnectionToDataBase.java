import java.sql.*;

public class ConnectionToDataBase {
	private Connection conn ;
	private String dbUrl;
	private Statement stmt;

	public ConnectionToDataBase(Connection conn, String dbUrl) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.dbUrl=dbUrl;
		this.conn=conn;
		 stmt = conn.createStatement();

	}

	public ResultSet getStudentFromData() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * \n"
				+ "From Person \n"
				+ "Where FirstName LIKE \"Linoy\"");
			return rs;
		//	"SELECT student.SID , student.average, person.FirstName, person.LastName , person.YearOfBirth , person.City\n"
		///	+ "FROM student join person\n" + "where student.SID = person.ID;"
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
