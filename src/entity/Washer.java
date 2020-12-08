package entity;

import java.io.Serializable;

/** 洗衣机实体类 */
public class Washer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;	// 洗衣机ID
	private String name;	// 洗衣机名称
	private String location;	// 洗衣机位置
	
	/** 使用者ID，用作该洗衣机是否正被使用的标志。
	 * 变量为空字符串或null表示洗衣机未使用，否则表示正在使用 */
	private String userID;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
}
