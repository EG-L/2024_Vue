package com.sist.vo;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
/*
 * 	   기본
 *     ===
 *      src
 *       = com.sist.config : XML 대신 스플링에 클래스 관계를 설정
 *                           => 5버전의 핵심 (권장) => 보안
 *                           => Spring-Boot (포함 => SpringFramework) => XML(pom.xml)
 *                           => 순수하게 자바로만 설정
 *                              <context:component-scan>
 *                              @ComponentScan()
 *                              <mybatis-spring>
 *                              @MapperScan()
 *                              <bean>
 *                              @Bean
 *       ***= com.sist.dao : 데이터베이스 연결
 *       = com.sist.service : DAO 통합 => interface (결합성을 낮게 만든다)
 *       ***= com.sist.vo : 사용자 정의 데이터형
 *       ***= com.sist.web : Model 클래스(요청 => 응답)
 *       = com.sist.interceptor : Model 연결 전 , JSP 연결 전
 *                                preHandle()   postHandle()
 *                                => 자동 로그인   => 권한
 *       = com.sist.aop : 공통모듈
 *       = com.sist.manager : 오픈api 이용 시 사용 => 실시간 뉴스 읽기 등
 *       = com.sist.commons : 공통 예외 처리
 *       = com.sist.security : 보안 => 암호화 / 복호화 / 권한 / 메소드 보안
 *       = com.sist.chat : 실시간 상담
 *       
 *       => 모든 패키지의 메모리 할당 요청 ==> 스프링 (클래스 관리) => 생성 / 소멸
 *                                                      -----------
 *                                                      1. 스프링에 클래스 메모리 주소 요청
 *                                                         => @Autowired
 *       => 서블릿 (자바로 만들어진 웹 파일)
 *          server + let
 *          => 서버에서 실행하는 가벼운 프로그램
 *          => 서블릿은 실행을 하는 대상 => 톰캣 (request/response)
 *             ============================================ 웹서버
 *             => 서블릿은 무조건 톰캣에 등록
 *                           =========
 *                           web.xml => @WebServlet("*.do")
 *             => DispatcherServlet 등록
 *                => WebApplicationContext
 *                => HandlerMapping
 *                => XML => 자동생성 , Annotation 직접 생성 요청
 *                => URL에 따라서 => 톰캣이 관리
 *        list.do =======================> DispatcherServlet
 *                 톰캣(request,response)
 *                        public void service(request,response){
 *                              => Model을 찾아준다. ==> HandlerMapping
 *                                => 기능 수행 (메소드) => 구분자 @GetMapping , @PostMapping
 *                              => return을 읽어 온다.
 *                              => JSP 찾기 ==> ViewResolver (경로명)
 *                              => request를 전송
 *                        }
 *                        
 * */
@Data
public class DataBoardVO {
	private int no,hit,filecount;
	private String name,subject,content,pwd,filename,filesize,dbday;
	private Date regdate;
	private List<MultipartFile> files;
}
