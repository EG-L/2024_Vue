package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO gDao;
	
	@GetMapping("goods/list.do")
	public String goods_list(String page,Model model) {
		// Model JSP 값 전송 시 사용 (전송 객체)
		
		if(page==null) {
			page="1";
		}
		int curpage = Integer.parseInt(page);
		int rowSize = 20;
		int start = (rowSize*curpage)-rowSize;
		// LIMIT => 0번부터 시작 , rownum => 1번부터 시작
		List<GoodsVO> list = gDao.goodsListData(start);
		int totalpage = gDao.goodsTotalPage();
		//JSP에서 출력할 데이터 전송
		System.out.println("11111");
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		
		return "goods/list";
		
	}
}
