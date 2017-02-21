package beans;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Location {
	public Location() {
	}

	private Integer local_ID;

	public Integer getLocal_ID() {
		return local_ID;
	}

	public void setLocal_ID(Integer local_ID) {
		this.local_ID = local_ID;
	}

	public Integer getParent_ID() {
		return parent_ID;
	}

	public void setParent_ID(Integer parent_ID) {
		this.parent_ID = parent_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
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

	private Integer parent_ID;
	private String name;
	private String content;
	private String address;
	private String station;
	private Date publish_Date;
	private Date last_Edit;
	private int status;

	private List<Image> listImage = new ArrayList<Image>();

	public List<Image> getListImage() {
		return listImage;
	}

	public void setListImage(List<Image> listImage) {
		this.listImage = listImage;
	}

	public Location(ResultSet rs) throws SQLException {
		local_ID = rs.getInt("Local_ID");
		parent_ID = rs.getInt("Parent_ID");
		name = rs.getString("Name");
		content = rs.getString("Content");
		address = rs.getString("Address");
		station = rs.getString("Station");
		publish_Date = rs.getDate("Publish_Date");
		last_Edit = rs.getDate("Last_Edit");
		status = rs.getInt("Status");
		/*Image image = new Image(rs);
		listImage.add(image);*/
	}
}
