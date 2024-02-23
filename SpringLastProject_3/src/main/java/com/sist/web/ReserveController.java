package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.vo.ReserveVO;

@Controller
public class ReserveController {
	@GetMapping("reserve/reserve_main.do")
	public String food_reserve() {
		return "reserve/reserve_main";
	}
	
	@GetMapping("mypage/mypage.do")
	public String mypage_main() {
		return "mypage/mypage_main";
	}
}
