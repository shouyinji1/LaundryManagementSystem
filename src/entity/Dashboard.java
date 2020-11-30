package entity;

import java.io.Serializable;

public class Dashboard implements Serializable{
	private static final long serialVersionUID = 1L;

	private String brand;	// 面板右上角文字

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
