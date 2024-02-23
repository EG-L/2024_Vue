package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class ReserveDAO {
	@Autowired
	private ReserveMapper mapper;
	
	public List<FoodVO> foodReserveData(String type){
		return mapper.foodReserveData(type);
	}
	public List<ReserveVO> reserveMypageData(String userId){
		return mapper.reserveMypageData(userId);
	}
	public void foodReserveInsert(ReserveVO vo) {
		mapper.foodReserveInsert(vo);
	}
}
