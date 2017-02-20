package beans;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Image {
	private int image_ID;

	public int getImage_ID() {
		return image_ID;
	}

	public void setImage_ID(int image_ID) {
		this.image_ID = image_ID;
	}

	public int getImage_LocalID() {
		return image_LocalID;
	}

	public void setImage_LocalID(int image_LocalID) {
		this.image_LocalID = image_LocalID;
	}

	public int getImag_BlogID() {
		return image_BlogID;
	}

	public void setImag_BlogID(int imag_BlogID) {
		this.image_BlogID = imag_BlogID;
	}

	public String getImage_Name() {
		return image_Name;
	}

	public void setImage_Name(String image_Name) {
		this.image_Name = image_Name;
	}

	public Date getUpload_Date() {
		return upload_Date;
	}

	public void setUpload_Date(Date upload_Date) {
		this.upload_Date = upload_Date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private int image_LocalID;
	private int image_BlogID;
	private String image_Name;
	private Date upload_Date;
	private String url;

	public Image() {
	}

	public Image(ResultSet rs) throws SQLException {
		image_ID = rs.getInt("Image_ID");
		image_LocalID = rs.getInt("Image_LocalID");
		image_BlogID = rs.getInt("Image_BlogID");
		image_Name = rs.getString("Image_Name");
		upload_Date = rs.getDate("Upload_Date");
		url = rs.getString("Url");
		// ...
	}
}
