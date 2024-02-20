package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.ReplyService;
import com.sist.vo.ReplyVO;

import java.util.*;

import javax.servlet.http.HttpSession;

@RestController
public class ReplyRestController {
	@Autowired
	private ReplyService rService;
	
	// insert,update,delete
	public String commonsReplyData(int rno) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		List<ReplyVO> list = rService.replyListData(rno);
		
		String json = mapper.writeValueAsString(list);
		
		return json;
	}
	
	@PostMapping(value="recipe/reply_insert_vue.do",produces = "text/plain;charset=UTF-8")
	public String reply_insert(ReplyVO vo,HttpSession session) throws Exception{
		String userId = (String)session.getAttribute("userId");
		String userName = (String)session.getAttribute("userName");
		vo.setUserId(userId);
		vo.setUserName(userName);
		//rno,msg
		rService.replyInsert(vo);
		
		return commonsReplyData(vo.getRno());
	}
	
	//수정
	
	//삭제
	@GetMapping(value = "recipe/reply_delete_vue.do",produces = "text/plain;charset=UTF-8")
	public String reply_delete(int no,int rno) throws Exception{
		rService.replyDelete(no);
		
		return commonsReplyData(rno);
	}
	
	@PostMapping(value="recipe/reply_update_vue.do",produces = "text/plain;charset=UTF-8")
	public String reply_update(ReplyVO vo) throws Exception{
		rService.replyUpdate(vo);
		
		return commonsReplyData(vo.getRno());
	}
}
