package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface FoodMapper {
	@Select("SELECT fno,poster,name,num "
			+ "FROM (SELECT fno,poster,name,rownum as num "
			+ "FROM (SELECT fno,poster,name "
			+ "FROM food_menu_house WHERE REGEXP_LIKE(address,#{address}) ORDER BY fno)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20) "
			+ "FROM food_menu_house WHERE REGEXP_LIKE(address,#{address})")
	public int foodFindCount(Map map);
	
	@Select("SELECT fno,score,poster,name,type,address,phone,theme,price,time,seat "
			+ "FROM food_menu_house "
			+ "WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
