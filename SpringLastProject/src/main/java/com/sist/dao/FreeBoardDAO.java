package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.FreeBoardVO;

@Repository
public class FreeBoardDAO {
	@Autowired
	private FreeBoardMapper mapper;
	
	public List<FreeBoardVO> freeboardListData(int start,int end){
		return mapper.freeboardListData(start, end);
	}
	
	public int freeboardTotalPage() {
		return mapper.freeboardTotalPage();
	}
	
	public void freeboardInsert(FreeBoardVO vo) {
		mapper.freeboardInsert(vo);
	}
	public FreeBoardVO freeboardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.freeboardDetailData(no);
	}
	
	public String freeboardDelete(int no,String pwd) {
		String db_pwd = mapper.freeboardGetPassword(no);
		String result = "no";
		if(db_pwd.equals(pwd)) {
			result="yes";
			mapper.freeboardDelete(no);
		}
		
		return result;
	}
	public FreeBoardVO freeboardUpdate(int no) {
		return mapper.freeboardDetailData(no);
	}
	
	public String freeboardUpdate(FreeBoardVO vo) {
		String result = "no";
		String db_pwd = mapper.freeboardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd())) {
			result = "yes";
			mapper.freeboardUpdate(vo);
		}
		return result;
	}
}
