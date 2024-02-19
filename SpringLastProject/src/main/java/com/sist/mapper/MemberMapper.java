package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;

public interface MemberMapper {
	//1. 회원가입
	@Select("SELECT COUNT(*) FROM projectMember "
			+ "WHERE userid=#{id}")
	public int memberIdCount(String id);
	// => ID 중복체크
	@Insert("INSERT INTO projectMember(userid,username,userpwd,sex,birthday,email,post,addr1,addr2,phone"
			+ ",content) VALUES(#{userId},#{userName},#{userPwd},#{sex},#{birthday},"
			+ "#{email},#{post},#{addr1},#{addr2},#{phone},#{content})")
	public void memberInsert(MemberVO vo);
	
	@Insert("INSERT INTO projectAuthority VALUES(#{userId},'ROLE_USER')")
	public void memberAuthorityInsert(String userId);
	//2. 로그인
}
