package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
	@GetMapping("food/detail.do")
	public String food_detail(int fno,Model model,HttpSession session) {
		
		
		String id = (String)session.getAttribute("id");
		
		model.addAttribute("id",id);
		model.addAttribute("fno",fno);
		return "food/detail";
	}
}
