package utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.UserAccount;
import beans.Location;

public class DBUtils {
	public static UserAccount findUser(Connection conn, String userName,
			String password) throws SQLException {

		String sql = "Select a.UserName, a.Password from users a "
				+ " where a.UserName = ? and a.Password= ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			UserAccount user = new UserAccount();
			user.setUserName(rs.getString("UserName"));
			user.setPassword(rs.getString("password"));
			return user;
		}
		return null;
	}
	public static UserAccount findUser(Connection conn, String userName)
			throws SQLException {

		String sql = "Select a.UserName, a.Password from users a "
				+ " where a.UserName = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			return user;
		}
		return null;
	}


}
