package com.fuhope.ssm.mapper;

import java.util.List;

import com.fuhope.ssm.po.AddressCustom;

public interface AddressMapper {
	
	// 增加地址
	public void insertAddress(AddressCustom addCustom)throws Exception;
	
	// 修改地址
	
	// 查询地址
	public List<AddressCustom> selectAddressByAccount(String account)throws Exception;

	// 删除地址
}
