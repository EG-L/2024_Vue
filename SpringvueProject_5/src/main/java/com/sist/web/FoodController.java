package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	@GetMapping("food/list.do")
	public String food_list() {
		return "food/list";
	}
	@GetMapping(value = "food/list_vue.do",produces = "text/plian;charset=UTF-8")
	@ResponseBody
	// => @RestController
	public String food_list_vue(int page) {
		//VueJS => 연결전에 초기값을 설정
		/*
		 * data(){
		 * 	return {
		 * 	  page:1
		 * 	}
		 * }
		 * */
		int rowSize = 20;
		int start = (rowSize*page)-(rowSize-1);
		int end = (rowSize*page);
		Map map = new HashMap();
		map.put("start", start);
		map.put("end",end);
		List<FoodVO> list = dao.foodListData(map);
		int totalpage = dao.foodTotalPage();
		final int BLOCK = 10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if (endPage>totalpage) {
			endPage=totalpage;
		}
		int i = 0;
		JSONArray arr = new JSONArray();
		for(FoodVO vo:list) {
			JSONObject obj = new JSONObject();
			obj.put("fno", vo.getFno());
			obj.put("name", vo.getName());
			obj.put("poster", vo.getPoster());// {"fno":1,"name":'홍길동',"poster":"....jpg"}
			
			if(i==0) {
				obj.put("curpage", page);
				obj.put("totalpage", totalpage);
				obj.put("startPage", startPage);
				obj.put("endPage", endPage);
			}
			
			arr.add(obj);
			i++;
		}
		return arr.toJSONString();
	}
	@GetMapping("food/page_vue.do")
	@ResponseBody
	public String food_page_vue(int page) {
		return "";
	}
}
