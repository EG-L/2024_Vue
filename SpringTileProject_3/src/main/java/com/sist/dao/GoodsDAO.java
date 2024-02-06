package com.sist.dao;

import java.util.*;
import com.sist.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;

@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;

	public List<GoodsVO> goodsListData(Map map){
		return mapper.goodsListData(map);
	}
	
	public int goodsTotalPage(Map map) {
		return mapper.goodsTotalPage(map);
	}
	public GoodsVO goodsDetailData(Map map) {
		return mapper.goodsDetailData(map);
	}
}
