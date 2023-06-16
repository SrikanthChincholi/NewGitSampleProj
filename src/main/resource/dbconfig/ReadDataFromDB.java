package dbconfig;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class ReadDataFromDB {
	
	private String userlocation;
	private String useroccupation;
	private String userage;
	private String username;
	private String password;
	
	public String getUserage() {
		return userage;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserage(String userage) {
		this.userage = userage;
	}
	public String getUserlocation() {
		return userlocation;
	}
	public void setUserlocation(String userlocation) {
		this.userlocation = userlocation;
	}
	public String getUseroccupation() {
		return useroccupation;
	}
	public void setUseroccupation(String useroccupation) {
		this.useroccupation = useroccupation;
	}
	
	
	
	
	

}
