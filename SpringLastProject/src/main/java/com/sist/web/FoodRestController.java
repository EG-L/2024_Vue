package com.sist.web;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("food/")
/*
 * 		사용자(클라이언트 => 브라우저) => 요청(URL) .do
 *                                        ===== 현재 사이트에서 가능
 *    서버
 *    => 라이브러리 (기본 동작을 위한 틀이 만들어져 있기 때문에 => 형식을 맞춰줘야 한다.)
 *    ===============================================================                
 *      DispatcherServlet => 요청 받기 (request,response)
 *         web.xml에 셋팅을 한다.
 *      	= WebApplicationContext => 사용자가 등록한 클래스 관리
 *            ==============> 관리가 필요한 모든 클래스를 xml에 설정해서 전송
 *                  <init-param>
 *                  	<param-name></param-name>
 *                  	<param-value></param-value>
 *                  </init-param>
 *      	= HandlerMapping : 요청시에 처리하는 Controller/RestController를 찾는 역할
 *      	= viewResolver : JSP를 찾아서 Request를 전송
 *    ===============================================================
 *    Model : Controller / RestController
 *            => HandlerMapping에서 해당 메소드를 찾을 수 있게 만든다.
 *                                =========
 *                                @GetMapping,@PostMapping,@RequestMapping
 *            => 조립기
 *               요청을 받아서 => 응답하기
 *                       처리 => DB
 *    Mapper : 테이블 1개를 다루는 경우
 *    Service : 관련된 Mapper가 여러 개 있는 경우
 *    DAO
 *    ==================================== DB연동 (MyBatis는 데이터베이스 연결)
 *    View(JSP) : 화면 출력
 *    ==================================== 요청 (form , a , axios , ajax)
 *                                             =========  =============
 *                                              |화면 변경    | 변경 없이 화면 처리
 *    
 *    list.do ========> DispatcherServlet
 *                           ====> list.do처리 메소드를 찾아라
 *                                 HandlerMapping
 *                           ====> list.do에 대한 처리 ==> 개발자
 *                                 @GetMapping("list.do")
 *                           ====> JSP를 응답값에 전송 / 화면 변경
 *                           --------------------------------- Model
 *                                             @Controller,@RestController
 *                           
 *                           ===> JSP를 찾아서 request를 전송
 *                                =======================
 *                                  ViewResolver ==> 경로명 , 확장자 확인 => 등록
 *        => 어노테이션 / XML => 스프링 동작을 위한 메뉴얼 제작
 *        => Model / JSP
 *             |
 *           DAO/Service ==> MyBatis
 *           
 *       Model
 *       =====
 *         => RestController
 *             => 다른 언어와 연동 ==> JSON
 *             => 자바스크립트와 자바 연동
 *                자바 => VO => {} (Object)
 *                자바 => List => [] (Array)
 *                => 나머지는 동일
 *         => Controller : 화면 이동 (변경)
 *            => forward => request 전송할 경우
 *                          ======= 스프링에서 제공하는 전송 객체 : Model
 *                          return "폴더명/JSP명";
 *            => redirect => 재호출 => .do
 *                          request를 초기화 
 *                          return "redirect:...do";
 *                          _ok
 * */
public class FoodRestController {
	@Autowired
	private FoodService service;
	
	@GetMapping(value = "find_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_find(int page,String fd) throws Exception{
		int rowSize = 20;
		int start = (rowSize*page)-(rowSize-1);
		int end = (rowSize*page);
		
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("address", fd);
		
		List<FoodVO> list = service.foodFindData(map);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		
		return json;
	}
	
	@GetMapping(value = "page_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_page(int page,String fd) throws Exception{
		Map map = new HashMap();
		map.put("address", fd);
		int totalpage = service.foodFindCount(map);
		
		int BLOCK = 10;
		int startPage = ((page-1)/BLOCK*BLOCK)+1;
		int endPage = ((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage) endPage=totalpage;
		
		map = new HashMap();
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("endPage", endPage);
		map.put("startPage",startPage);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		return json;
	}
	/*
	 * 중요
	 * = 어노테이션은 반드시 밑에 있는 변수, 메소드 , 클래스를 제어
	 * */
	@GetMapping(value = "detail_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_detail(int fno) throws Exception{
		
		FoodVO vo = service.foodDetailData(fno);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(vo);
		
		return json;
	}
}
