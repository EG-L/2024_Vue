package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.ReserveDAO;
import com.sist.vo.FoodVO;
import com.sist.vo.ReserveVO;

//Service => DAO통합, 실제 데이터 전송 모아서 처리 => Controller
/*
 * 	사용자 ==> page
 * list_vue.do?page=1 => DispatcherSErvlet
 * 	String page = request.getParameter("page")
 * */
@Service
public class ReserveServiceImpl implements ReserveService{
	
	@Autowired
	private ReserveDAO rDao;
	
	@Override
	public List<FoodVO> foodReserveData(String type) {
		// TODO Auto-generated method stub
		return rDao.foodReserveData(type);
	}

	@Override
	public List<ReserveVO> reserveMypageData(String userId) {
		// TODO Auto-generated method stub
		return rDao.reserveMypageData(userId);
	}

	@Override
	public void foodReserveInsert(ReserveVO vo) {
		// TODO Auto-generated method stub
		rDao.foodReserveInsert(vo);
	}

	@Override
	public void reserveCancel(int rno) {
		// TODO Auto-generated method stub
		rDao.reserveCancel(rno);
	}

}
