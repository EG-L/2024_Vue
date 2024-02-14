package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FreeBoardDAO;
import com.sist.vo.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService{
	@Autowired
	private FreeBoardDAO fdao;

	@Override
	public List<FreeBoardVO> freeboardListData(int start, int end) {
		// TODO Auto-generated method stub
		return fdao.freeboardListData(start, end);
	}

	@Override
	public int freeboardTotalPage() {
		// TODO Auto-generated method stub
		return fdao.freeboardTotalPage();
	}

	@Override
	public void freeboardInsert(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		fdao.freeboardInsert(vo);
		
	}

	@Override
	public FreeBoardVO freeboardDetailData(int no) {
		// TODO Auto-generated method stub
		return fdao.freeboardDetailData(no);
	}

	@Override
	public String freeboardDelete(int no, String pwd) {
		// TODO Auto-generated method stub
		return fdao.freeboardDelete(no, pwd);
	}

	@Override
	public FreeBoardVO freeboardUpdate(int no) {
		// TODO Auto-generated method stub
		return fdao.freeboardDetailData(no);
	}

	@Override
	public String freeboardUpdate(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		return fdao.freeboardUpdate(vo);
	}
	
}
