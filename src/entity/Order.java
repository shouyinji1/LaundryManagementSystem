package entity;

import java.io.Serializable;

/** 订单实体类 */
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;	// 订单ID
	private String userID;	// 用户ID
	private String washerID;	// 洗衣机ID
	private String mode;	// 洗衣模式
	private String generatedTime;	// 订单生成时间

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getWasherID() {
		return washerID;
	}
	public void setWasherID(String washerID) {
		this.washerID = washerID;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getGeneratedTime() {
		return generatedTime;
	}
	public void setGeneratedTime(String generatedTime) {
		this.generatedTime = generatedTime;
	}
}
