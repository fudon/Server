package com.fuhope.ssm.mapper;

import java.util.List;

import com.fuhope.ssm.po.ShopcarCustom;

public interface ShopcarMapper {
	
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
}
