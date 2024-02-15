package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.ChefVO;
import com.sist.vo.RecipeVO;

public interface RecipeService {
	public List<ChefVO> ChefHome12();
	public List<RecipeVO> RecipeHome12();
	public int recipeCount();
	public List<RecipeVO> recipeListData(int start,int end);
	public int recipeTotalPage();
	public List<ChefVO> chefListData(int start,int end);
	public int chefTotalPage();
	public List<RecipeVO> chefDetailData(Map map);
	public int chefDetailTotalPage(int cno);
	public List<RecipeVO> chefDetailFindData(Map map);
	public int chefDetailFindTotalPage(Map map);
}
