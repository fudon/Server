package com.fuhope.ssm.mapper;

import java.util.List;

import com.fuhope.ssm.po.UserCustom;
import com.fuhope.ssm.po.UserQueryVo;

public interface UserMapper {
	//用户查询列表
	public List<UserCustom> findUserList(UserQueryVo userQueryVo)throws Exception; 
	
	//根据account查询用户信息
	public UserCustom findUserByAccount(String account)throws Exception;
				
	//插入用户
	public int insertUser(UserQueryVo userQueryVo)throws Exception;
	
	//更新用户
	public void updateUserByAccount(UserCustom userCustom)throws Exception;
	
	//更新手机号
	public void updatePhoneByAccount(UserCustom userCustom)throws Exception;
	
	//获取数据库记录数
	public long knowTheCount()throws Exception;
	
}
