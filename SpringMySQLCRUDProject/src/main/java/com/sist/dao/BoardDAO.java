package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> boardListData(int start){
		return mapper.boardListData(start);
	}
	
	public int boardTotalPage() {
		return mapper.boardTotalPage();
	}
	
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}
	public BoardVO boardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}
	public BoardVO boardUpdateData(int no) {
		return mapper.boardDetailData(no);
	}
	public boolean boardUpdate(BoardVO vo) {
		boolean bCheck = false;
		String db_pwd = mapper.boardGetPassword(vo.getNo());
		if(vo.getPwd().equals(db_pwd)) {
			bCheck=true;
			mapper.boardUpdate(vo);
		}
		return bCheck;
	}
}
