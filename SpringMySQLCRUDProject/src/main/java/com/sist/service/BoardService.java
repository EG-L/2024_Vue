package com.sist.service;

import org.springframework.ui.Model;

import com.sist.vo.BoardVO;

public interface BoardService {
	public String boardListData(String page,Model model);
	public String boardInsertOk(BoardVO vo);
	public String boardDetailData(int no,Model model);
	public String boardUpdateData(int no,Model model);
	public String boardUpdateOk(BoardVO vo,Model model);
}
