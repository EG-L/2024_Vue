package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;


public interface ReserveMapper {
	@Select("SELECT fno,poster,name "
			+ "FROM food_menu_house "
			+ "WHERE REGEXP_LIKE(type,#{type})")
	public List<FoodVO> foodReserveData(String type);// 한식 중식 양식 일식
	
	@Insert("INSERT INTO reserve VALUES("
			+ "re_rno_seq.nextval,#{fno},#{userId},#{rDate},#{rTime},#{rInwon},SYSDATE,0)")
	public void foodReserveInsert(ReserveVO vo);
	
	@Results({
		@Result(column = "name",property = "fvo.name",jdbcType = JdbcType.VARCHAR),
		@Result(column = "poster",property = "fvo.poster",jdbcType = JdbcType.VARCHAR)
	})
	@Select("SELECT rno,r.fno,name,poster,rDate,rTime,rInwon,reserve_ok,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday "
			+ "FROM reserve r, food_menu_house f "
			+ "WHERE r.fno=f.fno AND userId=#{userId} "
			+ "ORDER BY rno DESC")
	public List<ReserveVO> reserveMypageData(String userId);
	
	@Delete("DELETE FROM reserve "
			+ "WHERE rno=#{rno}")
	public void reserveCancel(int rno);
}
