package entity;

import java.io.Serializable;

/** 用户实体类 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;	// ID
	private String name;	//用户名
	private String password;	//密码
	private String level;	//权限级别
	private String tel;	// 电话号码

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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
