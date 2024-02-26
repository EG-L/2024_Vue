package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.GoodsVO;
public interface GoodsMapper {
	@Select("SELECT no,goods_name,goods_price,goods_poster "
			+ "FROM goods_all "
			+ "ORDER BY no ASC "
			+ "LIMIT #{start},20")
	public List<GoodsVO> goodsListData(int start);
	//CRUD => NVL => isnull , TO_CHAR => dateFormat()
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM goods_all")
	public int goodsTotalPage();
}
