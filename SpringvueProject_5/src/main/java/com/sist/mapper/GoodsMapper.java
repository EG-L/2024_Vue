package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
/*
 *  NO                                        NOT NULL NUMBER
 GOODS_NAME                                NOT NULL VARCHAR2(1000)
 GOODS_SUB                                          VARCHAR2(1000)
 GOODS_PRICE                               NOT NULL VARCHAR2(50)
 GOODS_DISCOUNT                                     NUMBER
 GOODS_FIRST_PRICE                                  VARCHAR2(20)
 GOODS_DELIVERY                            NOT NULL VARCHAR2(20)
 GOODS_POSTER                                       VARCHAR2(260)
 HIT                                                NUMBER
 * */

import com.sist.dao.GoodsVO;
public interface GoodsMapper {
	@Select("SELECT goods_name as name,goods_sub as sub,goods_price as price,goods_discount as discount,goods_first_price as first_price,goods_delivery as delivery,goods_poster as poster,num "
			+ "FROM (SELECT goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery,goods_poster,rownum as num "
			+ "FROM (SELECT goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery,goods_poster "
			+ "FROM goods_all ORDER BY goods_name)) WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20) FROM goods_all")
	public int goodsTotalPage();
}
