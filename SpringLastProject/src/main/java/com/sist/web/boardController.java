package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sist.vo.*;
import com.sist.manager.*;
import com.sist.service.*;

@Controller
@RequestMapping("freeboard/")
public class boardController {
	@Autowired
	private FreeBoardService service;
	
	@Autowired
	private WordManager mgr;
	
	@GetMapping("list.do")
	public String freeboard_list() {
		return "freeboard/list";
	}
	
	@GetMapping("insert.do")
	public String freeboard_insert() {
		return "freeboard/insert";
	}
	@GetMapping("detail.do")
	public String freeboarddetail(int no,Model model) {
		FreeBoardVO vo = service.freeboardUpdate(no);
		List<WordVO> list = mgr.wordListData(vo.getContent());
		model.addAttribute("list",list);
		model.addAttribute("no",no);
		return "freeboard/detail";
	}
	@GetMapping("update.do")
	public String freeboardUpdate(int no,Model model) {
		model.addAttribute("no",no);
		return "freeboard/update";
	}
}
