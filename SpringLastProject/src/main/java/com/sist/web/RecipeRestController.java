package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
@RestController
public class RecipeRestController {
	@Autowired
	private RecipeService rService;
	
	//Vue,React에서 요청 => 자바스크립트가 인식한 데이터로 변경 후에 전송
	//                                         ========== JSON 자바스크립트 객체 표현법
	// vo {}, List[]
	@GetMapping(value = "recipe/recipe_list_vue.do",produces = "text/plain;charset=UTF-8")
	public String recipe_list(int page) throws Exception{
		int rowSize=20;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		List<RecipeVO> list = rService.recipeListData(start, end);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		
		return json;
	}
	
	@GetMapping(value = "recipe/recipe_page_vue.do",produces = "text/plain;charset=UTF-8")
	public String recipe_page(int page) throws Exception{
		int totalpage = rService.recipeTotalPage();
		int count = rService.recipeCount();
		final int BLOCK = 10;
		int startPage = ((page-1)/BLOCK*BLOCK)+1;
		int endPage = ((page-1)/BLOCK*BLOCK)+BLOCK;
		
		Map map = new HashMap();
		map.put("curpage",page);
		map.put("count", count);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		return json;
	}
	
	@GetMapping(value = "recipe/chef_list_vue.do",produces = "text/plain;charset=UTF-8")
	public String chef_list(int page) throws Exception{
		int rowSize=20;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		
		List<ChefVO> list = rService.chefListData(start, end);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		
		return json;
	}
	
	@GetMapping(value = "recipe/chef_page_vue.do",produces = "text/plain;charset=UTF-8")
	public String chef_page(int page) throws Exception{
		int totalpage = rService.chefTotalPage();
		final int BLOCK = 10;
		int startPage = ((page-1)/BLOCK*BLOCK)+1;
		int endPage = ((page-1)/BLOCK*BLOCK)+BLOCK;
		
		Map map = new HashMap();
		map.put("curpage",page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		return json;
	}
	// chef => 제작한 레시피 출력
	
}
