package com.fuhope.ssm.mapper;

import java.util.List;

import com.fuhope.ssm.po.MSGCodeCustom;

public interface MSGCodeMapper {
	
		// 插入短信验证码
		public void insertMSGCode(MSGCodeCustom codeCustom)throws Exception;
		
		// 根据账号查询验证码
		public List<MSGCodeCustom> findCodeByAccount(MSGCodeCustom codeCustom)throws Exception;
		
		// 根据account更新验证码
		public void updateCodeByAccount(MSGCodeCustom codeCustom)throws Exception;
		
		// 获取未验证的验证码
		public List<MSGCodeCustom> findCodeByIsUsed(String isUsed)throws Exception;
		
		// 获取所有验证码条数
		public long knowTheMsgCodeCount()throws Exception;
}
