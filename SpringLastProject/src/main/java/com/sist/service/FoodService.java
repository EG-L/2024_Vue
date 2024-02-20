package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.FoodVO;
import com.sist.vo.NoticeVO;

public interface FoodService {
	public List<FoodVO> foodFindData(Map map);
	public int foodFindCount(Map map);
	public FoodVO foodDetailData(int fno);
	public List<FoodVO> foodListData(Map map);
	public int foodListCount();
	public FoodVO foodListDetailData(int fno);
	public List<NoticeVO> noticeTop7();
	public List<FoodVO> foodTop7();
	public List<FoodVO> foodHome12();
	public List<String> foodAllData();
	public List<FoodVO> foodNameInfoData(String name);
}
