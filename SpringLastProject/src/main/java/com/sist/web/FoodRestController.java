package com.sist.web;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("food/")
public class FoodRestController {
	@Autowired
	private FoodService service;
	
	@GetMapping(value = "find_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_find(int page,String fd) throws Exception{
		int rowSize = 20;
		int start = (rowSize*page)-(rowSize-1);
		int end = (rowSize*page);
		
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("address", fd);
		
		List<FoodVO> list = service.foodFindData(map);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		
		return json;
	}
	
	@GetMapping(value = "page_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_page(int page,String fd) throws Exception{
		Map map = new HashMap();
		map.put("address", fd);
		int totalpage = service.foodFindCount(map);
		
		int BLOCK = 10;
		int startPage = ((page-1)/BLOCK*BLOCK)+1;
		int endPage = ((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage) endPage=totalpage;
		
		map = new HashMap();
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("endPage", endPage);
		map.put("startPage",startPage);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		return json;
	}
}
