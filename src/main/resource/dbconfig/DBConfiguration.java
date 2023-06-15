package dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConfiguration {

	public static void main(String arg[]) throws Exception {

		// Registering jdbc driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish connection to the db using url,username and password
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDetails", "root",
				"Srikanth@kk42");
		// Create statement object using connection object
		Statement stmt = conn.createStatement();
	
		// execute query and get resultset
		ResultSet rs = stmt.executeQuery("select * from UserCredentials");
		// iterate result set to get column values
		while (rs.next()) {
			String username = rs.getString("username");
			String userpassword = rs.getString("userpassword");
			System.out.println(username + " " + userpassword);
		}

	}

}
