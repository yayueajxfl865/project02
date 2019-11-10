package com.myproject.service;

import java.util.List;

import com.myproject.dao.GoodsDao;
import com.myproject.entity.Goods;

public class GoodsService {
	
	private GoodsDao goodsDao=new GoodsDao();
	
	public List<Goods> getAllGoods(){
		
		return goodsDao.getAllGoods();
	}
	
	public int addGoods(Goods pd){
		
		return goodsDao.addGoods(pd);
	}
	
	public int deleteGoods(String id){
		
		return goodsDao.deleteGoods(id);
	}
	public Goods getGoodsById(String id){
		
		return goodsDao.getGoodsById(id);
	}
	public List<Goods> getAllGoodsByybid(String yb_userid){
		return goodsDao.getAllGoodsByybid(yb_userid);
	}
	
	public List<Goods> getAllGoodsByKind(String kind){
		
		return goodsDao.getAllGoodsByKind(kind);
	}

}
