package com.sist.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.GoodsService;
import com.sist.vo.GoodsVO;

@Controller
public class GoodsController {
	private String[] tables= {"","goods_all","goods_best","goods_special","goods_new"};
	
	@Autowired
	private GoodsService service;
	
	@GetMapping("goods/goods_main.do")
	public String goods_main(String page,String type,Model model) {
		if(page==null) {
			page="1";
		}
		int curpage = Integer.parseInt(page);
		
		if(type==null) {
			type="1";
		}
		
		int rowSize = 12;
		int start = (rowSize*curpage)-(rowSize-1);
		int end = (rowSize*curpage);
		
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("table_name",tables[Integer.parseInt(type)]);
		List<GoodsVO> list = service.goodsListData(map);
		int totalpage = service.goodsTotalPage(map);
		
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("type",type);
		
		return "goods";
	}
	
	@GetMapping("goods/goods_detail.do")
	public String goods_detail(int no,int type,Model model) {
		Map map = new HashMap();
		map.put("table_name", tables[type]);
		map.put("no", no);
		GoodsVO vo = service.goodsDetailData(map);
		
		model.addAttribute("vo",vo);
		
		return "goods/goods_detail";
	}
}
