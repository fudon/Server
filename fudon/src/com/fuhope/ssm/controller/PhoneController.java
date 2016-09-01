package com.fuhope.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fuhope.ssm.po.User;
import com.fuhope.ssm.po.UserCustom;
import com.fuhope.ssm.service.UserService;

import FJModel.ChangeUser;
import FJShare.FJData;
import FJShare.FJResult;

/**
 * 用户的控制类
 * @author slshao
 *
 */

@Controller
@RequestMapping("/user")
//@RequestMapping("/user")//根路径，对url实行分类管理,eg.localhost:8080/fudon/user/login.action	窄华请求映射
//@RequestMapping(value="/user",method={RequestMethod.GET,RequestMethod.POST})//限制请求为GET和POST
public class PhoneController {
	
	@Autowired
	private UserService userService;
	
	//用户查询
	@RequestMapping("/addOld")
	public @ResponseBody FJResult queryUsers(HttpServletRequest request,HttpServletResponse response,@RequestBody UserCustom userCustom)throws Exception{
				
		List<UserCustom> userList = userService.findUserList(null);
		
		for(User tmp:userList)  
        {  
            System.out.println(tmp.getAccount());  
        }  
		
		FJResult result = new FJResult("获取数据成功",1,userList);
		return result;
	}
	
	@RequestMapping("/add")
	public @ResponseBody FJResult add(HttpServletRequest request,HttpServletResponse response,@RequestBody UserCustom userCustom)throws Exception{
		
		String account = userCustom.getAccount();
		if	(account.length() < 6){
			FJResult result = new FJResult("账号长度必须至少6位数",0);
			return result;
		}
		
		UserCustom userList = userService.findUserByAccount(account);
		if(userList != null){	//已经注册了
			
			FJResult result = new FJResult("该用户已经注册",0);
			return result;
		}else{
			long count = userService.knowTheCount() + 10000;
			String weiyi = String.valueOf(count);
			userCustom.setWeiyi(weiyi);
			
			if (FJData.isMobilePhone(account)){
				userCustom.setPhone(account);
			}
			
			String id = userService.insertUser(userCustom);
			System.out.println("account:"+id);
					
			UserCustom userNew = userService.findUserByAccount(userCustom.getAccount());
			FJResult result = null;
			if (userNew != null){
				result = new FJResult("注册成功",1,userNew);
			}else{
				result = new FJResult("注册失败",0);
			}
			return result;
		}
	}
	
	@RequestMapping("/login")
	public @ResponseBody FJResult login(HttpServletRequest request,HttpServletResponse response,@RequestBody UserCustom userCustom)throws Exception{
		
		UserCustom user = userService.findUserByAccount(userCustom.getAccount());
		System.out.println("UserServicefdd"+userService);

		if (user != null){
			String password = user.getPassword();
			String loginPWD = userCustom.getPassword();
			if (loginPWD.equals(password)){
				FJResult result = new FJResult("登陆成功",1,user);
				return result;
			}else{
				FJResult result = new FJResult("密码错误",0);
				return result;
			}			
		}else{
			FJResult result = new FJResult("该用户未注册",0);
			return result;
		}
	}
	
	@RequestMapping("/updateName")
	public @ResponseBody FJResult update(@RequestBody UserCustom userCustom)throws Exception{
		
		UserCustom oldUC = userService.findUserByAccount(userCustom.getAccount());
		if(oldUC != null){
			oldUC.setName(userCustom.getName().toLowerCase());
						
			userService.updateUserByAccount(oldUC);
			
			UserCustom userNew = userService.findUserByAccount(userCustom.getAccount());
			if (userNew != null){
				FJResult result = new FJResult("更新成功",1,userNew);
				return result;
			}else{
				FJResult result = new FJResult("查询用户信息失败",0);
				return result;
			}
		}else{
			FJResult result = new FJResult("该用户未注册",0);
			return result;
		}
	}
	
	@RequestMapping("/updateEmail")
	public @ResponseBody FJResult updateEmail(@RequestBody UserCustom userCustom)throws Exception{
		
		UserCustom oldUC = userService.findUserByAccount(userCustom.getAccount());
		if(oldUC != null){
			oldUC.setEmail(userCustom.getEmail().toLowerCase());
						
			userService.updateUserByAccount(oldUC);
			
			UserCustom userNew = userService.findUserByAccount(userCustom.getAccount());
			if (userNew != null){
				FJResult result = new FJResult("更新邮箱成功",1,userNew);
				return result;
			}else{
				FJResult result = new FJResult("查询用户信息失败",0);
				return result;
			}
		}else{
			FJResult result = new FJResult("该用户未注册",0);
			return result;
		}
	}
	
	@RequestMapping("/changeLoginPwd")
	public @ResponseBody FJResult changeLoginPwd(@RequestBody ChangeUser cpUser)throws Exception{
		
		UserCustom oldUC = userService.findUserByAccount(cpUser.getAccount());
		if(oldUC != null){
			if (!cpUser.getMoreParam().equals(oldUC.getPassword())){
				FJResult result = new FJResult("原密码错误",0);
				return result;
			}
			
			oldUC.setPassword(cpUser.getPassword());
						
			userService.updateUserByAccount(oldUC);
			
			UserCustom userNew = userService.findUserByAccount(cpUser.getAccount());
			if (userNew != null){
				FJResult result = new FJResult("更新成功",1,userNew);
				return result;
			}else{
				FJResult result = new FJResult("查询用户信息失败",0);
				return result;
			}
		}else{
			FJResult result = new FJResult("该用户未注册",0);
			return result;
		}
	}
	
	@RequestMapping("/changePhone")
	public @ResponseBody FJResult changePhone(@RequestBody ChangeUser cpUser)throws Exception{
		
		UserCustom oldUC = userService.findUserByAccount(cpUser.getAccount());
		if(oldUC != null){			
			oldUC.setPhone(cpUser.getPhone());
						
			userService.updatePhoneByAccount(oldUC);
			
			UserCustom userNew = userService.findUserByAccount(cpUser.getAccount());
			if (userNew != null){
				FJResult result = new FJResult("更新手机号成功",1,userNew);
				return result;
			}else{
				FJResult result = new FJResult("查询用户信息失败",0);
				return result;
			}
		}else{
			FJResult result = new FJResult("该用户未注册",0);
			return result;
		}
	}
	
}
