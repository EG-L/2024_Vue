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
}
