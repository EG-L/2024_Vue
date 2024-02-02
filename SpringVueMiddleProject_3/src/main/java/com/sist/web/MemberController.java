package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.FoodService;

@Controller
public class MemberController {
	@Autowired
	private FoodService service;
	
	@GetMapping("member/logout.do")
	public String member_logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:../food/list.do";
	}
}
