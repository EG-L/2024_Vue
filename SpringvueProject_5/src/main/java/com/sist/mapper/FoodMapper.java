package com.sist.mapper;
/*
 * Mybatis에서 자동 구현
 * => 메소드를 만들면 => 자동 SQL생성
 * findByNO(int No) => WHERE no=? findByNameLike => WHERE name LIKE
 * insert update delete findAll(Page page)
 * */

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
/*
 * 	SELECT fno,name,poster FROM food_menu_house
 * ORDER BY fno 
 * LIMIT #{start},20
 * */

import com.sist.dao.FoodVO;
public interface FoodMapper {
	@Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT fno,name,poster "
			+ "FROM food_menu_house ORDER BY fno)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20) FROM food_menu_house")
	public int foodTotalPage();
}
