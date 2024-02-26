package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;

@Controller
public class BoardController {
	@Autowired
	private BoardService bService;
	
	@GetMapping("board/list.do")
	public String boardListData(String page,Model model) {
		
		return bService.boardListData(page, model);
	}
	
	@GetMapping("board/insert.do")
	public String boardInsert() {
		return "board/insert";
	}
	@PostMapping("board/insert_ok.do")
	public String boardInsertOk(BoardVO vo) {
		return bService.boardInsertOk(vo);
	}
	@GetMapping("board/detail.do")
	public String boardDetailData(int no,Model model) {
		return bService.boardDetailData(no, model);
	}
	
	@GetMapping("board/update.do")
	public String boardUpdateData(int no,Model model) {
		return bService.boardUpdateData(no, model);
	}
	
	@PostMapping("board/update_ok.do")
	public String boardUpdateOk(BoardVO vo,Model model) {
		return "";
	}
}
