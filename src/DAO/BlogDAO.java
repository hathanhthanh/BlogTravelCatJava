package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.MySQLConnection;
import beans.Blog;

public class BlogDAO {
	public List<Blog> getBlog(String UserName) throws SQLException {
		List<Blog> ret = new ArrayList<Blog>();// result
		// TODO: connection database
		Connection conn = MySQLConnection.getMySQLConnection();
		if (conn == null) {
			return null;
		}
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			
			String sql = "";
			sql  =sql + "SELECT blogs.Blog_ID, blogs.Title, blogs.Content, blogs.Publish_Date, blogs.Last_Edit, blogs.Status, blogs.UserName, blogs.Local_ID, locations.Name, locations.Address, images.Image_BlogID, images.Image_Name, images.Url FROM blogs ";
			sql  =sql + "JOIN locations ON blogs.Local_ID = locations.Local_ID JOIN images ON blogs.Blog_ID = images.Image_BlogID ";
			sql= sql + "WHERE blogs.Status = ? AND blogs.UserName = ? ORDER BY blogs.Publish_Date DESC";

;
			st = conn.prepareStatement(sql);
			// int index = 1;
			st.setInt(1, 0);
			st.setString(2, UserName);
			rs = st.executeQuery();
			while (rs.next()) {
				Blog bl = new Blog(rs);
				ret.add(bl);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			conn.close();
		}
		return ret;
	}
}
