package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;

@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodsData(Map map){
		return mapper.goodsData(map);
	}
	
	public int goodsTotalPage() {
		return mapper.goodsTotalPage();
	}
}
