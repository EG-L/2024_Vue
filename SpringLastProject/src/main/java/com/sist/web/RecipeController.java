package com.sist.web;

import javax.servlet.http.HttpSession;

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
		model.addAttribute("cno",cno);
		
		return "recipe/chef_detail";
	}
	
	@GetMapping("recipe/recipe_detail.do")
	public String recipe_detail(int no,Model model,HttpSession session) {
		String userId=(String)session.getAttribute("userId");
		String sessionId="";
		if(userId==null) {
			sessionId="";
		}
		else {
			sessionId=userId;
		}
		
		model.addAttribute("sessionId",sessionId);
		model.addAttribute("no",no);
		//댓글 넘기기
		
		
		return "recipe/recipe_detail";
	}
}
