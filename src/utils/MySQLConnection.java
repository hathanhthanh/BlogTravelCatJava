package utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class MySQLConnection {
	public static Connection getMySQLConnection() {

		// information connection
		String hostName = "localhost";
		String dbName = "TravelCat";
		String userName = "root";
		String password = "";
		try {
		return getMySQLConnection(hostName, dbName, userName, password);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

	public static Connection getMySQLConnection(String hostName, String dbName,
			String userName, String password) throws SQLException,
			ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://"
				+ hostName
				+ ":3306/"
				+ dbName
				+ "?user=root&password=&useUnicode=true&characterEncoding=Shift_JIS";

		// Connection conn = DriverManager.getConnection(url, userName,
		// password);
		Connection conn = DriverManager.getConnection(url);
		return conn;
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		if (getMySQLConnection() != null) {
			System.out.println("ok");
		}
	}
}
