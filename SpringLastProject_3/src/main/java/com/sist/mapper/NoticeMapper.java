package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface NoticeMapper {
	@Select("SELECT no,subject,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,rownum "
			+ "FROM (SELECT no,subject,regdate "
			+ "FROM projectNotice ORDER BY hit DESC) "
			+ "WHERE rownum<=7")
	public List<NoticeVO> noticeTop7();
	
	//추가 , 수정 , 삭제 , 목록 출력
}
