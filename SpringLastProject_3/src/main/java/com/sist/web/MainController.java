package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.sist.service.*;

@Controller
public class MainController {
	@Autowired
	private FoodService service;
	@Autowired
	private RecipeService rservice;
	
	@Autowired
	private MemberService mService;
	
	@GetMapping("main/main.do")
	public String main_main(Model model,Principal p,HttpSession session) {
		if(p!=null) {
			MemberVO vo = mService.memberSessionData(p.getName());
			session.setAttribute("userId", vo.getUserId());
			session.setAttribute("userName", vo.getUserName());
			session.setAttribute("sex",vo.getSex());
			session.setAttribute("address", vo.getAddr1()+" "+vo.getAddr2());
			session.setAttribute("phone", vo.getPhone());
			session.setAttribute("email", vo.getEmail());
		}
		
		// JSP로 값을 전송 객체 => 전송 객체
		List<FoodVO> foodList = service.foodHome12();
		List<ChefVO> chefList = rservice.ChefHome12();
		List<RecipeVO> recipeList = rservice.RecipeHome12();
		model.addAttribute("foodList",foodList);
		model.addAttribute("chefList",chefList);
		model.addAttribute("recipeList",recipeList);
		return "main";
	}
}
