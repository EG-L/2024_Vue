package com.sist.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 서비스
오늘의선곡 레이블 PICK 디깅 업 방해금지모드 Travellist 감성 라이팅 왓츠인마이플리 뉴트로 뮤우-직 진희네 고민 상담소 돌비애트모스
장르
가요 발라드 댄스 R&B/소울 락/메탈 POP 랩/힙합 일렉트로니카 인디 블루스/포크 트롯 OST JPOP 재즈 클래식 뉴에이지 월드뮤직
상황
출/퇴근길 휴식 일/공부 집 카페 휴가/여행 드라이브 산책 운동 하우스파티 시상식 집중 거리 클럽 고백 해변 공연 라운지 애도
감성
기분전환 외로움 슬픔 힘찬 이별 지침/힘듦 설렘 오후 위로 밤 새벽 저녁 아침 사랑 스트레스/짜증 그리움 추억 우울 행복 불안 분노 기쁨 축하
스타일
밝은 신나는 편안한 따뜻한 그루브한 부드러운 로맨틱한 웅장한 매혹적인 영화음악 잔잔한 몽환적인 댄서블한 달콤한 시원한 애절한 어두운 연주음악 발렌타인데이 화이트데이
날씨/계절
봄 여름 가을 겨울 맑은날 추운날 흐린날 비오는날 더운날 안개낀날 눈오는날
 * */
@Controller
public class FoodController {
	@GetMapping("food/food_find.do")
	public String food_find() {
		return "food/food_find";
	}
	@GetMapping("food/food_list.do")
	public String food_list() {
		return "food/food_list";
	}
	@GetMapping("food/food_list_detail.do")
	public String food_list_detail(int fno,Model model) {
		model.addAttribute("fno",fno);
		return "food/food_list_detail";
	}
	@GetMapping("food/food_before_list_detail.do")
	public String food_before_detail(int fno,RedirectAttributes ra,HttpServletResponse response) {
		Cookie cookie = new Cookie("food_"+fno, String.valueOf(fno));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		
		response.addCookie(cookie);
		
		ra.addAttribute("fno",fno);
		return "redirect:../food/food_list_detail.do";
	}
	@GetMapping("recipe/recipe_test.do")
	public String food_test() {
		return "recipe/recipe_test";
	}
	
	@GetMapping("food/food_recommand.do")
	public String food_recommand(String type,Model model)
	{
		String[] menu1= {
				"퇴근길","휴식","일/공부","집","카페","휴가/여행","드라이브","산책","운"
		};
		String[] menu2= {
				"기분전환","외로움","슬픔","힘찬","이별","지침/힘듦","설렘","오후","위로","밤","새벽","저녁","아침","사랑","스트레스/짜증"};
		String[] menu3= {
				"밝은","신나는","편안한","따뜻한","그루브한","부드러운","로맨틱한","웅장한","매혹적인","영화음악","잔잔한"
		};
		String data = "봄 여름 가을 겨울 맑은날 추운날 흐린날 비오는날 더운날 안개낀날 눈오는날";
		String[] menu4= new String[data.split(" ").length];
		for(int i = 0;i<data.split(" ").length;i++) {
			menu4[i] = data.split(" ")[i];
		}
		
		if(type==null) {
			type="1";
		}
		
		return "food/food_recommand";
	}
}
