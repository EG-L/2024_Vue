package com.sist.service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDAO dao;
	
	@Autowired
	private MemberDAO mdao;
	
	@Autowired
	private ReplyDAO rdao;
	
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
	
	//ReplyDAO
	@Override
	public List<ReplyVO> replyListData(int fno) {
		// TODO Auto-generated method stub
		return rdao.replyListData(fno);
	}

	@Override
	public void replyInsert(ReplyVO vo) {
		// TODO Auto-generated method stub
		rdao.replyInsert(vo);
	}
	@Override
	public void replyDelete(int rno) {
		// TODO Auto-generated method stub
		rdao.replyDelete(rno);
	}
	@Override
	public void replyUpdate(ReplyVO vo) {
		rdao.replyUpdate(vo);
		// TODO Auto-generated method stub
	}
	//Member관련
	@Override
	public MemberVO isLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		return mdao.isLogin(id, pwd);
	}
}
