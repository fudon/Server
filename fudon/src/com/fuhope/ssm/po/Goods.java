package com.fuhope.ssm.po;

public class Goods {
	
	private String number;		// 唯一的编码,表征那个商品
	private String home;		// 商品的归类，根据这个字段来查找同一列表的数据
	private String name;		// 商品的名字
	private String detail;		// 商品的描述
	private String price;		// 价格
	private String cent;		// 评分
	private String rest;		// 剩余
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCent() {
		return cent;
	}
	public void setCent(String cent) {
		this.cent = cent;
	}
	public String getRest() {
		return rest;
	}
	public void setRest(String rest) {
		this.rest = rest;
	}

}
