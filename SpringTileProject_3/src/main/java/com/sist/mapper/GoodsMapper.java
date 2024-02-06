package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface GoodsMapper {
	@Select("SELECT no,goods_poster,goods_price,goods_name,num "
			+ "FROM (SELECT no,goods_poster,goods_price,goods_name,rownum as num "
			+ "FROM (SELECT no,goods_poster,goods_price,goods_name "
			+ "FROM ${table_name} ORDER BY no)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12) FROM ${table_name}")
	public int goodsTotalPage(Map map);
	
	@Select("SELECT no,goods_poster,goods_price,goods_name "
			+ "FROM ${table_name} "
			+ "WHERE no=#{no}")
	public GoodsVO goodsDetailData(Map map);
}
