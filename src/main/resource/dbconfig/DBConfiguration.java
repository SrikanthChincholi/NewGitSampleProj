package dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

public class DBConfiguration {
	
	static ReadDataFromDB readdata;

	public static List<ReadDataFromDB> getDataFromDB() throws Exception {

		List<ReadDataFromDB> data = new ArrayList<ReadDataFromDB>();

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
			readdata = new ReadDataFromDB();
			readdata.setUserlocation(rs.getString("userlocation"));
			readdata.setUseroccupation(rs.getString("useroccupation"));
			readdata.setUserage(rs.getString("userage"));
			readdata.setUsername(rs.getString("username"));
			readdata.setPassword(rs.getString("userpassword"));
			data.add(readdata);//admin // admin123 - row1 with object readdata
			
		}
		return data;
		
	}

}
