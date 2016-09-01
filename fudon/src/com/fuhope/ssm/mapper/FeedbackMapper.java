package com.fuhope.ssm.mapper;

import java.util.List;

import com.fuhope.ssm.feedback.FBCustom;

public interface FeedbackMapper {
	
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
	
}
