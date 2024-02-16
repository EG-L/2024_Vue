package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.RecipeDAO;
import com.sist.vo.ChefVO;
import com.sist.vo.GoodsVO;
import com.sist.vo.RecipeDetailVO;
import com.sist.vo.RecipeVO;

@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeDAO rDao;

	@Override
	public List<ChefVO> ChefHome12() {
		// TODO Auto-generated method stub
		return rDao.ChefHome12();
	}

	@Override
	public List<RecipeVO> RecipeHome12() {
		// TODO Auto-generated method stub
		return rDao.RecipeHome12();
	}

	@Override
	public int recipeCount() {
		// TODO Auto-generated method stub
		return rDao.recipeCount();
	}

	@Override
	public List<RecipeVO> recipeListData(int start, int end) {
		// TODO Auto-generated method stub
		return rDao.recipeListData(start, end);
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return rDao.recipeTotalPage();
	}

	@Override
	public List<ChefVO> chefListData(int start, int end) {
		// TODO Auto-generated method stub
		return rDao.chefListData(start, end);
	}

	@Override
	public int chefTotalPage() {
		// TODO Auto-generated method stub
		return rDao.chefTotalPage();
	}

	@Override
	public List<RecipeVO> chefDetailData(Map map) {
		// TODO Auto-generated method stub
		return rDao.chefDetailData(map);
	}

	@Override
	public int chefDetailTotalPage(int cno) {
		// TODO Auto-generated method stub
		return rDao.chefDetailTotalPage(cno);
	}

	@Override
	public List<RecipeVO> chefDetailFindData(Map map) {
		// TODO Auto-generated method stub
		return rDao.chefDetailFindData(map);
	}

	@Override
	public int chefDetailFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return rDao.chefDetailFindTotalPage(map);
	}

	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		// TODO Auto-generated method stub
		return rDao.recipeDetailData(no);
	}

	@Override
	public List<GoodsVO> recipeGoodsData(String goods_name) {
		// TODO Auto-generated method stub
		return rDao.recipeGoodsData(goods_name);
	}
}
