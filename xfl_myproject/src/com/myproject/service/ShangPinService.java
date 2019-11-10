package com.myproject.service;

import java.util.List;

import com.myproject.dao.ShangPinDao;
import com.myproject.entity.Product;
/*����:Ф����
 * ����ʱ��:2018-11-06
 * �޸�ʱ��:
 *����:ҵ���м�� (Service��)
 */
public class ShangPinService {
	
	private ShangPinDao pdDao=new ShangPinDao();
	
	public List<Product> getAllProduct(String state){
		return pdDao.getAllProduct(state);
	}
	
	public int addProduct(Product pd){
		return pdDao.addProduct(pd);
	}
	
	public List<Product> getAllProductByca(String category){
		
		return pdDao.getAllProductByca(category);
	}
	
	public int deleteProduct(String id) {
		return pdDao.deleteProduct(id);
	}
	
	public Product getProductById(String id)
	{
		return pdDao.getProductById(id);
	}
	
	public int updateProduct(Product pd) {
		return pdDao.updateProduct(pd);
	}
	public List<Product> getRandomProduct(){
		return pdDao.getRandomProduct();
	}
	
	public List<Product> getAllProductByybid(String yb_userid){
		
		return pdDao.getAllProductByybid(yb_userid);
	}
	
	public int updatePdState(Product pd){
		
		return pdDao.updatePdState(pd);
	}
	
	public List<Product> getAllSellpdofUser(String yb_userid){
		
		return pdDao.getAllSellpdofUser(yb_userid);
	}

}
