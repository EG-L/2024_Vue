package com.sist.mapper;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;

public interface MemberMapper {
	@Select("SELECT COUNT(*) FROM vueMember "
			+ "WHERE id=#{id}")
	public int idCount(String id);
	
	@Select("SELECT id,name,pwd FROM vueMember "
			+ "WHERE id=#{id}")
	public MemberVO isLogin(String id);
}
