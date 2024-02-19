package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	public int memberIdCount(String id) {
		return mapper.memberIdCount(id);
	}
	
	public void memberInsert(MemberVO vo) {
		mapper.memberInsert(vo);
	}
	
	public void memberAuthorityInsert(String userId) {
		mapper.memberAuthorityInsert(userId);
	}
}
