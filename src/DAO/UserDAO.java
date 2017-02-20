package DAO;


import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import utils.MySQLConnection;
import beans.UserAccount;

public class UserDAO {
	
	public UserAccount getUser(String username) {
		UserAccount ret = null; // result
		
		//TODO: get connection
		Connection conn = MySQLConnection.getMySQLConnection();
		if(conn == null) {
			return ret;
		}
		
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
//			String query = "SELECT * FROM ";
//			st = conn.prepareStatement(query);
//			st.setInt(parameterIndex, x);
//			rs = st.executeQuery();
//			if(rs.next()) {
//				ret = new UserAccount(rs);
//				
//			}
 		} catch(Exception ex) {
 			
 		} finally {
 			//TODO: close rs, close st
 			//TODO: close conn
 		}
		
		
		return ret;
	}
}
