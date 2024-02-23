package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.sist.service.*;
import com.sist.vo.*;

import java.security.Principal;
import java.util.*;

@Controller
public class ChatController {
	@Autowired
	private MemberService service;
	
	@GetMapping("chat/chat.do")
	public String chat_chat(Model model) {
//		
//		MemberVO vo = service.memberInfo(p.getName());
//		
//		model.addAttribute("vo",vo);
		
		return "chat/chat";
	}
}
