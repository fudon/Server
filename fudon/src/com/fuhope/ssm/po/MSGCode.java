package com.fuhope.ssm.po;

public class MSGCode {
	
	private String account;		// 账号
	private String code;		// 短信验证码，随机数字
	private String time;		// 生成时间
	private String validity;	// 有效时间（分钟）
	private String type;		// 类型：1.注册 2.找回密码 3.其他
	private String isUsed;		// 类型：0.未使用  1.使用
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
}
