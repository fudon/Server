package com.fuhope.ssm.po;

public class User {
	
	private String name;
	private String password;
	private String account;
	private String phone;
	private String weiyi;
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	
    static	public User configUser(String name,String password){
		User user = new User();
		user.name = name;
		user.password = password;
		return user;
	}
    
	public String getWeiyi() {
		return weiyi;
	}
	public void setWeiyi(String weiyi) {
		this.weiyi = weiyi;
	}
	
    
}
