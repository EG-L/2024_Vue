package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class GoodsDAO {
	// 구현된 매퍼 주소를 설정
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodsListData(int start){
		return mapper.goodsListData(start);
	}
	public int goodsTotalPage() {
		return mapper.goodsTotalPage();
	}
}
