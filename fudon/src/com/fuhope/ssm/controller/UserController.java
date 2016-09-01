package com.fuhope.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fuhope.ssm.po.User;
import com.fuhope.ssm.po.UserCustom;
import com.fuhope.ssm.service.UserService;

/**
 * 用户的控制类
 * @author slshao
 *
 */

@Controller
//@RequestMapping("/user")//根路径，对url实行分类管理,eg.localhost:8080/fudon/user/login.action	窄华请求映射
//@RequestMapping(value="/user",method={RequestMethod.GET,RequestMethod.POST})//限制请求为GET和POST
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//用户查询
	@RequestMapping("/loginWeb")
	public ModelAndView queryUsers()throws Exception{
		
		List<UserCustom> userList = userService.findUserList(null);
		
		System.out.println(userList);
		for(User tmp:userList)  
        {  
            System.out.println(tmp.getAccount());  
        }  
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList",userList);
//		modelAndView.setViewName("/WEB-INF/jsp/user/fuhope.html");
		modelAndView.setViewName("/WEB-INF/jsp/user/login.jsp");
		return modelAndView;
	}
}
