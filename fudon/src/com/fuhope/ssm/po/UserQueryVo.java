package com.fuhope.ssm.po;

/**
 * 
 * @author 用户的包装对象
 *
 */

public class UserQueryVo {

	private User user;
	private UserCustom userCustom;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserCustom getUserCustom() {
		return userCustom;
	}
	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
}
