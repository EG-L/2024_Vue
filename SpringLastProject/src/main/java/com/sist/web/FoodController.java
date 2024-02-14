package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
	@GetMapping("food/food_find.do")
	public String food_find() {
		return "food/food_find";
	}
	@GetMapping("food/food_list.do")
	public String food_list() {
		return "food/food_list";
	}
	@GetMapping("food/food_list_detail.do")
	public String food_list_detail(int fno,Model model) {
		model.addAttribute("fno",fno);
		return "food/food_list_detail";
	}
}
