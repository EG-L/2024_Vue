package com.sist.service;

import java.util.List;

import com.sist.vo.FoodVO;
import com.sist.vo.MemberVO;

public interface FoodService {
	//Food 관련
	public List<FoodVO> foodListData(int start,int end);
	public int foodTotalPage();
	public FoodVO foodDetailData(int fno);
	//Reply관련
	
	//Member관련
	public MemberVO isLogin(String id,String pwd);
}
