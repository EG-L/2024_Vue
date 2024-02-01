package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * 	선택적 메모리할당
 * --------------------- 기능별로 분리
 * => Component : AOP,MainClass,Open Api => 일반 클래스
 * => @Repository : DAO(저장소 데이터베이스 연결)
 * => @Service : BI => DAO여러개 통합(기능 통합) =>
 *               BoardDAO / ReplyDAO => 기능별로 클래스 만든다. (재사용)
 * => @Controller : Model (요청 처리 => 응답) => 페이지 설정
 * => @RestController : Model (요청 처리 => 응답) => 실제 처리된 데이터만 전송
 *     ==== 다른 프로그램과 연동 (자바스크립트)
 * => @ControllerAdvice : Controller에서 오류 발생시 예외 처리 (공통)
 * => @RestControllerAdvice : RestController에서 오류 발생시 예외 처리 (공통)
 * => @Configureation : XML 대신에 클래스 설정을 자바로 변경
 * */
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> databoardListData(int start,int end){
		return mapper.databoardListData(start, end);
	}
	public int databoardTotalPage() {
		return mapper.databoardTotalPage();
	}
	public void databoardInsert(DataBoardVO vo) {
		mapper.databoardInsert(vo);
	}
}
