package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MemberMapper;
import com.sist.vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	public MemberVO isLogin(String id,String pwd) {
		MemberVO vo = new MemberVO();
		int count = mapper.idCount(id);
		if(count==0) {
			vo.setMsg("NOID");
		}
		else {
			MemberVO dbvo = mapper.isLogin(id);
			if(pwd.equals(dbvo.getPwd())) {
				vo.setMsg("OK");
				vo.setName(dbvo.getName());
				vo.setId(dbvo.getId());
			}
			else {
				vo.setMsg("NOPWD");
			}
		}
		return vo;
	}
}
