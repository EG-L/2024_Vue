package com.sist.dao;
import java.util.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;

@Repository // id(FoodDAO)
//스프링에 관리 요청 => interface/VO(데이터형)
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<FoodVO> foodListData(int start,int end){
		return mapper.foodListData(start, end);
	}
	
	public int foodTotalPage() {
		
		return mapper.foodTotalPage();
	}
	
	public FoodVO foodDetailData(int fno) {
		return mapper.foodDetailData(fno);
	}
}
