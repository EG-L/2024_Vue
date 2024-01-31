package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;
import com.sist.vo.BoardVO;

@Repository
public class BoardDAO {
	@Autowired // 스프링에게 구현된 클래스 주소를 입력 요청
	private BoardMapper mapper;
	
	public List<BoardVO> boardListData(int start,int end){
		return mapper.boardListData(start, end);
	}
	public int boardTotalPage() {
		return mapper.boardTotalPage();
	}
	
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}
	
	public BoardVO boardDetail(int no) {
		mapper.hitIncrement(no);
		return mapper.boardDetail(no);
	}
	
	public BoardVO boardUpdateData(int no) {
		return mapper.boardDetail(no);
	}
	
	public String boardUpdate(BoardVO vo) {
		String result="no";
		String db_pwd = mapper.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd())) {
			result="yes";
			mapper.boardUpdate(vo);
		}
		return result;
	}
	
	public String boardDelete(int no,String pwd) {
		String result ="no";
		String db_pwd = mapper.boardGetPassword(no);
		if(db_pwd.equals(pwd)) {
			result="yes";
			mapper.boardDelete(no);
		}
		
		return result;
	}
}
