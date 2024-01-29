package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//Vue로 데이터 전송 => [] =>목록출력 , {} =>상세보기
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping(value = "food/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_list_vue() throws Exception{
		List<FoodVO> list = dao.foodListData();
		ObjectMapper mapper = new ObjectMapper();//ObjectMapper 호출
		String json = mapper.writeValueAsString(list);//Json 송신
		return json;
	}
}
