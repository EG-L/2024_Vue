package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO bDao;
	
	@Override
	public String boardListData(String page, Model model) {
		// TODO Auto-generated method stub
		if(page==null) {
			page="1";
		}
		int curpage = Integer.parseInt(page);
		int rowSize = 10;
		int start = (rowSize*curpage)-(rowSize);
		List<BoardVO> list = bDao.boardListData(start);
		int totalpage = bDao.boardTotalPage();
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		
		return "board/list";
	}

	@Override
	public String boardInsertOk(BoardVO vo) {
		// TODO Auto-generated method stub
		bDao.boardInsert(vo);
		return "redirect:list.do";
	}

	@Override
	public String boardDetailData(int no, Model model) {
		// TODO Auto-generated method stub
		BoardVO vo = bDao.boardDetailData(no);
		model.addAttribute("vo",vo);
		return "board/detail";
	}

	@Override
	public String boardUpdateData(int no, Model model) {
		// TODO Auto-generated method stub
		BoardVO vo = bDao.boardUpdateData(no);
		
		model.addAttribute("vo",vo);
		return "board/update";
	}

	@Override
	public String boardUpdateOk(BoardVO vo, Model model) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
