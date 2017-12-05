package selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Access MySQL database - connect to database and query from a table
public class databaseDemo {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		// Set up database prerequisite
		String host = "localhost";
		String port = "3306";
		Class.forName("com.mysql.jdbc.Driver");

		// Connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root", "shlok");

		Statement stmt = conn.createStatement();

		// Execute query
		ResultSet rs = stmt.executeQuery("select * from employee where name = 'kunti'");

		while (rs.next()) {
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("id"));
		}
	}

}
