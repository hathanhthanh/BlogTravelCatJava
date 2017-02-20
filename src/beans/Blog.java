package beans;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Blog {

	private int blog_ID;

	public int getBlog_ID() {
		return blog_ID;
	}

	public void setBlog_ID(int blog_ID) {
		this.blog_ID = blog_ID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLocal_ID() {
		return local_ID;
	}

	public void setLocal_ID(int local_ID) {
		this.local_ID = local_ID;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getPublish_Date() {
		return publish_Date;
	}

	public void setPublish_Date(Date publish_Date) {
		this.publish_Date = publish_Date;
	}

	public Date getLast_Edit() {
		return last_Edit;
	}

	public void setLast_Edit(Date last_Edit) {
		this.last_Edit = last_Edit;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private String title;
	private int local_ID;
	private String contents;
	private String userName;
	private Date publish_Date;
	private Date last_Edit;
	private int status;
    private Image image = new Image();
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	private Location location = new Location();
	
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Blog() {
	};

	public Blog(ResultSet rs) throws SQLException {
		blog_ID = rs.getInt("Blog_ID");
		title = rs.getString("Title");
		local_ID = rs.getInt("Local_ID");
		contents = rs.getString("Content");
		userName = rs.getString("UserName");
		publish_Date = rs.getDate("Publish_Date");
		last_Edit = rs.getDate("Last_Edit");
		status = rs.getInt("Status");
		image.setImage_Name(rs.getNString("images.Image_Name"));
		image.setUrl(rs.getString("images.Url"));
		location.setName(rs.getString("locations.Name"));
		location.setAddress(rs.getString("locations.Address"));
	}
}
