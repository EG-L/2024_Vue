package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.FoodVO;
public interface FoodMapper {
	@Select("SELECT fno,name,poster,rownum "
			+ "FROM food_menu_house "
			+ "WHERE REGEXP_LIKE(address,#{address}) "
			+ "AND rownum<=20")
	public List<FoodVO> foodFindData(String address);
	
}
