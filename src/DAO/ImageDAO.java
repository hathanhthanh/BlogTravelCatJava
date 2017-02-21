package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.MySQLConnection;
import beans.Image;
import beans.Location;

import com.mysql.jdbc.PreparedStatement;

public class ImageDAO {
	public List< Image> getImage(int local_ID) throws SQLException {
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
}
