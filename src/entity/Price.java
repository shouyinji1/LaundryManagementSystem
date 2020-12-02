package entity;

import java.io.Serializable;

public class Price implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String mode;	// 洗衣模式
	private String price;	// 价格；
	private String duration;	// 洗衣时长

	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
}
