package entity;

import java.io.Serializable;

public class Dashboard implements Serializable{
	private static final long serialVersionUID = 1L;

	private String level;	// 用户级别
	private String brand;	// 面板右上角文字
	private String iframe_src;	// 首页界面

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
		switch (level) {
			case "admin":
				initForAdmin();
				break;
			default:
				initForNormalUser();
				break;
		}
	}
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getIframe_src() {
		return iframe_src;
	}

	public void setIframe_src(String iframe_src) {
		this.iframe_src = iframe_src;
	}
	
	private void initForNormalUser() {
		this.brand="欢迎光临！";
		this.iframe_src="washerList.normalUserServlet";
	}
	private void initForAdmin() {
		this.brand="洗衣房管理";
		this.iframe_src="washerList.adminServlet";
	}
}
