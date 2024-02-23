package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface ReplyMapper {
	//목록
	@Select("SELECT no,rno,userId,userName,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday "
			+ "FROM projectRecipeReply "
			+ "WHERE rno=#{rno} "
			+ "ORDER BY no DESC")
	public List<ReplyVO> replyListData(int rno);
	//추가
	@Insert("INSERT INTO projectRecipeReply(no,rno,userId,userName,msg) "
			+ "VALUES(prr_no_seq.nextval,#{rno},#{userId},#{userName},#{msg})")
	public void replyInsert(ReplyVO vo);
	//수정
	@Update("UPDATE projectRecipeReply SET "
			+ "msg=#{msg} "
			+ "WHERE no=#{no}")
	public void replyUpdate(ReplyVO vo);
	//삭제
	@Delete("DELETE FROM projectRecipeReply "
			+ "WHERE no=#{no}")
	public void replyDelete(int no);
	
	//사용자 정보 읽기
	@Select("SELECT userId,userName FROM projectMember "
			+ "WHERE userId=#{userId}")
	public MemberVO memberInfoData(String userId);
}
