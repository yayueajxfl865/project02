package com.myproject.service;

import java.util.List;

import com.myproject.dao.OperatorDao;
import com.myproject.entity.Operator;

public class OperatorService {
	
	private OperatorDao peratorDao=new OperatorDao();
	
	public List<Operator> getAllOperator(){
		return peratorDao.getAllOperator();
	}
	public int addOperator(Operator ot) {
		
		return peratorDao.addOperator(ot);			
	}
	public int deleteOperator(String id) {
		return peratorDao.deleteOperator(id);
	}
	public Operator getOperatorById(String id) {
		return peratorDao.getOperatorById(id);
	}
    public List<Operator> getAllOperatorbyybid(String yb_userid){
		return peratorDao.getAllOperatorbyybid(yb_userid);
	}

}
