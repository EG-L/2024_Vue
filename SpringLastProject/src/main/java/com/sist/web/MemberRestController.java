package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;

@RestController
public class MemberRestController {
	@Autowired
	private MemberService mService;
	
	@GetMapping(value = "member/idcheck_vue.do",produces = "text/plain;charset=UTF-8")
	public String member_idcheck(String userId) {
		int count=mService.memberIdCount(userId);
		return String.valueOf(count);
	}
}
