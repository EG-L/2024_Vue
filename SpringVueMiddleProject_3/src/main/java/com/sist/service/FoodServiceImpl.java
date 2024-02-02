package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// BI => DAO/Manager를 여러개 통합해서 사용 => 결합성이 낮은 프로그램 => 스프링에서 권장
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.FoodVO;
import com.sist.vo.MemberVO;

@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDAO dao;
	
	@Autowired
	private MemberDAO mDao;
	
	@Override
	public List<FoodVO> foodListData(int start, int end) {
		// TODO Auto-generated method stub
		return dao.foodListData(start, end);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return dao.foodTotalPage();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodDetailData(fno);
	}

	@Override
	public MemberVO isLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		return mDao.isLogin(id, pwd);
	}
	
}
