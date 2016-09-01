package com.fuhope.ssm.po;

public class Shopcar {
	
	private String number;	// 商品的唯一编码
	private String account; // 用户账号
	private String count;	// 该商品用户购买数量
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}

}
