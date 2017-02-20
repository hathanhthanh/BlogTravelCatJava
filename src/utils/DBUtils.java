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

	public static List<Location> queryTravel(Connection conn)
			throws SQLException {
		String sql = "Select * from locations where Status='0' ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Location> list = new ArrayList<Location>();
		while (rs.next()) {
			int local_ID = rs.getInt("Local_ID");
			int parent_ID = rs.getInt("Parent_ID");
			String name = rs.getString("Name");
			String content = rs.getString("Content");
			String address = rs.getString("Address");
			String station = rs.getString("Station");
			Date publish_Date = rs.getDate("Publish_Date");
			Date last_Edit = rs.getDate("Last_Edit");
			int status = rs.getInt("Status");
			Location local = new Location();
			local.setLocal_ID(local_ID);
			local.setParent_ID(parent_ID);
			local.setName(name);
			local.setContent(content);
			local.setAddress(address);
			local.setStation(station);
			local.setPublish_Date(publish_Date);
			local.setLast_Edit(last_Edit);
			local.setStatus(status);
			list.add(local);
		}
		return list;
	}
	public static void insertLocation(Connection conn, Location location) throws SQLException{
		String sql = "Insert into locations(Parent_ID,Name,Content,Address,Station,Publish_Date,Last_Edit,Status) value(?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, location.getParent_ID());
		pstm.setString(2, location.getName());
		pstm.setString(3, location.getContent());
		pstm.setString(4, location.getAddress());
		pstm.setString(5, location.getStation());
		pstm.setDate(6,location.getPublish_Date());
		pstm.setDate(7,  location.getLast_Edit());
		pstm.setInt(8, location.getStatus());		
		pstm.executeUpdate();	
	}
	public static Location findLocation(Connection conn, int Local_ID) throws SQLException{
		String sql ="Select * from locations where Local_ID=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1,Local_ID);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){
			int local_ID = rs.getInt("Local_ID");
			int parent_ID = rs.getInt("Parent_ID");
			String name = rs.getString("Name");
			String content = rs.getString("Content");
			String address = rs.getString("Address");
			String station = rs.getString("Station");
			Date publish_Date = rs.getDate("Publish_Date");
			Date last_Edit = rs.getDate("Last_Edit");
			int status = rs.getInt("Status");
			Location local = new Location();
			local.setLocal_ID(local_ID);
			local.setParent_ID(parent_ID);
			local.setName(name);
			local.setContent(content);
			local.setAddress(address);
			local.setStation(station);
			local.setPublish_Date(publish_Date);
			local.setLast_Edit(last_Edit);
			local.setStatus(status); 
			return local;
		}		
		return null;
	}
	public static void updateLocaltion(Connection conn, Location location) throws SQLException{
		String sql = "Update locations set Name =?, Content =?, Address =?, Station=?, Last_Edit=? where Local_ID =?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		//pstm.setInt(1, location.getParent_ID());
		pstm.setString(1, location.getName());
		pstm.setString(2, location.getContent());
		pstm.setString(3, location.getAddress());
		pstm.setString(4, location.getStation());		
		pstm.setDate(5,  location.getLast_Edit());
		// id
		pstm.setInt(6, location.getLocal_ID());
		//pstm.setInt(8, location.getStatus());	
		pstm.executeUpdate();	
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
