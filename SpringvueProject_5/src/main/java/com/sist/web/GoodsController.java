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

import com.sist.dao.FoodVO;
import com.sist.dao.GoodsDAO;
import com.sist.dao.GoodsVO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;
	
	@GetMapping("goods/list.do")
	public String goods_list() {
		return "goods/list";
	}
	
	@GetMapping(value = "goods/list_ok.do" ,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String goods_list_ok(int page) {
		int rowSize = 20;
		int start = (rowSize*page)-(rowSize-1);
		int end = (rowSize*page);
		Map map = new HashMap();
		map.put("start", start);
		map.put("end",end);
		int totalpage = dao.goodsTotalPage();
		final int BLOCK = 10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if (endPage>totalpage) {
			endPage=totalpage;
		}
		int i = 0;
		List<GoodsVO> list = dao.goodsData(map);
		JSONArray arr = new JSONArray();
		for(GoodsVO vo:list) {
			JSONObject obj = new JSONObject();
			obj.put("name", vo.getName());
			obj.put("poster", vo.getPoster());
			obj.put("price", vo.getPrice());
			
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
}
