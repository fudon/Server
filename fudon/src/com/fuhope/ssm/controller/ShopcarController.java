package com.fuhope.ssm.controller;

import java.util.ArrayList;
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

import com.fuhope.ssm.feedback.FBCustom;
import com.fuhope.ssm.po.GoodsCustom;
import com.fuhope.ssm.po.ShopcarCustom;
import com.fuhope.ssm.service.UserService;

import FJModel.ShopcarModel;
import FJShare.FJResult;

@Controller
@RequestMapping("/shopcar")
public class ShopcarController {
	
	@Autowired
	private UserService userService;
	
	//增加购物车
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public @ResponseBody FJResult addShopcar(HttpServletRequest request,HttpServletResponse response,@RequestBody ShopcarCustom scCustom)throws Exception{
		
		List<ShopcarCustom> list = userService.selectShopcarsByAccountAndNumber(scCustom);
		if (list != null && list.size() > 0){
			ShopcarCustom newSC = (ShopcarCustom)list.get(0);
			long count = Long.parseLong(newSC.getCount());
			long newCount = count + Long.parseLong(scCustom.getCount());
			
			scCustom.setCount(String.valueOf(newCount));
			userService.updateShopcarByAccountAndNumber(scCustom);
		}else{
			userService.insertShopcar(scCustom);
		}
		
		List<ShopcarCustom> findList = userService.selectShopcarsByAccount(scCustom.getAccount());
		ArrayList<ShopcarModel> resultList = new ArrayList<ShopcarModel>();
		for(Iterator<ShopcarCustom> it = findList.iterator(); it.hasNext();)
		{   
			ShopcarCustom tempCustom = it.next();
			GoodsCustom goods = userService.findGoodsByNumber(tempCustom.getNumber());
			ShopcarModel model = new ShopcarModel();
			model.setGoodsCustom(goods);
			model.setShopcarCustom(tempCustom);
			resultList.add(model);
		}   
		FJResult result = new FJResult("操作成功",1,resultList);
		return result;
	}
	
	//查询购物车
	@RequestMapping(value="/find",method=RequestMethod.POST)
	public @ResponseBody FJResult findShopcar(HttpServletRequest request,HttpServletResponse response,@RequestBody ShopcarCustom scCustom)throws Exception{
				
		String account = scCustom.getAccount();
		if (account == null || account.equals("")){
			FJResult result = new FJResult("Account为空",0);
			return result;
		}
		List<ShopcarCustom> scList = userService.selectShopcarsByAccount(account);
		ArrayList<ShopcarModel> resultList = new ArrayList<ShopcarModel>();
		for(Iterator<ShopcarCustom> it = scList.iterator(); it.hasNext();)
		{   
			ShopcarCustom tempCustom = it.next();
			GoodsCustom goods = userService.findGoodsByNumber(tempCustom.getNumber());
			ShopcarModel model = new ShopcarModel();
			model.setGoodsCustom(goods);
			model.setShopcarCustom(tempCustom);
			resultList.add(model);
		}   
		FJResult result = new FJResult("获取数据成功",1,resultList);
		return result;
	}
	
	//删除购物车
		@RequestMapping(value="/delete",method=RequestMethod.POST)
		public @ResponseBody FJResult delete(HttpServletRequest request,HttpServletResponse response,@RequestBody ShopcarCustom scCustom)throws Exception{
					
			String account = scCustom.getAccount();
			if (account == null || account.equals("")){
				FJResult result = new FJResult("Account为空",0);
				return result;
			}
			userService.deleteShopcarByAccountAndNumber(scCustom);

			List<ShopcarCustom> scList = userService.selectShopcarsByAccount(account);
			ArrayList<ShopcarModel> resultList = new ArrayList<ShopcarModel>();
			for(Iterator<ShopcarCustom> it = scList.iterator(); it.hasNext();)
			{   
				ShopcarCustom tempCustom = it.next();
				GoodsCustom goods = userService.findGoodsByNumber(tempCustom.getNumber());
				ShopcarModel model = new ShopcarModel();
				model.setGoodsCustom(goods);
				model.setShopcarCustom(tempCustom);
				resultList.add(model);
			}   
			FJResult result = new FJResult("操作成功",1,resultList);
			return result;
		}
	
}
