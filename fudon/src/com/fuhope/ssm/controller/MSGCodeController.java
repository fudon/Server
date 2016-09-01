package com.fuhope.ssm.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuhope.ssm.po.MSGCodeCustom;
import com.fuhope.ssm.po.UserCustom;
import com.fuhope.ssm.service.UserService;

import FJShare.FJData;
import FJShare.FJResult;

@Controller
@RequestMapping("/msgCode")
public class MSGCodeController {
	
	@Autowired
	private UserService userService;
	
	// 插入短信验证码
	@RequestMapping(value="/registerCode",method=RequestMethod.POST)
	public @ResponseBody FJResult makeMSGCode(HttpServletRequest request,HttpServletResponse response,@RequestBody MSGCodeCustom codeCustom)throws Exception{
		
		String phone = codeCustom.getAccount();
		UserCustom userList = userService.findUserByAccount(phone);
		if (userList != null){
			return new FJResult("用户已经注册",0,null);
		}
		int code = FJData.randomNumberByDigit(4);
		 Date date = new Date(System.currentTimeMillis());
		 long time = date.getTime();
		 long validity = 600000;
		 String type = "1";	// register
		 
		 MSGCodeCustom resultCustom = new MSGCodeCustom();
		 resultCustom.setAccount(phone);
		 resultCustom.setCode(String.valueOf(code));
		 resultCustom.setTime(String.valueOf(time));
		 resultCustom.setValidity(String.valueOf(validity));
		 resultCustom.setType(type);
		 resultCustom.setIsUsed("0");
		 userService.insertMSGCode(resultCustom);		 
		FJResult result = new FJResult("获取短信验证吗成功",1,resultCustom);
		return result;
	}
	
	// 根据account查询短信验证码
	@RequestMapping(value="/findMSGCode",method=RequestMethod.POST)
	public @ResponseBody FJResult findMSGCode(HttpServletRequest request,HttpServletResponse response,@RequestBody MSGCodeCustom codeCustom)throws Exception{
		
		String account = codeCustom.getAccount();
		if (account == null){
			return new FJResult("请输入手机号",0);
		}
		codeCustom.setIsUsed("0");
		List<MSGCodeCustom> list = userService.findCodeByAccount(codeCustom);
		if (list == null){
			return new FJResult("没有短信验证码",0);
		}
		FJResult result = new FJResult("获取短信验证码成功",1,list);
		return result;
	}
	
	// 根据isUsed查询所有短信验证码
	@RequestMapping(value="/findMSGCodeIsUsed",method=RequestMethod.POST)
	public @ResponseBody FJResult findMSGCodeIsUsed(HttpServletRequest request,HttpServletResponse response)throws Exception{
	
		List<MSGCodeCustom> list = userService.findCodeByIsUsed("0");
		if (list == null){
			return new FJResult("没有短信验证码",0);
		}
		FJResult result = new FJResult("获取短信验证码成功",1,list);
		return result;
	}
	
	// 根据account更新短信验证码
	@RequestMapping(value="/updateMSGCode",method=RequestMethod.POST)
	public @ResponseBody FJResult updateMSGCode(HttpServletRequest request,HttpServletResponse response,@RequestBody MSGCodeCustom paramCustom)throws Exception{
		if (paramCustom.getAccount() == null){
			return new FJResult("参数错误",0);
		}
		paramCustom.setIsUsed("0");
		List<MSGCodeCustom> list = userService.findCodeByAccount(paramCustom);
		if (list == null || list.size() == 0){
			return new FJResult("没有短信验证码",0);
		}
		
		for(Iterator<MSGCodeCustom> it = list.iterator(); it.hasNext();)
		{   
			MSGCodeCustom tempCustom = it.next();
			tempCustom.setIsUsed("1");
			userService.updateCodeByAccount(tempCustom);
		}   
		
		FJResult result = new FJResult("更新短信验证码成功",1);
		return result;
	}
}
