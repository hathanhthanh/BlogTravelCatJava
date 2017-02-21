package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import utils.MySQLConnection;
import beans.Blog;
import beans.Image;
import beans.Location;

import com.mysql.jdbc.PreparedStatement;

public class ImageDAO {
	public List<Image> getImage(int local_ID) throws SQLException {
		List<Image> ret = new ArrayList<Image>();// result

		// TODO: get connection
		Connection conn = MySQLConnection.getMySQLConnection();
		if (conn == null) {
			return null;
		}

		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			String query = "SELECT * FROM images where Image_LocalID=?";
			st = (PreparedStatement) conn.prepareStatement(query);
			int parameterIndex = 1;
			st.setInt(parameterIndex, local_ID);
			rs = st.executeQuery();
			while (rs.next()) {
				Image img = new Image(rs);
				ret.add(img);

			}
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			// TODO: close rs, close st
			// TODO: close conn
			rs.close();
			st.close();
			conn.close();
		}

		return ret;
	}

	public static boolean insertImage(Image image) {

		// TODO: get connection

		Connection conn = MySQLConnection.getMySQLConnection();
		if (conn == null) {
			return false;
		}
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			String sql = "Insert into images(Image_Name, Image_LocalID, Upload_Date, Url, Image_BlogID) value(?,?,?,?,?)";
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, image.getImage_Name());
			st.setInt(2, image.getImage_LocalID());
			st.setDate(3, image.getUpload_Date());
			st.setString(4, image.getUrl());
			st.setInt(5, image.getImag_BlogID());
			st.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		Image img = new Image();
		img.setImage_Name("ˆÉ“¤");
		img.setImage_LocalID(4);
		Date publish_Date = new java.sql.Date(Calendar.getInstance().getTime()
				.getTime());
		img.setUpload_Date(publish_Date);
		img.setUrl("/resources/img/slider/2.jpg");
		img.setImag_BlogID(4);
		if (insertImage(img)) {
			System.out.println("ok");
		}

	}
}
