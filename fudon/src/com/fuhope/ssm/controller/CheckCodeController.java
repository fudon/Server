package com.fuhope.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuhope.ssm.feedback.FBCustom;
import com.fuhope.ssm.po.AddressCustom;
import com.fuhope.ssm.service.UserService;

import FJShare.FJResult;

@Controller
@RequestMapping("/checkCode")
public class CheckCodeController {
	
	@Autowired
	private UserService userService;
	
	//找回密码
	@RequestMapping(value="/findPwd",method=RequestMethod.POST)
	public @ResponseBody FJResult findPwd(HttpServletRequest request,HttpServletResponse response,@RequestBody FBCustom fbCustom)throws Exception{
			
		List<AddressCustom> list = userService.selectAddressByAccount(fbCustom.getAccount());
		FJResult result = new FJResult("查询地址数据成功",1,list);
		return result;
	}
	
	//增加地址
	@RequestMapping(value="/addAddress",method=RequestMethod.POST)
	public @ResponseBody FJResult allFeedback(HttpServletRequest request,HttpServletResponse response,@RequestBody AddressCustom addCustom)throws Exception{
				
		userService.insertAddress(addCustom);
		FJResult result = new FJResult("插入地址成功",1);
		return result;
	}
}
