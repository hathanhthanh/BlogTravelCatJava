package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import utils.MySQLConnection;
import beans.Blog;
import beans.Location;

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
			sql = sql
					+ "SELECT blogs.Blog_ID, blogs.Title, blogs.Content, blogs.Publish_Date, blogs.Last_Edit, blogs.Status, blogs.UserName, blogs.Local_ID, locations.Name, locations.Address, images.Image_BlogID, images.Image_Name, images.Url FROM blogs ";
			sql = sql
					+ "JOIN locations ON blogs.Local_ID = locations.Local_ID JOIN images ON blogs.Blog_ID = images.Image_BlogID ";
			sql = sql
					+ "WHERE blogs.Status = ? AND blogs.UserName = ? ORDER BY blogs.Publish_Date DESC";

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

	public boolean insertBlog(Blog blog){
		String sql = "Insert into blogs(Title,Content,Publish_Date,Last_Edit,Status,Local_ID,UserName) value(?,?,?,?,?,?,?)";
		Connection conn = MySQLConnection.getMySQLConnection();
		if (conn == null) {
			return false;
		}
		ResultSet rs = null;
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(sql);
			int index = 1;
				st.setString(index++, blog.getTitle());
				st.setString(index++, blog.getContents());
				st.setDate(index++, blog.getPublish_Date());
				st.setDate(index++, blog.getLast_Edit());
				st.setInt(index++, blog.getStatus());				
				st.setInt(index++, blog.getLocal_ID());
				st.setString(index++, blog.getUserName());
				st.executeUpdate();
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		 
	}

	public static void main(String[] args) {
		Blog blog = new Blog();
		blog.setTitle("a");
		blog.setContents("aaaa");
		blog.setLocal_ID(1);
		blog.setUserName("Thanh");
		Date publish_Date = new java.sql.Date(Calendar.getInstance().getTime()
				.getTime());
		blog.setPublish_Date(publish_Date);
		blog.setLast_Edit(publish_Date);
		blog.setStatus(0);
		/*if(insertBlog(blog)){
			System.out.println("ok");
		}*/
	}
}
