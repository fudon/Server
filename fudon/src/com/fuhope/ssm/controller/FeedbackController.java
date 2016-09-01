package com.fuhope.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuhope.ssm.feedback.FBCustom;
import com.fuhope.ssm.service.UserService;

import FJShare.FJResult;

/*
 * 反馈的控制器类
 */

@Controller
@RequestMapping("/feedback")//根路径，对url实行分类管理,eg.localhost:8080/fudon/user/login.action	窄华请求映射
public class FeedbackController {
	
	@Autowired
	private UserService userService;
	
	//增加反馈
	@RequestMapping(value="/addFeedback",method=RequestMethod.POST)
	public @ResponseBody FJResult addFeedback(HttpServletRequest request,HttpServletResponse response,@RequestBody FBCustom fbCustom)throws Exception{
			
		long count = userService.knowTheFBCount();
		fbCustom.setNumber(String.valueOf(count));
		fbCustom.setFlag("0");
		userService.insertFeedback(fbCustom);
		FJResult result = new FJResult("反馈成功",1);
		return result;
	}
	
	//查询所有反馈
	@RequestMapping(value="/allFeedback",method=RequestMethod.POST)
	public @ResponseBody FJResult allFeedback(HttpServletRequest request,HttpServletResponse response,@RequestBody FBCustom fbCustom)throws Exception{
				
		String flag = fbCustom.getFlag();
		List<FBCustom> fbList = null;
		if	(flag == null){
			 fbList = userService.selectAllFBs();
		}else{
			 fbList = userService.selectFBsByFlag(fbCustom.getFlag());
		}
		FJResult result = new FJResult("获取数据成功",1,fbList);
		return result;
	}
	
	//处理反馈
	@RequestMapping(value="/handleFeedback",method=RequestMethod.POST)
	public @ResponseBody FJResult handleFeedback(HttpServletRequest request,HttpServletResponse response,@RequestBody FBCustom fbCustom)throws Exception{
			
		userService.updateFeedbackByNumber(fbCustom.getNumber());
		FJResult result = new FJResult("处理成功",1);
		return result;
	}
	
}
