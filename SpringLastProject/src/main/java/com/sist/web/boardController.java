package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("freeboard/")
public class boardController {
	@GetMapping("list.do")
	public String freeboard_list() {
		return "freeboard/list";
	}
}
