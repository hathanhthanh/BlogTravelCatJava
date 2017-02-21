package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.MySQLConnection;
import beans.Location;
import beans.UserAccount;

public class LocationDAO {
	public List<Location> getLocations() {
		List<Location> list = new ArrayList<Location>();
		String sql = "Select * from locations where Status='0' ";
		Connection conn = MySQLConnection.getMySQLConnection();
		if (conn == null) {
			return null;
		}
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Location local = new Location(rs);
				list.add(local);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void insertLocation(Connection conn, Location location)
			throws SQLException {
		String sql = "Insert into locations(Parent_ID,Name,Content,Address,Station,Publish_Date,Last_Edit,Status) value(?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, location.getParent_ID());
		pstm.setString(2, location.getName());
		pstm.setString(3, location.getContent());
		pstm.setString(4, location.getAddress());
		pstm.setString(5, location.getStation());
		pstm.setDate(6, location.getPublish_Date());
		pstm.setDate(7, location.getLast_Edit());
		pstm.setInt(8, location.getStatus());
		pstm.executeUpdate();
	}

	public Location findLocation(Connection conn, int Local_ID)
			throws SQLException {
		String sql = "Select * from locations where Local_ID=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, Local_ID);
		ResultSet rs = pstm.executeQuery();
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
			return local;
		}
		return null;
	}

	public void updateLocaltion(Connection conn, Location location)
			throws SQLException {
		String sql = "Update locations set Name =?, Content =?, Address =?, Station=?, Last_Edit=? where Local_ID =?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		// pstm.setInt(1, location.getParent_ID());
		pstm.setString(1, location.getName());
		pstm.setString(2, location.getContent());
		pstm.setString(3, location.getAddress());
		pstm.setString(4, location.getStation());
		pstm.setDate(5, location.getLast_Edit());
		// id
		pstm.setInt(6, location.getLocal_ID());
		// pstm.setInt(8, location.getStatus());
		pstm.executeUpdate();
	}
	
	public static void main (String[] args){
		/*if(getLocations() != null){
			System.out.println("ok");
		}*/
	}
}
