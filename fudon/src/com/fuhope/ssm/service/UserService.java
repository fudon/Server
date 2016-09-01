package com.fuhope.ssm.service;

import java.util.List;

import com.fuhope.ssm.feedback.FBCustom;
import com.fuhope.ssm.po.AddressCustom;
import com.fuhope.ssm.po.GoodsCustom;
import com.fuhope.ssm.po.MSGCodeCustom;
import com.fuhope.ssm.po.ShopcarCustom;
import com.fuhope.ssm.po.UserCustom;
import com.fuhope.ssm.po.UserQueryVo;

public interface UserService {
	
	//用户查询列表
		public List<UserCustom> findUserList(UserQueryVo userQueryVo)throws Exception; 
		
	//根据account查询用户信息
		public UserCustom findUserByAccount(String account)throws Exception;
		
	// 插入用户
		public String insertUser(UserCustom userCustom)throws Exception;
		
	// 更新用户
		public void updateUserByAccount(UserCustom userCustom)throws Exception;
		
	//更新手机号
		public void updatePhoneByAccount(UserCustom userCustom)throws Exception;
	
	//获取数据库记录数
		public long knowTheCount()throws Exception;
		
	// 增加反馈
		public void insertFeedback(FBCustom fbCustom)throws Exception;
		
	// 查询反馈数据
		public List<FBCustom> selectAllFBs()throws Exception;
		
	// 根据flag查询反馈数据
		public List<FBCustom> selectFBsByFlag(String flag)throws Exception;
		
	// 更新反馈状态
		public void updateFeedbackByNumber(String number)throws Exception;
		
		// 查询反馈数据总数
		public long knowTheFBCount()throws Exception;
		
	// 查询地址
		public List<AddressCustom> selectAddressByAccount(String account)throws Exception;

		// 增加地址
		public void insertAddress(AddressCustom addCustom)throws Exception;
		
		// 根据home字段查找同列商品
		public List<GoodsCustom> findGoodsByHome(String home)throws Exception;
		
		// 根据number查询商品
		public GoodsCustom findGoodsByNumber(String number)throws Exception;

		// 插入商品
		public void insertGoods(GoodsCustom goodsCustom)throws Exception;
		
		// 更新商品
		public void updateGoodsByNumber(GoodsCustom goodsCustom)throws Exception;

		// 获取Goods数据库总条数
		public long knowTheGoodsCount()throws Exception;
		
		// 增加购物车
		public void insertShopcar(ShopcarCustom shopcarCustom)throws Exception;
		
		// 根据account查询购物车
		public List<ShopcarCustom> selectShopcarsByAccount(String account)throws Exception;

		// 根据account和number更新购物车
		public void updateShopcarByAccountAndNumber(ShopcarCustom shopcarCustom)throws Exception;
		
		// 根据account和number查询数据库
		public List<ShopcarCustom> selectShopcarsByAccountAndNumber(ShopcarCustom shopcarCustom)throws Exception;
		
		// 根据account和number删除购物车
		public void deleteShopcarByAccountAndNumber(ShopcarCustom shopcarCustom)throws Exception;
		
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
