package com.sist.service;

import java.util.List;

import com.sist.vo.FoodVO;
import com.sist.vo.ReserveVO;

public interface ReserveService {
	public List<FoodVO> foodReserveData(String type);
	public List<ReserveVO> reserveMypageData(String userId);
	public void foodReserveInsert(ReserveVO vo);
}
