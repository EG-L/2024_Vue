package com.sist.dao;
import java.util.*;

import com.sist.mapper.FoodMapper;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<FoodVO> foodFindData(Map map){
		return mapper.foodFindData(map);
	}
	
	public int foodFindCount(Map map) {
		return mapper.foodFindCount(map);
	}
	
	public FoodVO foodDetailData(int fno) {
		return mapper.foodDetailData(fno);
	}
	
	public List<FoodVO> foodListData(Map map){
		
		
		return mapper.foodListData(map);
	}
	public int foodListCount() {
		return mapper.foodListCount();
	}
	
	public FoodVO foodListDetailData(int fno) {
		mapper.foodHitIncrement(fno);
		return mapper.foodDetailData(fno);
	}
	public List<FoodVO> foodTop7(){
		return mapper.foodTop7();
	}
}
