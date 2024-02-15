package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {
	@GetMapping(value = "recipe/recipe_list.do",produces = "text/plain;charset=UTF-8")
	public String recipe_list() {
		return "recipe/recipe_list";
	}
	
	@GetMapping(value = "recipe/chef_list.do",produces = "text/plain;charset=UTF-8")
	public String chef_list() {
		return "recipe/chef_list";
	}
	@GetMapping(value = "recipe/chef_detail.do",produces = "text/plain;charset=UTF-8")
	public String chef_detail(int cno,Model model) {
		return "recipe/chef_detail";
	}
}
