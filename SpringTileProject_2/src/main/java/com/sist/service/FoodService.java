package com.sist.service;

import java.util.List;

import com.sist.vo.FoodVO;
import com.sist.vo.MemberVO;
import com.sist.vo.ReplyVO;

public interface FoodService {
	//Food 관련
	public List<FoodVO> foodListData(int start,int end);
	public int foodTotalPage();
	public FoodVO foodDetailData(int fno);
	//Reply관련
	public List<ReplyVO> replyListData(int fno);
	public void replyInsert(ReplyVO vo);
	public void replyDelete(int rno);
	public void replyUpdate(ReplyVO vo);
	//Member관련
	public MemberVO isLogin(String id,String pwd);
}
