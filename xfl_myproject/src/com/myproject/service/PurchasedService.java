package com.myproject.service;

import java.util.List;

import com.myproject.dao.PurchasedDao;
import com.myproject.entity.Purchased;

public class PurchasedService {

	private PurchasedDao pcDao=new PurchasedDao();
	public int addPurchased(Purchased pc){
		
		return pcDao.addPurchased(pc);
	}
	public List<Purchased> getAllPurchasedByybid(String yb_userid){
		
		return pcDao.getAllPurchasedByybid(yb_userid);
	}
	
}
