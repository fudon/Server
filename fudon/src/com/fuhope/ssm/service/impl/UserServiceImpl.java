package com.fuhope.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fuhope.ssm.feedback.FBCustom;
import com.fuhope.ssm.mapper.AddressMapper;
import com.fuhope.ssm.mapper.FeedbackMapper;
import com.fuhope.ssm.mapper.GoodsMapper;
import com.fuhope.ssm.mapper.MSGCodeMapper;
import com.fuhope.ssm.mapper.ShopcarMapper;
import com.fuhope.ssm.mapper.UserMapper;
import com.fuhope.ssm.po.AddressCustom;
import com.fuhope.ssm.po.GoodsCustom;
import com.fuhope.ssm.po.MSGCodeCustom;
import com.fuhope.ssm.po.ShopcarCustom;
import com.fuhope.ssm.po.UserCustom;
import com.fuhope.ssm.po.UserQueryVo;
import com.fuhope.ssm.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private FeedbackMapper fbMapper;
	@Autowired
	private AddressMapper addMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private ShopcarMapper shopcarMapper;
	@Autowired
	private MSGCodeMapper msgCodeMapper;
		
	@Override
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception {
			
		return userMapper.findUserList(userQueryVo);
	}

	@Override
	public UserCustom findUserByAccount(String account)throws Exception{

		UserCustom userCustom = userMapper.findUserByAccount(account);
//		UserCustom userCustom = new UserCustom();
//		BeanUtils.copyProperties(user, userCustom);
		return userCustom;
	}

	@Override
	public String insertUser(UserCustom userCustom) throws Exception {
		
		UserQueryVo vo = new UserQueryVo();
		vo.setUserCustom(userCustom);
		userMapper.insertUser(vo);
		return userCustom.getAccount();
	}

	@Override
	public void updateUserByAccount(UserCustom userCustom) throws Exception {
		userMapper.updateUserByAccount(userCustom);
	}
	
	@Override
	public void updatePhoneByAccount(UserCustom userCustom)throws Exception{
		userMapper.updatePhoneByAccount(userCustom);
	}

	@Override
	public long knowTheCount() throws Exception {
		return userMapper.knowTheCount();
	}

	@Override
	public void insertFeedback(FBCustom fbCustom) throws Exception {
		fbMapper.insertFeedback(fbCustom);
	}

	@Override
	public List<FBCustom> selectAllFBs() throws Exception {
		return fbMapper.selectAllFBs();
	}

	@Override
	public List<AddressCustom> selectAddressByAccount(String account) throws Exception {
		return addMapper.selectAddressByAccount(account);
	}

	@Override
	public void insertAddress(AddressCustom addCustom) throws Exception {
		addMapper.insertAddress(addCustom);
	}

	@Override
	public List<GoodsCustom> findGoodsByHome(String home) throws Exception {
		return goodsMapper.findGoodsByHome(home);
	}

	@Override
	public void insertGoods(GoodsCustom goodsCustom) throws Exception {
		goodsMapper.insertGoods(goodsCustom);
	}

	@Override
	public void updateGoodsByNumber(GoodsCustom goodsCustom) throws Exception {
		goodsMapper.updateGoodsByNumber(goodsCustom);
	}

	@Override
	public long knowTheGoodsCount() throws Exception {
		return goodsMapper.knowTheGoodsCount();
	}

	@Override
	public void updateFeedbackByNumber(String number) throws Exception {
		fbMapper.updateFeedbackByNumber(number);
	}

	@Override
	public long knowTheFBCount() throws Exception {
		return fbMapper.knowTheFBCount();
	}

	@Override
	public List<FBCustom> selectFBsByFlag(String flag) throws Exception {
		return fbMapper.selectFBsByFlag(flag);
	}

	@Override
	public void insertShopcar(ShopcarCustom shopcarCustom) throws Exception {
		shopcarMapper.insertShopcar(shopcarCustom);
	}

	@Override
	public List<ShopcarCustom> selectShopcarsByAccount(String account) throws Exception {
		return shopcarMapper.selectShopcarsByAccount(account);
	}

	@Override
	public void updateShopcarByAccountAndNumber(ShopcarCustom shopcarCustom) throws Exception {
		shopcarMapper.updateShopcarByAccountAndNumber(shopcarCustom);
	}

	@Override
	public List<ShopcarCustom> selectShopcarsByAccountAndNumber(ShopcarCustom shopcarCustom) throws Exception {
		return shopcarMapper.selectShopcarsByAccountAndNumber(shopcarCustom);
	}

	@Override
	public GoodsCustom findGoodsByNumber(String number) throws Exception {
		return goodsMapper.findGoodsByNumber(number);
	}

	@Override
	public void deleteShopcarByAccountAndNumber(ShopcarCustom shopcarCustom) throws Exception {
		shopcarMapper.deleteShopcarByAccountAndNumber(shopcarCustom);
	}

	@Override
	public void insertMSGCode(MSGCodeCustom codeCustom) throws Exception {
		msgCodeMapper.insertMSGCode(codeCustom);
	}

	@Override
	public List<MSGCodeCustom> findCodeByAccount(MSGCodeCustom codeCustom) throws Exception {
		return msgCodeMapper.findCodeByAccount(codeCustom);
	}

	@Override
	public long knowTheMsgCodeCount() throws Exception {
		return msgCodeMapper.knowTheMsgCodeCount();
	}

	@Override
	public void updateCodeByAccount(MSGCodeCustom codeCustom)throws Exception
	{
		msgCodeMapper.updateCodeByAccount(codeCustom);	
	}

	@Override
	public List<MSGCodeCustom> findCodeByIsUsed(String isUsed)throws Exception{
		return msgCodeMapper.findCodeByIsUsed(isUsed);
	}

}
