package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.ChefVO;
import com.sist.vo.GoodsVO;
import com.sist.vo.RecipeDetailVO;
import com.sist.vo.RecipeVO;

public interface RecipeMapper {
	/*
	 * CNO                                       NOT NULL NUMBER
 CHEF                                      NOT NULL VARCHAR2(100)
 POSTER                                    NOT NULL VARCHAR2(500)
 MEM_CONT1                                          NUMBER
 MEM_CONT2                                          NUMBER
 MEM_CONT3                                          NUMBER
 MEM_CONT7                                          NUMBER
	 * */
	@Select("SELECT cno,CHEF,POSTER,MEM_CONT7,rownum "
			+ "FROM (SELECT cno,chef,poster,mem_cont7 "
			+ "FROM chef ORDER BY mem_cont7 DESC) "
			+ "WHERE rownum<=12")
	public List<ChefVO> ChefHome12();
	/*
	 *  NO                                        NOT NULL NUMBER
	 TITLE                                     NOT NULL VARCHAR2(2000)
	 POSTER                                    NOT NULL VARCHAR2(500)
	 CHEF                                      NOT NULL VARCHAR2(200)
	 LINK                                      NOT NULL VARCHAR2(300)
	 JJIMCOUNT                                          NUMBER
	 HIT                                                NUMBER
	 * */
	@Select("SELECT no,title,poster,hit,rownum "
			+ "FROM (SELECT no,title,poster,hit "
			+ "FROM recipe ORDER BY hit DESC) "
			+ "WHERE rownum<=12")
	public List<RecipeVO> RecipeHome12();
	
	// 목록 출력
	@Select("SELECT COUNT(*) FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe "
			+ "INTERSECT SELECT no FROM recipeDetail)")
	public int recipeCount();
	
	@Select("SELECT no,title,poster,num "
			+ "FROM (SELECT no,title,poster,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,title,poster "
			+ "FROM recipe WHERE no IN(SELECT no FROM recipe "
			+ "INTERSECT SELECT no FROM recipeDetail)"
			+ ")) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/20) FROM recipe WHERE no IN(SELECT no FROM recipe "
			+ "INTERSECT SELECT no FROM recipeDetail)")
	public int recipeTotalPage();
	// 상세보기
	// 쉐프 목록
	@Select("SELECT cno,chef,poster,mem_cont1,mem_cont2,mem_cont3,mem_cont7,num "
			+ "FROM (SELECT cno,chef,poster,mem_cont1,mem_cont2,mem_cont3,mem_cont7,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(chef chef_cno_pk)*/cno,chef,poster,mem_cont1,mem_cont2,mem_cont3,mem_cont7 "
			+ "FROM chef)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<ChefVO> chefListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/50) FROM chef")
	public int chefTotalPage();
	// 쉐프별 레시피
	@Select("SELECT no,title,poster,chef,num "
			+ "FROM (SELECT no,title,poster,chef,rownum as num "
			+ "FROM (SELECT no,title,poster,chef "
			+ "FROM recipe WHERE chef=(SELECT chef FROM chef WHERE cno=#{cno}))) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> chefDetailData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20) FROM recipe "
			+ "WHERE chef=(SELECT chef FROM chef WHERE cno=#{cno})")
	public int chefDetailTotalPage(int cno);
	
	@Select("SELECT no,title,poster,chef,num "
			+ "FROM (SELECT no,title,poster,chef,rownum as num "
			+ "FROM (SELECT no,title,poster,chef "
			+ "FROM recipe WHERE chef=(SELECT chef FROM chef WHERE cno=#{cno} AND REGEXP_LIKE(title,#{title})))) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> chefDetailFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20) FROM recipe "
			+ "WHERE chef=(SELECT chef FROM chef WHERE cno=#{cno} AND REGEXP_LIKE(title,#{title}))")
	public int chefDetailFindTotalPage(Map map);
	
	@Select("SELECT * FROM recipeDetail "
			+ "WHERE no=#{no}")
	public RecipeDetailVO recipeDetailData(int no);
	
	@Select("SELECT goods_poster,goods_name,goods_price "
			+ "FROM goods_all "
			+ "WHERE REGEXP_LIKE(goods_name,#{goods_name})")
	public List<GoodsVO> recipeGoodsData(String goods_name);
}
