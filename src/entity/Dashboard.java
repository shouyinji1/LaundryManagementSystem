package entity;

import java.io.Serializable;

/** 首页实体类 */
public class Dashboard implements Serializable{
	private static final long serialVersionUID = 1L;

	private String level;	// 用户级别
	private String brand;	// 面板右上角文字
	private String iframe_src;	// 首页界面
	private String menu1;	// 菜单
	private String menu2;	// 菜单
	private String menu3;	// 菜单
	private String menu4;	// 菜单
	private String link1;	// 菜单对应的链接
	private String link2;	// 菜单对应的链接
	private String link3;	// 菜单对应的链接
	private String link4;	// 菜单对应的链接
	

	public String getLevel() {
		return level;
	}

	/** 设置用户级别，并根据不同的用户级别初始化首页文字信息 */
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
	public String getMenu1() {
		return menu1;
	}
	public void setMenu1(String menu1) {
		this.menu1 = menu1;
	}
	public String getMenu2() {
		return menu2;
	}
	public void setMenu2(String menu2) {
		this.menu2 = menu2;
	}
	public String getMenu3() {
		return menu3;
	}
	public void setMenu3(String menu3) {
		this.menu3 = menu3;
	}
	public String getMenu4() {
		return menu4;
	}
	public void setMenu4(String menu4) {
		this.menu4 = menu4;
	}
	public String getLink1() {
		return link1;
	}
	public void setLink1(String link1) {
		this.link1 = link1;
	}
	public String getLink2() {
		return link2;
	}
	public void setLink2(String link2) {
		this.link2 = link2;
	}
	public String getLink3() {
		return link3;
	}
	public void setLink3(String link3) {
		this.link3 = link3;
	}
	public String getLink4() {
		return link4;
	}
	public void setLink4(String link4) {
		this.link4 = link4;
	}
	
	/** 普通用户的首页初始化 */
	private void initForNormalUser() {
		this.brand="欢迎光临！";
		this.iframe_src="washerList.normalUserServlet";
		this.menu1="挑选洗衣机";
		this.menu2="我的订单";
		this.menu3=null;
		this.menu4=null;
		this.link1="washerList.normalUserServlet";
		this.link2="myOrders.normalUserServlet";
		this.link3=null;
		this.link4=null;
	}
	
	/** 管理员的首页初始化 */
	private void initForAdmin() {
		this.brand="洗衣房管理";
		this.iframe_src="washerList.adminServlet";
		this.menu1="洗衣机管理";
		this.menu2="订单管理";
		this.menu3="用户管理";
		this.menu4="价目管理";
		this.link1="washerList.adminServlet";
		this.link2="orderList.adminServlet";
		this.link3="userList.adminServlet";
		this.link4="priceList.adminServlet";
	}
}
