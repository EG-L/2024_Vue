package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.ChefVO;
import com.sist.vo.RecipeVO;

@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	public List<ChefVO> ChefHome12(){
		return mapper.ChefHome12();
	}
	public List<RecipeVO> RecipeHome12(){
		return mapper.RecipeHome12();
	}
	public int recipeCount() {
		return mapper.recipeCount();
	}
	public List<RecipeVO> recipeListData(int start,int end){
		return mapper.recipeListData(start, end);
	}
	public int recipeTotalPage() {
		return mapper.recipeTotalPage();
	}
	public List<ChefVO> chefListData(int start,int end){
		return mapper.chefListData(start, end);
	}
	public int chefTotalPage() {
		return mapper.chefTotalPage();
	}
	public List<RecipeVO> chefDetailData(Map map){
		return mapper.chefDetailData(map);
	}
	public int chefDetailTotalPage(int cno) {
		return mapper.chefDetailTotalPage(cno);
	}
	public List<RecipeVO> chefDetailFindData(Map map){
		return mapper.chefDetailFindData(map);
	}
	public int chefDetailFindTotalPage(Map map) {
		return mapper.chefDetailFindTotalPage(map);
	}
	
}
