package com.fuhope.ssm.feedback;

public class FeedBack {
	
	private  String number;
	private  String account;
	private	 String content;
	private	 String userinfo;
	private  String	flag;		// 1是已经处理
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserinfo() {
		return userinfo;
	}
	
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
