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

import com.fuhope.ssm.po.GoodsCustom;
import com.fuhope.ssm.service.UserService;

import FJShare.FJResult;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private UserService userService;
	
	//查找地址
	@RequestMapping(value="/findGoods",method=RequestMethod.POST)
	public @ResponseBody FJResult addFeedback(HttpServletRequest request,HttpServletResponse response,@RequestBody GoodsCustom goodsCustom)throws Exception{
			
		List<GoodsCustom> list = userService.findGoodsByHome(goodsCustom.getHome());
		FJResult result = new FJResult("查询地址数据成功",1,list);
		return result;
	}
	
	//增加商品
	@RequestMapping(value="/addGoods",method=RequestMethod.POST)
	public @ResponseBody FJResult addGoods(HttpServletRequest request,HttpServletResponse response,@RequestBody GoodsCustom goodsCustom)throws Exception{
		
		long count = userService.knowTheGoodsCount();
		goodsCustom.setNumber(String.valueOf(count));
		userService.insertGoods(goodsCustom);
		FJResult result = new FJResult("增加商品成功",1);
		return result;
	}
	
	// 更新商品
		@RequestMapping(value="/updateGoods",method=RequestMethod.POST)
		public @ResponseBody FJResult updateGoods(HttpServletRequest request,HttpServletResponse response,@RequestBody GoodsCustom goodsCustom)throws Exception{
			userService.updateGoodsByNumber(goodsCustom);
			FJResult result = new FJResult("更新商品成功",1);
			return result;
		}
}
