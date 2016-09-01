package com.fuhope.ssm.mapper;

import java.util.List;

import com.fuhope.ssm.po.GoodsCustom;

public interface GoodsMapper {
	
	// 根据home字段查找同列商品
	public List<GoodsCustom> findGoodsByHome(String home)throws Exception;
	
	// 插入商品
	public void insertGoods(GoodsCustom goodsCustom)throws Exception;
	
	// 更新商品
	public void updateGoodsByNumber(GoodsCustom goodsCustom)throws Exception;
	
	// 获取Goods数据库总条数
	public long knowTheGoodsCount()throws Exception;
	
	// 根据number查询商品
	public GoodsCustom findGoodsByNumber(String number)throws Exception;

}
