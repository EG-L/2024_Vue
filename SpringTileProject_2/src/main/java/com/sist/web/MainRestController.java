package com.sist.web;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;

@RestController
public class MainRestController {
	@Autowired
	private FoodService service;
	
	@GetMapping(value = "food/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_list(int page) throws Exception{
		int rowSize = 12;
		int start = (rowSize*page)-(rowSize-1);
		int end = (rowSize*page);
		
		List<FoodVO> list = service.foodListData(start, end);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		
		return json;
	}
	
	@GetMapping(value = "food/page_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_page(int page) throws Exception{
		int totalpage = service.foodTotalPage();
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;// page=> 1~10 => endPage => 10 유지
		if(endPage>totalpage) endPage=totalpage;
		
		Map map = new HashMap();
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("endPage", endPage);
		map.put("startPage", startPage);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		return json;
	}
	
	@GetMapping(value = "food/detail_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_detail(int fno) throws Exception{
		FoodVO vo = service.foodDetailData(fno);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(vo);
		
		return json;
	}
}
