package com.sist.service;

import com.sist.vo.MemberVO;

public interface MemberService {
	public int memberIdCount(String id) ;
	public void memberInsert(MemberVO vo);
	public void memberAuthorityInsert(String userId);
}
