package com.myproject.service;

import java.util.List;


import com.myproject.dao.BarterDao;
import com.myproject.entity.Barter;

public class BarterService {
	
	private BarterDao pdDao=new BarterDao();
	
	public List<Barter> getAllProduct(String state){
		return pdDao.getAllProduct(state);
	}
	
	public int addProduct(Barter pd){
		return pdDao.addProduct(pd);
	}
	
	public List<Barter> getAllProductByca(String category){
		
		return pdDao.getAllProductByca(category);
	}
	
	public int deleteProduct(String id) {
		return pdDao.deleteProduct(id);
	}
	
	public Barter getProductById(String id)
	{
		return pdDao.getProductById(id);
	}
	
	public int updateProduct(Barter pd) {
		return pdDao.updateProduct(pd);
	}
	public List<Barter> getRandomProduct(){
		return pdDao.getRandomProduct();
	}
	
	public List<Barter> getAllProductByybid(String yb_userid){
		
		return pdDao.getAllProductByybid(yb_userid);
	}
	
	public int updatePdState(Barter pd){
		
		return pdDao.updatePdState(pd);
	}
	
	public List<Barter> getAllSellpdofUser(String yb_userid){
		
		return pdDao.getAllSellpdofUser(yb_userid);
	}

}
