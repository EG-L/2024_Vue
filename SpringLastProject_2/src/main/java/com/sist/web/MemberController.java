package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.service.*;
import com.sist.vo.*;

@Controller
public class MemberController {
	// sercurity => 4, 5(반드시 비밀번호 암호화)
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private MemberService mService;
	
	@GetMapping("member/join.do")
	public String member_join() {
		return "member/join";
	}
	
	@PostMapping("member/join_ok.do")
	public String member_join_ok(MemberVO vo) {
		vo.setPhone(vo.getPhone1()+"-"+vo.getPhone2());
		String enPwd = encoder.encode(vo.getUserPwd());
		vo.setUserPwd(enPwd);
		mService.memberInsert(vo);
		mService.memberAuthorityInsert(vo.getUserId());
		return "main";
	}
	
	@GetMapping("member/login.do")
	public String member_login() {
		return "member/login";
	}
	
//	@GetMapping("member/logout.do")
//	public String member_logout(HttpSession session) {
//		session.invalidate();
//		
//		return "redirect:../main/main.do";
//	}
}
