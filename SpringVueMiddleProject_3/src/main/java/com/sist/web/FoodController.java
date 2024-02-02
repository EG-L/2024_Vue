package com.sist.web;

import org.springframework.stereotype.Controller;
/*
 *  => 화면 변경 / 다운로드
 *     String / void
 *     => forward / sendRedirect => return "redirect:..do" => request를 초기화
 *                  => _ok => 기존의 화면을 이용
 *        return "경로/파일명" => request에 값을 추가해서 전송
 * */
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FoodController {
	@GetMapping("food/list.do")
	public String food_list() {
		return "food/list";
	}
	
}