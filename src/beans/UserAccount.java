package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccount {
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	 public UserAccount() {
	        
	   }
	 
	 public UserAccount(ResultSet rs) throws SQLException {
		 userName = rs.getString("username");
		 //...
	 }
    
}
